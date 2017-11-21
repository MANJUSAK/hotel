package com.goodsoft.hotel.service.lmpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goodsoft.hotel.domain.dao.RepastOrderDao;
import com.goodsoft.hotel.domain.entity.param.PageParam;
import com.goodsoft.hotel.domain.entity.repastorder.Order;
import com.goodsoft.hotel.domain.entity.repastorder.OrderGoods;
import com.goodsoft.hotel.domain.entity.result.Result;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.service.RepastOderService;
import com.goodsoft.hotel.util.OrderIdutil;
import com.goodsoft.hotel.util.UUIDUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 * ===>餐饮订单管理业务接口实现类，用于实现餐饮所有订单的管理，查询订单、下订单
 *
 * @author 严彬荣 Created on 2017-11-17 9:46
 * @version V1.0
 */
@SuppressWarnings("ALL")
@Service
public class RepastOderServicelmpl implements RepastOderService {
    @Resource
    private RepastOrderDao dao;
    //实例化UUID工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();
    //实例化订单编号生成工具类
    private OrderIdutil orderId = OrderIdutil.getInstance();

    /**
     * 餐饮订单查询业务方法，用于前台收银获取相关订单数据信息
     *
     * @param id     订单编号
     * @param status 订单状态（0为未支付/1为已支付），默认查询未支付订单
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryOrderService(String id, PageParam page) throws Exception {
        Page<Object> pages = PageHelper.startPage(page.getPage(), page.getTotal());
        int status = page.getStatus();
        List<Order> list = this.dao.queryRepastOrderDao(id, status);
        int len = list.size();
        if (len > 0) {
            for (int i = 0; i < len; ++i) {
                List<OrderGoods> list1 = this.dao.queryRepastOrderGoodsDao(list.get(i).getId());
                if (list1.size() > 0) {
                    list.get(i).setOrderGoods(list1);
                }
            }
            PageInfo<Order> data = new PageInfo<>(list);
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 餐饮订单添加（下订单）业务方法，用于点餐服务产生相应订单以便于收银获取相关订单数据信息
     *
     * @param order      订单信息
     * @param orderGoods 订单食品明细信息
     * @throws Exception
     */
    @Override
    public void addOrderService(Order order, List<OrderGoods> orderGoods) throws Exception {
        String id = this.orderId.getOrderId().toString();
        order.setId(id);
        for (int i = 0, len = orderGoods.size(); i < len; ++i) {
            orderGoods.get(i).setId(this.uuid.getUUID().toString());
            orderGoods.get(i).setOid(id);
        }
        this.dao.addRepastOrderDao(order);
        this.dao.addRepastOrderGoodsDao(orderGoods);
    }

    /**
     * 餐饮订单更新（结算订单）业务方法，用于前台收银结算相关订单
     *
     * @param msg        订单结算信息
     * @param orderGoods 订单商品结算明细信息
     * @return 结算信息
     * @throws Exception
     */
    @Override
    public Status updateRepastOrderService(Order msg, List<OrderGoods> orderGoods) throws Exception {
        int num = this.dao.updateRepastOrderDao(msg);
        if (num > 0) {
            int num1 = this.dao.updateRepastOrderGoodsDao(orderGoods);
            if (num1 > 0) {
                return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
            }
            return new Status(StatusEnum.PAYZ_THE_BILL.getCODE(), StatusEnum.PAYZ_THE_BILL.getEXPLAIN());
        }
        return new Status(StatusEnum.PAYZ_THE_BILL.getCODE(), StatusEnum.PAYZ_THE_BILL.getEXPLAIN());
    }
}
