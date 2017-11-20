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
    private double price1;
    private double price2;
    private double price3;
    private double price4;
    private double price5;
    private int num;
    private String unit;
    private int isNo;
    private String spec1;
    private String spec2;
    private String spec3;
    private String spec4;
    private String spec5;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
        this.tid = tid == null ? null : tid.trim();
    }

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid == null ? null : stid.trim();
    }

    public String getCbName() {
        return cbName;
    }

    public void setCbName(String cbName) {
        this.cbName = cbName == null ? null : cbName.trim();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getIsNo() {
        return isNo;
    }

    public void setIsNo(int isNo) {
        this.isNo = isNo;
    }

    public double getPrice1() {
        return price1;
    }

    public void setPrice1(double price1) {
        this.price1 = price1;
    }

    public double getPrice2() {
        return price2;
    }

    public void setPrice2(double price2) {
        this.price2 = price2;
    }

    public double getPrice3() {
        return price3;
    }

    public void setPrice3(double price3) {
        this.price3 = price3;
    }

    public double getPrice4() {
        return price4;
    }

    public void setPrice4(double price4) {
        this.price4 = price4;
    }

    public double getPrice5() {
        return price5;
    }

    public void setPrice5(double price5) {
        this.price5 = price5;
    }

    public String getSpec1() {
        return spec1;
    }

    public void setSpec1(String spec1) {
        this.spec1 = spec1;
    }

    public String getSpec2() {
        return spec2;
    }

    public void setSpec2(String spec2) {
        this.spec2 = spec2;
    }

    public String getSpec3() {
        return spec3;
    }

    public void setSpec3(String spec3) {
        this.spec3 = spec3;
    }

    public String getSpec4() {
        return spec4;
    }

    public void setSpec4(String spec4) {
        this.spec4 = spec4;
    }

    public String getSpec5() {
        return spec5;
    }

    public void setSpec5(String spec5) {
        this.spec5 = spec5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Menu)) return false;
        Menu menu = (Menu) o;
        return isNo == menu.isNo &&
                Objects.equals(id, menu.id) &&
                Objects.equals(tid, menu.tid) &&
                Objects.equals(stid, menu.stid) &&
                Objects.equals(cbName, menu.cbName) &&
                Objects.equals(unit, menu.unit) &&
                Objects.equals(spec1, menu.spec1) &&
                Objects.equals(spec2, menu.spec2) &&
                Objects.equals(spec3, menu.spec3) &&
                Objects.equals(spec4, menu.spec4) &&
                Objects.equals(spec5, menu.spec5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tid, stid, cbName, unit, isNo, spec1, spec2, spec3, spec4, spec5);
    }
}
