package com.goodsoft.hotel.domain.entity.cookbook;

import java.util.Objects;

/**
 * description:
 * ===>菜单实体
 *
 * @author 严彬荣 Created on 2017-11-11 16:43
 */
public class Menu implements java.io.Serializable {

    private static final long serialVersionUID = -2579296305533311577L;
    private String id;
    private int cbid;
    private String tid;
    private String stid;
    private String cbName;
    private double price;
    private int num;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCbid() {
        return cbid;
    }

    public void setCbid(int cbid) {
        this.cbid = cbid;
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

    public String getCbName() {
        return cbName;
    }

    public void setCbName(String cbName) {
        this.cbName = cbName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Menu)) return false;
        Menu menu = (Menu) o;
        return cbid == menu.cbid &&
                Double.compare(menu.price, price) == 0 &&
                num == menu.num &&
                Objects.equals(id, menu.id) &&
                Objects.equals(tid, menu.tid) &&
                Objects.equals(stid, menu.stid) &&
                Objects.equals(cbName, menu.cbName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cbid, tid, stid, cbName, price, num);
    }
}
