package com.goodsoft.hotel.controller.guestRoom;

import com.goodsoft.hotel.controller.CookBookController;
import com.goodsoft.hotel.domain.dao.guestRoom.RoomSDao;
import com.goodsoft.hotel.domain.entity.guestRoom.*;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.util.UUIDUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Administrator on 2017/11/9/009.
 * <p>
 * 房态信息
 */

@RestController
public class RoomsController {


    @Resource
    private RoomSDao roomSDao;

    //实例化日志管理工具类
    private Logger logger = LoggerFactory.getLogger(CookBookController.class);

//    /**
//     * 获取房间房态信息
//     * @return
//     */
//    @CrossOrigin(origins = "*",maxAge = 3600,methods = RequestMethod.GET)
//    @RequestMapping("floor/roomType/find1")
//    public Object getFang1(){
//        List<Map<String,Object>> list = null;
//        try {
////            list =this.roomSDao.findFang1();
//            for (Map<String, Object> map : list) {
//                for (Map.Entry<String, Object> m : map.entrySet()) {
//                    System.out.print(m.getKey() + "    ");
//                    System.out.println(m.getValue());
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
//        }
//        return null;
//    }

    /**
     * 获取房间房态信息
     *
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/roomType")
    public List<Map<String, Object>> getFang() {
        List<Map<String, Object>> list = null;
        Map<String, Object> map = null;
        try {
            List<Floors> floors = this.roomSDao.queryFloorMapper();
            list = new ArrayList<Map<String, Object>>();
            for (Floors f : floors
                    ) {
                map = new HashMap<String, Object>();
                map.put("FloorName", f.getFloorName());
                map.put("Rooms", this.findFloor(f.getFloorCode()));
                list.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 通过楼层号获取房间信息
     *
     * @param floorCode 楼层号
     * @return 房间信息
     * @throws Exception 异常
     */
    public List<Room> findFloor(String floorCode) throws Exception {
        return this.roomSDao.queryFloorRoomMapper(floorCode);
    }

    /**
     * 获取前台楼层号
     *
     * @param floorName
     * @return 房间信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/room/queryFloorName")
    public Object getRoomS(@Param("floorName") String floorName) {
        try {
            System.out.println(floorName);
            return this.roomSDao.queryRoomFloorNameMapper(floorName);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }

    /**
     * 房间类型
     *
     * @return 房间类型
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/roomTypeName")
    public Object getAllRoomType() {
        try {
            return this.roomSDao.queryRoomTypeMapper();
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }


    /**
     * 快速预定的房态,左边的列表
     *
     * @return 房间类型信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/roomTypeName/room")
    public Object findRoomType() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            return this.roomSDao.queryRoomALLMapper();

        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }


    /**
     * 传递空房信息  获取类型id 动态传递
     * 根据选择的房间类型 查看空房信息
     *
     * @return 空房数据
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/roomTypeName/kong")
    public Object getKongAll(@Param("typeId") String typeId) {
        List<Map<String, Object>> map = null;
        List<Integer> typeIds = null;
        try {
            String[] arr = {};
            if (typeId.trim() != null && typeId.trim() != "") {
                arr = typeId.split(",");
            }
            typeIds = new ArrayList<Integer>();
            for (int i = 0; i < arr.length; i++) {
                int s = Integer.parseInt(arr[i]);
                typeIds.add(s);
                map = this.roomSDao.selectKongMapper(typeIds);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
        return map;
    }


    /**
     * 前台查询的获取--还没编写
     *
     * @param str
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/roomTypeName/find")
    public Status findFangTai(@Param("str") String str) {
        String str1 = str.trim();
        System.out.println(str1);
        return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
    }


    /**
     * 添加建筑--未交互
     *
     * @param buildingCode 自己编的代码
     * @param buildingName 建筑的名称
     * @throws Exception
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("insertBuilding")
    public void insertBuild(String buildingCode, String buildingName) throws Exception {
        String ID = UUIDUtil.getInstance().getUUID().toString();
        Building buildings = new Building();
        buildings.setId(ID);
        buildings.setBuildingCode(buildingCode);
        buildings.setBuildingName(buildingName);
        this.roomSDao.insertBuild(buildings);
    }

    /**
     * 添加楼层信息
     *
     * @param floorCode 楼层的编号代码
     * @param floorName 楼层的名称
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("insertFloor")
    public void insertFloor(String floorCode, String floorName) throws Exception {
        String ID = UUIDUtil.getInstance().getUUID().toString();
        Floors floors = new Floors();
        floors.setId(ID);
        floors.setFloorCode(floorCode);
        floors.setFloorName(floorName);
        this.roomSDao.insertFloor(floors);
    }

    /**
     * 添加房间类型信息
     *
     * @param roomType
     * @param roomName
     * @param housePrices
     * @throws Exception
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("insertRoomType")
    public void insertRoomType(String roomType, String roomName, String housePrices) throws Exception {
        String ID = UUIDUtil.getInstance().getUUID().toString();
        RoomType room = new RoomType();
        room.setId(ID);
        room.setRoomType(roomType.trim());
        room.setTypeName(roomName.trim());
        room.setHousePrices(housePrices.trim());
        this.roomSDao.insertRoomType(room);
    }

    /**
     * 测试接口--添加房间详细信息
     *
     * @param buildingCode
     * @param floorCode
     * @param roomType
     * @param roomNo
     * @param cName
     * @param nights
     * @param stdPax
     * @param maxPax
     * @param status
     * @param doorLockId
     * @param remark
     * @param flag
     * @param rackRate
     * @param rateCode
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("insertRoom")
    public void insertRoom(String buildingCode, String floorCode, String roomType, String roomNo, String cName, String nights, String stdPax, String maxPax, String status, String doorLockId, String remark, String flag, String rackRate, String rateCode) {
        String ID = UUIDUtil.getInstance().getUUID().toString();
        Room room = new Room();
        room.setId(ID);
        room.setRoomType(roomType);
        room.setRoomNo(roomNo);
        room.setcName(cName);
        room.setNights(nights);
        room.setStdPax(stdPax);
        room.setMaxPax(maxPax);
        room.setStatus(status);
        room.setBuildingCode(buildingCode);
        room.setFloorCode(floorCode);
        room.setDoorLockId(doorLockId);  //门锁id
        room.setRemark(remark);
        room.setFlag(flag);
        room.setRackRate(rackRate);
        room.setRateCode(rateCode);


    }


    /**
     * 修改建筑--未完成
     *
     * @param map
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("updateBuilding")
    public Status updateBuild(@RequestBody Building map) {
        try {
            System.out.println(map.getBuildingName());
            return new Status(StatusEnum.SUCCESS.getCODE(),StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.ERROR.getCODE(),StatusEnum.ERROR.getEXPLAIN());
        }
    }


}
