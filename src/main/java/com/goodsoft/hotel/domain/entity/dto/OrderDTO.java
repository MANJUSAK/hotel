package com.goodsoft.hotel.domain.entity.dto;

import com.goodsoft.hotel.domain.entity.repastorder.OrderDO;

import java.util.Objects;

/**
 * description:
 * ===>订单业务参数封装实体
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-12-22 9:28
 * @version V1.0.0
 */
public class OrderDTO implements java.io.Serializable {

    private static final long serialVersionUID = -3252192817044579371L;

    private String oid;//订单编号
    private String reason;//订单更改原因
    private int status;//订单状态
    private OrderDO order;//订单

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public OrderDO getOrder() {
        return order;
    }

    public void setOrder(OrderDO order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDTO)) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(oid, orderDTO.oid) &&
                Objects.equals(reason, orderDTO.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oid, reason);
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "oid='" + oid + '\'' +
                ", reason='" + reason + '\'' +
                ", status=" + status +
                ", order=" + order +
                '}';
    }
}
