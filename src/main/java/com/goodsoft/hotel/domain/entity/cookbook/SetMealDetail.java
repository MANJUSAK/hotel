package com.goodsoft.hotel.domain.entity.cookbook;

import java.util.Objects;

/**
 * description:
 * ===>套餐内容实体
 *
 * @author 严彬荣 Created on 2017-11-13 19:18
 */
public class SetMealDetail implements java.io.Serializable {

    private static final long serialVersionUID = 6070489500037427371L;
    private String id;//编号
    private String cbid;//关联菜单表id
    private String smid;//关联套餐表id
    private String smName;//套餐名
    private int isdd;//是否可单点（0为true/1为false）
    private int isNo;//是否打折（0为true/1为false）
    private double stPrice;//套餐价格

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCbid() {
        return cbid;
    }

    public void setCbid(String cbid) {
        this.cbid = cbid == null ? null : cbid.trim();
    }

    public String getSmid() {
        return smid;
    }

    public void setSmid(String smid) {
        this.smid = smid == null ? null : smid.trim();
    }

    public String getSmName() {
        return smName;
    }

    public void setSmName(String smName) {
        this.smName = smName == null ? null : smName.trim();
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
        if (!(o instanceof SetMealDetail)) return false;
        SetMealDetail that = (SetMealDetail) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(cbid, that.cbid) &&
                Objects.equals(smid, that.smid) &&
                Objects.equals(smName, that.smName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cbid, smid, smName);
    }
}
