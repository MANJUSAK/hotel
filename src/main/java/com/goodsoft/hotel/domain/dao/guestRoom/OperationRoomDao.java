package com.goodsoft.hotel.domain.dao.guestRoom;

import com.goodsoft.hotel.domain.entity.guestRoom.Building;
import com.goodsoft.hotel.domain.entity.guestRoom.Floors;
import com.goodsoft.hotel.domain.entity.guestRoom.Room;
import com.goodsoft.hotel.domain.entity.guestRoom.RoomType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhiWang on 2017/12/2/002.
 */

@Repository
public interface OperationRoomDao {

    /**
     * 添加建筑,楼层,房间类型,房间
     */
    //添加建筑
    public Integer addBuildingMapper(Building building) throws Exception;

    //获取到建筑的信息
    public List<Building> queryBuildAllMapper() throws Exception;

    //添加楼层
    public Integer addFloorMapper(Floors floors) throws Exception;

    //查询楼层信息
    public List<Floors> queryFloorAllMapper() throws Exception;

    //添加房间信息
    public Integer addRoomTypeMapper(RoomType roomType) throws Exception;

    //获取房间类型信息
    public List<RoomType> queryRoomTypeMapper() throws Exception;

    //添加房间信息
    public Integer addRoomMapper(Room room) throws Exception;


    /**
     * 修改建筑,楼层,房间类型,房间信息
     */
    //修改建筑信息
    public Integer updateBuildingMapper(Building building) throws Exception;

    //修改楼层信息
    public Integer updateFloorsMapper(Floors floors) throws Exception;

    //修改房间类型信息
    public Integer updateRoomTypeMapper(RoomType roomType) throws Exception;

    //修改房间信息
    public Integer updateRoomMapper(Room room) throws Exception;

    /**
     * 删除建筑
     */
    //删除建筑关联房间
    public Integer deleteBuildingRoomMapper(String str) throws Exception;

    //删除建筑关联楼层
    public Integer deleteBuildingFloorMapper(String str) throws Exception;

    //删除建筑
    public Integer deleteBuildingMapper(String str) throws Exception;

    /**
     * 删除楼层
     */
    //删除楼层关联的房间
    public Integer deleteFloorRoomMapper(String str) throws Exception;

    //删除楼层
    public Integer deleteFloorMapper(String str) throws Exception;

    /**
     * 删除房间类型
     */
    //删除房间类型
    public Integer deleteRoomTypeMapper(String str) throws Exception;

    /**
     * 删除房间
     */
    //删除房间
    public Integer deleteRoomMapper(String str) throws Exception;
}
