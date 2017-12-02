package com.goodsoft.hotel.domain.entity.guestRoom;

import java.util.List;

/**
 * Created by duyuxiang on 2017/12/1.
 * 实时房价参数接收类
 */
public class RealTimeRoomPriceParam implements java.io.Serializable{

    private String time;
    private List<RealTimeRoomPrice> realTimeRooms;

    public RealTimeRoomPriceParam() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<RealTimeRoomPrice> getRealTimeRooms() {
        return realTimeRooms;
    }

    public void setRealTimeRooms(List<RealTimeRoomPrice> realTimeRooms) {
        this.realTimeRooms = realTimeRooms;
    }
}
