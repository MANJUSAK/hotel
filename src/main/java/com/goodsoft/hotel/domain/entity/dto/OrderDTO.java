package com.goodsoft.hotel.domain.entity.dto;

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

    private String id;//订单编号
    private String reason;//订单更改原因
    private int status;//订单状态
    private String ctid;//餐台id
    private String mdTime;//买单时间
    private int payType;//订单支付方式

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCtid() {
        return ctid;
    }

    public void setCtid(String ctid) {
        this.ctid = ctid;
    }

    public String getMdTime() {
        return mdTime;
    }

    public void setMdTime(String mdTime) {
        this.mdTime = mdTime;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDTO)) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return status == orderDTO.status &&
                Objects.equals(id, orderDTO.id) &&
                Objects.equals(reason, orderDTO.reason) &&
                Objects.equals(ctid, orderDTO.ctid) &&
                Objects.equals(mdTime, orderDTO.mdTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reason, status, ctid, mdTime);
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id='" + id + '\'' +
                ", reason='" + reason + '\'' +
                ", status=" + status +
                ", ctid='" + ctid + '\'' +
                ", mdTime='" + mdTime + '\'' +
                ", payType=" + payType +
                '}';
    }
}
