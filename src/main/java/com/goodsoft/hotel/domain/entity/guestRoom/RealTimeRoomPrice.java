package com.goodsoft.hotel.domain.entity.guestRoom;

import java.io.Serializable;

/**
 * Created by duyuxiang on 2017/12/1.
 * 客房实时房价
 */
public class RealTimeRoomPrice implements java.io.Serializable{

     private String id;
     private String typeid;   //房间类型id
     private String time;     //时间
     private String price;    //价格



    public RealTimeRoomPrice() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RealTimeRoomPrice{" +
                "id='" + id + '\'' +
                ", typeid='" + typeid + '\'' +
                ", time='" + time + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
