package com.goodsoft.hotel.controller.guestRoom;

import com.goodsoft.hotel.domain.dao.guestRoom.RoomSDao;
import com.goodsoft.hotel.domain.entity.guestRoom.Room;
import com.goodsoft.hotel.service.RoomsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/9/009.
 */

@RestController
public class RoomsController {

    
    @Resource
    private RoomSDao roomSDao;

//    @CrossOrigin(origins = "*",maxAge = 3600,methods = RequestMethod.GET)
//    @RequestMapping("/test")
//    public List<Building> getBuildingAll() throws Exception{
//        return this.roomsService.findBuilding();
//    }


//    @CrossOrigin(origins = "*",maxAge = 3600,methods = RequestMethod.GET)
//    @RequestMapping("/floor")
//    public List<Floors> getFloorsAll() throws Exception{
//        List<Floors> floors= roomsService.findFloors();
//        return floors;
//    }


    @CrossOrigin(origins = "*",maxAge = 3600,methods = RequestMethod.GET)
    @RequestMapping("/room")
    public List<Room> getRoomAll() throws Exception{
        System.out.println("11111111");
//        List<Room> rooms= this.roomSDao.queryRoomDao();
        System.out.println("23232323");
        return null;
    }


    @CrossOrigin(origins = "*",maxAge = 3600,methods = RequestMethod.GET)
    @RequestMapping("/wo")
    public List<Map<String,Object>> getRoomTypeAll()throws Exception{

        List<Map<String,Object>> list = this.roomSDao.queryFloorRoomMapper();

        for(Map<String,Object> map:list){
            for(Map.Entry<String,Object> e:map.entrySet()){
                System.out.println("----------------------------");
                System.out.println(e.getKey());
                System.out.println();
                System.out.println(e.getValue());
                System.out.println("----------------------------");
            }

        }
        return list;
    }



}
