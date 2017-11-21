package com.goodsoft.hotel.domain.entity.repastorder;

import java.util.Objects;

/**
 * description:
 * ===>餐饮订单食品实体
 *
 * @author 严彬荣 Created on 2017-11-17 10:07
 */
public class OrderGoods implements java.io.Serializable {

    private static final long serialVersionUID = 6551389333680604804L;
    private String id;//订单食品编号
    private String oid;//订单编号
    private String cbname;//食品名称
    private int spNum;//数量
    private String spec;//规格
    private String unit;//单位
    private double spPrice;//价格
    private double jjMeans;//做法加价
    private double detailZqSum;//折前金额
    private double detailZhSum;//折后金额
    private String discount;//折扣
    private double zkSum;//金额折
    private int isDiscount;//可折否（0为true/1为false）
    private String batch;//批次
    private double redouble;//倍数
    private String ratedSeat;//客位
    private String operato;//点菜员
    private String dcTime;//点菜时间
    private int writeBill;//是否手写单（0为true/1为false）
    private String menuType;//部门类别
    private String detailRemarks;//备注

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? " " : id.trim();
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid == null ? " " : oid.trim();
    }

    public String getCbname() {
        return cbname;
    }

    public void setCbname(String cbname) {
        this.cbname = cbname == null ? " " : cbname.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? " " : spec.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? " " : unit.trim();
    }


    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount == null ? " " : discount.trim();
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch == null ? " " : batch.trim();
    }

    public double getSpPrice() {
        return spPrice;
    }

    public void setSpPrice(double spPrice) {
        this.spPrice = spPrice < 0 ? Math.abs(spPrice) : spPrice;
    }

    public double getJjMeans() {
        return jjMeans;
    }

    public void setJjMeans(double jjMeans) {
        this.jjMeans = jjMeans < 0 ? Math.abs(jjMeans) : jjMeans;
    }

    public double getDetailZqSum() {
        return detailZqSum;
    }

    public void setDetailZqSum(double detailZqSum) {
        this.detailZqSum = detailZqSum < 0 ? Math.abs(detailZqSum) : detailZqSum;
    }

    public double getDetailZhSum() {
        return detailZhSum;
    }

    public void setDetailZhSum(double detailZhSum) {
        this.detailZhSum = detailZhSum < 0 ? Math.abs(detailZhSum) : detailZhSum;
    }

    public double getZkSum() {
        return zkSum;
    }

    public void setZkSum(double zkSum) {
        this.zkSum = zkSum < 0 ? Math.abs(zkSum) : zkSum;
    }

    public double getRedouble() {
        return redouble;
    }

    public void setRedouble(double redouble) {
        this.redouble = redouble < 0 ? Math.abs(redouble) : redouble;
    }

    public String getRatedSeat() {
        return ratedSeat;
    }

    public void setRatedSeat(String ratedSeat) {
        this.ratedSeat = ratedSeat == null ? " " : ratedSeat.trim();
    }

    public String getOperato() {
        return operato;
    }

    public void setOperato(String operato) {
        this.operato = operato == null ? " " : operato.trim();
    }

    public String getDcTime() {
        return dcTime;
    }

    public void setDcTime(String dcTime) {
        this.dcTime = dcTime == null ? " " : dcTime.trim();
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? " " : menuType.trim();
    }

    public String getDetailRemarks() {
        return detailRemarks;
    }

    public void setDetailRemarks(String detailRemarks) {
        this.detailRemarks = detailRemarks;
    }

    public int getSpNum() {
        return spNum;
    }

    public void setSpNum(int spNum) {
        this.spNum = spNum < 0 ? Math.abs(spNum) : spNum;
    }

    public int getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(int isDiscount) {
        this.isDiscount = isDiscount < 0 ? Math.abs(isDiscount) : isDiscount;
    }

    public int getWriteBill() {
        return writeBill;
    }

    public void setWriteBill(int writeBill) {
        this.writeBill = writeBill < 0 ? Math.abs(writeBill) : writeBill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderGoods)) return false;
        OrderGoods that = (OrderGoods) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(oid, that.oid) &&
                Objects.equals(cbname, that.cbname) &&
                Objects.equals(spec, that.spec) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(discount, that.discount) &&
                Objects.equals(batch, that.batch) &&
                Objects.equals(ratedSeat, that.ratedSeat) &&
                Objects.equals(operato, that.operato) &&
                Objects.equals(dcTime, that.dcTime) &&
                Objects.equals(menuType, that.menuType) &&
                Objects.equals(detailRemarks, that.detailRemarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, oid, cbname, spec, unit, discount, batch, ratedSeat, operato, dcTime, menuType, detailRemarks);
    }
}