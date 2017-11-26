package com.goodsoft.hotel.domain.entity.cookbook;

import java.beans.Transient;
import java.util.Objects;

/**
 * description:
 * ===>菜单做法明细实体
 *
 * @author 严彬荣 Created on 2017-11-15 15:49
 */
public class MenuMeansDetail implements java.io.Serializable {

    private static final long serialVersionUID = -320588136817271691L;
    private String id;//编号
    private String tid;//部门类别id
    private String stid;//小类编号
    private String cbid;//菜单编号
    private String mid;//做法明细编号
    private int mdid;//关联做法表id
    private String mdName;//名称

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Transient
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Transient
    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid;
    }

    @Transient
    public String getCbid() {
        return cbid;
    }

    public void setCbid(String cbid) {
        this.cbid = cbid;
    }

    @Transient
    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public int getMdid() {
        return mdid;
    }

    public void setMdid(int mdid) {
        this.mdid = mdid;
    }

    public String getMdName() {
        return mdName;
    }

    public void setMdName(String mdName) {
        this.mdName = mdName == null ? null : mdName.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuMeansDetail)) return false;
        MenuMeansDetail that = (MenuMeansDetail) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tid, that.tid) &&
                Objects.equals(stid, that.stid) &&
                Objects.equals(cbid, that.cbid) &&
                Objects.equals(mid, that.mid) &&
                Objects.equals(mdName, that.mdName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tid, stid, cbid, mid, mdName);
    }
}
