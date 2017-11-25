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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SetMealDetail)) return false;
        SetMealDetail that = (SetMealDetail) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(cbid, that.cbid) &&
                Objects.equals(smid, that.smid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cbid, smid);
    }
}
