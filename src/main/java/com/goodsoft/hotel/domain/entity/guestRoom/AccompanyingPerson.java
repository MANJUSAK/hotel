package com.goodsoft.hotel.domain.entity.guestRoom;

import java.util.List;

/**
 * Created by duyuxiang on 2017/12/1.
 * 随行人bean
 */
public class AccompanyingPerson {

    private String id;      //id
    private  String bookid; //预订单号
    private  String typename;  //房类
    private  String roomnumber; //房号
    private String  customername; //客人名
    private String  registerno; //登记号

    private List<AccompanyingPerson> accPersons;

    public List<AccompanyingPerson> getAccPersons() {
        return accPersons;
    }

    public void setAccPersons(List<AccompanyingPerson> accPersons) {
        this.accPersons = accPersons;
    }

    public AccompanyingPerson() {
    }

    @Override
    public String toString() {
        return "AccompanyingPerson{" +
                "bookid='" + bookid + '\'' +
                ", typename='" + typename + '\'' +
                ", roomnumber='" + roomnumber + '\'' +
                ", customername='" + customername + '\'' +
                ", registerno='" + registerno + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getRegisterno() {
        return registerno;
    }

    public void setRegisterno(String registerno) {
        this.registerno = registerno;
    }
}
