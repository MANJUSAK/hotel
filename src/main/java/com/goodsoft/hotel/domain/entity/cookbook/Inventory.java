package com.goodsoft.hotel.domain.entity.cookbook;

import java.util.Objects;

/**
 * description:
 * ===>菜单库存量实体
 *
 * @author 严彬荣 Created on 2017-11-13 9:24
 */
public class Inventory implements java.io.Serializable {

    private static final long serialVersionUID = 901888118996173301L;
    private String id;//关联菜单编号
    private String date;//录入时间
    private int num;//库存量
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
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
        if (!(o instanceof Inventory)) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(id, inventory.id) &&
                Objects.equals(date, inventory.date) &&
                Objects.equals(tid, inventory.tid) &&
                Objects.equals(stid, inventory.stid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, tid, stid);
    }
}
