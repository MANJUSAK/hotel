package com.goodsoft.hotel.domain.dao.guestRoom;

import com.goodsoft.hotel.domain.entity.guestRoom.Quickbooking;
import com.goodsoft.hotel.domain.entity.guestRoom.QuickbookingRoomno;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by duyuxiang on 2017/12/15.
 * 客房退房收银
 */
@Repository
public interface KfCheckOutDao {

    //查询预订单信息
    public Quickbooking selectBookingInfo(@Param("id") String id);
    //查询预订单全部已入住房间信息
    public List<QuickbookingRoomno> selectBookingCheckRooms(@Param("bookId") String bookId);

    //修改客人信息状态为0 通过预定单号
    public Integer updateCustomerStateByBook(@Param("bookid") String bookid);

    //修改客人信息状态为0  通过房间号
    public Integer updateCustomerStateByRoom(List<String> rooms);

    //修改财务信息状态为0  通过预定单
    public Integer updateRecordStateByBook(String bookingNo);

    //修改财务信息状态为0  通过房间List
    public Integer updateRecordStateByRoom(Map map);

    //查询房间信息 -- 换房时替换预订单关联房间信息
    public QuickbookingRoomno selectRoomInfoPrice(String roomId);

    //查询多条房间信息 --
    public List<QuickbookingRoomno> selectRoomInfoPriceList(List<String> list);

    //修改单条预订单关联房间信息
    public Integer updateBookingRoomInfo(Map map);

    //修改客房消费信息房间id
    public Integer updateRecordRoomId(Map map);

    //修改客房关联客人信息roomid
    public Integer updateGuestRoomId(Map map);

    //修改客房状态
    public Integer updateRoomFlag(@Param("id") String id,@Param("flag") String flag);

    //批量修改客房状态为空房
    public Integer updateRoomFlagEmpty(List<String> list);

    //修改预订单状态
    public Integer updateBookingFlag(@Param("id") String id,@Param("flag") String flag);

    //修改预订单结束时间
    public Integer updateBookingEndTime(@Param("bookingno") String bookingno,@Param("enddate") String enddate);

    //查询预订单开始时间和结束时间
    public Map selectBookingTime(String bookingno);


    //通过房间号查询当前订单ID
    public String selectQuiRoomsByRoomNo(String roomno);


}
