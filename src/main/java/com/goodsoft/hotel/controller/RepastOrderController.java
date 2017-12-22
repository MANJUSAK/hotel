package com.goodsoft.hotel.controller;

import com.goodsoft.hotel.domain.entity.dto.HotelDTO;
import com.goodsoft.hotel.domain.entity.dto.OrderDTO;
import com.goodsoft.hotel.domain.entity.dto.RepastOrderDTO;
import com.goodsoft.hotel.domain.entity.repastorder.OrderDO;
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
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-11-15 9:30
 * @version V1.0
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/repast")
public class RepastOrderController {

    @Resource
    private RepastOderService service;
    //实例化日志管理工具类
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @param id 订单编号
     * @return 响应结果
     * @deprecated 餐饮订单查询单条接口，获取餐饮订单数据信息用于打印机打票已使用其它方式代替不必调用接口实现
     * 注：id为必传
     * 该接口涵盖了订单的所有信息
     */
    @Deprecated
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/find/order/data.shtml")
    public <T> T queryOrderOneController(String id) {
        try {
            if (id != null && !("".equals(id))) {
                return this.service.queryOrderService(id);
            }
            return (T) new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN() + "原因：id的值为null或为空");
        } catch (Exception e) {
            this.logger.error(e.toString());
            return (T) new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }

    }

    /**
     * 餐饮订单查询接口，用于获取餐饮所有订单数据信息
     * 注：无参状态下默认查询已结算的所有订单，前台查询订单状态需传入status字段
     * （status=0支付/1开台/2打单或反结/3超时未买单/4迟付/5取消）
     * 该接口涵盖了订单的所有信息
     *
     * @param param 可传入参数：page 页码、total 总记录数
     *              id 订单编号、status 订单状态
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/order/data.shtml")
    public <T> T queryOrderController(HotelDTO param) {
        try {
            return this.service.queryOrderService(param);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return (T) new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }

    }

    /**
     * 通过订单号查询订单接口，用于开台跳转点餐页面获取该消费者订单信息
     * 注：开台后必须获取开台订单信息（id必传，否则开台后无法打单）
     * 该接口为获取订单信息(返回单条数据)
     *
     * @param id 订单编号
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/order/by/id/data.shtml")
    public <T> T queryOrderController(String id, int status) {
        try {
            return this.service.queryOrderByIdService(id, status);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return (T) new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }

    }

    /**
     * 餐饮预订开台订单添加（开台）接口，用于处理预订之后的点餐服务产生相应订单以便于收银获取相关订单数据信息
     * 返回该订单号用于添加商品明细或者修改订单
     * 该接口用于楼面开台生成新订单，以便点餐时获取开台订单数据
     *
     * @param orderDO 订单信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/add/order/data.shtml", method = RequestMethod.POST)
    public <T> T addOrderService(OrderDO orderDO) {
        try {
            return this.service.addOrderService(orderDO);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return (T) new Status(StatusEnum.ERROR_ORDER.getCODE(), StatusEnum.ERROR_ORDER.getEXPLAIN());
        }
    }

    /**
     * 餐饮订单商品添加（打单、落单、先落）接口，用于点餐服务产生相应订单以便于收银获取相关订单数据信息
     * 用于开台后用户点餐之后数据的提交
     * 该接口用于点餐员点完菜之后的打单、落单、先落服务，并保存点餐信息用于厨房做菜服务
     * 注：打单调用该接口时需额外传入status=2（必传）
     *
     * @param msg 订单商品信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/add/order/goods/data.shtml", method = RequestMethod.POST)
    public Status addOrderService(@RequestBody RepastOrderDTO msg) {
        if (msg.getMsg() != null) {
            if (msg.getMsg().size() > 0) {
                try {
                    this.service.addOrderGoodsService(msg);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (HotelDataBaseException e) {
                    this.logger.error(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), e.toString());
                }
            }
            return new Status(StatusEnum.NO_GOODS.getCODE(), StatusEnum.NO_GOODS.getEXPLAIN());
        }
        return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN());
    }

    /**
     * 该接口未启用（待使用）
     * 餐饮预订单开台订单修改（开台后修改订单）接口，用于处理预订之后的顾客临时调整用餐信息时,
     * 产生相应订单以便于收银获取相关订单数据信息
     *
     * @param orderDO 订单信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/update/order/data.shtml", method = RequestMethod.POST)
    public Status updateOrderService(OrderDO orderDO) {
        try {
            return this.service.updateRepastOrderService(orderDO);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
        }

    }

    /**
     * 餐饮订单更新（结算订单）接口，用于前台收银结算相关订单
     * 该接口用于收银员结算消费者消费信息，经过改接口的所有订单将不可进行任何操作。
     *
     * @param orderDO 订单结算信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/checkout/order/data.shtml", method = RequestMethod.POST)
    public Status checkoutOrderController(OrderDO order) {
        try {
            return this.service.checkoutRepastOrderService(order);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
        }
    }

    /**
     * 餐饮订单更新（反结账，迟付等）接口，用于前台收银相关订单结算错误回滚到可修改状态或迟付等
     * 1.该接口用于前台收银员结算错误的订单之后将订单设置为可编辑状态
     * 2.该接口用于前台收银员将此订单推迟支付
     *
     * @param oid    订单编号
     * @param reason 反结账，迟付等原因
     * @param status 订单状态
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/counter/checkout/order/data.shtml", method = RequestMethod.POST)
    public Status counterCheckoutController(OrderDTO param) {
        boolean pm = (param.getOid() != null && param.getOid() != "" && param.getStatus() > 0);
        if (pm) {
            try {
                return this.service.counterCheckoutService(param);
            } catch (Exception e) {
                this.logger.error(e.toString());
                return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
            }
        }
        return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN() + "原因可能为oid为空或null、status小于0");
    }

    /**
     * 该接口未启用（待用）
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
