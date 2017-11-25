package com.goodsoft.hotel.domain.entity.param;

import com.goodsoft.hotel.domain.entity.cookbook.MenuMeans;

import java.util.List;
import java.util.Objects;

/**
 * description:
 * ===>做法辅助实体，用于前台获取做法数据信息
 *
 * @author 严彬荣 Created on 2017-11-24 17:00
 */
public class MeansParam implements java.io.Serializable {

    private static final long serialVersionUID = -1491761767077326645L;
    private String cbid;
    private List<MenuMeans> means;

    public String getCbid() {
        return cbid;
    }

    public void setCbid(String cbid) {
        this.cbid = cbid;
    }

    public List<MenuMeans> getMeans() {
        return means;
    }

    public void setMeans(List<MenuMeans> means) {
        this.means = means;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeansParam)) return false;
        MeansParam meansParam = (MeansParam) o;
        return Objects.equals(cbid, meansParam.cbid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cbid);
    }
}
