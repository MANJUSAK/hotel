package com.goodsoft.hotel.domain.entity.guestRoom;


/**
 * Created by Administrator on 2017/11/18/018.
 */
public class QuickbookingRoomno {
    private String roomNo;              //房间号
    private String typeName;            //房间类型
    private String doorLockId;          //门锁ID
    private String housePrices;         //标准房价
    private String bookId;              //预定表单ID

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

    @Override
    public String toString() {
        return "QuickbookingRoomno{" +
                "roomNo='" + roomNo + '\'' +
                ", roomType='" + typeName + '\'' +
                ", doorLockId='" + doorLockId + '\'' +
                ", housePrices=" + housePrices +
                ", bookId='" + bookId + '\'' +
                '}';
    }
}
