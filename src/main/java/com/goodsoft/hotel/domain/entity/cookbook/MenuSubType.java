package com.goodsoft.hotel.domain.entity.cookbook;

import java.util.Objects;

/**
 * description:
 * ===>菜单子类型数据过滤实体
 *
 * @author 严彬荣 Created on 2017-11-07 16:42
 */
public class MenuSubType implements java.io.Serializable {

    private static final long serialVersionUID = 1604565411882057472L;
    private String id;//编号
    private int stid;//小类型编号
    private String tName;//类型名称
    private String stName;//小类型名称
    private String tid;//关联类别表id
    private String sbid;//前台传入小类编号


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? " " : id.trim();
    }

    public int getStid() {
        return stid;
    }

    public void setStid(int stid) {
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
        if (!(o instanceof MenuSubType)) return false;
        MenuSubType that = (MenuSubType) o;
        return stid == that.stid &&
                Objects.equals(id, that.id) &&
                Objects.equals(stName, that.stName) &&
                Objects.equals(sbid, that.sbid) &&
                Objects.equals(tid, that.tid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stid, stName, stid, tid);
    }
}
