package com.goodsoft.hotel.service.lmpl;

import com.goodsoft.hotel.domain.dao.guestRoom.RoomSDao;
import com.goodsoft.hotel.domain.entity.guestRoom.Room;
import com.goodsoft.hotel.service.FloorRoomService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/16/016.
 */
public class FloorRoomServiceImpl implements FloorRoomService {

    @Resource
    private RoomSDao roomSDao;

    @Override
    public List<Map<String,Object>> findsFang1() throws Exception {
//        Map<String,Object> map = this.roomSDao.findFang1();
        return null;
    }

    public List<Room> getRooms(String floorCode ){
        List<Room> list = null;
        try {
             list = this.roomSDao.queryFloorRoomMapper(floorCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
