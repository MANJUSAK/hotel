package com.goodsoft.hotel.service;

import com.goodsoft.hotel.domain.entity.param.PageParam;
import com.goodsoft.hotel.domain.entity.repastorder.Order;
import com.goodsoft.hotel.domain.entity.repastorder.OrderGoods;
import com.goodsoft.hotel.domain.entity.result.Status;

import java.util.List;

/**
 * description:
 * ===>餐饮订单管理业务接口类，用于实现餐饮所有订单的管理，查询订单，下订单。
 *
 * @author 严彬荣 Created on 2017-11-15 9:32
 * @version V1.0
 */
public interface RepastOderService {

    /**
     * 餐饮订单查询业务方法，用于前台收银获取相关订单数据信息
     *
     * @param id  订单编号
     * @param <T>
     * @return 查询数据
     * @throws Exception
     */
    <T> T queryOrderService(String id, PageParam page) throws Exception;

    /**
     * 餐饮订单添加（下订单）业务方法，用于点餐服务产生相应订单以便于收银获取相关订单数据信息
     *
     * @param order      订单信息
     * @param orderGoods 订单食品明细信息
     * @throws Exception
     */
    void addOrderService(Order order, List<OrderGoods> orderGoods) throws Exception;

    /**
     * 餐饮订单更新（结算订单）业务方法，用于前台收银结算相关订单
     *
     * @param msg        订单结算信息
     * @param orderGoods 订单商品结算明细信息
     * @return 结算信息
     * @throws Exception
     */
    Status updateRepastOrderService(Order msg, List<OrderGoods> orderGoods) throws Exception;


}
