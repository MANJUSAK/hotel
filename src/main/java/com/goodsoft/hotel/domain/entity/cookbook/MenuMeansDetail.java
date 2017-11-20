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
    private String id;
    private String mid;
    private int mdid;
    private String mdName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuMeansDetail)) return false;
        MenuMeansDetail that = (MenuMeansDetail) o;
        return mdid == that.mdid &&
                Objects.equals(id, that.id) &&
                Objects.equals(mid, that.mid) &&
                Objects.equals(mdName, that.mdName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mid, mdid, mdName);
    }
}
