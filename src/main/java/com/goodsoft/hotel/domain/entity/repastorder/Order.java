package com.goodsoft.hotel.domain.entity.repastorder;

import java.util.List;
import java.util.Objects;

/**
 * description:
 * ===>餐饮订单实体
 *
 * @author 严彬荣 Created on 2017-11-17 10:07
 */
public class Order implements java.io.Serializable {

    private static final long serialVersionUID = -5502168041100514292L;
    private String id;//订单编号
    private String kzNum;//可账号
    private String consumer;//客人姓名
    private String ktTime;//开台时间
    private double fwRate;//服务费率
    private String ctType;//餐台类型
    private String salemanager;//营业经理
    private String ktNum;//开台号
    private int personNum;//人数
    private String ktShift;//开台班次
    private double zdConsume;//最低消费
    private double qdDiscount;//全单折扣
    private String department;//合约单位
    private String partHall;//分厅
    private String vipNum;//会员卡号
    private String vipType;//会员类型
    private String zdConsumeGist;//最低消费依据
    private double discountSum;//折扣金额
    private double zqSum;//折去金额
    private String aoh;//台号
    private String operator;//开台操作员
    private String ktSb;//开台市别
    private String timeMinute;//计时分钟
    private int isServiceCharge;//收服务费（0为true/1为false）
    private int isZdConsume;//记最低消费（0为true/1为false）
    private String paymentType;//支付方式
    private int status;//订单状态（是否支付，0为true/1为false）
    private String remarks;//备注
    private List<OrderGoods> orderGoods;//订单明细容器

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? "" : id.trim();
    }

    public String getKzNum() {
        return kzNum;
    }

    public void setKzNum(String kzNum) {
        this.kzNum = kzNum == null ? "" : kzNum.trim();
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
        this.ktTime = ktTime == null ? "" : ktTime.trim();
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
        this.ktShift = ktShift == null ? "" : ktShift.trim();
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

    public int getPersonNum() {
        return personNum;
    }

    public void setPersonNum(int personNum) {
        this.personNum = personNum < 0 ? Math.abs(personNum) : personNum;
    }

    public int getIsServiceCharge() {
        return isServiceCharge;
    }

    public void setIsServiceCharge(int isServiceCharge) {
        this.isServiceCharge = isServiceCharge < 0 ? Math.abs(isServiceCharge) : isServiceCharge;
    }

    public int getIsZdConsume() {
        return isZdConsume;
    }

    public void setIsZdConsume(int isZdConsume) {
        this.isZdConsume = isZdConsume < 0 ? Math.abs(isZdConsume) : isZdConsume;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status < 0 ? Math.abs(status) : status;
    }

    public double getFwRate() {
        return fwRate;
    }

    public void setFwRate(double fwRate) {
        this.fwRate = fwRate < 0 ? Math.abs(fwRate) : fwRate;
    }

    public double getZdConsume() {
        return zdConsume;
    }

    public void setZdConsume(double zdConsume) {
        this.zdConsume = zdConsume < 0 ? Math.abs(zdConsume) : zdConsume;
    }

    public double getQdDiscount() {
        return qdDiscount;
    }

    public void setQdDiscount(double qdDiscount) {
        this.qdDiscount = qdDiscount < 0 ? Math.abs(qdDiscount) : qdDiscount;
    }

    public double getDiscountSum() {
        return discountSum;
    }

    public void setDiscountSum(double discountSum) {
        this.discountSum = discountSum < 0 ? Math.abs(discountSum) : discountSum;
    }

    public double getZqSum() {
        return zqSum;
    }

    public void setZqSum(double zqSum) {
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
        this.ktSb = ktSb == null ? "" : ktSb.trim();
    }

    public String getTimeMinute() {
        return timeMinute;
    }

    public void setTimeMinute(String timeMinute) {
        this.timeMinute = timeMinute == null ? "" : timeMinute.trim();
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

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(kzNum, order.kzNum) &&
                Objects.equals(consumer, order.consumer) &&
                Objects.equals(ktTime, order.ktTime) &&
                Objects.equals(ctType, order.ctType) &&
                Objects.equals(salemanager, order.salemanager) &&
                Objects.equals(ktNum, order.ktNum) &&
                Objects.equals(ktShift, order.ktShift) &&
                Objects.equals(department, order.department) &&
                Objects.equals(partHall, order.partHall) &&
                Objects.equals(vipNum, order.vipNum) &&
                Objects.equals(vipType, order.vipType) &&
                Objects.equals(zdConsumeGist, order.zdConsumeGist) &&
                Objects.equals(aoh, order.aoh) &&
                Objects.equals(operator, order.operator) &&
                Objects.equals(ktSb, order.ktSb) &&
                Objects.equals(timeMinute, order.timeMinute) &&
                Objects.equals(paymentType, order.paymentType) &&
                Objects.equals(remarks, order.remarks) &&
                Objects.equals(orderGoods, order.orderGoods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kzNum, consumer, ktTime, ctType, salemanager, ktNum, ktShift, department, partHall, vipNum, vipType, zdConsumeGist, aoh, operator, ktSb, timeMinute, paymentType, remarks, orderGoods);
    }
}