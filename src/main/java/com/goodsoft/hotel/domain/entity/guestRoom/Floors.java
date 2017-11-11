package com.goodsoft.hotel.domain.entity.guestRoom;

/**
 * Created by Administrator on 2017/11/9/009.
 */
public class Floors {
    private String id;
    private String floorCode;
    private String floorName;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Floors floors = (Floors) o;

        if (id != null ? !id.equals(floors.id) : floors.id != null) return false;
        if (floorCode != null ? !floorCode.equals(floors.floorCode) : floors.floorCode != null) return false;
        return floorName != null ? floorName.equals(floors.floorName) : floors.floorName == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (floorCode != null ? floorCode.hashCode() : 0);
        result = 31 * result + (floorName != null ? floorName.hashCode() : 0);
        return result;
    }
}
