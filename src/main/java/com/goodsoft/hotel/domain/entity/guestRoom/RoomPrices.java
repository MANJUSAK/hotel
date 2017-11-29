package com.goodsoft.hotel.domain.entity.guestRoom;

/**
 * Created by Administrator on 2017/11/27/027.
 */
public class RoomPrices {
    private String id;          //id
    private String roomTypeId;  //房间类型id
    private String setStartTime;    //时间
    private String roomPrices;      //价格

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getSetStartTime() {
        return setStartTime;
    }

    public void setSetStartTime(String setStartTime) {
        this.setStartTime = setStartTime;
    }

    public String getRoomPrices() {
        return roomPrices;
    }

    public void setRoomPrices(String roomPrices) {
        this.roomPrices = roomPrices;
    }


    @Override
    public String toString() {
        return "RoomPrices{" +
                "id='" + id + '\'' +
                ", roomTypeId='" + roomTypeId + '\'' +
                ", setStartTime='" + setStartTime + '\'' +
                ", roomPrices='" + roomPrices + '\'' +
                '}';
    }
}
