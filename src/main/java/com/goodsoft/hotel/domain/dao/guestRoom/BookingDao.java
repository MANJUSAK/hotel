package com.goodsoft.hotel.domain.dao.guestRoom;

import com.goodsoft.hotel.domain.entity.guestRoom.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 预定信息
 * Created by zhiWang on 2017/11/21/021.
 */
@Repository
public interface BookingDao {
    //添加预订信息
    public void insertQuickBooking(Quickbooking Quickbooking) throws Exception;

    //   添加预定信息中的房间信息
    public void insertQuickBookingRoom(List<QuickbookingRoomno> QuickbookingRoomno) throws Exception;

    //查询房间信息
    public List<String> findRoomNoMapper(String id) throws Exception;

    //添加客人信息
    public Integer addGuestMapper(Guest guest) throws Exception;

    //修改房间信息的状态
    public void updateRoomFlag(String id) throws Exception;

    //查询预定信息
    public List<Quickbooking> selectrQuickBookings(Map map);

    //查询预定房间信息
    public List<QuickbookingRoomno> selectrQuickBookingRooms(String quiId);

    //查询预订单所有已入住房间ID
    public List<String> selectBookingNotEmptyRooms(String bookingno);

    //修改预定单中信息
    public Integer updateQuickBookingALL(Quickbooking Quickbooking);

    //取消订单
    public void updateFlagQuxiaoMapper(@Param("reason") String reason , @Param("bookid") String bookId);

    //    取消订单恢复
    public void updateFlagQuXiaoHuiFuMapper(String bookid);

    //订单逻辑删除
    public void updateFlagDeleteMapper(String str);

    //逻辑删除订单恢复
    public void updateFlagDeleteHuiFuMapper(String bookid) throws Exception;

    //永久删除预定单信息
    public void deleteBookingMapper(String id) throws Exception;

    //永久删除预定房间号信息
    public void deleteBookingRoomMapper(String bookid) throws Exception;


    //修改预订单状态为部分入住
    public Integer updateReserveFlagByNo(String bookingNo);
    //修改预订单状态为全部入住
    public Integer updateReserveFlagAllByNo(String bookingNo);





    //通过预定单号查询预订Id
    public String selectBookIdByBookNo(String bookingNo);
    //通过预定ID查询预订单号
    public String selectBookNoByBookId(String bookId);

    //查询预订单所有房间状态
    public List<String> selectAllReserveRoomState(String bookId);

    //判断预定房间重复
    public Integer joinRoomIdResves(Map map);

    //判断房间号在预订中重复
    public Integer joinRoomRepeat(@Param("roomno") String roomno,@Param("startdate") String startdate);

    //查询入住信息的房间ID
    public List<Map> selectRuZhuRoomIdMapper(Map map) ;

    //预定入住之前查询
    public List<Map<String,Object>> selectRoomRuZhu(List<String> list);

    //预定入住
    public Integer updateRoomFlagRuZhu(Map<String,Object> map);

    //查询房间状态
    public String selectFlagByRoomId(@Param("roomId") String roomId);



    //修改预订状态
     Integer updateRoomFlagRuZhuBooking(String id);

     //查询订单入住客人证件号码
     public List<String> selectRoomGuestInfo(String bookid);

     //查询客房入住客人证件号码
    public List<String> selectBookingRoomGuestInfo(@Param("bookid") String bookid,@Param("roomid") String roomid);

    //会员信息添加
    public void addVipCardMapper(VipCard vipCard);

    //会员信息修改
    public void updateVipCardMapper(VipCard vipCard);

    //查询预订信息
    public  Quickbooking selectReserveInfo(@Param("id") String id);
    //查询未入住预订房间信息
    public List<QuickbookingRoomno> selectReserveRooms(@Param("bookId") String bookId);

    //查询全部预订房间信息
    public List<QuickbookingRoomno> selectReserveRoomsAll(@Param("bookId") String bookId);
    //删除预订房间信息
    public Integer deleteBookdingRoomAll(@Param("bookId") String bookId);

    //查询预订类型
    public String  selectBookingMarkets(@Param("bookingno") String bookingno);

    //查询预订单客人信息
    public String selectBookingGuestName(String bookingno);

    //查询单条客人信息
    public List<Guest> selectOneGuestByRoom(@Param("bookid") String bookid ,@Param("roomid") String roomid,@Param("documentno") String documentno);

    //修改客人信息
    public Integer updateGuestMapper(Guest guest);


    //查询预订单所有未入住房间信息
    public List<QuickbookingRoomno> selectAllQuiNotPeckRoom(String bookid);


    //通过房间ID查询预订单ID
    public String selectBookingIdByRoomId(String roomid);

    //通过身份证号码查询订单ID 与房间Id
    public List<Map<String,String>> selectBookIdByDocumentno(String documentno);

    //通过门锁id查询订单id
    public Map selectBookIdByDoorLock(String doorlock);


    /**
     * 退房修改客房状态
     */
    public Integer updateRoomFlagTuifang(List list);

    /**
     * 退房修改预订单状态为全部退房
     */
     public Integer updateBookingStateTuifang(String bookingId);

    /**
     * 退房修改预订单状态为部分退房
     */
     public Integer updateBookingStateTuifangBufen(String bookingId);

    /**
     * 查询预订单关联的所有房间号
     */
     public List<String> selectBookingRooms(String bookid);

    /**
     * 随行人
     */
    //查询随行人
    public List<AccompanyingPerson> selectAccompanyingInfo(@Param("bookId") String bookId);

    //添加随行人
    public Integer insertAccompanyingInfo(List<AccompanyingPerson> accompanyingPerson);

    //修改随行人
    public Integer updateAccompanyingInfo(AccompanyingPerson accompanyingPerson);

    //删除随行人
    public Integer deleteAccompanyingInf(List<String> bookIds);

    //通过预定单号查询所有房间信息
    public List<Map> selectReserveRoomsBybookNo(String bookNo);



    /**
     * 会员卡查询
     */
    //会员卡按照会员名查询
    public List<VipCard> findVipCardVipNameMapper(String vipName);

    //会员卡按照会员卡号查询
    public List<VipCard> findVipCardVipNoMapper(String vipNo);

    //会员卡按照会员电话查询
    public List<VipCard> findVipCardVipPhoneMapper(String vipPhone);

    //删除会员卡信息
    public void deleteVipCardMapper(String id);


    /**
     * 公共信息发布
     */
    //添加信息
    public int addMsgMapper(GsPublicMsgIssuance gsPublicMsgIssuance) throws Exception;

    //修改信息
    public void updateMsgMapper(GsPublicMsgIssuance gsPublicMsgIssuance) throws Exception;
}
