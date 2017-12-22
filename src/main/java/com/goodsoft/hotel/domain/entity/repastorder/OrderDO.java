package com.goodsoft.hotel.domain.entity.repastorder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * description:
 * ===>餐饮订单实体
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-11-17 10:07
 */
public class OrderDO implements java.io.Serializable {
    private static final long serialVersionUID = -5502168041100514292L;
    private String id;//订单编号(客账号)
    private Integer totalNum;//数量合计
    private Integer mNum;//菜品分量合计
    private String consumer;//客人姓名
    private String ktTime;//开台时间（订单生成时间）
    private Double fwRate;//服务费率
    private String ctType;//餐台类型
    private String salemanager;//营业经理
    private String ktNum;//开台卡号
    private Integer personNum;//人数
    private String ktShift;//开台班次
    private Double zdConsume;//最低消费
    private Double qdDiscount;//全单折扣
    private String department;//合约单位
    private String partHall;//分厅
    private String vipNum;//会员卡号
    private String vipType;//会员类型
    private String zdConsumeGist;//最低消费依据
    private Double discountSum;//折扣金额（打折优惠的金额）
    private Double zqSum;//折去金额（打折后的金额）
    private String aoh;//台号
    private String operator;//开台操作员
    private String ktSb;//开台市别
    private Integer isServiceCharge;//收服务费（0为true/1为false）
    private Integer isZdConsume;//记最低消费（0为true/1为false）
    private String paymentType;//支付方式
    private Integer status;//订单状态（0支付/1开台/2打单或反结/3超时未买单/4迟付/5取消）
    private String remarks;//备注
    private Integer placeNum;//席数
    private String ctid;//餐台编号
    private Double orderPrice;//订单总价
    private String mdTime;//买单时间
    private String reason;//反结账或迟付等说明
    private List<OrderGoodsDO> orderGoods;//订单明细容器

    public OrderDO() {
        this.ktTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.ktShift = joinDateSb() + "班";
        this.ktSb = joinDateSb() + "市";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? "" : id.trim();
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum < 0 ? Math.abs(totalNum) : totalNum;
    }

    public Integer getmNum() {
        return mNum;
    }

    public void setmNum(Integer mNum) {
        this.mNum = mNum < 0 ? Math.abs(mNum) : mNum;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer == null ? "" : consumer.trim();
    }

    public String getKtTime() {
        return ktTime;
    }

    public void setKtTime(String ktTime) {
        this.ktTime = ktTime;
    }

    public String getCtType() {
        return ctType;
    }

    public void setCtType(String ctType) {
        this.ctType = ctType == null ? "" : ctType.trim();
    }

    public String getSalemanager() {
        return salemanager;
    }

    public void setSalemanager(String salemanager) {
        this.salemanager = salemanager == null ? "" : salemanager.trim();
    }

    public String getKtNum() {
        return ktNum;
    }

    public void setKtNum(String ktNum) {
        this.ktNum = ktNum == null ? "" : ktNum.trim();
    }


    public String getKtShift() {
        return ktShift;
    }

    public void setKtShift(String ktShift) {
        this.ktShift = ktShift;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? "" : department.trim();
    }

    public String getPartHall() {
        return partHall;
    }

    public void setPartHall(String partHall) {
        this.partHall = partHall == null ? "" : partHall.trim();
    }

    public String getVipNum() {
        return vipNum;
    }

    public void setVipNum(String vipNum) {
        this.vipNum = vipNum == null ? "" : vipNum.trim();
    }

    public String getVipType() {
        return vipType;
    }

    public void setVipType(String vipType) {
        this.vipType = vipType == null ? "" : vipType.trim();
    }

    public String getZdConsumeGist() {
        return zdConsumeGist;
    }

    public void setZdConsumeGist(String zdConsumeGist) {
        this.zdConsumeGist = zdConsumeGist == null ? "" : zdConsumeGist.trim();
    }

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum < 0 ? Math.abs(personNum) : personNum;
    }

    public Integer getIsServiceCharge() {
        return isServiceCharge;
    }

    public void setIsServiceCharge(Integer isServiceCharge) {
        this.isServiceCharge = isServiceCharge < 0 ? Math.abs(isServiceCharge) : isServiceCharge;
    }

    public Integer getIsZdConsume() {
        return isZdConsume;
    }

    public void setIsZdConsume(Integer isZdConsume) {
        this.isZdConsume = isZdConsume < 0 ? Math.abs(isZdConsume) : isZdConsume;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status < 0 ? Math.abs(status) : status;
    }

    public Double getFwRate() {
        return fwRate;
    }

    public void setFwRate(Double fwRate) {
        //服务费率小于或等于0，改变收取服务费为1
        if (fwRate <= 0) {
            this.isServiceCharge = 1;
        }
        this.fwRate = fwRate < 0 ? Math.abs(fwRate) : fwRate;
    }

    public Double getZdConsume() {
        return zdConsume;
    }

    public void setZdConsume(Double zdConsume) {
        if (zdConsume <= 0) {
            this.isZdConsume = 1;
        }
        this.zdConsume = zdConsume < 0 ? Math.abs(zdConsume) : zdConsume;
    }

    public Double getQdDiscount() {
        return qdDiscount;
    }

    public void setQdDiscount(Double qdDiscount) {
        this.qdDiscount = qdDiscount < 0 ? Math.abs(qdDiscount) : qdDiscount;
    }

    public Double getDiscountSum() {
        return discountSum;
    }

    public void setDiscountSum(Double discountSum) {
        this.discountSum = discountSum < 0 ? Math.abs(discountSum) : discountSum;
    }

    public Double getZqSum() {
        return zqSum;
    }

    public void setZqSum(Double zqSum) {
        this.zqSum = zqSum < 0 ? Math.abs(zqSum) : zqSum;
    }

    public String getAoh() {
        return aoh;
    }

    public void setAoh(String aoh) {
        this.aoh = aoh == null ? "" : aoh.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? "" : operator.trim();
    }

    public String getKtSb() {
        return ktSb;
    }

    public void setKtSb(String ktSb) {
        this.ktSb = ktSb;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? "" : paymentType.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? "" : remarks.trim();
    }

    public Integer getPlaceNum() {
        return placeNum;
    }

    public void setPlaceNum(Integer placeNum) {
        this.placeNum = placeNum < 0 ? Math.abs(placeNum) : placeNum;
    }

    public String getCtid() {
        return ctid;
    }

    public void setCtid(String ctid) {
        this.ctid = ctid == null ? " " : ctid.trim();
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public String getMdTime() {
        return mdTime;
    }

    public void setMdTime(String mdTime) {
        this.mdTime = mdTime == null ? " " : mdTime.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String fjzReason) {
        this.reason = reason == null ? " " : reason.trim();
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice < 0 ? Math.abs(orderPrice) : orderPrice;

    }

    public List<OrderGoodsDO> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoodsDO> orderGoods) {
        this.orderGoods = orderGoods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDO)) return false;
        OrderDO orderDO = (OrderDO) o;
        return Objects.equals(id, orderDO.id) &&
                Objects.equals(totalNum, orderDO.totalNum) &&
                Objects.equals(mNum, orderDO.mNum) &&
                Objects.equals(consumer, orderDO.consumer) &&
                Objects.equals(ktTime, orderDO.ktTime) &&
                Objects.equals(fwRate, orderDO.fwRate) &&
                Objects.equals(ctType, orderDO.ctType) &&
                Objects.equals(salemanager, orderDO.salemanager) &&
                Objects.equals(ktNum, orderDO.ktNum) &&
                Objects.equals(personNum, orderDO.personNum) &&
                Objects.equals(ktShift, orderDO.ktShift) &&
                Objects.equals(zdConsume, orderDO.zdConsume) &&
                Objects.equals(qdDiscount, orderDO.qdDiscount) &&
                Objects.equals(department, orderDO.department) &&
                Objects.equals(partHall, orderDO.partHall) &&
                Objects.equals(vipNum, orderDO.vipNum) &&
                Objects.equals(vipType, orderDO.vipType) &&
                Objects.equals(zdConsumeGist, orderDO.zdConsumeGist) &&
                Objects.equals(discountSum, orderDO.discountSum) &&
                Objects.equals(zqSum, orderDO.zqSum) &&
                Objects.equals(aoh, orderDO.aoh) &&
                Objects.equals(operator, orderDO.operator) &&
                Objects.equals(ktSb, orderDO.ktSb) &&
                Objects.equals(isServiceCharge, orderDO.isServiceCharge) &&
                Objects.equals(isZdConsume, orderDO.isZdConsume) &&
                Objects.equals(paymentType, orderDO.paymentType) &&
                Objects.equals(status, orderDO.status) &&
                Objects.equals(remarks, orderDO.remarks) &&
                Objects.equals(placeNum, orderDO.placeNum) &&
                Objects.equals(ctid, orderDO.ctid) &&
                Objects.equals(orderPrice, orderDO.orderPrice) &&
                Objects.equals(mdTime, orderDO.mdTime) &&
                Objects.equals(reason, orderDO.reason) &&
                Objects.equals(orderGoods, orderDO.orderGoods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalNum, mNum, consumer, ktTime, fwRate, ctType, salemanager, ktNum, personNum, ktShift, zdConsume, qdDiscount, department, partHall, vipNum, vipType, zdConsumeGist, discountSum, zqSum, aoh, operator, ktSb, isServiceCharge, isZdConsume, paymentType, status, remarks, placeNum, ctid, orderPrice, mdTime, reason, orderGoods);
    }

    @Override
    public String toString() {
        return "OrderDO{" +
                "id='" + id + '\'' +
                ", totalNum=" + totalNum +
                ", mNum=" + mNum +
                ", consumer='" + consumer + '\'' +
                ", ktTime='" + ktTime + '\'' +
                ", fwRate=" + fwRate +
                ", ctType='" + ctType + '\'' +
                ", salemanager='" + salemanager + '\'' +
                ", ktNum='" + ktNum + '\'' +
                ", personNum=" + personNum +
                ", ktShift='" + ktShift + '\'' +
                ", zdConsume=" + zdConsume +
                ", qdDiscount=" + qdDiscount +
                ", department='" + department + '\'' +
                ", partHall='" + partHall + '\'' +
                ", vipNum='" + vipNum + '\'' +
                ", vipType='" + vipType + '\'' +
                ", zdConsumeGist='" + zdConsumeGist + '\'' +
                ", discountSum=" + discountSum +
                ", zqSum=" + zqSum +
                ", aoh='" + aoh + '\'' +
                ", operator='" + operator + '\'' +
                ", ktSb='" + ktSb + '\'' +
                ", isServiceCharge=" + isServiceCharge +
                ", isZdConsume=" + isZdConsume +
                ", paymentType='" + paymentType + '\'' +
                ", status=" + status +
                ", remarks='" + remarks + '\'' +
                ", placeNum=" + placeNum +
                ", ctid='" + ctid + '\'' +
                ", orderPrice=" + orderPrice +
                ", mdTime='" + mdTime + '\'' +
                ", reason='" + reason + '\'' +
                ", orderGoodDOS=" + orderGoods +
                '}';
    }

    private String joinDateSb() {
        String shibie = null;
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(Calendar.HOUR_OF_DAY);
        if (i < 10 && i > 5) {
            shibie = "早";
        } else if (i >= 10 && i < 14) {
            shibie = "中";
        } else {
            shibie = "晚";
        }
        return shibie;
    }

}