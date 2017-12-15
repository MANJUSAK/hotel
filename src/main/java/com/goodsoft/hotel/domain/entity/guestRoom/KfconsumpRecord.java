package com.goodsoft.hotel.domain.entity.guestRoom;

/**
 * Created by duyuxiang on 2017/12/7.
 * 客房消费记录
 */
public class KfconsumpRecord {

    private String  id;
    private String  roomno;        //房间号
    private String  guestname;     //客人名
    private String  project;       //项目
    private String  projectnumber; //数量
    private String  unitprice;     //单价
    private String  discount;      //折扣
    private String  paymentexplain;//付款说明
    private String  bookingno;     //预订单号
    private String  roomid ;       //房间id
    private String  state ="1";        //状态 1:未结账  0:已结账
    private String  isgive;        //是否赠送


    private String totalPrice;          //总价格

    public String getTotalPrice() {
        if(projectnumber!=null && unitprice!=null ){
            return String.valueOf(Double.valueOf(unitprice)* Double.valueOf(projectnumber));
        }else{
            return "0";
        }
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public KfconsumpRecord() {
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

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

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

    @Override
    public String toString() {
        return "KfconsumpRecord{" +
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
