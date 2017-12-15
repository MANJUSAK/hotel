package com.goodsoft.hotel.domain.dao.guestRoom;

import com.goodsoft.hotel.domain.entity.guestRoom.Quickbooking;
import com.goodsoft.hotel.domain.entity.guestRoom.QuickbookingRoomno;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
