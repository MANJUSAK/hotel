package com.goodsoft.hotel.service.impl;

import com.goodsoft.hotel.domain.dao.guestRoom.OperationRoomDao;
import com.goodsoft.hotel.domain.entity.guestRoom.*;
import com.goodsoft.hotel.service.OperationRoomsService;
import com.goodsoft.hotel.util.UUIDUtil;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiWang on 2017/12/4/004.
 */
@Service
public class OperationRoomsServiceImpl implements OperationRoomsService {

    @Resource
    private OperationRoomDao operationRoomDao;

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;


    /**
     * 添加建筑
     *
     * @param building 建筑信息
     * @return 返回说明(成功或者失败)
     */
    @Transactional
    @Override
    public String addBuilding(Building building) {
        String uuid = UUIDUtil.getInstance().getUUID("QT").toString();
        building.setId(uuid);
        Integer x = 0;
        try {
            x = this.operationRoomDao.addBuildingMapper(building);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x > 0 ? "建筑添加成功,添加" + x + "栋" : "建筑添加失败";
    }

    /**
     * 添加楼层
     *
     * @param floors 楼层信息
     * @return 返回成功或者失败说明
     */
    @Transactional
    @Override
    public String addFloors(Floors floors) {
        String uuid = UUIDUtil.getInstance().getUUID("QT").toString();
        floors.setId(uuid);
        Integer x = 0;
        try {
            x = this.operationRoomDao.addFloorMapper(floors);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x > 0 ? "楼层添加成功,添加了" + x + "层" : "楼层添加失败";
    }

    /**
     * 添加房间类型信息
     *
     * @param roomType 房间类型信息
     * @return 返回成功或者失败说明
     */
    @Transactional
    @Override
    public String addRoomType(RoomType roomType) {
        String uuid = UUIDUtil.getInstance().getUUID("QT").toString();
        roomType.setId(uuid);
        Integer x = 0;
        try {
            x = this.operationRoomDao.addRoomTypeMapper(roomType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x > 0 ? "房间类型添加成功,添加了" + x + "种类型" : "房间类型添加失败";
    }

    /**
     * 添加房间详情
     *
     * @param room 房间信息
     * @return 返回成功或者失败说明
     */
    @Transactional
    @Override
    public String addRoom(Room room) {
        String uuid = UUIDUtil.getInstance().getUUID("QT").toString();
        room.setId(uuid);
        Integer x = 0;
        try {
            x = this.operationRoomDao.addRoomMapper(room);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x > 0 ? "房间添加成功,添加" + x + "间" : "房间添加失败";
    }

    /**
     * 修改建筑信息
     *
     * @param building 建筑信息
     * @return 返回成功或者失败信息
     */
    @Transactional
    @Override
    public String updateBuilding(Building building) {
        Integer x = 0;
        try {
            x = this.operationRoomDao.updateBuildingMapper(building);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return x > 0 ? "更新成功,更新" + x + "栋" : "建筑更新失败";
    }

    /**
     * 修改楼层信息
     *
     * @param floors 楼层信息
     * @return 返回成功或者失败信息
     */
    @Transactional
    @Override
    public String updateFloors(Floors floors) {
        Integer x = 0;
        try {
            x = this.operationRoomDao.updateFloorsMapper(floors);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x > 0 ? "更新成功,更新" + x + "层" : "楼层更新失败";
    }

    /**
     * 修改房间类型信息
     *
     * @param roomType 房间类型信息
     * @return 返回成功或者失败信息
     */
    @Transactional
    @Override
    public String updateRoomType(RoomType roomType) {
        Integer x = 0;
        try {
            x = this.operationRoomDao.updateRoomTypeMapper(roomType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x > 0 ? "更新成功,更新" + x + "种类型" : "房间类型更新失败";
    }

    /**
     * 修改房间信息
     *
     * @param room 前台房间信息
     * @return 返回成功或者失败信息
     */
    @Transactional
    @Override
    public String updateRoom(Room room) {
        Integer x = 0;
        try {
            x = this.operationRoomDao.updateRoomMapper(room);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x > 0 ? "更新成功,更新" + x + "间" : "房间更新失败";
    }

    /**
     * 删除建筑
     *
     * @param str 前台获取的建筑id
     * @return 返回成功信息
     */
    @Transactional
    @Override
    public String deleteBuilding(String str) {
        SqlSession sqlSession = this.sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        OperationRoomDao arDao = sqlSession.getMapper(OperationRoomDao.class);
        List<String> list = this.getListArr(str);
        try {
            arDao.deleteBuildingRoomMapper(list);
            arDao.deleteBuildingFloorMapper(list);
            arDao.deleteBuildingMapper(list);
            sqlSession.commit();
            return "建筑删除成功";
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            return "建筑删除失败";
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 删除楼层
     *
     * @param str 前台传递的ID
     * @return 返回成功信息
     */
    @Override
    public String deleteFloor(String str) {
        SqlSession sqlSession = this.sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        OperationRoomDao arDao = sqlSession.getMapper(OperationRoomDao.class);
        List<String> list = this.getListArr(str);
        try {
            arDao.deleteFloorRoomMapper(list);
            arDao.deleteFloorMapper(list);
            sqlSession.commit();
            return "楼层删除成功";
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            return "楼层删除失败";
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 删除房间类型
     *
     * @param str 前台获取的ID
     * @return 返回成功信息
     */
    @Override
    public String deleteRoomType(String str) {
        SqlSession sqlSession = this.sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        OperationRoomDao arDao = sqlSession.getMapper(OperationRoomDao.class);
        List<String> list = this.getListArr(str);
        try {
            arDao.deleteRoomTypeMapper(list);
            sqlSession.commit();
            return "房间类型删除成功";
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            return "房间类型删除失败";
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 删除房间
     *
     * @param str 前台获取的id
     * @return 返回成功信息
     */
    @Override
    public String deleteRoom(String str) {
        SqlSession sqlSession = this.sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        OperationRoomDao arDao = sqlSession.getMapper(OperationRoomDao.class);
        List<String> list = this.getListArr(str);
        try {
            arDao.deleteRoomMapper(list);
            sqlSession.commit();
            return "房间删除成功";
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            return "房间删除失败";
        } finally {
            sqlSession.close();
        }
    }


    /**
     * 传入一个逗号分隔的字符串 返回一个集合
     *
     * @param str 传入的字符串
     * @return 返回的集合
     */
    public List getListArr(String str) {
        List<String> list = new ArrayList<String>();
        if (str.indexOf(",") != -1) {
            String[] strs = str.split(",");
            for (int i = 0; i < strs.length; i++) {
                list.add(strs[i]);
            }
        } else {
            list.add(str);
        }
        return list;
    }

}
