package com.goodsoft.hotel.controller;

import com.goodsoft.hotel.domain.entity.param.HotelParam;
import com.goodsoft.hotel.domain.entity.param.RepastOrderParam;
import com.goodsoft.hotel.domain.entity.repastorder.Order;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.exception.HotelDataBaseException;
import com.goodsoft.hotel.service.RepastOderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * description:
 * ===>餐饮订单管理访问接口入口类，用于实现餐饮所有订单的管理，查询订单、下订单
 *
 * @author 严彬荣 Created on 2017-11-15 9:30
 * @version V1.0
 */
@RestController
@RequestMapping("/repast")
public class RepastOrderController {

    @Resource
    private RepastOderService service;
    //实例化日志管理工具类
    private Logger logger = LoggerFactory.getLogger(RepastOrderController.class);

    /**
     * 餐饮订单查询接口，用于前台收银获取相关订单数据信息
     *
     * @param id 订单编号
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/order/data.shtml")
    public Object queryOrderController(String id, HotelParam page) {
        try {
            return this.service.queryOrderService(id, page);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }

    }

    /**
     * 通过订单号查询餐饮订单接口，用于开台跳转点餐页面获取该消费者订单信息
     *
     * @param id 订单编号
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/order/by/id/data.shtml")
    public Object queryOrderController(String id) {
        try {
            return this.service.queryOrderByIdService(id);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }

    }

    /**
     * 餐饮预订单开台订单添加（开台）接口，用于处理预订之后的点餐服务产生相应订单以便于收银获取相关订单数据信息
     * 返回该订单号用于添加商品明细或者修改订单
     *
     * @param order 订单信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/add/order/data.shtml", method = RequestMethod.POST)
    public Object addOrderService(Order order) {
        try {
            return this.service.addOrderService(order);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.ERROR_ORDER.getCODE(), StatusEnum.ERROR_ORDER.getEXPLAIN());
        }
    }

    /**
     * 餐饮订单商品添加（打单）接口，用于点餐服务产生相应订单以便于收银获取相关订单数据信息
     * 用于开台后用户点餐之后数据的提交
     *
     * @param msg 订单商品信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/add/order/goods/data.shtml", method = RequestMethod.POST)
    public Status addOrderService(@RequestBody RepastOrderParam msg) {
        if (msg.getMsg() != null) {
            if (msg.getMsg().size() > 0) {
                try {
                    this.service.addOrderGoodsService(msg);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (HotelDataBaseException e) {
                    this.logger.error(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), e.toString());
                }
            } else {
                return new Status(StatusEnum.NO_GOODS.getCODE(), StatusEnum.NO_GOODS.getEXPLAIN());
            }
        } else {
            return new Status(StatusEnum.NO_PRAM.getCODE(), StatusEnum.NO_PRAM.getEXPLAIN());
        }
    }

    /**
     * 餐饮预订单开台订单修改（开台后修改订单）接口，用于处理预订之后的顾客临时调整用餐信息时,
     * 产生相应订单以便于收银获取相关订单数据信息
     *
     * @param order 订单信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/update/order/data.shtml", method = RequestMethod.POST)
    public Status updateOrderService(Order order) {
        try {
            return this.service.updateRepastOrderService(order);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
        }

    }

    /**
     * 餐饮订单更新（结算订单）接口，用于前台收银结算相关订单
     *
     * @param order 订单结算信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/checkout/order/data.shtml", method = RequestMethod.POST)
    public Status checkoutOrderController(Order order) {
        try {
            return this.service.checkoutRepastOrderService(order);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
        }
    }

    /**
     * 餐饮订单更新（反结账）接口，用于前台收银相关订单结算错误回滚到可修改状态
     *
     * @param oid    订单编号
     * @param reason 反结账原因
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/counter/checkout/order/data.shtml", method = RequestMethod.POST)
    public Status counterCheckoutController(String oid, String reason) {
        try {
            return this.service.counterCheckoutService(oid, reason);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }

    /**
     * 餐饮订单删除（取消订单）接口，用于预订单处于取消状态时删除该预订单所产生的记录数据
     *
     * @param id 订单编号
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/delete/order/data.shtml", method = RequestMethod.POST)
    public Status deleteOrderService(String id) {
        try {
            return this.service.deteleRepastOrderServicr(id);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
        }
    }
}
