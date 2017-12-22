package com.goodsoft.hotel.domain.entity.dto;

import java.util.Objects;

/**
 * description:
 * ===>数据库操作参数辅助工具实体类
 * 用于通用方法下获取数据库表、字段等数据
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-12-02 15:33
 * @version V1.0
 */
public class DatabasesDTO implements java.io.Serializable {

    private static final long serialVersionUID = -3161028603507663900L;
    private String table;//表名
    private String column;//字段名
    private String id;//数据编号
    private String tid;//部门编号
    private String stid;//小类编号
    private String cbid;//菜品编号

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

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

    public String getCbid() {
        return cbid;
    }

    public void setCbid(String cbid) {
        this.cbid = cbid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatabasesDTO)) return false;
        DatabasesDTO that = (DatabasesDTO) o;
        return Objects.equals(table, that.table) &&
                Objects.equals(column, that.column) &&
                Objects.equals(id, that.id) &&
                Objects.equals(tid, that.tid) &&
                Objects.equals(stid, that.stid) &&
                Objects.equals(cbid, that.cbid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, column, id, tid, stid, cbid);
    }

    @Override
    public String toString() {
        return "DatabasesDTO{" +
                "table='" + table + '\'' +
                ", column='" + column + '\'' +
                ", id='" + id + '\'' +
                ", tid='" + tid + '\'' +
                ", stid='" + stid + '\'' +
                ", cbid='" + cbid + '\'' +
                '}';
    }
}
