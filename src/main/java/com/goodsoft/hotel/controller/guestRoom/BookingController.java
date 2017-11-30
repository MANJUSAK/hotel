package com.goodsoft.hotel.controller.guestRoom;

import com.goodsoft.hotel.controller.CookBookController;
import com.goodsoft.hotel.domain.dao.guestRoom.BookingDao;
import com.goodsoft.hotel.domain.entity.guestRoom.*;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.service.FloorRoomService;
import com.goodsoft.hotel.util.UUIDUtil;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 预定
 * Created by 王智 on 2017/11/21/021.
 */
@RestController
public class BookingController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource
    private BookingDao bookingDao;
    @Resource
    private FloorRoomService floorRoomService;

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
     * 添加快速预定的信息接口--正式接口
     *
     * @param quickbooking 获取前台传递的类
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("booking/addQuick")
    public Map<String, String> addQuicking(@RequestBody Quickbooking quickbooking) {
        //返回map
        Map<String, String> map = new HashMap<String, String>();
//        //判断房间号是否重复预定
//        Map paramMap = new HashMap();
//
//            paramMap.put("startdate", quickbooking.getStartDate());
//            List<QuickbookingRoomno> roomno = quickbooking.getRoomno();
//            for (int i = 0; i < roomno.size(); i++) {
//                paramMap.put("roomid", roomno.get(i).getRoomId());
//                Integer integer = bookingDao.joinRoomIdResves(paramMap);
//                System.out.println(integer);
//                if (integer > 0) {
//                    map.put("error", "重复预定");
//                }
//                return map;
//            }
        try {
            map = this.floorRoomService.insertQuickBooking(quickbooking);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error", "错误");
            return map;
        }


    }


    /**
     * 预定信息修改接口   ---还没使用
     * .*
     *
     * @param quickbooking 传入的需要修改的对象
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
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
     * 取消预定单   ---还没使用
     *
     * @param bookid 预定单号
     * @param reason 取消的原因
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("booking/updateQuXiaoBooking")
    public Status updateQuXiaoBooking(@Param("bookid") String bookid, @Param("reason") String reason) {
        List<String> list = new ArrayList<String>();
        list.add(bookid);
        list.add(reason);
        try {
            this.bookingDao.updateFlagQuxiaoMapper(list);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }

    /**
     * 预定单号修改状态(取消恢复,取消删除)  ---还没使用
     *
     * @param bookid 预定单号
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("booking/updateQuXiaoBooingHuiFu")
    public Status updateQuXiaoBookingHuiFu(@Param("bookid") String bookid) {
        try {
            //取消恢复
            this.bookingDao.updateFlagQuXiaoHuiFuMapper(bookid);
            this.bookingDao.updateFlagDeleteHuiFuMapper(bookid);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }

    /**
     * 预定单号修改状态(删除订单)  ---还没使用
     *
     * @param bookid 预定单号
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("booking/updateDeleteBooking")
    public Status updateDeleteBookingHuiFu(@Param("bookid") String bookid) {
        try {
            System.out.println(bookid);
            this.bookingDao.updateFlagDeleteMapper(bookid);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }


    /**
     * 彻底删除预订信息 (不建议使用)  ---还没使用
     *
     * @param str 传回的id
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("booking/deleteBooking")
    public Status deleteBooking(@Param("str") String str) {
        try {
            this.bookingDao.deleteBookingMapper(str);
            this.bookingDao.deleteBookingRoomMapper(str);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }

    /**
     * 删除订单主要是修改订单的状态   ---还没使用
     *
     * @param id        订单ID
     * @param bookingNo 订单编号
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("booking/deleteFlagBooking")
    public Status deleteFlagBooking(String id, String bookingNo) {
        if (id.trim() != null && !("".equals(id))) {
            this.bookingDao.updateFlagDeleteMapper(id);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } else if (bookingNo != null && !("".equals(bookingNo))) {
            this.bookingDao.updateFlagDeleteMapper(bookingNo);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } else {
            return new Status(StatusEnum.NO_PRAM.getCODE(), StatusEnum.NO_PRAM.getEXPLAIN());
        }
    }


    /**
     * 查询预定信息接口   ---还没使用
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

    /**
     * 添加客人信息   ---还没使用
     *
     * @param guest
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("booking/addGuest")
    public Status addGuest(@RequestBody Guest guest) {
        System.out.println(guest.toString());
        return null;
    }


    //获取标准时间格式   ---还没使用
    private String dateFormat(Date date) {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sim.format(date);
    }


    /**
     * 会员卡信息添加   ---还没使用
     *
     * @return 响应的结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("vipCard/addVipCard")
    public Map addVipCard(@RequestBody VipCard vipCard) {
        Map<String, String> map = new HashMap<String, String>();
        String ID = UUIDUtil.getInstance().getUUID().toString();
        vipCard.setId(ID);
        this.bookingDao.addVipCardMapper(vipCard);
        map.put("success", "操作成功");
        return map;
    }

    /**
     * 会员信息修改    ---还没使用
     *
     * @param vipCard 需要修改的类
     * @return 返回结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("vipCard/updateVipCard")
    public Map updateVipCard(@RequestBody VipCard vipCard) {
        Map<String, String> map = new HashMap<String, String>();
        this.bookingDao.updateVipCardMapper(vipCard);
        map.put("success", "0");
        map.put("success", "操作成功");
        return map;
    }


    /**
     * 查询会员卡信息  ---还没使用
     *
     * @param vipName  会员名
     * @param vipNo    会员卡号
     * @param vipPhone 会员电话
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("vipCard/findVipCard")
    public Map findVipCard(String vipName, String vipNo, String vipPhone) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (vipName != null && !("".equals(vipName))) {
            List<VipCard> list1 = this.bookingDao.findVipCardVipNameMapper(vipName);
            map.put("VipCard", list1);
        } else if (vipNo != null && !("".equals(vipNo))) {
            List<VipCard> list2 = this.bookingDao.findVipCardVipNoMapper(vipNo);
            map.put("VipCard", list2);
        } else if (vipPhone != null && !("".equals(vipPhone))) {
            List<VipCard> list3 = this.bookingDao.findVipCardVipPhoneMapper(vipPhone);
            map.put("VipCard", list3);
        } else {
            map.put("error", "502");
            map.put("error", "参数错误");
        }
        return map;
    }


    /**
     * 删除会员信息   ---还没使用
     *
     * @param id
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("vipCard/deleteVipCard")
    public Map deleteVipCard(String id) {
        System.out.println(id.trim());
        Map<String, Object> map = new HashMap<String, Object>();
        if (id != null && !("".equals(id))) {
            this.bookingDao.deleteVipCardMapper(id);
            map.put("success", "成功");
            return map;
        } else {
            map.put("error", "失败");
            return map;
        }
    }

    /**
     * 预定入住
     *
     * @param msg 接收传入的预定信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("booking/bookingRuZhu")
    public Status bookingRuZhu(@RequestBody BookingCheckIn msg) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<String> list1 = new ArrayList<>();
        Map<String, Object> map = null;
        for (int i = 0; i < msg.getMsg().size(); i++) {
            list1.add(msg.getMsg().get(i).getRoomId());
        }
        list = this.bookingDao.selectRoomRuZhu(list1);
        try {
            String str = this.floorRoomService.updateRoomFlagRuZhuService(list);
            return new Status(StatusEnum.SUCCESS.getCODE(), str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(404, "失败");
        }
    }

    /**
     * 公共信息发布添加
     *
     * @param gsPublicMsgIssuance
     * @return
     */
    @Transactional
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("message/addMessage")
    public Status addMessge(@RequestBody GsPublicMsgIssuance gsPublicMsgIssuance) throws Exception {
        try {
            this.floorRoomService.addMsgMapper(gsPublicMsgIssuance);
            System.out.println(gsPublicMsgIssuance.toString());
            return new Status(0, "成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(500, "添加失败");
        }

    }

    /**
     * 公共信息发布修改  ---还没使用
     *
     * @param gsPublicMsgIssuance
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("message/updateMessage")
    public List<Map<String, String>> updateMessge(@RequestBody GsPublicMsgIssuance gsPublicMsgIssuance) {
        List<Map<String, String>> list = null;
        Map<String, String> map = null;
        try {
            this.bookingDao.updateMsgMapper(gsPublicMsgIssuance);
            map.put("success", "0");
            map.put("success", "成功");
            list.add(map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", "500");
            map.put("success", e.getMessage());
            list.add(map);
        }
        return list;
    }


}
