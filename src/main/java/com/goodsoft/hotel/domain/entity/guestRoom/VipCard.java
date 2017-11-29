package com.goodsoft.hotel.domain.entity.guestRoom;

/**
 * 会员信息
 * Created by 王智 on 2017/11/23/023.
 */
public class VipCard {
    private String id;                  //ID
    private String vipNo;               //会员卡号
    private String vipType;             //会员卡类型
    private String vipName;             //会员卡持卡人名字
    private String vipPhone;            //会员卡持卡人电话
    private String vipAddress;          //会员卡持卡人住址
    private String vipRegisterDate;     //会员卡注册时间
    private String vipRechargeDate;     //会员卡充值时间
    private String vipRechargeAmount;   //会员卡充值金额
    private String vipEndConsumeDate;   //会员卡最后消费时间
    private String vipExpireDate;       //会员卡到期时间
    private String vipConsumeCount;     //会员卡消费累计
    private String vipPaymentCount;     //会员卡付款累计
    private String vipBalance;          //会员卡余额
    private String blackList;           //黑名单
    private String mark;                //记号

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVipNo() {
        return vipNo;
    }

    public void setVipNo(String vipNo) {
        this.vipNo = vipNo;
    }

    public String getVipType() {
        return vipType;
    }

    public void setVipType(String vipType) {
        this.vipType = vipType;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public String getVipPhone() {
        return vipPhone;
    }

    public void setVipPhone(String vipPhone) {
        this.vipPhone = vipPhone;
    }

    public String getVipAddress() {
        return vipAddress;
    }

    public void setVipAddress(String vipAddress) {
        this.vipAddress = vipAddress;
    }

    public String getVipRegisterDate() {
        return vipRegisterDate;
    }

    public void setVipRegisterDate(String vipRegisterDate) {
        this.vipRegisterDate = vipRegisterDate;
    }

    public String getVipRechargeDate() {
        return vipRechargeDate;
    }

    public void setVipRechargeDate(String vipRechargeDate) {
        this.vipRechargeDate = vipRechargeDate;
    }

    public String getVipRechargeAmount() {
        return vipRechargeAmount;
    }

    public void setVipRechargeAmount(String vipRechargeAmount) {
        this.vipRechargeAmount = vipRechargeAmount;
    }

    public String getVipEndConsumeDate() {
        return vipEndConsumeDate;
    }

    public void setVipEndConsumeDate(String vipEndConsumeDate) {
        this.vipEndConsumeDate = vipEndConsumeDate;
    }

    public String getVipExpireDate() {
        return vipExpireDate;
    }

    public void setVipExpireDate(String vipExpireDate) {
        this.vipExpireDate = vipExpireDate;
    }

    public String getVipConsumeCount() {
        return vipConsumeCount;
    }

    public void setVipConsumeCount(String vipConsumeCount) {
        this.vipConsumeCount = vipConsumeCount;
    }

    public String getVipPaymentCount() {
        return vipPaymentCount;
    }

    public void setVipPaymentCount(String vipPaymentCount) {
        this.vipPaymentCount = vipPaymentCount;
    }

    public String getVipBalance() {
        return vipBalance;
    }

    public void setVipBalance(String vipBalance) {
        this.vipBalance = vipBalance;
    }

    public String getBlackList() {
        return blackList;
    }

    public void setBlackList(String blackList) {
        this.blackList = blackList;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "VipCard{" +
                "id='" + id + '\'' +
                ", vipNo='" + vipNo + '\'' +
                ", vipType='" + vipType + '\'' +
                ", vipName='" + vipName + '\'' +
                ", vipPhone='" + vipPhone + '\'' +
                ", vipAddress='" + vipAddress + '\'' +
                ", vipRegisterDate='" + vipRegisterDate + '\'' +
                ", vipRechargeDate='" + vipRechargeDate + '\'' +
                ", vipRechargeAmount='" + vipRechargeAmount + '\'' +
                ", vipEndConsumeDate='" + vipEndConsumeDate + '\'' +
                ", vipExpireDate='" + vipExpireDate + '\'' +
                ", vipConsumeCount='" + vipConsumeCount + '\'' +
                ", vipPaymentCount='" + vipPaymentCount + '\'' +
                ", vipBalance='" + vipBalance + '\'' +
                ", blackList='" + blackList + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
