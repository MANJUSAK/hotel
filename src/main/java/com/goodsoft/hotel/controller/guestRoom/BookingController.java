package com.goodsoft.hotel.controller.guestRoom;

import com.goodsoft.hotel.controller.CookBookController;
import com.goodsoft.hotel.domain.dao.guestRoom.BookingDao;
import com.goodsoft.hotel.domain.dao.guestRoom.KfCheckOutDao;
import com.goodsoft.hotel.domain.dao.guestRoom.RoomSDao;
import com.goodsoft.hotel.domain.entity.guestRoom.*;
import com.goodsoft.hotel.domain.entity.result.Result;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.service.FloorRoomService;
import com.goodsoft.hotel.util.UUIDUtil;
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
 * Created by zhiWang on 2017/11/21/021.
 */
@RestController
public class BookingController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource
    private BookingDao bookingDao;
    @Resource
    private FloorRoomService floorRoomService;
    @Resource
    private RoomSDao roomSDao;

    @Resource
    private KfCheckOutDao kfCheckOutDao;

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
    public Status getKong(@RequestBody Quickbooking quickbooking){
        String ID = UUIDUtil.getInstance().getUUID().toString();
        quickbooking.setId(ID);
        System.out.println(quickbooking.getId());
        System.out.println(quickbooking.toString());
        try {
            this.bookingDao.insertQuickBooking(quickbooking);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e){
            this.logger.error(e.toString());
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }

    /**
     * 添加预定的信息接口--正式接口
     *
     * @param quickbooking 获取前台传递的类
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("booking/addQuick")
    public Map<String, String> addQuicking(@RequestBody Quickbooking quickbooking){
        System.out.println("quickbooking:"+quickbooking);
        //返回map
        Map<String, String> map = new HashMap<String, String>();
        try {
            map = this.floorRoomService.insertQuickBooking(quickbooking);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("bookingNo", "数据库服务器错误");
            return map;
        }
    }




    /**
     * 查询单条订单信息
     * @param roomid 房间ID
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("booking/roomid/selectOne")
    public Object bookingSelectByRoomNo(String roomid){
            if(roomid==null){
                return new Result(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
            }

        try {
            String bookid = bookingDao.selectBookingIdByRoomId(roomid);
            if(bookid==null){
                return new Result(StatusEnum.NO_PARAM.getCODE(),"房间无订单号");
            }
            Quickbooking quickbooking = bookingDao.selectReserveInfo(bookid);
            List<QuickbookingRoomno> quickbookingRoomnos = bookingDao.selectReserveRoomsAll(bookid);
            quickbooking.setRoomno(quickbookingRoomnos);
            return new Result(StatusEnum.SUCCESS.getCODE(),quickbooking);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }


    /**
     * 查询单条预订详细信息
     * @param bookingId   预订id
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("booking/selectOne/Booking")
    public Object bookingSelectBooking(String bookingId){
        Quickbooking quickbooking=null;
        try{
             quickbooking = bookingDao.selectReserveInfo(bookingId);
             if(quickbooking==null){
                 return new Status(StatusEnum.NO_DATA.getCODE(),StatusEnum.NO_DATA.getEXPLAIN());
             }
             List<QuickbookingRoomno> quickbookingRoomnos = bookingDao.selectReserveRooms(bookingId);
             quickbooking.setRoomno(quickbookingRoomnos);
        }catch (Exception e){
            e.printStackTrace();
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
        return quickbooking;
    }





    /**
     * 预定信息修改接口
     *
     * @param quickbooking 传入的需要修改的对象
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("booking/updateBooking")
    public Status updateQuick(@RequestBody Quickbooking quickbooking){

        System.out.println(quickbooking.toString());
        try {
            this.bookingDao.updateQuickBookingALL(quickbooking);
            //List<QuickbookingRoomno> quickbookingRoomnos = bookingDao.selectReserveRooms(quickbooking.getId());
            bookingDao.deleteBookdingRoomAll(quickbooking.getId());
            System.out.println(quickbooking.getRoomno());
            for(int i=0;i<quickbooking.getRoomno().size();i++){
                quickbooking.getRoomno().get(i).setBookId(quickbooking.getId());
            }
            bookingDao.insertQuickBookingRoom(quickbooking.getRoomno());
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        }catch (Exception e){
            e.printStackTrace();
            this.logger.error("dao");
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }


    /**
     * 仅修改预订信息
     * @param <T>
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("booking/updateBookingOnly")
    public <T> T updateBookingOnly(@RequestBody Quickbooking quickbooking){

        try{
            this.bookingDao.updateQuickBookingALL(quickbooking);
        }catch (Exception e){
            e.printStackTrace();
            return (T)new Status(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
        return (T) new Status(StatusEnum.SUCCESS.getCODE(),StatusEnum.SUCCESS.getEXPLAIN());
    }




    /**
     * 取消预定单
     *
     * @param bookid 预定单号
     * @param reason 取消的原因
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("booking/updateQuXiaoBooking")
    public Status updateQuXiaoBooking(@Param("bookid") String bookid, @Param("reason") String reason,@Param("sign") String sign){

        try {
            if(sign!=null) {
                //取消预订单
                if(sign.equals("1")){
                    this.bookingDao.updateFlagQuxiaoMapper(reason,bookid);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                //恢复预订单
                }else if(sign.equals("2")){
                   bookingDao.updateFlagQuXiaoHuiFuMapper(bookid);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                }else{
                    return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN());
                }
            }else{
                  return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN());
            }
            }catch (Exception e){
            e.printStackTrace();
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
        } catch (Exception e){
            this.logger.error(e.toString());
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }


//    查询预定单所有房间信息selectReserveRoomsBybookNo
      @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
      @RequestMapping("accompanying/select/reserveRoom")
       public Object reserveRoom(String bookNo){
          try{
              List<Map> maps = bookingDao.selectReserveRoomsBybookNo(bookNo);
              return new Result(StatusEnum.SUCCESS.getCODE(),maps);
          }catch (Exception e){
              return new Status(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
          }

      }

    /**
     * 查询随行人
     * @param bookId
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("accompanying/selectPerson")
    public Object accompanyingSelectPerson(String bookId){
        List<AccompanyingPerson> accompanyingPeople= null;
        try{
             accompanyingPeople = bookingDao.selectAccompanyingInfo(bookId);
        }catch (Exception e){
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
        return  new Result(StatusEnum.SUCCESS.getCODE(),accompanyingPeople);
    }


    /**
     * 添加随行人
     * @param accompanyingPerson
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("accompanying/addPerson")
    public  Object accompanyingOparation(@RequestBody AccompanyingPerson accompanyingPerson){
        for(AccompanyingPerson ap:accompanyingPerson.getAccPersons()){
            ap.setId(UUIDUtil.getInstance().getUUID().toString());
        }
        try{
            bookingDao.insertAccompanyingInfo(accompanyingPerson.getAccPersons());
        }catch (Exception e){
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }

        return new Status(StatusEnum.SUCCESS.getCODE(),StatusEnum.SUCCESS.getEXPLAIN());
    }

    /**
     * 修改随行人
     * @param accompanyingPerson
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("accompanying/updatePerson")
    public Object updatePerson(@RequestBody AccompanyingPerson accompanyingPerson){
        try{
            bookingDao.updateAccompanyingInfo(accompanyingPerson);
        }catch (Exception e){
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }

        return  new Status(StatusEnum.SUCCESS.getCODE(),StatusEnum.SUCCESS.getEXPLAIN());
    }

    /**
     * 删除随行人
     * @param bookIds
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("accompanying/deletePerson")
    public Object deletePerson(@RequestBody String[] bookIds){

        List<String> books =new ArrayList<String>();
        for(int i=0;i<bookIds.length;i++){
            books.add(bookIds[i]);
        }

        try{
            bookingDao.deleteAccompanyingInf(books);
        }catch (Exception e){
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }

        return  new Status(StatusEnum.SUCCESS.getCODE(),StatusEnum.SUCCESS.getEXPLAIN());
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
            return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN());
        }
    }


    /**
     *
     * 查询预定信息接口   ---还没使用
     * @param startDate 入住时间
     * @param endDate   离开时间
     * @return 响应结果
     */
    //查询预定信息
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("quick/select")
    public Object selectrQuickBookings(String startDate, String endDate){
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
     * 添加客人信息
     *
     * @param guest
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("booking/addGuest")
    public Status addGuest(@RequestBody Guest guest) {

        System.out.println(guest);
        StringBuilder uuid = UUIDUtil.getInstance().getUUID();
        guest.setId(uuid.toString());
        try {
            bookingDao.addGuestMapper(guest);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
        return new Status(StatusEnum.SUCCESS.getCODE(),StatusEnum.SUCCESS.getEXPLAIN());
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

//    /**
//     * 预定入住
//     *
//     * @param msg 接收传入的预定信息
//     * @return 响应结果
//     */
//    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
//    @RequestMapping("booking/bookingRuZhu")
//    public Status bookingRuZhu(@RequestBody BookingCheckIn msg){
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        List<String> list1 = new ArrayList<>();
//        Map<String, Object> map = null;
//        for (int i = 0; i < msg.getMsg().size(); i++){
//            list1.add(msg.getMsg().get(i).getRoomId());
//        }
//        //查询房间状态
//        list = this.bookingDao.selectRoomRuZhu(list1);
//        try {
//            String str = this.floorRoomService.updateRoomFlagRuZhuService(list);
//            return new Status(StatusEnum.SUCCESS.getCODE(), str);
//        } catch (Exception e){
//            e.printStackTrace();
//            return new Status(404, "失败");
//        }
//    }


    /**
     * 添加客人信息
     * @param guest
     * @param <T>
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("booking/insertGuest")
    public <T> T insertGuest(@RequestBody Guest guest){

        System.out.println(guest);
        //判断客人信息是否完整
        if(guest.getGuestName()==null ||guest.getDocumentNo()==null ||"".equals(guest.getGuestName()) || "".equals(guest.getDocumentNo())){
            return (T) new Status(40010,"客人名或证件号为空");
        }
        //查询订单内全全部客人信息证件号码
        List<String> documentNos = bookingDao.selectRoomGuestInfo(guest.getBookId());
        //查询同一房间所有入住证件号码
        List<String> strings = bookingDao.selectBookingRoomGuestInfo(guest.getBookId(), guest.getRoomId());
        if(strings.size()>=5){
            return (T) new Status(40010,"房间入住人数已满");
        }
        //判断客人信息重复
        for(String s:documentNos){
            if(guest.getDocumentNo().equals(s)){
                return (T) new Status(40010,"客人信息重复");
            }
        }
        try{
            //插入客人信息
         Integer ss= bookingDao.addGuestMapper(guest);
         System.out.println("sssssss:"+ss);
        }catch (Exception e){
            e.printStackTrace();
            return (T) new Status(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
        return (T) new Status(StatusEnum.SUCCESS.getCODE(),StatusEnum.SUCCESS.getEXPLAIN());
    }

    /**
     * 修改客人信息
     * @param guest
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("booking/updateGuest")
    public Object updateGuestInfo(@RequestBody Guest guest){

        if(guest.getDocumentNo()==null || guest.getBookId()==null || guest.getGuestName()==null || guest.getAddress()==null){
            return new Status(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
        }
        System.out.println("classes:"+guest);
        try{
            Integer integer = bookingDao.updateGuestMapper(guest);
            return new Status(StatusEnum.SUCCESS.getCODE(),StatusEnum.SUCCESS.getEXPLAIN());
        }catch (Exception e){
            e.printStackTrace();
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }


    }


    /**
     * 查询单条客人信息
     * @param bookid  预订ID
     * @param roomid  客房id
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("booking/selectOne/guest")
    public Object getOneGuestInfo(String bookid,String roomid,String documentno){

        if(bookid==null || roomid==null){
            return new Result(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
        }

        try{
           List<Guest> guest = bookingDao.selectOneGuestByRoom(bookid, roomid,documentno);
            if(guest==null || guest.size()==0){
                return new Result(StatusEnum.DEFEAT.getCODE(),"未查询到客人信息");
            }

            return new Result(StatusEnum.SUCCESS.getCODE(),guest.get(0));
        }catch (Exception e){
            e.printStackTrace();
            return new Result(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }


    }

    /**
     * 入住
     * @param  bookingNo  roomNo  roomId
     * @param <T>
     * @return
     */
       @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
       @RequestMapping("booking/roomCheck")
       public <T> T roomCheck(String bookingNo ,String roomNo ,String roomId){
       //判断必填参数是否为空
        if(bookingNo==null || roomNo==null || roomId==null ||"".equals(bookingNo) || "".equals(roomId) || "".equals(roomNo)){
           return (T) new Status(40010,StatusEnum.NO_PARAM.getEXPLAIN());
       }
           try {
               //查询预订单ID
               String reserveId = bookingDao.selectBookIdByBookNo(bookingNo);

                //修改房间状态参数map
                Map roomFlagParam = new HashMap();
               //获取房间状态
               String roomflag = bookingDao.selectFlagByRoomId(roomId);
               if (roomflag != null && !"".equals(roomflag)) {
                //判断房间是否已入住
                if(!roomflag.equals("空房")){
                    return (T) new Status(40010, "房间已入住");
               }
                   //判断是否有客人信息
                   List<String> documentNos = bookingDao.selectBookingRoomGuestInfo(reserveId,roomId);
                   if(documentNos.size()==0){
                       return (T) new Status(40010, "无客人信息");
                   }

                //查询预订状态
                String s = bookingDao.selectBookingMarkets(bookingNo);
                roomFlagParam.put("markets",s);
                roomFlagParam.put("id",roomId);
                //修改客房状态
                bookingDao.updateRoomFlagRuZhu(roomFlagParam);


                //查询预订所有房间状态
                List<String> flags = bookingDao.selectAllReserveRoomState(reserveId);
                int x=0;
                for(int i=0;i<flags.size();i++){
                    if("空房".equals(flags.get(i))){
                       x++;
                    }
                }
                   //修改预订单状态
                   if(x==0){
                    //全部入住
                    bookingDao.updateReserveFlagAllByNo(bookingNo);
                  } else{
                       //部分入住
                       bookingDao.updateReserveFlagByNo(bookingNo);
                   }
                   //查询预订单客人姓名
                   String guestName = bookingDao.selectBookingGuestName(bookingNo);
                   //查询房间价格
                    String price = roomSDao.selectRoomNowPrice(roomId);
                   //添加房费消费信息
                   KfconsumpRecord record=new KfconsumpRecord();
                   record.setId(UUIDUtil.getInstance().getUUID().toString());
                   record.setRoomno(roomNo);
                   record.setGuestname(guestName);
                   record.setProject("房费");
                   record.setProjectnumber("1");
                   record.setUnitprice(price);
                   record.setBookingno(bookingNo);
                   record.setRoomid(roomId);record.setState("1"); record.setIsgive("否");
                   List list =new ArrayList();list.add(record);
                   System.out.println("44444:"+record);

                   roomSDao.insertXfConsumptionInfo(list);
               } else {
                   return (T) new Status(40010, "房间ID错误");
               }




           }catch (Exception e){
            e.printStackTrace();
            return (T) new Status(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
           }
        return (T) new Status(StatusEnum.SUCCESS.getCODE(),StatusEnum.SUCCESS.getEXPLAIN());
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
    public List<Map<String, String>> updateMessge(@RequestBody GsPublicMsgIssuance gsPublicMsgIssuance){
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


    /**
     * 判断房间预定是否重复
     * @param startdate
     * @param rooms
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("room/select/roomRepeat")
    public Object roomRepeat(String startdate,String  rooms){

        String [] room=rooms.split(",");
        String result="";
        try{
            for(int i=0;i<room.length;i++){
                Integer integer = bookingDao.joinRoomRepeat(room[i], startdate);
                if(integer>0){
                    result+=room[i]+",";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return new Result(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }

        if(result.length()==0){
            return new Result(StatusEnum.SUCCESS.getCODE(),StatusEnum.SUCCESS.getEXPLAIN());
        }else{
            return new Result(StatusEnum.DEFEAT.getCODE(),result);
        }

    }

}
