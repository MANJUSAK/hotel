package com.goodsoft.hotel.domain.entity.cookbook;

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
    private String mdName;//做法详情
    private String tName;//部门类别（仅用于查询）
    private String stName;//小类（仅用于查询）
    private String cbName;//菜品名（仅用于查询）
    private String mName;//做法名（仅用于查询）


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCbid() {
        return cbid;
    }

    public void setCbid(String cbid) {
        this.cbid = cbid;
    }

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

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getCbName() {
        return cbName;
    }

    public void setCbName(String cbName) {
        this.cbName = cbName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
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
                Objects.equals(tName, that.tName) &&
                Objects.equals(stName, that.stName) &&
                Objects.equals(cbName, that.cbName) &&
                Objects.equals(mName, that.mName) &&
                Objects.equals(mdName, that.mdName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tid, stid, cbid, mid, mdName, tName, stName, cbName, mName);
    }
}
