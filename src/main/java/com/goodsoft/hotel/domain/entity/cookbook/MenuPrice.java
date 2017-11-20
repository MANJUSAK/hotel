package com.goodsoft.hotel.domain.entity.cookbook;

import java.util.Objects;

/**
 * description:
 * ===>菜单规格价位实体
 *
 * @author 严彬荣 Created on 2017-11-16 18:57
 */
public class MenuPrice implements java.io.Serializable {

    private static final long serialVersionUID = 3563399713121692250L;
    private String id;
    private String spec;
    private String cbid;
    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getCbid() {
        return cbid;
    }

    public void setCbid(String cbid) {
        this.cbid = cbid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuPrice)) return false;
        MenuPrice menuPrice = (MenuPrice) o;
        return Objects.equals(id, menuPrice.id) &&
                Objects.equals(spec, menuPrice.spec) &&
                Objects.equals(cbid, menuPrice.cbid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, spec, cbid);
    }
}
