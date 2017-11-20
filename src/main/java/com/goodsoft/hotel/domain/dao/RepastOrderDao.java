package com.goodsoft.hotel.domain.dao;

import com.goodsoft.hotel.domain.entity.repastorder.Order;
import com.goodsoft.hotel.domain.entity.repastorder.OrderGoods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description:
 * ===>餐饮菜单管理操作数据库接口类
 *
 * @author 严彬荣 Created on 2017-11-15 9:27
 * @version V1.0
 */
@Repository
public interface RepastOrderDao {

    //餐饮订单查询
    List<Order> queryRepastOrderDao(@Param("id") String id, @Param("status") int status) throws Exception;

    //餐饮订单食品查询
    List<OrderGoods> queryRepastOrderGoodsDao(@Param("oid") String oid) throws Exception;

    //餐饮订单下单
    void addRepastOrderDao(Order msg) throws Exception;

    //餐饮订单食品下单
    void addRepastOrderGoodsDao(List<OrderGoods> msg) throws Exception;

}
