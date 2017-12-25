package com.goodsoft.hotel.domain.dao;

import com.goodsoft.hotel.domain.entity.dto.HotelDTO;
import com.goodsoft.hotel.domain.entity.dto.OrderDTO;
import com.goodsoft.hotel.domain.entity.dto.RepastOrderDTO;
import com.goodsoft.hotel.domain.entity.repastorder.MenuCustomDO;
import com.goodsoft.hotel.domain.entity.repastorder.OrderDO;
import com.goodsoft.hotel.domain.entity.repastorder.OrderGoodsDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * description:
 * ===>餐饮菜单管理操作数据库接口类
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-11-15 9:27
 * @version V1.0
 */
@Repository
public interface RepastOrderDao {

    //餐饮订单查询
    List<OrderDO> queryRepastOrdersDao(HotelDTO param) throws Exception;


    /**
     * 餐饮订单查询(单条) 用于打印小票已使用其它方式代替不必调用接口实现
     *
     * @deprecated
     */
    @Deprecated
    OrderDO queryRepastOrderDao(@Param("id") String id, @Param("status") int status) throws Exception;

    //餐饮订单查询通过订单编号
    OrderDO queryRepastOrderByIdDao(@Param("id") String id, @Param("status") int status) throws Exception;

    //餐饮订单食品查询
    List<OrderGoodsDO> queryRepastOrderGoodsDao(@Param("oid") String oid) throws Exception;

    //查询开台后的订单时间，用于判断是否已达超时时间
    List<Map> queryKtOrderTimeDao() throws Exception;

    //自定义菜品（套餐）查询
    List<MenuCustomDO> queryMenuCustomDao(@Param("id") String id) throws Exception;

    //餐饮订单下单
    int addRepastOrderDao(OrderDO msg) throws Exception;

    //餐饮订单食品下单
    void addRepastOrderGoodsDao(List<OrderGoodsDO> msg) throws Exception;

    //自定义菜品（套餐）添加
    void addMenuCustomDao(List<MenuCustomDO> msg) throws Exception;

    //餐饮订单更新（用于打单）
    int updateRepastOrderDao(RepastOrderDTO msg) throws Exception;

    //换台更新订单餐台信息
    int updateOrderCTDao(@Param("tableId") String tableId, @Param("orderId") String orderId, @Param("aoh") String aoh);

    //餐饮订单更新（结算、修改）
    int checkoutRepastOrderDao(OrderDO msg) throws Exception;

    //反结账
    int updateOrderStatusDao(OrderDTO param) throws Exception;

    //餐饮订单商品更新（用于结算订单）
    int updateRepastOrderGoodsDao(List<OrderGoodsDO> msg) throws Exception;

    //餐饮订单取消
    int deleteRepastOrderDao(@Param("id") String id) throws Exception;

}
