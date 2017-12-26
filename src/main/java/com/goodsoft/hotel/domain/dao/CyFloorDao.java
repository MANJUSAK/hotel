package com.goodsoft.hotel.domain.dao;

import com.goodsoft.hotel.domain.entity.floor.Diningtable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by duyuxiang on 2017/11/17.
 * 餐饮楼面
 */
@Repository
public interface CyFloorDao {

    //查询所有餐台
    public List<Map> selectTableInfos(Map map);


    /**
     * 修改餐台状态
     *
     * @param tableId
     * @param status
     * @return
     */
    public Integer updateTableState(@Param("tableId") String tableId, @Param("status") String status);


    //查询餐台各状态数量
    public Map<String, Integer> selectTableStateForNumber();


    //修改订单状态
    public Integer updateOrderStatusDao(@Param("id") String id);


    //查询当前厅所有空闲餐台
    public List<Diningtable> selectFreeTables(@Param("tableId") String tableId);

    //查询餐台买单时间
    public List<String> selectOrderMdTime(@Param("tableId") String tableId);

}
