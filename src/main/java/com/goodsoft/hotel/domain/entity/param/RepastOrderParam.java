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
    private String aoh;//台号
    private String ctType;//分厅
    private List<OrderGoods> msg;//用于接收前台传入的餐饮订单明细数据容器

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCtType() {
        return ctType;
    }

    public void setCtType(String ctType) {
        this.ctType = ctType;
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
                Objects.equals(aoh, that.aoh) &&
                Objects.equals(ctType, that.ctType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ctid, aoh, ctType);
    }
}
