package com.goodsoft.hotel.service.lmpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goodsoft.hotel.domain.dao.CookBookDao;
import com.goodsoft.hotel.domain.dao.CyFloorDao;
import com.goodsoft.hotel.domain.dao.CyReserveDao;
import com.goodsoft.hotel.domain.dao.RepastOrderDao;
import com.goodsoft.hotel.domain.entity.cookbook.SetMealDetail;
import com.goodsoft.hotel.domain.entity.param.HotelParam;
import com.goodsoft.hotel.domain.entity.param.RepastOrderParam;
import com.goodsoft.hotel.domain.entity.repastorder.MenuCustom;
import com.goodsoft.hotel.domain.entity.repastorder.Order;
import com.goodsoft.hotel.domain.entity.repastorder.OrderGoods;
import com.goodsoft.hotel.domain.entity.result.Result;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.exception.HotelApplicationException;
import com.goodsoft.hotel.exception.HotelDataBaseException;
import com.goodsoft.hotel.service.RepastOderService;
import com.goodsoft.hotel.service.supp.OrderIdsupp;
import com.goodsoft.hotel.util.UUIDUtil;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * description:
 * ===>餐饮订单管理业务接口实现类，用于实现餐饮所有订单的管理，查询订单、下订单
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-11-17 9:46
 * @version V1.0
 */
@SuppressWarnings("ALL")
@Service
public class RepastOderServicelmpl implements RepastOderService {
    @Resource
    private RepastOrderDao dao;
    @Resource
    private CyFloorDao cydao;
    @Resource
    private CyReserveDao cyReserveDao;
    @Resource
    private CookBookDao cbDao;
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;
    //实例化订单编号生成工具类
    @Resource
    private OrderIdsupp orderId;
    //实例化UUID工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();


    /**
     * @param id 订单编号
     * @return 查询数据
     * @throws Exception
     * @deprecated 餐饮订单查询单条业务方法，获取餐饮订单数据信息用于打印机打票
     * 注：id为必传
     * 该接口涵盖了订单的所有信息
     */
    @Override
    public <T> T queryOrderService(String id) throws Exception {
        Order data = this.dao.queryRepastOrderDao(id, 1);
        if (data != null) {
            //订单商品详情
            List<OrderGoods> list1 = this.dao.queryRepastOrderGoodsDao(data.getId());
            int len1 = list1.size();
            if (len1 > 0) {
                for (int j = 0; j < len1; ++j) {
                    //是否存在套餐
                    String tcid = list1.get(j).getTcid();
                    if (tcid != null && !("".equals(tcid))) {
                        List<SetMealDetail> list2 = this.cbDao.querySetMealDetailDao(tcid);
                        if (list2.size() > 0) {
                            list1.get(j).setSetMealDetails(list2);
                        }
                    }
                    //是否存在自定义套餐
                    String customId = list1.get(j).getZdyTcid();
                    if (tcid != null && !("".equals(tcid))) {
                        List<MenuCustom> list2 = this.dao.queryMenuCustomDao(customId);
                        if (list2.size() > 0) {
                            list1.get(j).setSetMealCustoms(list2);
                        }
                    }
                }
                data.setOrderGoods(list1);
            }
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 餐饮订单查询业务方法，用于获取餐饮所有订单数据信息
     * 注：无参状态下默认查询已结算的所有订单，前台查询订单状态需传入status字段
     * （status=0支付/1开台/2打单/3超时未买单/4迟付/5取消/6反结）
     * 该接口涵盖了订单的所有信息
     *
     * @param param 查询条件
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryOrderService(HotelParam param) throws Exception {
        Page<T> pages = PageHelper.startPage(param.getPage(), param.getTotal());
        List<Order> list = this.dao.queryRepastOrdersDao(param);
        int len = list.size();
        if (len > 0) {
            for (int i = 0; i < len; ++i) {
                //订单商品详情
                List<OrderGoods> list1 = this.dao.queryRepastOrderGoodsDao(list.get(i).getId());
                int len1 = list1.size();
                if (len1 > 0) {
                    for (int j = 0; j < len1; ++j) {
                        //是否存在套餐
                        String tcid = list1.get(j).getTcid();
                        if (tcid != null && !("".equals(tcid))) {
                            List<SetMealDetail> list2 = this.cbDao.querySetMealDetailDao(tcid);
                            if (list2.size() > 0) {
                                list1.get(j).setSetMealDetails(list2);
                            }
                        }
                        //是否存在自定义套餐
                        String customId = list1.get(j).getZdyTcid();
                        if (customId != null && !("".equals(customId))) {
                            List<MenuCustom> list2 = this.dao.queryMenuCustomDao(customId);
                            if (list2.size() > 0) {
                                list1.get(j).setSetMealCustoms(list2);
                            }
                        }
                    }
                    list.get(i).setOrderGoods(list1);
                }
            }
            PageInfo<Order> data = new PageInfo<Order>(list);
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 通过订单号查询订单业务方法，用于开台跳转点餐页面获取该消费者订单信息
     * 注：开台后必须获取开台订单信息（id必传，否则开台后无法打单）
     * 该接口为开台后获取订单信息接口
     *
     * @param id 订单编号
     * @return 查询数据
     * @throws Exception
     */
    @Override
    public <T> T queryOrderByIdService(String id) throws Exception {
        Order data = this.dao.queryRepastOrderByIdDao(id);
        if (data != null) {
            //订单商品详情
            List<OrderGoods> list = this.dao.queryRepastOrderGoodsDao(id);
            int len = list.size();
            if (len > 0) {
                for (int j = 0; j < len; ++j) {
                    //是否存在套餐
                    String tcid = list.get(j).getTcid();
                    if (tcid != null && !("".equals(tcid))) {
                        List<SetMealDetail> list1 = this.cbDao.querySetMealDetailDao(tcid);
                        if (list1.size() > 0) {
                            list.get(j).setSetMealDetails(list1);
                        }
                    }
                    //是否存在自定义套餐
                    String customId = list.get(j).getZdyTcid();
                    if (customId != null && !("".equals(customId))) {
                        List<MenuCustom> list1 = this.dao.queryMenuCustomDao(customId);
                        if (list1.size() > 0) {
                            list.get(j).setSetMealCustoms(list1);
                        }
                    }
                }
                data.setOrderGoods(list);
            }
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * * 餐饮预订开台订单添加（开台）业务方法，用于处理预订之后的点餐服务产生相应订单以便于收银获取相关订单数据信息
     * 返回该订单号用于添加商品明细或者修改订单
     * 该接口用于楼面开台生成新订单，以便点餐时获取开台订单数据
     *
     * @param order 订单信息
     * @return 下单状态
     * @throws Exception
     */
    @Transactional
    @Override
    public <T> T addOrderService(Order order) throws Exception {
        String id = null;
        try {
            id = this.orderId.getOrderId().toString();
        } catch (HotelApplicationException e) {
            throw new HotelApplicationException(StatusEnum.SERVER_ERROR.getEXPLAIN());
        }
        //预订编号
        String ydid = order.getId();
        order.setId(id);
        order.setStatus(1);
        int row = this.dao.addRepastOrderDao(order);
        if (row > 0) {
            this.cyReserveDao.updateAloneReserveState("3", ydid);
            this.cydao.updateTableState(order.getCtid(), "8");
            return (T) new Result(0, id);
        }
        return (T) new Status(StatusEnum.NO_ORDER.getCODE(), StatusEnum.NO_ORDER.getEXPLAIN());
    }

    /**
     * 餐饮订单商品添加（打单、落单、先落）业务方法，用于点餐服务产生相应订单以便于收银获取相关订单数据信息
     * 用于开台后用户点餐之后数据的提交
     * 该业务方法用于点餐员点完菜之后的打单、落单、先落服务，并保存点餐信息用于厨房做菜服务
     * 注：打单调用该业务方法时需额外传入status=2（必传）
     *
     * @param msg 订单商品信息
     * @throws Exception
     */
    @Transactional
    @Override
    public void addOrderGoodsService(RepastOrderParam msg) throws HotelDataBaseException {
        SqlSession sqlSession = this.sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        RepastOrderDao orderDao = sqlSession.getMapper(RepastOrderDao.class);
        String id = msg.getId();
        List<OrderGoods> orderGoods = msg.getMsg();
        List<MenuCustom> menuCustoms = null;
        int len1 = 0;
        for (int i = 0, len = orderGoods.size(); i < len; ++i) {
            orderGoods.get(i).setId(this.uuid.getUUID("CY").toString());
            orderGoods.get(i).setOid(id);
            menuCustoms = orderGoods.get(i).getSetMealCustoms();
            //是否存在自定义套餐
            if (menuCustoms != null) {
                len1 = menuCustoms.size();
                if (len1 > 0) {
                    String zdytcid = this.uuid.getUUID("CY").toString();
                    orderGoods.get(i).setZdyTcid(zdytcid);
                    for (int j = 0; j < len1; ++j) {
                        menuCustoms.get(j).setId(this.uuid.getUUID("CY").toString());
                        menuCustoms.get(j).setCustomId(zdytcid);
                    }
                }
            }
        }
        try {
            if (menuCustoms != null && len1 > 0) {
                orderDao.addMenuCustomDao(menuCustoms);
            }
            orderDao.addRepastOrderGoodsDao(orderGoods);
            orderDao.updateRepastOrderDao(msg);
            this.cydao.updateTableState(msg.getCtid(), "4");
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            throw new HotelDataBaseException(StatusEnum.DATABASE_ERROR.getEXPLAIN());
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 餐饮预订单开台订单修改（开台后修改订单）业务方法，用于处理预订之后的顾客临时调整用餐信息时,
     * 产生相应订单以便于收银获取相关订单数据信息
     *
     * @param msg 订单信息
     * @return 更新结果
     * @throws Exception
     */
    @Override
    public Status updateRepastOrderService(Order msg) throws Exception {
        int row = this.dao.checkoutRepastOrderDao(msg);
        if (row > 0) {
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        }
        return new Status(StatusEnum.NO_GOODS.getCODE(), StatusEnum.NO_GOODS.getEXPLAIN());
    }

    /**
     * 餐饮订单更新（结算订单）业务方法，用于前台收银结算相关订单
     * 该接口用于收银员结算消费者消费信息，经过改接口的所有订单将不可进行任何操作。
     *
     * @param order 订单结算信息
     * @return 结算结果
     * @throws Exception
     */
    @Override
    public Status checkoutRepastOrderService(Order order) throws Exception {
        order.setMdTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        int row = this.dao.checkoutRepastOrderDao(order);
        if (row > 0) {
            //更新餐台状态为清洁中
            try {
                this.cydao.updateTableState(order.getCtid(), "7");
            } catch (Exception e) {
            }
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        }
        return new Status(StatusEnum.PAYZ_THE_BILL.getCODE(), StatusEnum.PAYZ_THE_BILL.getEXPLAIN());
    }

    /**
     * 餐饮订单更新（反结账，迟付等）业务方法，用于前台收银相关订单结算错误回滚到可修改状态或迟付等
     * 1.该接口用于前台收银员结算错误的订单之后将订单设置为可编辑状态
     * 2.该接口用于前台收银员将此订单推迟支付
     *
     * @param oid    订单编号
     * @param reason 反结账，迟付等原因
     * @param status 订单状态
     * @return Status 结果
     * @throws Exception
     */
    @Override
    @Transactional
    public Status counterCheckoutService(String oid, int status, String reason) throws Exception {
        int row = this.dao.updateOrderStatusDao(oid, status, reason);
        if (row > 0) {
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        }
        return new Status(StatusEnum.NO_GOODS.getCODE(), StatusEnum.NO_GOODS.getEXPLAIN());
    }

    /**
     * 餐饮订单删除（取消订单）业务方法，用于预订单处于取消状态时删除该预订单所产生的记录数据
     *
     * @param id 订单编号
     * @return 删除结果
     * @throws Exception
     */
    @Override
    public Status deteleRepastOrderServicr(String id) throws Exception {
        int row = this.dao.deleteRepastOrderDao(id);
        if (row > 0) {
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        }
        return new Status(StatusEnum.DEL_ORDER.getCODE(), StatusEnum.DEL_ORDER.getEXPLAIN());
    }
}
