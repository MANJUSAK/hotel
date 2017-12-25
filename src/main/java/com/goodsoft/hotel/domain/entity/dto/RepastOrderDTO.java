package com.goodsoft.hotel.domain.entity.dto;

import com.goodsoft.hotel.domain.entity.repastorder.OrderGoodsDO;

import java.util.List;
import java.util.Objects;

/**
 * description:
 * ===>餐饮订单明细辅助实体类
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-11-17 14:21
 */
public class RepastOrderDTO implements java.io.Serializable {

    private static final long serialVersionUID = 5280307344852398777L;
    private String id;//订单号
    private String ctid;//餐台编号
    private double orderPrice;//订单总价
    private double discountSum;//折扣金额（打折优惠的金额）
    private double zqSum;//折去金额（打折后的金额）
    private int totalNum;//数量合计
    private int mNum;//菜品分量合计
    private String aoh;//台号
    private int status;//订单状态（0支付/1下单/2打单/3超时未买单/4迟付/5取消/6反结）
    private List<OrderGoodsDO> msg;//用于接收前台传入的餐饮订单明细数据容器

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

    public List<OrderGoodsDO> getMsg() {
        return msg;
    }

    public void setMsg(List<OrderGoodsDO> msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RepastOrderDTO)) return false;
        RepastOrderDTO that = (RepastOrderDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(ctid, that.ctid) &&
                Objects.equals(aoh, that.aoh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ctid, aoh);
    }

    @Override
    public String toString() {
        return "RepastOrderDTO{" +
                "id='" + id + '\'' +
                ", ctid='" + ctid + '\'' +
                ", orderPrice=" + orderPrice +
                ", discountSum=" + discountSum +
                ", zqSum=" + zqSum +
                ", totalNum=" + totalNum +
                ", mNum=" + mNum +
                ", aoh='" + aoh + '\'' +
                ", status=" + status +
                ", msg=" + msg +
                '}';
    }
}
