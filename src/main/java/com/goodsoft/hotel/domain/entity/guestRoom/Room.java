package com.goodsoft.hotel.domain.entity.guestRoom;

/**
 * 房间实体类
 * Created by Administrator on 2017/11/9/009.
 */


public class Room {
    private String id;
    private String roomType;
    private String roomNo;
    private String cName;
    private String rackRate;
    private String buildingCode;
    private String floorCode;
    private String status;
    private String doorLockId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getRackRate() {
        return rackRate;
    }

    public void setRackRate(String rackRate) {
        this.rackRate = rackRate;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getFloorCode() {
        return floorCode;
    }

    public void setFloorCode(String floorCode) {
        this.floorCode = floorCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoorLockId() {
        return doorLockId;
    }

    public void setDoorLockId(String doorLockId) {
        this.doorLockId = doorLockId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (id != null ? !id.equals(room.id) : room.id != null) return false;
        if (roomType != null ? !roomType.equals(room.roomType) : room.roomType != null) return false;
        if (roomNo != null ? !roomNo.equals(room.roomNo) : room.roomNo != null) return false;
        if (cName != null ? !cName.equals(room.cName) : room.cName != null) return false;
        if (rackRate != null ? !rackRate.equals(room.rackRate) : room.rackRate != null) return false;
        if (buildingCode != null ? !buildingCode.equals(room.buildingCode) : room.buildingCode != null) return false;
        if (floorCode != null ? !floorCode.equals(room.floorCode) : room.floorCode != null) return false;
        if (status != null ? !status.equals(room.status) : room.status != null) return false;
        return doorLockId != null ? doorLockId.equals(room.doorLockId) : room.doorLockId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roomType != null ? roomType.hashCode() : 0);
        result = 31 * result + (roomNo != null ? roomNo.hashCode() : 0);
        result = 31 * result + (cName != null ? cName.hashCode() : 0);
        result = 31 * result + (rackRate != null ? rackRate.hashCode() : 0);
        result = 31 * result + (buildingCode != null ? buildingCode.hashCode() : 0);
        result = 31 * result + (floorCode != null ? floorCode.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (doorLockId != null ? doorLockId.hashCode() : 0);
        return result;
    }
}
