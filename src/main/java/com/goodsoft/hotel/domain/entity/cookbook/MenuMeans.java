package com.goodsoft.hotel.domain.entity.cookbook;

import java.util.Objects;

/**
 * description:
 * ===>菜单做法表
 *
 * @author 严彬荣 Created on 2017-11-11 16:49
 */
public class MenuMeans implements java.io.Serializable {

    private static final long serialVersionUID = -6334216758539123420L;
    private String id;
    private int mid;
    private String mName;
    private String cbid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getCbid() {
        return cbid;
    }

    public void setCbid(String cbid) {
        this.cbid = cbid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuMeans)) return false;
        MenuMeans menuMeans = (MenuMeans) o;
        return mid == menuMeans.mid &&
                Objects.equals(id, menuMeans.id) &&
                Objects.equals(mName, menuMeans.mName) &&
                Objects.equals(cbid, menuMeans.cbid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mid, mName, cbid);
    }
}
