package com.goodsoft.hotel.domain.entity.guestRoom;

/**
 * Created by Administrator on 2017/11/9/009.
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Floors floors = (Floors) o;

        if (id != null ? !id.equals(floors.id) : floors.id != null) return false;
        if (floorCode != null ? !floorCode.equals(floors.floorCode) : floors.floorCode != null) return false;
        if (floorName != null ? !floorName.equals(floors.floorName) : floors.floorName != null) return false;
        return floorId != null ? floorId.equals(floors.floorId) : floors.floorId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (floorCode != null ? floorCode.hashCode() : 0);
        result = 31 * result + (floorName != null ? floorName.hashCode() : 0);
        result = 31 * result + (floorId != null ? floorId.hashCode() : 0);
        return result;
    }
}
