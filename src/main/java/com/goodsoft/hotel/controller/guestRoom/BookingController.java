package com.goodsoft.hotel.controller.guestRoom;

import com.goodsoft.hotel.controller.CookBookController;
import com.goodsoft.hotel.domain.dao.guestRoom.BookingDao;
import com.goodsoft.hotel.domain.entity.guestRoom.Quickbooking;
import com.goodsoft.hotel.domain.entity.guestRoom.QuickbookingRoomno;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.util.UUIDUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 预定
 * Created by Administrator on 2017/11/21/021.
 */
@RestController
public class BookingController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource
    private BookingDao bookingDao;

    //实例化日志管理工具类
    private Logger logger = LoggerFactory.getLogger(CookBookController.class);


    /**
     * 添加预定的信息 未完善
     *
     * @param quickbooking 获取前台传递的类
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("floor/roomTypeName/add")
    public Status getKong(@RequestBody Quickbooking quickbooking) {
        String ID = UUIDUtil.getInstance().getUUID().toString();
        quickbooking.setId(ID);
        System.out.println(quickbooking.getId());
        System.out.println(quickbooking.toString());
        try {
            this.bookingDao.insertQuickBooking(quickbooking);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }

    /**
     *
     * 添加快速预定的信息接口--正式接口
     *
     * @param quickbooking 获取前台传递的类
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("booking/addQuick")
    public  Map<String,String> addQuicking(@RequestBody Quickbooking quickbooking) {
        System.out.println(quickbooking);
        String uuid = UUIDUtil.getInstance().getUUID().toString();
        String bookingNo = this.getCodes();
        quickbooking.setId(uuid);
        quickbooking.setBookingNo(bookingNo);
        quickbooking.setBookingFlag("1");
        for (QuickbookingRoomno qr : quickbooking.getRoomno()) {
            qr.setBookId(uuid);
        }
        Map<String,String> map = new HashMap<String, String>();
        try {
            this.bookingDao.insertQuickBooking(quickbooking);
            this.bookingDao.insertQuickBookingRoom(quickbooking.getRoomno());
            map.put("status",StatusEnum.SUCCESS.getEXPLAIN());
            map.put("bookingNo",bookingNo);
        } catch (Exception e) {
            this.logger.error(e.toString());

            map.put("error",StatusEnum.ERROR.getEXPLAIN());
        }
        return map;

    }


    /**
     * 预定信息修改接口
     *
     * @param quickbooking 传入的需要修改的对象
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("booking/updateBooking")
    public Status updateQuick(@RequestBody Quickbooking quickbooking) {

        System.out.println(quickbooking.toString());
        try {
            this.bookingDao.updateQuickBookingALL(quickbooking);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }

    /**
     * 删除订单主要是修改订单的状态
     *
     * @param id        订单ID
     * @param bookingNo 订单编号
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("booking/deleteFlagBooking")
    public Status deleteFlagBooking(@Param("id") String id, @Param("bookingNo") String bookingNo) {

        return null;
    }


    /**
     * 查询预定信息接口
     *
     * @param startDate 入住时间
     * @param endDate   离开时间
     * @return 响应结果
     */
    //查询预定信息
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("quick/select")
    public Object selectrQuickBookings(String startDate, String endDate) {
        Map paramMap = new HashMap();
        if (startDate != null && !"".equals(startDate)) {
            paramMap.put("startDate", startDate);
        }
        if (endDate != null && !"".equals(endDate)) {
            paramMap.put("endDate", endDate);
        }

        List<Quickbooking> quickbookings = bookingDao.selectrQuickBookings(paramMap);
        if (quickbookings.size() != 0) {
            for (int i = 0; i < quickbookings.size(); i++) {
                List<QuickbookingRoomno> quickbookingRoomnos = bookingDao.selectrQuickBookingRooms(quickbookings.get(i).getId());
                quickbookings.get(i).setRoomno(quickbookingRoomnos);
            }
        }

        return quickbookings;
    }

    private String dateFormat(Date date) {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sim.format(date);
    }

    /**
     * char 数组  用于生成随机数
     */
    static char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
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
}
