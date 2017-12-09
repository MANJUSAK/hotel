package com.goodsoft.hotel.controller.guestRoom;

import com.goodsoft.hotel.domain.dao.guestRoom.OperationRoomDao;
import com.goodsoft.hotel.domain.entity.guestRoom.Building;
import com.goodsoft.hotel.domain.entity.guestRoom.Floors;
import com.goodsoft.hotel.domain.entity.guestRoom.Room;
import com.goodsoft.hotel.domain.entity.guestRoom.RoomType;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.service.OperationRoomsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 房间建筑,楼层,房间类型,房间的增加,删除,修改操作
 * Created by zhiWang on 2017/12/2/002.
 */

@RestController
public class OperationRoomController {

    @Resource
    private OperationRoomDao operationRoomDao;
    @Resource
    private OperationRoomsService operationRoomsService;


    /**
     * 添加建筑信息
     *
     * @param building 建筑前台添加的信息
     * @return 返回响应状态
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("room/operation/addBuild")
    public Status addBuliding(@RequestBody Building building) {
        try {
            String str = this.operationRoomsService.addBuilding(building);
            return new Status(StatusEnum.SUCCESS.getCODE(), str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.QT_ADD_ERROR.getCODE(), StatusEnum.QT_ADD_ERROR.getEXPLAIN());
        }
    }

    /**
     * 获取建筑的信息
     *
     * @return 建筑详情
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("room/operation/getBuild")
    public Object getBuild() {
        try {
            return this.operationRoomDao.queryBuildAllMapper();
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.QT_FIND_ERROR.getCODE(), StatusEnum.QT_FIND_ERROR.getEXPLAIN());
        }
    }


    /**
     * 添加楼层信息
     *
     * @param floors 楼层信息
     * @return 返回响应状态
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("room/operation/addFloors")
    public Status addFloor(@RequestBody Floors floors) {
        try {
            String str = this.operationRoomsService.addFloors(floors);
            return new Status(StatusEnum.SUCCESS.getCODE(), str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.QT_ADD_ERROR.getCODE(), StatusEnum.QT_ADD_ERROR.getEXPLAIN());
        }
    }

    /**
     * 添加房间类型信息
     *
     * @param roomType 前台填写的房间类型
     * @return 响应状态
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("room/operation/addRoomType")
    public Status addRoomType(@RequestBody RoomType roomType) {
        try {
            String str = this.operationRoomsService.addRoomType(roomType);
            return new Status(StatusEnum.SUCCESS.getCODE(), str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.QT_ADD_ERROR.getCODE(), StatusEnum.QT_ADD_ERROR.getEXPLAIN());
        }
    }

    /**
     * 获取楼层信息
     *
     * @return 楼层信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("room/operation/getFloor")
    public Object getFloor() {
        try {
            return this.operationRoomDao.queryFloorAllMapper();
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.QT_FIND_ERROR.getCODE(), StatusEnum.QT_FIND_ERROR.getEXPLAIN());
        }
    }

    /**
     * 获取房间类型信息
     *
     * @return 房间类型
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("room/operation/getRoomType")
    public Object getRoomType() {
        try {
            return this.operationRoomDao.queryRoomTypeMapper();
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.QT_FIND_ERROR.getCODE(), StatusEnum.QT_FIND_ERROR.getEXPLAIN());
        }
    }

    /**
     * 添加房间信息
     *
     * @param room 前台传递的房间信息
     * @return 返回响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("room/operation/addRoom")
    public Status addRoom(@RequestBody Room room) {
        try {
            String str = this.operationRoomsService.addRoom(room);
            return new Status(StatusEnum.SUCCESS.getCODE(), str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.QT_ADD_ERROR.getCODE(), StatusEnum.QT_ADD_ERROR.getEXPLAIN());
        }
    }

    /**
     * 修改建筑信息
     *
     * @param building 前台获取到修改的建筑信息
     * @return 返回响应状态
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("room/operation/updateBuilding")
    public Status updateBuilding(@RequestBody Building building) {
        try {
            String str = this.operationRoomsService.updateBuilding(building);
            return new Status(StatusEnum.SUCCESS.getCODE(), str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.QT_MODIFY_ERROR.getCODE(), StatusEnum.QT_MODIFY_ERROR.getEXPLAIN());
        }
    }

    /**
     * 修改楼层信息
     *
     * @param floors 前台获取到修改的楼层信息
     * @return 返回响应状态
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("room/operation/updateFloor")
    public Status updateFloors(@RequestBody Floors floors) {
        try {
            String str = this.operationRoomsService.updateFloors(floors);
            return new Status(StatusEnum.SUCCESS.getCODE(), str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.QT_MODIFY_ERROR.getCODE(), StatusEnum.QT_MODIFY_ERROR.getEXPLAIN());
        }
    }

    /**
     * 修改房间类型信息
     *
     * @param roomType 前台获取到的修改的房间类型信息
     * @return 返回响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("room/operation/updateRoomType")
    public Status updateRoomType(@RequestBody RoomType roomType) {
        try {
            String str = this.operationRoomsService.updateRoomType(roomType);
            return new Status(StatusEnum.SUCCESS.getCODE(), str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.QT_MODIFY_ERROR.getCODE(), StatusEnum.QT_MODIFY_ERROR.getEXPLAIN());
        }
    }

    /**
     * 修改房间信息
     *
     * @param room 获取前台修改的房间信息
     * @return 返回响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("room/operation/updateRoom")
    public Status updateRoom(@RequestBody Room room) {
        try {
            String str = this.operationRoomsService.updateRoom(room);
            return new Status(StatusEnum.SUCCESS.getCODE(), str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.QT_MODIFY_ERROR.getCODE(), StatusEnum.QT_MODIFY_ERROR.getEXPLAIN());
        }
    }


    /**
     * 删除建筑信息
     *
     * @param buildId 获取前台建筑id
     * @return 返回响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("room/operation/deleteBuilding")
    public Status deleteBuilding(String buildId) {
        try {
            String str = this.operationRoomsService.deleteBuilding(buildId);
            return new Status(StatusEnum.SUCCESS.getCODE(), str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.QT_REMOVE_ERROR.getCODE(), StatusEnum.QT_REMOVE_ERROR.getEXPLAIN());
        }
    }

    /**
     * 删除楼层信息
     *
     * @param floorId 获取前台的楼层ID
     * @return 返回响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("room/operation/deleteFloor")
    public Status deleteFloor(String floorId) {
        try {
            String str = this.operationRoomsService.deleteFloor(floorId);
            return new Status(StatusEnum.SUCCESS.getCODE(), str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.QT_REMOVE_ERROR.getCODE(), StatusEnum.QT_REMOVE_ERROR.getEXPLAIN());
        }
    }

    /**
     * 删除房间类型
     *
     * @param typeId 前台获取的id
     * @return 返回响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("room/operation/deleteRoomType")
    public Status deleteRoomType(String typeId) {
        try {
            String str = this.operationRoomsService.deleteRoomType(typeId);
            return new Status(StatusEnum.SUCCESS.getCODE(), str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.QT_REMOVE_ERROR.getCODE(), StatusEnum.QT_REMOVE_ERROR.getEXPLAIN());
        }
    }

    /**
     * 删除房间信息
     *
     * @param id 前台获取到的ID
     * @return 返回响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("room/operation/deleteRoom")
    public Status deleteRoom(String id) {
        try {
            String str = this.operationRoomsService.deleteRoom(id);
            return new Status(StatusEnum.SUCCESS.getCODE(), str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.QT_REMOVE_ERROR.getCODE(), StatusEnum.QT_REMOVE_ERROR.getEXPLAIN());
        }
    }


}
