package com.goodsoft.hotel.domain.entity.dto;

import com.goodsoft.hotel.domain.entity.cookbook.MenuMeansDO;

import java.util.List;
import java.util.Objects;

/**
 * description:
 * ===>做法辅助实体，用于前台获取做法数据信息
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-11-24 17:00
 */
public class MeansDTO implements java.io.Serializable {

    private static final long serialVersionUID = -1491761767077326645L;
    private String tid;
    private String stid;
    private String cbid;
    private List<MenuMeansDO> means;

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

    public List<MenuMeansDO> getMeans() {
        return means;
    }

    public void setMeans(List<MenuMeansDO> means) {
        this.means = means;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeansDTO)) return false;
        MeansDTO that = (MeansDTO) o;
        return Objects.equals(tid, that.tid) &&
                Objects.equals(stid, that.stid) &&
                Objects.equals(cbid, that.cbid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, stid, cbid);
    }

    @Override
    public String toString() {
        return "MeansDTO{" +
                "tid='" + tid + '\'' +
                ", stid='" + stid + '\'' +
                ", cbid='" + cbid + '\'' +
                ", means=" + means +
                '}';
    }
}
