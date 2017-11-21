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
    private String id;//编号
    private String cbid;//关联菜单编号
    private String date;//录入时间
    private int num;//库存量

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCbid() {
        return cbid;
    }

    public void setCbid(String cbid) {
        this.cbid = cbid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventory)) return false;
        Inventory inventory = (Inventory) o;
        return num == inventory.num &&
                Objects.equals(id, inventory.id) &&
                Objects.equals(cbid, inventory.cbid) &&
                Objects.equals(date, inventory.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cbid, date, num);
    }
}
