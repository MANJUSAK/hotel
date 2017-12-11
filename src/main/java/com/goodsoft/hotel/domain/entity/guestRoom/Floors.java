package com.goodsoft.hotel.domain.entity.guestRoom;

/**
 * 楼层信息表
 * Created by zhiWang on 2017/11/9/009.
 */
public class Floors {
    private String id;              //ID
    private String floorCode;       //楼层编号
    private String floorName;       //楼层名称
    private String floorId;         //楼层ID

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFloorCode() {
        return floorCode;
    }

    public void setFloorCode(String floorCode) {
        this.floorCode = floorCode;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    @Override
    public String toString() {
        return "Floors{" +
                "id='" + id + '\'' +
                ", floorCode='" + floorCode + '\'' +
                ", floorName='" + floorName + '\'' +
                ", floorId='" + floorId + '\'' +
                '}';
    }
}
