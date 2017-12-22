package com.goodsoft.hotel.domain.entity.cookbook;

import java.util.Objects;

/**
 * description:
 * ===>菜单库存量实体
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-11-13 9:24
 */
public class InventoryDO implements java.io.Serializable {

    private static final long serialVersionUID = 901888118996173301L;
    private String id;//关联菜单编号
    private String date;//录入时间
    private Integer num;//库存量
    private String tid;//部门类别id
    private String stid;//小类id

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num <= 0 ? 0 : num;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InventoryDO)) return false;
        InventoryDO that = (InventoryDO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(num, that.num) &&
                Objects.equals(tid, that.tid) &&
                Objects.equals(stid, that.stid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, num, tid, stid);
    }

    @Override
    public String toString() {
        return "InventoryDO{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", num=" + num +
                ", tid='" + tid + '\'' +
                ", stid='" + stid + '\'' +
                '}';
    }
}
