package com.goodsoft.hotel.domain.entity.cookbook;

import java.util.List;
import java.util.Objects;

/**
 * description:
 * ===>菜单类型实体
 *
 * @author 严彬荣 Created on 2017-11-11 16:47
 */
public class MenuTypeDO implements java.io.Serializable {

    private static final long serialVersionUID = 6309767747012396344L;
    private String id;//编号
    private Integer tid;//类别编号
    private String tName;//类别名称
    private List<MenuSubTypeDO> menuSubType;//小类型实体容器

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public List<MenuSubTypeDO> getMenuSubType() {
        return menuSubType;
    }

    public void setMenuSubType(List<MenuSubTypeDO> menuSubType) {
        this.menuSubType = menuSubType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuTypeDO)) return false;
        MenuTypeDO that = (MenuTypeDO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tid, that.tid) &&
                Objects.equals(tName, that.tName) &&
                Objects.equals(menuSubType, that.menuSubType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tid, tName, menuSubType);
    }

    @Override
    public String toString() {
        return "MenuTypeDO{" +
                "id='" + id + '\'' +
                ", tid=" + tid +
                ", tName='" + tName + '\'' +
                ", menuSubTypeDOS=" + menuSubType +
                '}';
    }
}
