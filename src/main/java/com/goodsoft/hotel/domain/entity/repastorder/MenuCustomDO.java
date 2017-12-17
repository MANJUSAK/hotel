package com.goodsoft.hotel.domain.entity.repastorder;

import java.util.Objects;

/**
 * description:
 * ===>自定义菜品信息实体实体
 *
 * @author 严彬荣 Created on 2017-12-04 17:11
 * @version V1.0
 */
public class MenuCustomDO implements java.io.Serializable {

    private static final long serialVersionUID = -5117357082605185851L;

    private String id;//数据id
    private String customId;//关联字段编号
    private String cbname;//菜品名称
    private String spec;//规格
    private String unit;//单位
    private Double num;//数量
    private String tname;//部门类别
    private Double price;//价格
    private String tid;//部门id

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public String getCbname() {
        return cbname;
    }

    public void setCbname(String cbname) {
        this.cbname = cbname == null ? " " : cbname.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? " " : spec.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? " " : unit;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num < 0 ? Math.abs(num) : num;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? " " : tname.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price < 0 ? Math.abs(price) : price;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuCustomDO)) return false;
        MenuCustomDO that = (MenuCustomDO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(customId, that.customId) &&
                Objects.equals(cbname, that.cbname) &&
                Objects.equals(spec, that.spec) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(num, that.num) &&
                Objects.equals(tname, that.tname) &&
                Objects.equals(price, that.price) &&
                Objects.equals(tid, that.tid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customId, cbname, spec, unit, num, tname, price, tid);
    }

    @Override
    public String toString() {
        return "MenuCustomDO{" +
                "id='" + id + '\'' +
                ", customId='" + customId + '\'' +
                ", cbname='" + cbname + '\'' +
                ", spec='" + spec + '\'' +
                ", unit='" + unit + '\'' +
                ", num=" + num +
                ", tname='" + tname + '\'' +
                ", price=" + price +
                ", tid='" + tid + '\'' +
                '}';
    }
}
