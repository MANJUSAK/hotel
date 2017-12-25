package com.goodsoft.hotel.domain.dao.guestRoom;

import com.goodsoft.hotel.domain.entity.guestRoom.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhiWang on 2017/11/9/009.
 */


@Repository
public interface RoomSDao {
    /*
    房态  start
     */

    //   获取楼层所有信息
    public List<Floors> queryFloorMapper() throws Exception;

    //   通过楼层号获取到房间所有信息
    public List<RealStateResult> queryFloorRoomMapper(Map map) throws Exception;

    //获取所有有预订的房间列表
    public List<Map<String,String>> selectRoomReservesAll();

    //获取所有楼层id
    public List<Integer> selectFloorIdAll();

    //  获取房间总条数
    public Integer queryFloorRoomCountMapper(Map map) throws Exception;

   //查询实时房价
    public ArrayList<Map> selectImmediateRoomPrice();

    //房态 右边下拉框 楼层信息
    public List<Floors> findFloorAllMapper() throws Exception;

    //通过房态右边下拉框楼层信息 获取到该楼层房间信息
    public List<Map<String, Object>> findFloorNameGetRoomMapper(String floorCode) throws Exception;


    // 房态 右边下拉框 房间类型信息
    public List<RoomType> queryRoomTypeMapper() throws Exception;

    // 通过房态右边下拉框 房间类型信息 获取到该类型房间信息
    public List<Map<String, Object>> queryRoomTypeGetRoomMapper(String roomType) throws Exception;

    //查询传入时间段内被预订的房间号
    public List<String> selectReserveRoomByDate(@Param("startdate") String startdate ,@Param("enddate") String enddate) ;


    //房态右边的条件查询
    public List<Map> queryFuzzyRoomMapper(String str) throws Exception;

    //   快速预定中的房态信息,左边的列表
    public List<Map<String, Object>> queryRoomALLMapper() throws Exception;

    //   预定中 房间信息 通过左边的房间类型状态  获取所有空房
    public List<Map<String, Object>> selectKongMapper(List<String> typeIds) throws Exception;

    //   预定中 房间信息 通过左边的房间类型状态  获取所有已入住房间
    public List<Map<String,Object>> selectKongMapperMarkets(List<String> typeIds);




    /*
      快速分房
     */
    //快速分房右边下拉框房类接口
    public List<RoomType> findRoomTypeFenFangMapper();

    //快速分房建筑 楼的信息 需要传入 房类接口
    public List<Building> findBuildingFenFangMapper(String roomType);

    //快速分房楼层 需要传入 建筑编号
    public List<Floors> findFloorsFenFangMapper(String buildingCode);

    //快速分房通过查询 获取房间显示到左边
    public Map findRoomFenFangMapper(Map map);

    //添加房间的房间价格
    public void addRoomPricesMapper(RoomPrices roomPrices) throws Exception;



    //建筑信息添加
    public void insertBuild(Building building) throws Exception;

    //   楼层的信息添加
    public void insertFloor(Floors floors) throws Exception;

    //房间类型信息的添加
    public void insertRoomType(RoomType roomType) throws Exception;


    /**
     * 定时修改房间脏房净房状态
     */
     public void updateRoomSflagTimer();

    /**
     * 修改房间sflag
     */
     public Integer updateRoomSflag(@Param("sflag") String sflag,@Param("roomnos") List<String> roomnos);

    /**
     * 添加实时房价
     */
     public Integer insertRoomRealTimePrice(List<RealTimeRoomPrice> list);

    /**
     * 查询实时房价
     */
     public List<RealTimeRoomPrice> selectRoomRealTimePrice(@Param("time") String time);

    /**
     * 修改实时房价
     */
      public Integer updateRoomRealTimePrice(RealTimeRoomPrice realTimeRoomPrice);

     /**
      *判断实时房价是否存在
      */
     public Integer joinRoomRealTimePrice(RealTimeRoomPrice realTimeRoomPrice);

    /**
     * 删除错误房价
     */
     public Integer deleteErrorRoomRealTimePrice();

    /**
     * 删除过期实时房价
     */
      public Integer deleteLastRealTimePrice();

    /**
     * 删除全部房价
     */
      public Integer deleteAllRealTimePrice();



    /**
     * ----------------------------------------------
     *                消费项目
     * ----------------------------------------------
     */

     //获取所有消费项目
    public List<KfconsumerProjects> selectXfProjectAll();

    //插入客房消费记录
    public Integer insertXfConsumptionInfo(List<KfconsumpRecord> kfconsumpRecords);

    //删除客房消费记录
    public Integer deleteXfConsumptionInfo(@Param("bookingno") String bookingno);

    //删除单条客房消费记录
    public Integer deleteOneXfConsumptionInfo(String id);

    //查询订单所有消费记录
    public List<KfconsumpRecord> selectXfConsumptionInfo(String bookingno);
    //查询单个房间未付款消费信息
    public  List<KfconsumpRecord> selectXfRoomConsumptionInfo(@Param("bookingNo") String bookingNo ,@Param("roomid") String roomid);

    //查询单个房间所有消费信息
    public List<KfconsumpRecord> selectRoomConsumptionInfo(@Param("bookingNo") String bookingNo);

    //查询多个房间消费消费信息
    public List<KfconsumpRecord> selectXfRoomConsumptionInfoMultiple(Map map);

    //修改客房消费记录
    public Integer updateXfConsumptionInfo(KfconsumpRecord kfconsumpRecord);

    //通过房间ID查询房间号
    public String selectRoomNoByRoomId(String roomId);

    //查询房间所有预订信息
    public List<Quickbooking> selectRoomRetBooking(@Param("roomid") String bookid);

    //查询房间基本信息
    public Map selectRoomBaseInfo(String roomid);

    //查询客房房价
    public String selectRoomNowPrice(String roomId);


    //查询所有今天以前的订单详情
     public List<Quickbooking> selectPastQuickbooking();


     //修改预订单状态
    public Integer updateQuickbookingState(@Param("flag") String flag,@Param("id") String id);


    //删除预订单关联房间
     public Integer deleteQuickBookingRoom(@Param("bookid") String bookid,@Param("roomid") String roomid);
}
