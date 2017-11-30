package com.goodsoft.hotel.domain.entity.guestRoom;


/**
 *
 * 房间类型
 * Created by 王智 on 2017/11/13/013.
 */
public class RoomType {
    private String id;                      //房间ID,uuid
    private int typeId;                     //房间类型ID,自增
    private String roomType;                //房间类型
    private String typeName;                //类型名字
    private String housePrices;         //标准房价


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getHousePrices() {
        return housePrices;
    }

    public void setHousePrices(String housePrices) {
        this.housePrices = housePrices;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "id='" + id + '\'' +
                ", typeId=" + typeId +
                ", roomType='" + roomType + '\'' +
                ", typeName='" + typeName + '\'' +
                ", housePrices=" + housePrices +
                '}';
    }
}
