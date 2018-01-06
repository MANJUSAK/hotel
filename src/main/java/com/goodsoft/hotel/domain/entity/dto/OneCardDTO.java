package com.goodsoft.hotel.domain.entity.dto;

import java.util.Objects;

/**
 * description:
 * ===>一卡通餐饮订单辅助实体
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2018-01-04 16:24
 * @version V1.1.0
 */
public class OneCardDTO implements java.io.Serializable {

    private static final long serialVersionUID = 6829754053813071165L;
    private String id;
    private String roomno;        //房间号
    private String guestname;     //客人名
    private String project = "餐饮消费";       //项目
    private String projectnumber = "1"; //数量
    private String unitprice;     //总价
    private String discount;      //折扣
    private String paymentexplain;//付款说明
    private String bookingno;     //预订单号
    private String roomid;       //房间id
    private String state = "1";         //状态 1:未结账  0:已结账
    private String isgive = "否";        //是否赠送

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getGuestname() {
        return guestname;
    }

    public void setGuestname(String guestname) {
        this.guestname = guestname;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getProjectnumber() {
        return projectnumber;
    }

    public void setProjectnumber(String projectnumber) {
        this.projectnumber = projectnumber;
    }

    public String getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPaymentexplain() {
        return paymentexplain;
    }

    public void setPaymentexplain(String paymentexplain) {
        this.paymentexplain = paymentexplain;
    }

    public String getBookingno() {
        return bookingno;
    }

    public void setBookingno(String bookingno) {
        this.bookingno = bookingno;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIsgive() {
        return isgive;
    }

    public void setIsgive(String isgive) {
        this.isgive = isgive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OneCardDTO)) return false;
        OneCardDTO that = (OneCardDTO) o;
        return Objects.equals(roomno, that.roomno) &&
                Objects.equals(id, that.id) &&
                Objects.equals(guestname, that.guestname) &&
                Objects.equals(project, that.project) &&
                Objects.equals(projectnumber, that.projectnumber) &&
                Objects.equals(unitprice, that.unitprice) &&
                Objects.equals(discount, that.discount) &&
                Objects.equals(paymentexplain, that.paymentexplain) &&
                Objects.equals(bookingno, that.bookingno) &&
                Objects.equals(roomid, that.roomid) &&
                Objects.equals(state, that.state) &&
                Objects.equals(isgive, that.isgive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,roomno, guestname, project, projectnumber, unitprice, discount, paymentexplain, bookingno, roomid, state, isgive);
    }

    @Override
    public String toString() {
        return "OneCardDTO{" +
                "id='" + id + '\'' +
                ", roomno='" + roomno + '\'' +
                ", guestname='" + guestname + '\'' +
                ", project='" + project + '\'' +
                ", projectnumber='" + projectnumber + '\'' +
                ", unitprice='" + unitprice + '\'' +
                ", discount='" + discount + '\'' +
                ", paymentexplain='" + paymentexplain + '\'' +
                ", bookingno='" + bookingno + '\'' +
                ", roomid='" + roomid + '\'' +
                ", state='" + state + '\'' +
                ", isgive='" + isgive + '\'' +
                '}';
    }
}
