package com.goodsoft.hotel.domain.entity.guestRoom;

import java.util.List;

/**
 *
 * 接收房间信息预定入住信息
 * Created by zhiWang on 2017/11/28/028.
 */
public class BookingCheckIn {

    private List<QuickbookingRoomno> msg;

    public List<QuickbookingRoomno> getMsg() {
        return msg;
    }

    public void setMsg(List<QuickbookingRoomno> msg) {
        this.msg = msg;
    }
}
