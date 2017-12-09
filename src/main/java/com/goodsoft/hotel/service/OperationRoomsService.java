package com.goodsoft.hotel.service;

import com.goodsoft.hotel.domain.entity.guestRoom.Building;
import com.goodsoft.hotel.domain.entity.guestRoom.Floors;
import com.goodsoft.hotel.domain.entity.guestRoom.Room;
import com.goodsoft.hotel.domain.entity.guestRoom.RoomType;

/**
 * Created by zhiWang on 2017/12/4/004.
 */
public interface OperationRoomsService {

    /**
     * 添加
     */
    //添加建筑信息
    public String addBuilding(Building building) throws Exception;

    //添加楼层信息
    public String addFloors(Floors floors) throws Exception;

    //添加房间类型信息
    public String addRoomType(RoomType roomType) throws Exception;

    //添加房间信息
    public String addRoom(Room room) throws Exception;

    /**
     * 修改
     */
    //修改建筑信息
    public String updateBuilding(Building building) throws Exception;

    //修改楼层信息
    public String updateFloors(Floors floors) throws Exception;

    //修改房间类型信息
    public String updateRoomType(RoomType roomType) throws Exception;

    //修改房间信息
    public String updateRoom(Room room) throws Exception;

    /**
     * 删除
     */
    //删除建筑信息
    public String deleteBuilding(String str) throws Exception;

    //删除楼层信息
    public String deleteFloor(String str) throws Exception;

    //删除房间类型信息
    public String deleteRoomType(String str) throws Exception;

    //删除房间信息
    public String deleteRoom(String str) throws Exception;


}
