package com.goodsoft.hotel.domain.entity.guestRoom;

import java.util.List;

/**
 * Created by duyuxiang on 2017/12/13.
 * 房间入住接收参数类
 */
public class RoomCheckParam {

    private List<Guest> guest;  //客人信息
    private String room; //房间号
    private String roomId; //房间ID
    private String bookingNo;  //预订单号

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public List<Guest> getGuest() {
        return guest;
    }

    public void setGuest(List<Guest> guest) {
        this.guest = guest;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public RoomCheckParam() {
    }
}
