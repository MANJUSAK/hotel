package com.goodsoft.hotel.domain.entity.cookbook;

import java.util.Objects;

/**
 * description:
 * ===>套餐实体
 *
 * @author 严彬荣 Created on 2017-11-13 19:17
 */
public class SetMeal implements java.io.Serializable {

    private static final long serialVersionUID = 3883711168985410607L;
    private String id;
    private String smName;
    private int smid;
    private int isdd;
    private int isNo;
    private double stPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSmName() {
        return smName;
    }

    public void setSmName(String smName) {
        this.smName = smName == null ? null : smName.trim();
    }

    public int getSmid() {
        return smid;
    }

    public void setSmid(int smid) {
        this.smid = smid;
    }

    public int getIsdd() {
        return isdd;
    }

    public void setIsdd(int isdd) {
        this.isdd = isdd;
    }

    public int getIsNo() {
        return isNo;
    }

    public void setIsNo(int isNo) {
        this.isNo = isNo;
    }

    public double getStPrice() {
        return stPrice;
    }

    public void setStPrice(double stPrice) {
        this.stPrice = stPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SetMeal)) return false;
        SetMeal setMeal = (SetMeal) o;
        return Objects.equals(id, setMeal.id) &&
                Objects.equals(smName, setMeal.smName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, smName);
    }
}
