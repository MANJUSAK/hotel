package com.goodsoft.hotel.domain.entity.repastorder;

import com.goodsoft.hotel.domain.entity.cookbook.SetMealDetailDO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * description:
 * ===>餐饮订单食品实体
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-11-17 10:07
 */
public class OrderGoodsDO implements java.io.Serializable {

    private static final long serialVersionUID = 6551389333680604804L;
    private String id;//订单食品编号
    private String oid;//订单编号
    private String tcid;//套餐编号
    private String zdyTcid;//自定义套餐编号
    private String cbname;//食品名称
    private Integer spNum;//数量
    private String spec;//规格
    private String unit;//单位
    private Double spPrice;//价格
    private Double jjMeans;//做法加价
    private String means;//做法
    private Double detailZqSum;//折前金额
    private Double detailZhSum;//折后金额
    private String discount;//折扣
    private Double zkSum;//金额折
    private Integer isDiscount;//可折否（0为true/1为false）
    private String batch;//批次
    private Double reDouble;//倍数
    private String ratedSeat;//客位
    private String operato;//点菜员
    private String dcTime;//点菜时间
    private Integer writeBill;//是否手写单（0为true/1为false）
    private String menuType;//部门类别
    private Integer rePlay;//是否存在先落单（点餐之前先落单到厨房）[0为true/1为false]
    private String detailRemarks;//备注
    private List<SetMealDetailDO> setMealDetailDOS;//套餐数据容器（仅用于查询）
    private List<MenuCustomDO> setMealCustoms;//自定义套餐数据容器

    public OrderGoodsDO() {
        this.writeBill = 1;
        this.rePlay = 1;
        this.dcTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.tcid = " ";
        this.zdyTcid = " ";
    }

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

    public String getTcid() {
        return tcid;
    }

    public void setTcid(String tcid) {
        this.tcid = tcid == null ? " " : tcid.trim();
    }

    public String getZdyTcid() {
        return zdyTcid;
    }

    public void setZdyTcid(String zdyTcid) {
        this.zdyTcid = zdyTcid == null ? " " : zdyTcid.trim();
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

    public Double getSpPrice() {
        return spPrice;
    }

    public void setSpPrice(Double spPrice) {
        this.spPrice = spPrice < 0 ? Math.abs(spPrice) : spPrice;
    }

    public String getMeans() {
        return means;
    }

    public void setMeans(String means) {
        this.means = means == null ? " " : means.trim();
    }

    public Double getJjMeans() {
        return jjMeans;
    }

    public void setJjMeans(Double jjMeans) {
        this.jjMeans = jjMeans < 0 ? Math.abs(jjMeans) : jjMeans;
    }

    public Double getDetailZqSum() {
        return detailZqSum;
    }

    public void setDetailZqSum(Double detailZqSum) {
        this.detailZqSum = detailZqSum < 0 ? Math.abs(detailZqSum) : detailZqSum;
    }

    public Double getDetailZhSum() {
        return detailZhSum;
    }

    public void setDetailZhSum(Double detailZhSum) {
        this.detailZhSum = detailZhSum < 0 ? Math.abs(detailZhSum) : detailZhSum;
    }

    public Double getZkSum() {
        return zkSum;
    }

    public void setZkSum(Double zkSum) {
        this.zkSum = zkSum < 0 ? Math.abs(zkSum) : zkSum;
    }

    public Double getReDouble() {
        return reDouble;
    }

    public void setReDouble(Double reDouble) {
        this.reDouble = reDouble < 0 ? Math.abs(reDouble) : reDouble;
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

    public Integer getSpNum() {
        return spNum;
    }

    public void setSpNum(Integer spNum) {
        this.spNum = spNum < 0 ? Math.abs(spNum) : spNum;
    }

    public Integer getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(Integer isDiscount) {
        this.isDiscount = isDiscount < 0 ? Math.abs(isDiscount) : isDiscount;
    }

    public Integer getWriteBill() {
        return writeBill;
    }

    public void setWriteBill(Integer writeBill) {
        this.writeBill = writeBill < 0 ? Math.abs(writeBill) : writeBill;
    }

    public Integer getRePlay() {
        return rePlay;
    }

    public void setRePlay(Integer rePlay) {
        this.rePlay = rePlay;
    }

    public List<SetMealDetailDO> getSetMealDetailDOS() {
        return setMealDetailDOS;
    }

    public void setSetMealDetailDOS(List<SetMealDetailDO> setMealDetailDOS) {
        this.setMealDetailDOS = setMealDetailDOS;
    }

    public List<MenuCustomDO> getSetMealCustoms() {
        return setMealCustoms;
    }

    public void setSetMealCustoms(List<MenuCustomDO> setMealCustoms) {
        this.setMealCustoms = setMealCustoms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderGoodsDO)) return false;
        OrderGoodsDO that = (OrderGoodsDO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(oid, that.oid) &&
                Objects.equals(tcid, that.tcid) &&
                Objects.equals(zdyTcid, that.zdyTcid) &&
                Objects.equals(cbname, that.cbname) &&
                Objects.equals(spNum, that.spNum) &&
                Objects.equals(spec, that.spec) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(spPrice, that.spPrice) &&
                Objects.equals(jjMeans, that.jjMeans) &&
                Objects.equals(means, that.means) &&
                Objects.equals(detailZqSum, that.detailZqSum) &&
                Objects.equals(detailZhSum, that.detailZhSum) &&
                Objects.equals(discount, that.discount) &&
                Objects.equals(zkSum, that.zkSum) &&
                Objects.equals(isDiscount, that.isDiscount) &&
                Objects.equals(batch, that.batch) &&
                Objects.equals(reDouble, that.reDouble) &&
                Objects.equals(ratedSeat, that.ratedSeat) &&
                Objects.equals(operato, that.operato) &&
                Objects.equals(dcTime, that.dcTime) &&
                Objects.equals(writeBill, that.writeBill) &&
                Objects.equals(menuType, that.menuType) &&
                Objects.equals(rePlay, that.rePlay) &&
                Objects.equals(detailRemarks, that.detailRemarks) &&
                Objects.equals(setMealDetailDOS, that.setMealDetailDOS) &&
                Objects.equals(setMealCustoms, that.setMealCustoms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, oid, tcid, zdyTcid, cbname, spNum, spec, unit, spPrice, jjMeans, means, detailZqSum, detailZhSum, discount, zkSum, isDiscount, batch, reDouble, ratedSeat, operato, dcTime, writeBill, menuType, rePlay, detailRemarks, setMealDetailDOS, setMealCustoms);
    }

    @Override
    public String toString() {
        return "OrderGoodsDO{" +
                "id='" + id + '\'' +
                ", oid='" + oid + '\'' +
                ", tcid='" + tcid + '\'' +
                ", zdyTcid='" + zdyTcid + '\'' +
                ", cbname='" + cbname + '\'' +
                ", spNum=" + spNum +
                ", spec='" + spec + '\'' +
                ", unit='" + unit + '\'' +
                ", spPrice=" + spPrice +
                ", jjMeans=" + jjMeans +
                ", means='" + means + '\'' +
                ", detailZqSum=" + detailZqSum +
                ", detailZhSum=" + detailZhSum +
                ", discount='" + discount + '\'' +
                ", zkSum=" + zkSum +
                ", isDiscount=" + isDiscount +
                ", batch='" + batch + '\'' +
                ", reDouble=" + reDouble +
                ", ratedSeat='" + ratedSeat + '\'' +
                ", operato='" + operato + '\'' +
                ", dcTime='" + dcTime + '\'' +
                ", writeBill=" + writeBill +
                ", menuType='" + menuType + '\'' +
                ", rePlay=" + rePlay +
                ", detailRemarks='" + detailRemarks + '\'' +
                ", setMealDetailDOS=" + setMealDetailDOS +
                ", setMealCustoms=" + setMealCustoms +
                '}';
    }
}