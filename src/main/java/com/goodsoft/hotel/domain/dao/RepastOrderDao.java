package com.goodsoft.hotel.domain.dao;

import com.goodsoft.hotel.domain.entity.param.HotelParam;
import com.goodsoft.hotel.domain.entity.repastorder.MenuCustom;
import com.goodsoft.hotel.domain.entity.repastorder.Order;
import com.goodsoft.hotel.domain.entity.repastorder.OrderGoods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
    List<Order> queryRepastOrderDao(HotelParam param) throws Exception;

    //餐饮订单查询通过订单编号
    Order queryRepastOrderByIdDao(@Param("id") String id) throws Exception;

    //餐饮订单食品查询
    List<OrderGoods> queryRepastOrderGoodsDao(@Param("oid") String oid) throws Exception;

    //查询开台后的订单时间，用于判断是否已达超时时间
    List<Map> queryKtOrderTimeDao() throws Exception;

    //自定义菜品（套餐）查询
    List<MenuCustom> queryMenuCustomDao(@Param("id") String id) throws Exception;

    //餐饮订单下单
    int addRepastOrderDao(Order msg) throws Exception;

    //餐饮订单食品下单
    void addRepastOrderGoodsDao(List<OrderGoods> msg) throws Exception;

    //自定义菜品（套餐）添加
    void addMenuCustomDao(List<MenuCustom> msg) throws Exception;

    //餐饮订单更新（用于结算订单）
    int updateRepastOrderDao(Order msg) throws Exception;

    //反结账
    int updateOrderStatusDao(@Param("id") String id, @Param("status") int status, @Param("fjzReason") String fjzReason) throws Exception;

    //餐饮订单商品更新（用于结算订单）
    int updateRepastOrderGoodsDao(List<OrderGoods> msg) throws Exception;

    //餐饮订单取消
    int deleteRepastOrderDao(@Param("id") String id) throws Exception;

}
