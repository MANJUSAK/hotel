package com.goodsoft.hotel.controller;

import com.goodsoft.hotel.domain.entity.param.PageParam;
import com.goodsoft.hotel.domain.entity.param.RepastOrderParam;
import com.goodsoft.hotel.domain.entity.repastorder.Order;
import com.goodsoft.hotel.domain.entity.repastorder.OrderGoods;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.service.RepastOderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
    public Object queryOrderController(String id, PageParam page) {
        try {
            return this.service.queryOrderService(id, page);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

    /**
     * 餐饮订单添加（下订单）接口，用于点餐服务产生相应订单以便于收银获取相关订单数据信息
     *
     * @param order 订单信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/add/order/data.shtml", method = RequestMethod.POST)
    public Status addOrderService(Order order, RepastOrderParam msg) {
        if (msg != null) {
            List<OrderGoods> orderGoods = msg.getMsg();
            if (orderGoods != null) {
                try {
                    this.service.addOrderService(order, orderGoods);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } catch (Exception e) {
                    this.logger.error(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
            }
            return new Status(StatusEnum.NO_GOODS.getCODE(), StatusEnum.NO_GOODS.getEXPLAIN());
        }
        return new Status(StatusEnum.NO_PRAM.getCODE(), StatusEnum.NO_PRAM.getEXPLAIN());
    }

    /**
     * 餐饮订单添加（下订单）接口，用于点餐服务产生相应订单以便于收银获取相关订单数据信息
     *
     * @param order 订单信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/update/order/data.shtml", method = RequestMethod.POST)
    public Status updateOrderService(Order order, RepastOrderParam msg) {
        if (msg != null) {
            List<OrderGoods> orderGoods = msg.getMsg();
            if (orderGoods != null) {
                try {
                    return this.service.updateRepastOrderService(order, orderGoods);
                } catch (Exception e) {
                    this.logger.error(e.toString());
                    return new Status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
                }
            }
            return new Status(StatusEnum.NO_GOODS.getCODE(), StatusEnum.NO_GOODS.getEXPLAIN());
        }
        return new Status(StatusEnum.NO_PRAM.getCODE(), StatusEnum.NO_PRAM.getEXPLAIN());
    }
}
