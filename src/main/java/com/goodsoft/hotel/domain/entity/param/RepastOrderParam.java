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
    private List<OrderGoods> msg;//用于接收前台传入的餐饮订单明细数据容器

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
        return Objects.equals(msg, that.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msg);
    }
}
