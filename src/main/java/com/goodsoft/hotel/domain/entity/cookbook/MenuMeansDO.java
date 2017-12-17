package com.goodsoft.hotel.domain.entity.cookbook;

import java.util.List;
import java.util.Objects;

/**
 * description:
 * ===>菜单做法表
 *
 * @author 严彬荣 Created on 2017-11-11 16:49
 */
public class MenuMeansDO implements java.io.Serializable {

    private static final long serialVersionUID = -6334216758539123420L;
    private String id;//编号
    private String tid;//部门类别编号
    private String stid;//小类编号
    private String cbid;//关联菜单表id
    private Integer mid;//做法编号
    private String mName;//做法名
    private String mdid;//做法编号，用于获取前台传入的做法编号
    private String tName;//部门类别（仅用于查询）
    private String stName;//小类（仅用于查询）
    private String cbName;//菜品名（仅用于查询）
    private List<MenuMeansDetailDO> meansDetails;

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

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public String getCbid() {
        return cbid;
    }

    public void setCbid(String cbid) {
        this.cbid = cbid;
    }

    public String getMdid() {
        return mdid;
    }

    public void setMdid(String mdid) {
        this.mdid = mdid;
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

    public List<MenuMeansDetailDO> getMeansDetails() {
        return meansDetails;
    }

    public void setMeansDetails(List<MenuMeansDetailDO> meansDetails) {
        this.meansDetails = meansDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuMeansDO)) return false;
        MenuMeansDO that = (MenuMeansDO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tid, that.tid) &&
                Objects.equals(stid, that.stid) &&
                Objects.equals(cbid, that.cbid) &&
                Objects.equals(mid, that.mid) &&
                Objects.equals(mName, that.mName) &&
                Objects.equals(mdid, that.mdid) &&
                Objects.equals(tName, that.tName) &&
                Objects.equals(stName, that.stName) &&
                Objects.equals(cbName, that.cbName) &&
                Objects.equals(meansDetails, that.meansDetails);
    }

    @Override
    public String toString() {
        return "MenuMeansDO{" +
                "id='" + id + '\'' +
                ", tid='" + tid + '\'' +
                ", stid='" + stid + '\'' +
                ", cbid='" + cbid + '\'' +
                ", mid=" + mid +
                ", mName='" + mName + '\'' +
                ", mdid='" + mdid + '\'' +
                ", tName='" + tName + '\'' +
                ", stName='" + stName + '\'' +
                ", cbName='" + cbName + '\'' +
                ", meansDetails=" + meansDetails +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tid, stid, cbid, mid, mName, mdid, tName, stName, cbName, meansDetails);


    }
}
