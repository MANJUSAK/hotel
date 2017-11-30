package com.goodsoft.hotel.domain.entity.guestRoom;


/**
 * 预定房间信息表
 * Created by 王智 on 2017/11/18/018.
 */
public class QuickbookingRoomno {

    private String roomNo;              //房间号
    private String typeName;            //房间类型
    private String doorLockId;          //门锁ID
    private String housePrices;         //标准房价
    private String bookId;              //预定表单ID
    private String roomId;              //房间id


    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDoorLockId() {
        return doorLockId;
    }

    public void setDoorLockId(String doorLockId) {
        this.doorLockId = doorLockId;
    }

    public String getHousePrices() {
        return housePrices;
    }

    public void setHousePrices(String housePrices) {
        this.housePrices = housePrices;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "QuickbookingRoomno{" +
                "roomNo='" + roomNo + '\'' +
                ", typeName='" + typeName + '\'' +
                ", doorLockId='" + doorLockId + '\'' +
                ", housePrices='" + housePrices + '\'' +
                ", bookId='" + bookId + '\'' +
                ", roomId='" + roomId + '\'' +
                '}';
    }
}
