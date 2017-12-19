package com.goodsoft.hotel.domain.entity.guestRoom;

import java.util.List;

/**
 * Created by duyuxiang on 2017/12/15.
 * 退房参数接收类
 */
public class RoomChekcOutParam {

    private String identy;       //标识
    private String bookid;       //预订单号
    private List<String> roomId; //房间ID

    public RoomChekcOutParam() {
    }

    public String getIdenty() {
        return identy;
    }

    public void setIdenty(String identy) {
        this.identy = identy;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public List<String> getRoomId() {
        return roomId;
    }

    public void setRoomId(List<String> roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "RoomChekcOutParam{" +
                "bookid='" + bookid + '\'' +
                ", roomId=" + roomId +
                '}';
    }
}
