package com.goodsoft.hotel.domain.dao.guestRoom;

import com.goodsoft.hotel.domain.entity.guestRoom.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/9/009.
 */


@Repository
public interface RoomSDao {
    //   public Map<String,Object>  findFang1() throws Exception;
    //   获取楼层所有信息
    public List<Floors> queryFloorMapper() throws Exception;

    //   通过楼层号获取到房间所有信息
    public List<Room> queryFloorRoomMapper(String floorCode) throws Exception;

    //   房间类型
    public List<RoomType> queryRoomTypeMapper() throws Exception;

    //   通过楼层名字返回房间信息
    public List<Room> queryRoomFloorNameMapper(String floorName) throws Exception;

    //   快速预定中的房态信息,左边的列表
    public List<Map<String, Object>> queryRoomALLMapper() throws Exception;

    //   查询空房有多少
    public List<Map<String, Object>> selectKongMapper(List<Integer> typeIds) throws Exception;


    //建筑信息添加
    public void insertBuild(Building building) throws Exception;

    //   楼层的信息添加
    public void insertFloor(Floors floors) throws Exception;

    //房间类型信息的添加
    public void insertRoomType(RoomType roomType) throws Exception;
//   房间信息添加
//   public void  insertRoom(Room room) throws Exception;


}
