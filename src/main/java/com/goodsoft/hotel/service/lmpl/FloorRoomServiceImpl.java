package com.goodsoft.hotel.service.lmpl;

import com.goodsoft.hotel.domain.dao.guestRoom.BookingDao;
import com.goodsoft.hotel.domain.dao.guestRoom.RoomSDao;
import com.goodsoft.hotel.domain.entity.guestRoom.*;
import com.goodsoft.hotel.service.FloorRoomService;
import com.goodsoft.hotel.util.UUIDUtil;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhiWang on 2017/11/16/016.
 */
@Service
public class FloorRoomServiceImpl implements FloorRoomService {

    @Resource
    private RoomSDao roomSDao;
    @Resource
    private BookingDao bookingDao;


    @Resource
    SqlSessionTemplate sqlSessionTemplate;


    /**
     * 公共信息发布   添加
     * @param gsPublicMsgIssuance
     * @throws Exception
     */
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

//        //判断房间号是否重复预定
//        for(int i=0;i<quickbooking.getRoomno().size();i++){
//            Integer integer = bookingDao.joinRoomRepeat(quickbooking.getRoomno().get(i).getRoomNo(), quickbooking.getStartDate());
//            if(integer>0){
//            map.put("bookingNo", quickbooking.getRoomno().get(i).getRoomNo()+"已被预订");
//            return map;
//            }
//        }


        String uuid = UUIDUtil.getInstance().getUUID().toString();
        String bookingNo = this.getNumber("QT");
        quickbooking.setId(uuid);
        quickbooking.setBookingNo(bookingNo);
        quickbooking.setBookingFlag("明确预定");
        quickbooking.setRegisterNo(this.getNubmer());
        for (QuickbookingRoomno qr : quickbooking.getRoomno()) {
            qr.setBookId(uuid);
        }
        map.put("bookingNo", bookingNo);
        map.put("bookId",uuid);
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

        try {
            for (int i = 0; i < list.size(); i++) {
                Integer y = mapper.updateRoomFlagRuZhu(list.get(i));
                mapper.updateRoomFlagRuZhuBooking(String.valueOf(list.get(i).get("ids")));
            }
            sqlSession.commit();
        } catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());
            return "入住失败";
        } finally {
            sqlSession.close();
        }
        return "入住成功";
    }



    /**
     * 预订单生成预定单号
     * @return 预定单号
     */
    public String getNumber(String str) {

        //char 数组  用于生成随机数
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        //生成系统时间的时间戳
        SimpleDateFormat dateS = new SimpleDateFormat("yyyyMMddHHmmss");
        String str1 = dateS.format(new Date());
        //开始用客房的拼音
        StringBuffer sb = new StringBuffer(str);
        sb.append(str1);
        //预定单号长度20位  再加4个随机数  避免重复
        for (int i = 0; i < 4; i++) {
            int num = (int) (Math.random() * (chars.length - 1));
            sb.append(chars[num]);
        }
        return sb.toString();
    }

    /**
     * 预定单生成登记号
     * @return  登记号
     */
    public String getNubmer() {
        //当天的时间戳
        SimpleDateFormat dateS = new SimpleDateFormat("ddHHmmss");
        String str = dateS.format(new Date());
        return str;
    }

}
