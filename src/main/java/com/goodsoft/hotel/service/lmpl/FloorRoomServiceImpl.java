package com.goodsoft.hotel.service.lmpl;

import com.goodsoft.hotel.domain.dao.guestRoom.BookingDao;
import com.goodsoft.hotel.domain.dao.guestRoom.RoomSDao;
import com.goodsoft.hotel.domain.entity.guestRoom.*;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.service.FloorRoomService;
import com.goodsoft.hotel.util.UUIDUtil;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLSyntaxErrorException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/11/16/016.
 */
@Service
public class FloorRoomServiceImpl implements FloorRoomService {

    @Resource
    private RoomSDao roomSDao;
    @Resource
    private BookingDao bookingDao;


    @Resource
    SqlSessionTemplate sqlSessionTemplate;

    //
    @Override
    public List<Map<String, Object>> findsFang1() throws Exception {
////        Map<String,Object> map = this.roomSDao.findFang1();
//        return null;
//    }
//
//    public List<Room> getRooms(String floorCode ){
//        List<Room> list = null;
//        try {
//             list = this.roomSDao.queryFloorRoomMapper(floorCode);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }

    @Transactional
    @Override
    public void addMsgMapper(GsPublicMsgIssuance gsPublicMsgIssuance) throws Exception {
        String uuid = UUIDUtil.getInstance().getUUID().toString();
        gsPublicMsgIssuance.setId(uuid);
        this.bookingDao.addMsgMapper(gsPublicMsgIssuance);
    }

    /**
     * 预定信息添加
     *
     * @param quickbooking 前台传入的参数
     * @return 返回状态
     * @throws Exception
     */
    @Transactional
    @Override
    public Map<String, String> insertQuickBooking(Quickbooking quickbooking) throws Exception {
        //返回map
        Map<String, String> map = new HashMap<String, String>();

        //判断房间号是否重复预定
        Map paramMap = new HashMap();

        paramMap.put("startdate", quickbooking.getStartDate());
        List<QuickbookingRoomno> roomno = quickbooking.getRoomno();
        for (int i = 0; i < roomno.size(); i++) {
            paramMap.put("roomid", roomno.get(i).getRoomId());
            Integer integer = bookingDao.joinRoomIdResves(paramMap);
            System.out.println(integer);
            if (integer > 0) {
                map.put("error", "重复预定");
                return map;
            }

        }

        String uuid = UUIDUtil.getInstance().getUUID().toString();
        String bookingNo = this.getCodes();
        quickbooking.setId(uuid);
        quickbooking.setBookingNo(bookingNo);
        quickbooking.setBookingFlag("明确预定");
        quickbooking.setRegisterNo(this.getNubmer());
        for (QuickbookingRoomno qr : quickbooking.getRoomno()) {
            qr.setBookId(uuid);
        }
        map.put("bookingNo", bookingNo);
        this.bookingDao.insertQuickBooking(quickbooking);
        this.bookingDao.insertQuickBookingRoom(quickbooking.getRoomno());
        return map;

    }

    /**
     * 预定入住
     *
     * @param list 获取到的入住房间的信息
     * @return 返回更新状态
     * @throws Exception
     */
    @Override
    public String updateRoomFlagRuZhuService(List<Map<String, Object>> list) throws Exception {
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        BookingDao mapper = sqlSession.getMapper(BookingDao.class);
        Integer x = 0;
        try {
            for (int i = 0; i < list.size(); i++) {
                Integer y = bookingDao.updateRoomFlagRuZhu(list.get(i));
                x += y;
            }
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());
            x = 0;
        } finally {
            sqlSession.close();
        }
        System.out.println("sum:" + x);
        return x >= 0 ? "成功入住:入住" + x + "间" : "入住失败";
    }


    /**
     * char 数组  用于生成随机数
     */
    public static char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public String getCodes() {
        SimpleDateFormat dateS = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = dateS.format(new Date());
        StringBuffer code = new StringBuffer("KF");
        code.append(str);
        for (int i = 0; i < 4; i++) {
            int num = (int) (Math.random() * (codeSequence.length - 1));
            code.append(codeSequence[num]);
        }
        return code.toString();
    }

    public String getNubmer() {
        SimpleDateFormat dateS = new SimpleDateFormat("ddHHmmss");
        String str = dateS.format(new Date());
        return str;
    }

}
