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
     Integer addBuildingMapper(Building building) throws Exception;

    //获取到建筑的信息
     List<Building> queryBuildAllMapper() throws Exception;

    //添加楼层
     Integer addFloorMapper(Floors floors) throws Exception;

    //查询楼层信息
     List<Floors> queryFloorAllMapper() throws Exception;

    //添加房间信息
     Integer addRoomTypeMapper(RoomType roomType) throws Exception;

    //获取房间类型信息
     List<RoomType> queryRoomTypeMapper() throws Exception;

    //添加房间信息
     Integer addRoomMapper(Room room) throws Exception;


    /**
     * 修改建筑,楼层,房间类型,房间信息
     */
    //修改建筑信息
     Integer updateBuildingMapper(Building building) throws Exception;

    //修改楼层信息
     Integer updateFloorsMapper(Floors floors) throws Exception;

    //修改房间类型信息
     Integer updateRoomTypeMapper(RoomType roomType) throws Exception;

    //修改房间信息
     Integer updateRoomMapper(Room room) throws Exception;

    /**
     * 删除建筑
     */
    //删除建筑关联房间
     void deleteBuildingRoomMapper(List<String> list) throws Exception;

    //删除建筑关联楼层
     void deleteBuildingFloorMapper(List<String> list) throws Exception;

    //删除建筑
     void deleteBuildingMapper(List<String> list) throws Exception;

    /**
     * 删除楼层
     */
    //删除楼层关联的房间
     void deleteFloorRoomMapper(List<String> list) throws Exception;

    //删除楼层
     void deleteFloorMapper(List<String> list) throws Exception;

    /**
     * 删除房间类型
     */
    //删除房间类型
     void deleteRoomTypeMapper(List<String> list) throws Exception;

    /**
     * 删除房间
     */
    //删除房间
     void deleteRoomMapper(List<String> list) throws Exception;
}
