package com.goodsoft.hotel.domain.entity.repastorder;

import java.util.Objects;

/**
 * description:
 * ===>自定义菜品信息实体实体
 *
 * @author 严彬荣 Created on 2017-12-04 17:11
 * @version V1.0
 */
public class MenuCustom implements java.io.Serializable {

    private static final long serialVersionUID = -5117357082605185851L;

    private String id;//数据id
    private String customId;//关联字段编号
    private String cbname;//菜品名称
    private String spec;//规格
    private String unit;//单位
    private double num;//数量
    private String tname;//部门类别
    private double price;//价格

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

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num < 0 ? Math.abs(num) : num;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? " " : tname.trim();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price < 0 ? Math.abs(price) : price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuCustom)) return false;
        MenuCustom that = (MenuCustom) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(customId, that.customId) &&
                Objects.equals(cbname, that.cbname) &&
                Objects.equals(spec, that.spec) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(tname, that.tname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customId, cbname, spec, unit, tname);
    }
}
