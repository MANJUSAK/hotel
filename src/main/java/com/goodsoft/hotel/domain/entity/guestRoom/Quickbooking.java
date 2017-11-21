package com.goodsoft.hotel.domain.entity.guestRoom;

import java.util.List;

/**
 * Created by Administrator on 2017/11/16/016.
 */
public class Quickbooking {
    private String id;              //ID
    private String guestType;       //客人类型
    private String bookingNo;       //预定单号
    private String guestName;       //客人名字
    private String contractNo;      //合同号
    private String guestThno;       //客历号
    private String contractUnit;    //合约单位
    private String bookingUnit;     //预定单位
    private String salesman;        //业务员
    private String sex;             //性别
    private String registerNo;      //登记号
    private String teamNo;          //团体号
    private String reservationist;  //预定员
    private String teamName;        //团队名
    private String leaderName;      //领队姓名
    private String leaderPhone;     //领队电话
    private String leaderRoomNo;    //领队房号
    private String days;            //天数
    private String startDate;       //入住时间
    private String endDate;         //离开时间
    private String extraBed;        //加床价
    private String discount;        //折扣率
    private String discauth;        //折扣授权
    private String rentreson;       //租金因由
    private String releasetTime;    //预留房释放时间
    private String phoneNo;         //手机号码
    private String markets;         //市场分类
    private String guestSource;     //客人来源
    private String bookingType;     //预定类型
    private String receptionUnit;   //接待单位
    private String bookingName;     //订房人姓名
    private String bookingPhone;    //订房人电话
    private String bookingEmail;    //订房人邮箱
    private String predeterMode;    //预定方式
    private String roomNum;         //房间数量
    private String remark;          //备注
    private String teamRemark;      //团队备注
    private String bookingFlag;     //状态
    private String payMode;         //付款方式
    private String creditCardNo;    //信用卡号
    private String periodValidity;  //有效期
    private String authorizationNumber;     //授权号
    private String lineCredit;          //信用额度
    private String lineAdjustCredit;        //信用调节额度
    private List<QuickbookingRoomno> roomno;  //房间号表


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuestType() {
        return guestType;
    }

    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getGuestThno() {
        return guestThno;
    }

    public void setGuestThno(String guestThno) {
        this.guestThno = guestThno;
    }

    public String getContractUnit() {
        return contractUnit;
    }

    public void setContractUnit(String contractUnit) {
        this.contractUnit = contractUnit;
    }

    public String getBookingUnit() {
        return bookingUnit;
    }

    public void setBookingUnit(String bookingUnit) {
        this.bookingUnit = bookingUnit;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public String getTeamNo() {
        return teamNo;
    }

    public void setTeamNo(String teamNo) {
        this.teamNo = teamNo;
    }

    public String getReservationist() {
        return reservationist;
    }

    public void setReservationist(String reservationist) {
        this.reservationist = reservationist;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getLeaderPhone() {
        return leaderPhone;
    }

    public void setLeaderPhone(String leaderPhone) {
        this.leaderPhone = leaderPhone;
    }

    public String getLeaderRoomNo() {
        return leaderRoomNo;
    }

    public void setLeaderRoomNo(String leaderRoomNo) {
        this.leaderRoomNo = leaderRoomNo;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getExtraBed() {
        return extraBed;
    }

    public void setExtraBed(String extraBed) {
        this.extraBed = extraBed;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDiscauth() {
        return discauth;
    }

    public void setDiscauth(String discauth) {
        this.discauth = discauth;
    }

    public String getRentreson() {
        return rentreson;
    }

    public void setRentreson(String rentreson) {
        this.rentreson = rentreson;
    }

    public String getReleasetTime() {
        return releasetTime;
    }

    public void setReleasetTime(String releasetTime) {
        this.releasetTime = releasetTime;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMarkets() {
        return markets;
    }

    public void setMarkets(String markets) {
        this.markets = markets;
    }

    public String getGuestSource() {
        return guestSource;
    }

    public void setGuestSource(String guestSource) {
        this.guestSource = guestSource;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public String getReceptionUnit() {
        return receptionUnit;
    }

    public void setReceptionUnit(String receptionUnit) {
        this.receptionUnit = receptionUnit;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public String getBookingPhone() {
        return bookingPhone;
    }

    public void setBookingPhone(String bookingPhone) {
        this.bookingPhone = bookingPhone;
    }

    public String getBookingEmail() {
        return bookingEmail;
    }

    public void setBookingEmail(String bookingEmail) {
        this.bookingEmail = bookingEmail;
    }

    public String getPredeterMode() {
        return predeterMode;
    }

    public void setPredeterMode(String predeterMode) {
        this.predeterMode = predeterMode;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTeamRemark() {
        return teamRemark;
    }

    public void setTeamRemark(String teamRemark) {
        this.teamRemark = teamRemark;
    }

    public String getBookingFlag() {
        return bookingFlag;
    }

    public void setBookingFlag(String bookingFlag) {
        this.bookingFlag = bookingFlag;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getPeriodValidity() {
        return periodValidity;
    }

    public void setPeriodValidity(String periodValidity) {
        this.periodValidity = periodValidity;
    }

    public String getAuthorizationNumber() {
        return authorizationNumber;
    }

    public void setAuthorizationNumber(String authorizationNumber) {
        this.authorizationNumber = authorizationNumber;
    }

    public String getLineCredit() {
        return lineCredit;
    }

    public void setLineCredit(String lineCredit) {
        this.lineCredit = lineCredit;
    }

    public String getLineAdjustCredit() {
        return lineAdjustCredit;
    }

    public void setLineAdjustCredit(String lineAdjustCredit) {
        this.lineAdjustCredit = lineAdjustCredit;
    }

    public List<QuickbookingRoomno> getRoomno() {
        return roomno;
    }

    public void setRoomno(List<QuickbookingRoomno> roomno) {
        this.roomno = roomno;
    }

    @Override
    public String toString() {
        return "Quickbooking{" +
                "id='" + id + '\'' +
                ", guestType='" + guestType + '\'' +
                ", bookingNo='" + bookingNo + '\'' +
                ", guestName='" + guestName + '\'' +
                ", contractNo='" + contractNo + '\'' +
                ", guestThno='" + guestThno + '\'' +
                ", contractUnit='" + contractUnit + '\'' +
                ", bookingUnit='" + bookingUnit + '\'' +
                ", salesman='" + salesman + '\'' +
                ", sex='" + sex + '\'' +
                ", registerNo='" + registerNo + '\'' +
                ", teamNo='" + teamNo + '\'' +
                ", reservationist='" + reservationist + '\'' +
                ", teamName='" + teamName + '\'' +
                ", leaderName='" + leaderName + '\'' +
                ", leaderPhone='" + leaderPhone + '\'' +
                ", leaderRoomNo='" + leaderRoomNo + '\'' +
                ", days='" + days + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", extraBed='" + extraBed + '\'' +
                ", discount='" + discount + '\'' +
                ", discauth='" + discauth + '\'' +
                ", rentreson='" + rentreson + '\'' +
                ", releasetTime='" + releasetTime + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", markets='" + markets + '\'' +
                ", guestSource='" + guestSource + '\'' +
                ", bookingType='" + bookingType + '\'' +
                ", receptionUnit='" + receptionUnit + '\'' +
                ", bookingName='" + bookingName + '\'' +
                ", phone='" + bookingPhone + '\'' +
                ", bookingEmail='" + bookingEmail + '\'' +
                ", predeterMode='" + predeterMode + '\'' +
                ", roomNum='" + roomNum + '\'' +
                ", remark='" + remark + '\'' +
                ", teamRemark='" + teamRemark + '\'' +
                ", bookingFlag='" + bookingFlag + '\'' +
                ", payMode='" + payMode + '\'' +
                ", creditCardNo='" + creditCardNo + '\'' +
                ", periodValidity='" + periodValidity + '\'' +
                ", authorizationNumber='" + authorizationNumber + '\'' +
                ", lineCredit='" + lineCredit + '\'' +
                ", lineAdjustCredit='" + lineAdjustCredit + '\'' +
                ", roomno=" + roomno +
                '}';
    }
}
