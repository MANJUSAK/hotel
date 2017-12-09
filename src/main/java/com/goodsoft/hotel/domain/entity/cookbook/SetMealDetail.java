package com.goodsoft.hotel.domain.entity.cookbook;

import java.util.List;
import java.util.Objects;

/**
 * description:
 * ===>套餐内容实体
 *
 * @author 严彬荣 Created on 2017-11-13 19:18
 */
public class SetMealDetail implements java.io.Serializable {

    private static final long serialVersionUID = 6070489500037427371L;
    private String id;//编号
    private String tid;//部门类别编号
    private String stid;//小类编号
    private String cbid;//关联菜单表id
    private String smid;//关联套餐表id
    private String tcSpec;//菜品规格
    private double tcPrice;//菜品价格
    private int tcNum;//套餐菜品数量
    private String tName;//部门类别（仅用于查询）
    private String ptPort;//打印机端口号（仅用于查询）
    private String stName;//小类（仅用于查询）
    private String cbName;//菜品名（仅用于查询）
    private String unit;//菜品单位（仅用于查询）
    private String fileId;//菜品文件编号（仅用于查询）
    private List<String> picture;//图片容器（仅用于查询）

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? " " : id.trim();
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? " " : tid.trim();
    }

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid == null ? " " : stid.trim();
    }

    public String getCbid() {
        return cbid;
    }

    public void setCbid(String cbid) {
        this.cbid = cbid == null ? " " : cbid.trim();
    }

    public String getSmid() {
        return smid;
    }

    public void setSmid(String smid) {
        this.smid = smid == null ? " " : smid.trim();
    }

    public String getTcSpec() {
        return tcSpec;
    }

    public void setTcSpec(String tcSpec) {
        this.tcSpec = tcSpec == null ? " " : tcSpec.trim();
    }

    public double getTcPrice() {
        return tcPrice;
    }

    public void setTcPrice(double tcPrice) {
        this.tcPrice = tcPrice < 0 ? Math.abs(tcPrice) : tcPrice;
    }

    public int getTcNum() {
        return tcNum;
    }

    public void setTcNum(int tcNum) {
        this.tcNum = tcNum < 0 ? Math.abs(tcNum) : tcNum;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getCbName() {
        return cbName;
    }

    public void setCbName(String cbName) {
        this.cbName = cbName;
    }

    public String getPtPort() {
        return ptPort;
    }

    public void setPtPort(String ptPort) {
        this.ptPort = ptPort;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public List<String> getPicture() {
        return picture;
    }

    public void setPicture(List<String> picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SetMealDetail)) return false;
        SetMealDetail that = (SetMealDetail) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tid, that.tid) &&
                Objects.equals(stid, that.stid) &&
                Objects.equals(cbid, that.cbid) &&
                Objects.equals(smid, that.smid) &&
                Objects.equals(tcSpec, that.tcSpec) &&
                Objects.equals(tName, that.tName) &&
                Objects.equals(stName, that.stName) &&
                Objects.equals(cbName, that.cbName) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(ptPort, that.ptPort) &&
                Objects.equals(fileId, that.fileId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tid, stid, cbid, smid, tcSpec, tName, stName, cbName, unit, ptPort, fileId);
    }
}
