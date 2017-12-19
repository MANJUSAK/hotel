package com.goodsoft.hotel.domain.entity.cookbook;

import java.util.Objects;

/**
 * description:
 * ===>菜单子类型数据过滤实体
 *
 * @author 严彬荣 Created on 2017-11-07 16:42
 */
public class MenuSubTypeDO implements java.io.Serializable {

    private static final long serialVersionUID = 1604565411882057472L;
    private String id;//编号
    private Integer stid;//小类型编号
    private String tName;//部门类别（仅用于查询）
    private String stName;//小类型名称
    private String tid;//关联类别表id
    private String sbid;//前台传入小类编号


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? " " : id.trim();
    }

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? " " : tName.trim();
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName == null ? " " : stName.trim();
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? " " : tid.trim();
    }

    public String getSbid() {
        return sbid;
    }

    public void setSbid(String sbid) {
        this.sbid = sbid == null ? " " : sbid.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuSubTypeDO)) return false;
        MenuSubTypeDO that = (MenuSubTypeDO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(stid, that.stid) &&
                Objects.equals(tName, that.tName) &&
                Objects.equals(stName, that.stName) &&
                Objects.equals(tid, that.tid) &&
                Objects.equals(sbid, that.sbid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stid, tName, stName, tid, sbid);
    }

    @Override
    public String toString() {
        return "MenuSubTypeDO{" +
                "id='" + id + '\'' +
                ", stid=" + stid +
                ", tName='" + tName + '\'' +
                ", stName='" + stName + '\'' +
                ", tid='" + tid + '\'' +
                ", sbid='" + sbid + '\'' +
                '}';
    }
}
