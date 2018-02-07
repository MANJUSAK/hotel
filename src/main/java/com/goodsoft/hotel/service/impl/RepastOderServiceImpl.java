package com.goodsoft.hotel.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goodsoft.hotel.domain.dao.CookBookDao;
import com.goodsoft.hotel.domain.dao.CyFloorDao;
import com.goodsoft.hotel.domain.dao.CyReserveDao;
import com.goodsoft.hotel.domain.dao.RepastOrderDao;
import com.goodsoft.hotel.domain.dao.guestRoom.RoomSDao;
import com.goodsoft.hotel.domain.entity.cookbook.SetMealDetailDO;
import com.goodsoft.hotel.domain.entity.dto.HotelDTO;
import com.goodsoft.hotel.domain.entity.dto.OneCardDTO;
import com.goodsoft.hotel.domain.entity.dto.OrderDTO;
import com.goodsoft.hotel.domain.entity.dto.RepastOrderDTO;
import com.goodsoft.hotel.domain.entity.repastorder.MenuCustomDO;
import com.goodsoft.hotel.domain.entity.repastorder.OrderDO;
import com.goodsoft.hotel.domain.entity.repastorder.OrderGoodsDO;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * description:
 * ===>餐饮订单管理业务接口实现类，用于实现餐饮所有订单的管理，查询订单、下订单
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-11-17 9:46
 * @version V1.0
 */
@SuppressWarnings("ALL")
@Service("repastOderServiceImpl")
public class RepastOderServiceImpl implements RepastOderService {
    @Resource
    private RepastOrderDao dao;
    @Resource
    private CyFloorDao cydao;
    @Resource
    private CyReserveDao cyReserveDao;
    @Resource
    private CookBookDao cbDao;
    @Resource
    private RoomSDao roomSDao;
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;
    @Resource
    private OrderIdsupp orderId;
    /**
     * 实例化UUID工具类
     */
    private UUIDUtil uuid = UUIDUtil.getInstance();
    /**
     * 打单状态
     */
    private final int STATUS_2 = 2;
    /**
     * 支付方式为一卡通
     */
    private final int STATUS_6 = 6;


    /**
     * 餐饮订单查询单条业务方法，获取餐饮订单数据信息用于打印机打票已使用其它方式代替不必调用接口实现
     *
     * @param id 订单编号
     * @return 查询数据
     * @throws Exception 异常
     * @deprecated 餐饮订单查询单条业务方法，获取餐饮订单数据信息用于打印机打票已使用其它方式代替不必调用接口实现
     * 注：id为必传
     * 该接口涵盖了订单的所有信息
     */
    @Deprecated
    @Override
    public <T> T queryOrderService(String id) throws Exception {
        OrderDO data = this.dao.queryRepastOrderDao(id, 1);
        if (data != null) {
            //订单商品详情
            List<OrderGoodsDO> list1 = this.dao.queryRepastOrderGoodsDao(data.getId());
            int len1 = list1.size();
            if (len1 > 0) {
                for (int j = 0; j < len1; ++j) {
                    //是否存在套餐
                    String tcid = list1.get(j).getTcid();
                    if (tcid != null && !("".equals(tcid))) {
                        List<SetMealDetailDO> list2 = this.cbDao.querySetMealDetailDao(tcid);
                        if (list2.size() > 0) {
                            list1.get(j).setSetMealDetail(list2);
                        }
                    }
                    //是否存在自定义套餐
                    String customId = list1.get(j).getZdyTcid();
                    if (tcid != null && !("".equals(tcid))) {
                        List<MenuCustomDO> list2 = this.dao.queryMenuCustomDao(customId);
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
     * （status=0支付/1开台/2打单或反结/3超时未买单/4迟付/5取消）
     * 该接口涵盖了订单的所有信息
     *
     * @param param 查询条件
     * @return 查询数据
     * @throws Exception 异常
     */
    @Override
    public <T> T queryOrderService(HotelDTO param) throws Exception {
        Page<T> pages = PageHelper.startPage(param.getPage(), param.getTotal());
        List<OrderDO> list = this.dao.queryRepastOrdersDao(param);
        int len = list.size();
        if (len > 0) {
            for (int i = 0; i < len; ++i) {
                //订单商品详情
                List<OrderGoodsDO> list1 = this.dao.queryRepastOrderGoodsDao(list.get(i).getId());
                int len1 = list1.size();
                if (len1 > 0) {
                    for (int j = 0; j < len1; ++j) {
                        //是否存在套餐
                        String tcid = list1.get(j).getTcid();
                        if (tcid != null && !("".equals(tcid))) {
                            List<SetMealDetailDO> list2 = this.cbDao.querySetMealDetailDao(tcid);
                            if (list2.size() > 0) {
                                list1.get(j).setSetMealDetail(list2);
                            }
                        }
                        //是否存在自定义套餐
                        String customId = list1.get(j).getZdyTcid();
                        if (customId != null && !("".equals(customId))) {
                            List<MenuCustomDO> list2 = this.dao.queryMenuCustomDao(customId);
                            if (list2.size() > 0) {
                                list1.get(j).setSetMealCustoms(list2);
                            }
                        }
                    }
                    list.get(i).setOrderGoods(list1);
                }
            }
            PageInfo<OrderDO> data = new PageInfo<OrderDO>(list);
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 通过订单号查询订单业务方法，用于开台或加餐跳转点餐页面获取该消费者订单信息
     * 注：开台后必须获取开台订单信息（id必传，否则开台后无法打单）
     * 该接口为开台后获取订单信息接口
     *
     * @param id     订单编号
     * @param status 订单状态
     * @return 查询数据
     * @throws Exception 异常
     */
    @Override
    public <T> T queryOrderByIdService(String id, int status) throws Exception {
        OrderDO data = this.dao.queryRepastOrderByIdDao(id, status);
        if (data != null) {
            //订单商品详情
            List<OrderGoodsDO> list = this.dao.queryRepastOrderGoodsDao(id);
            int len = list.size();
            if (len > 0) {
                for (int j = 0; j < len; ++j) {
                    //是否存在套餐
                    String tcid = list.get(j).getTcid();
                    if (tcid != null && !("".equals(tcid))) {
                        List<SetMealDetailDO> list1 = this.cbDao.querySetMealDetailDao(tcid);
                        if (list1.size() > 0) {
                            list.get(j).setSetMealDetail(list1);
                        }
                    }
                    //是否存在自定义套餐
                    String customId = list.get(j).getZdyTcid();
                    if (customId != null && !("".equals(customId))) {
                        List<MenuCustomDO> list1 = this.dao.queryMenuCustomDao(customId);
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
     * @throws Exception 异常
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public <T> T addOrderService(OrderDO order) throws Exception {
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
     * @throws HotelDataBaseException 异常
     */
    @Transactional(rollbackFor = HotelDataBaseException.class)
    @Override
    public Status addOrderGoodsService(RepastOrderDTO msg) throws HotelDataBaseException {
        SqlSession sqlSession = this.sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        RepastOrderDao orderDao = sqlSession.getMapper(RepastOrderDao.class);
        String id = msg.getId();
        List<OrderGoodsDO> orderGoods = msg.getMsg();
        List<MenuCustomDO> menuCustom = null;
        int len = orderGoods.size();
        int len1 = 0;
        for (int i = 0; i < len; ++i) {
            orderGoods.get(i).setId(this.uuid.getUUID("CY").toString());
            orderGoods.get(i).setOid(id);
            menuCustom = orderGoods.get(i).getSetMealCustoms();
            //是否存在自定义套餐
            if (menuCustom != null) {
                len1 = menuCustom.size();
                if (len1 > 0) {
                    String zdytcid = this.uuid.getUUID("CY").toString();
                    orderGoods.get(i).setZdyTcid(zdytcid);
                    for (int j = 0; j < len1; ++j) {
                        menuCustom.get(j).setId(this.uuid.getUUID("CY").toString());
                        menuCustom.get(j).setCustomId(zdytcid);
                    }
                }
            }
        }
        try {
            if (menuCustom != null && len1 > 0) {
                orderDao.addMenuCustomDao(menuCustom);
            }
            if (len > 0) {
                orderDao.addRepastOrderGoodsDao(orderGoods);
            }
            orderDao.updateRepastOrderDao(msg);
            if (msg.getStatus() == this.STATUS_2) {
                int row = this.cydao.updateTableState(msg.getCtid(), "4");
                if (row == 0) {
                    return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN() + "不能获取餐台信息");
                }
            }
            sqlSession.commit();
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
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
     * @throws Exception 异常
     */
    @Override
    public Status updateRepastOrderService(OrderDO msg) throws Exception {
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
     * @throws Exception 异常
     */
    @Override
    public Status checkoutRepastOrderService(OrderDO order) throws Exception {
        //一卡通结算支付时将订单打到一卡通，消费者退房时统一结算
        if (order.getPaymentType() == this.STATUS_6) {
            String roomId = order.getRoomId();
            if (roomId == null || "".equals(roomId)) {
                return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN() + "原因：roomId为空或为null");
            }
            Map<String, String> room = this.dao.getRoomIdDao(roomId);
            boolean payType = room != null && room.size() > 0;
            if (payType) {
                List<OneCardDTO> list = new ArrayList<OneCardDTO>();
                OneCardDTO oc = new OneCardDTO();
                oc.setId(order.getId());
                oc.setRoomno(room.get("roomno"));
                String id = room.get("id");
                oc.setRoomid(id);
                //获取一卡通id保存到该消费者当前消费的订单中，以便于后期关联使用
                order.setRoomId(id);
                oc.setBookingno(room.get("bookingno"));
                oc.setDiscount(String.valueOf(order.getQdDiscount()));
                oc.setGuestname(order.getConsumer());
                oc.setUnitprice(String.valueOf(order.getOrderPrice()));
                list.add(oc);
                this.roomSDao.insertXfConsumptionInfo(list);
            } else {
                return new Status(StatusEnum.NO_ONECARD.getCODE(), StatusEnum.NO_ONECARD.getEXPLAIN());
            }
        }
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
     * 1.该业务方法用于前台收银员结算错误的订单之后将订单设置为可编辑状态
     * 2.该业务方法用于前台收银员将此订单推迟支付
     * 3.由于反结情况特殊需做特殊处理（status=2）
     *
     * @param param [oid:订单编号/reason 反结账，迟付等原因/status 订单状态(status=0支付/1开台/2打单或反结/3超时未买单/4迟付/5取消)]
     * @return Status 结果
     * @throws Exception 异常
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Status counterCheckoutService(OrderDTO param) throws Exception {
        switch (param.getStatus()) {
            case 2:
                if (param.getMdTime() == null || param.getMdTime() == "") {
                    return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN() + "原因是mdTime为空或为null");
                }
                long mdTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(param.getMdTime()).getTime();
                long nowTime = System.currentTimeMillis();
                long timeBetween = nowTime - mdTime;
                int hourBetween = (int) (timeBetween / 3600000);
                //超过一个小后不允许反结账
                if (hourBetween >= 0 && hourBetween <= 1) {
                    int row = this.dao.updateOrderStatusDao(param);
                    if (row > 0) {
                        //如果反结订单属于一卡通，则删除一卡通反结前的订单
                        if (param.getPayType() == this.STATUS_6) {
                            this.dao.deleteOneCardDao(param.getId());
                        }
                        this.cydao.updateTableState(param.getCtid(), "4");
                        return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                    }
                    return new Status(StatusEnum.NO_GOODS.getCODE(), StatusEnum.NO_GOODS.getEXPLAIN());
                }
                return new Status(StatusEnum.ORDER_TIME_OUT.getCODE(), StatusEnum.ORDER_TIME_OUT.getEXPLAIN());
            case 4:
                param.setMdTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                int row = this.dao.updateOrderStatusDao(param);
                if (row > 0) {
                    this.cydao.updateTableState(param.getCtid(), "7");
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                }
                return new Status(StatusEnum.NO_GOODS.getCODE(), StatusEnum.NO_GOODS.getEXPLAIN());
            default:
                return new Status(StatusEnum.NO_GOODS.getCODE(), StatusEnum.NO_GOODS.getEXPLAIN());

        }
    }

    /**
     * 餐饮订单删除（取消订单）业务方法，用于预订单处于取消状态时删除该预订单所产生的记录数据
     *
     * @param id 订单编号
     * @return 删除结果
     * @throws Exception 异常
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
