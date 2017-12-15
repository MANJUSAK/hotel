package com.goodsoft.hotel.domain.entity.param;

import com.goodsoft.hotel.domain.entity.repastorder.OrderGoods;

import java.util.List;
import java.util.Objects;

/**
 * description:
 * ===>餐饮订单明细辅助实体类
 *
 * @author 严彬荣 Created on 2017-11-17 14:21
 */
public class RepastOrderParam implements java.io.Serializable {

    private static final long serialVersionUID = 5280307344852398777L;
    private String id;//订单号
    private String ctid;//餐台编号
    private double orderPrice;//订单总价
    private double discountSum;//折扣金额（打折优惠的金额）
    private double zqSum;//折去金额（打折后的金额）
    private int totalNum;//数量合计
    private int mNum;//菜品分量合计
    private String aoh;//台号
    private List<OrderGoods> msg;//用于接收前台传入的餐饮订单明细数据容器

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getmNum() {
        return mNum;
    }

    public void setmNum(int mNum) {
        this.mNum = mNum;
    }

    public String getCtid() {
        return ctid;
    }

    public void setCtid(String ctid) {
        this.ctid = ctid;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getAoh() {
        return aoh;
    }

    public void setAoh(String aoh) {
        this.aoh = aoh;
    }


    public double getDiscountSum() {
        return discountSum;
    }

    public void setDiscountSum(double discountSum) {
        this.discountSum = discountSum;
    }

    public double getZqSum() {
        return zqSum;
    }

    public void setZqSum(double zqSum) {
        this.zqSum = zqSum;
    }

    public List<OrderGoods> getMsg() {
        return msg;
    }

    public void setMsg(List<OrderGoods> msg) {
        this.msg = msg;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RepastOrderParam)) return false;
        RepastOrderParam that = (RepastOrderParam) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(ctid, that.ctid) &&
                Objects.equals(aoh, that.aoh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ctid, aoh);
    }
}
