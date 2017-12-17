package com.goodsoft.hotel.domain.entity.dto;

import com.goodsoft.hotel.domain.entity.cookbook.MenuDO;

import java.util.List;
import java.util.Objects;

/**
 * description:
 * ===>菜品数据实体辅助类
 *
 * @author 严彬荣 Created on 2017-11-30 11:08
 * @version V1.0
 */
public class MenuDTO implements java.io.Serializable {

    private static final long serialVersionUID = -1090082481951956688L;
    private String tid;//部门类别编号
    private String stid;//小类编号
    private List<MenuDO> menu;//菜品数据

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

    public List<MenuDO> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuDO> menu) {
        this.menu = menu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuDTO)) return false;
        MenuDTO menuDTO = (MenuDTO) o;
        return Objects.equals(tid, menuDTO.tid) &&
                Objects.equals(stid, menuDTO.stid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, stid);
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "tid='" + tid + '\'' +
                ", stid='" + stid + '\'' +
                ", menu=" + menu +
                '}';
    }
}
