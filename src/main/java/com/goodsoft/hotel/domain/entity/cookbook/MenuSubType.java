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
    private String id;
    private int stid;
    private String tName;
    private String stName;
    private String tid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        this.tName = tName == null ? null : tName.trim();
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName == null ? null : stName.trim();
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuSubType)) return false;
        MenuSubType that = (MenuSubType) o;
        return stid == that.stid &&
                Objects.equals(id, that.id) &&
                Objects.equals(stName, that.stName) &&
                Objects.equals(tid, that.tid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stid, stName, tid);
    }
}
