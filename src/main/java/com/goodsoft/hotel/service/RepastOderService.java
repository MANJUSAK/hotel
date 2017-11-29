package com.goodsoft.hotel.service;

import com.goodsoft.hotel.domain.entity.param.PageParam;
import com.goodsoft.hotel.domain.entity.param.RepastOrderParam;
import com.goodsoft.hotel.domain.entity.repastorder.Order;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.exception.HotelDataBaseException;

/**
 * description:
 * ===>餐饮订单管理业务接口类，用于实现餐饮所有订单的管理，查询订单，下订单，修改订单。
 *
 * @author 严彬荣 Created on 2017-11-15 9:32
 * @version V1.0
 */
@SuppressWarnings("ALL")
public interface RepastOderService {

    /**
     * 餐饮订单查询业务方法，用于前台收银获取相关订单数据信息
     *
     * @param id   订单编号
     * @param page 分页信息
     * @param <T>
     * @return 查询数据
     * @throws Exception
     */
    <T> T queryOrderService(String id, PageParam page) throws Exception;

    /**
     * 通过订单号查询餐饮订单业务方法，用于开台跳转点餐页面获取该消费者订单信息
     *
     * @param id 订单编号
     * @return 查询数据
     * @throws Exception
     */
    <T> T queryOrderByIdService(String id) throws Exception;

    /**
     * 餐饮预订单开台订单添加（开台）业务方法，用于处理预订之后的点餐服务产生相应订单以便于收银获取相关订单数据信息
     * 返回该订单号用于添加商品明细或者修改订单
     *
     * @param order 订单信息
     * @return 下单状态
     * @throws Exception
     */
    <T> T addOrderService(Order order) throws Exception;

    /**
     * 餐饮订单商品添加（打单）业务方法，用于点餐服务产生相应订单以便于收银获取相关订单数据信息
     * 用于开台后用户点餐之后数据的提交
     *
     * @param order      订单信息
     * @param orderGoods 订单食品明细信息
     * @throws Exception
     */
    void addOrderGoodsService(RepastOrderParam msg) throws HotelDataBaseException;

    /**
     * 餐饮预订单开台订单修改（开台修改订单）业务方法，用于处理预订之后的顾客临时调整用餐信息时,
     * 产生相应订单以便于收银获取相关订单数据信息
     *
     * @param msg 订单信息
     * @return 更新结果
     * @throws Exception
     */
    Status updateRepastOrderService(Order msg) throws Exception;

    /**
     * 餐饮订单更新（结算订单）业务方法，用于前台收银结算相关订单
     *
     * @param order 订单结算信息
     * @return 结算结果
     * @throws Exception
     */
    Status checkoutRepastOrderService(Order order) throws Exception;

    /**
     * 餐饮订单删除（取消订单）业务方法，用于预订单处于取消状态时删除该预订单所产生的记录数据
     *
     * @param id 订单编号
     * @return 删除结果
     * @throws Exception
     */
    Status deteleRepastOrderServicr(String id) throws Exception;


}
