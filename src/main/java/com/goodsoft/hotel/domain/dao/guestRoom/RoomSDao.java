package com.goodsoft.hotel.domain.dao.guestRoom;

import com.goodsoft.hotel.domain.entity.Building;
import com.goodsoft.hotel.domain.entity.guestRoom.Floors;
import com.goodsoft.hotel.domain.entity.guestRoom.Room;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/9/009.
 */


@Repository
public interface RoomSDao {
//    //建筑的操作
//    public List<Building>  queryBuildingDao();
//    //楼层的操作
//    public List<Floors> queryFloorsDao();
//    //房间的操作
   public List<Map<String,Object>> queryRoomDao();
   public List<Map<String,Object>> queryFloorRoomMapper() throws Exception;

}
