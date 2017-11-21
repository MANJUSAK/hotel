package com.goodsoft.hotel.domain.dao.guestRoom;

import com.goodsoft.hotel.domain.entity.guestRoom.*;

import java.util.List;
import java.util.Map;

/**
 * 预定
 * Created by Administrator on 2017/11/21/021.
 */
public interface BookingDao {
    //添加预订信息
    public void insertQuickBooking(Quickbooking Quickbooking) throws Exception;

    //   添加预定信息中的房间信息
    public void insertQuickBookingRoom(List<QuickbookingRoomno> QuickbookingRoomno) throws Exception;

    //查询预定信息
    public List<Quickbooking> selectrQuickBookings(Map map);

    //查询预定房间信息
    public List<QuickbookingRoomno> selectrQuickBookingRooms(String quiId);


    //修改预定单中信息
    public void updateQuickBookingALL(Quickbooking Quickbooking) throws Exception;
}
