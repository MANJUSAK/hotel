package com.goodsoft.hotel.domain.dao.guestRoom;

import com.goodsoft.hotel.domain.entity.guestRoom.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 预定信息
 * Created by 王智 on 2017/11/21/021.
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
    public void addGuestMapper(Guest guest) throws Exception;

    //修改房间信息的状态
    public void updateRoomFlag(String id) throws Exception;

    //查询预定信息
    public List<Quickbooking> selectrQuickBookings(Map map);

    //查询预定房间信息
    public List<QuickbookingRoomno> selectrQuickBookingRooms(String quiId);

    //修改预定单中信息
    public void updateQuickBookingALL(Quickbooking Quickbooking);

    //取消订单
    public void updateFlagQuxiaoMapper(List<String> list) throws Exception;

    //    取消订单恢复
    public void updateFlagQuXiaoHuiFuMapper(String bookid) throws Exception;

    //订单逻辑删除
    public void updateFlagDeleteMapper(String str) ;

    //逻辑删除订单恢复
    public void updateFlagDeleteHuiFuMapper(String bookid) throws Exception;

    //永久删除预定单信息
    public void deleteBookingMapper(String id) throws Exception;

    //永久删除预定房间号信息
    public void deleteBookingRoomMapper(String bookid) throws Exception;


    //判断预定房间重复
    public Integer joinRoomIdResves(Map map);

    //查询入住信息的房间ID
    public List<Map> selectRuZhuRoomIdMapper(Map map) ;

    //预定入住之前查询
    public List<Map<String,Object>> selectRoomRuZhu(List<String> list);

    //预定入住
    public Integer updateRoomFlagRuZhu(Map<String,Object> map);

    //会员信息添加
    public void addVipCardMapper(VipCard vipCard);

    //会员信息修改
    public void updateVipCardMapper(VipCard vipCard);

    //查询预订信息
    public  Quickbooking selectReserveInfo(@Param("id") String id);
    //查询预订房间信息
    public List<QuickbookingRoomno> selectReserveRooms(@Param("bookId") String bookId);

   //删除预订房间信息
    public Integer deleteBookdingRoomAll(@Param("bookId") String bookId);


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
