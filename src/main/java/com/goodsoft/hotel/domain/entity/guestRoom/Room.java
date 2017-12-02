package com.goodsoft.hotel.domain.entity.guestRoom;

/**
 * 房间实体类
 * Created by 王智 on 2017/11/9/009.
 */


public class Room {
    private String id;              //id
    private int roomId;             //房间ID
    private String roomType;        //房间类型
    private String roomNo;          //房间编号
    private String cName;           //别名
    private String buildingCode;    //建筑编号
    private String floorCode;       //楼层编号
    private String nights;          //夜晚
    private String stdPax;          //正常人数
    private String maxPax;          //最大人数
    private String status;          //状态
    private String doorLockId;      //门锁ID
    private String remark;          //备注
    private String flag;            //状态(显示空房,散客,团体.....)
    private String sFlag;           //房间状态(显示脏房,空净房.....)
    private String rackRate;
    private String rateCode;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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

    public String getNights() {
        return nights;
    }

    public void setNights(String nights) {
        this.nights = nights;
    }

    public String getStdPax() {
        return stdPax;
    }

    public void setStdPax(String stdPax) {
        this.stdPax = stdPax;
    }

    public String getMaxPax() {
        return maxPax;
    }

    public void setMaxPax(String maxPax) {
        this.maxPax = maxPax;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getsFlag() {
        return sFlag;
    }

    public void setsFlag(String sFlag) {
        this.sFlag = sFlag;
    }

    public String getRackRate() {
        return rackRate;
    }

    public void setRackRate(String rackRate) {
        this.rackRate = rackRate;
    }

    public String getRateCode() {
        return rateCode;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", roomId=" + roomId +
                ", roomType='" + roomType + '\'' +
                ", roomNo='" + roomNo + '\'' +
                ", cName='" + cName + '\'' +
                ", buildingCode='" + buildingCode + '\'' +
                ", floorCode='" + floorCode + '\'' +
                ", nights='" + nights + '\'' +
                ", stdPax='" + stdPax + '\'' +
                ", maxPax='" + maxPax + '\'' +
                ", status='" + status + '\'' +
                ", doorLockId='" + doorLockId + '\'' +
                ", remark='" + remark + '\'' +
                ", flag='" + flag + '\'' +
                ", sFlag='" + sFlag + '\'' +
                ", rackRate='" + rackRate + '\'' +
                ", rateCode='" + rateCode + '\'' +
                '}';
    }
}
