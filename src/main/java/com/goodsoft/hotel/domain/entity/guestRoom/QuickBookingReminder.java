package com.goodsoft.hotel.domain.entity.guestRoom;

/**
 * 预定提醒信息
 * Created by 王智 on 2017/11/20/020.
 */
public class QuickBookingReminder {

    private String buildId;                          //预定单ID
    private String arrivalReminder;                  //抵店提醒
    private String departureReminder;                //离店提醒
    private String bookingExplain;                   //预定说明
    private String receptionExplain;                 //接待说明
    private String cashierExplain;                   //收银说明
    private String houseExplain;                     //房屋说明
    private String departureExplain;                 //离店说明

    public String getBuildId() {
        return buildId;
    }

    public void setBuildId(String buildId) {
        this.buildId = buildId;
    }

    public String getArrivalReminder() {
        return arrivalReminder;
    }

    public void setArrivalReminder(String arrivalReminder) {
        this.arrivalReminder = arrivalReminder;
    }

    public String getDepartureReminder() {
        return departureReminder;
    }

    public void setDepartureReminder(String departureReminder) {
        this.departureReminder = departureReminder;
    }

    public String getBookingExplain() {
        return bookingExplain;
    }

    public void setBookingExplain(String bookingExplain) {
        this.bookingExplain = bookingExplain;
    }

    public String getReceptionExplain() {
        return receptionExplain;
    }

    public void setReceptionExplain(String receptionExplain) {
        this.receptionExplain = receptionExplain;
    }

    public String getCashierExplain() {
        return cashierExplain;
    }

    public void setCashierExplain(String cashierExplain) {
        this.cashierExplain = cashierExplain;
    }

    public String getHouseExplain() {
        return houseExplain;
    }

    public void setHouseExplain(String houseExplain) {
        this.houseExplain = houseExplain;
    }

    public String getDepartureExplain() {
        return departureExplain;
    }

    public void setDepartureExplain(String departureExplain) {
        this.departureExplain = departureExplain;
    }

    @Override
    public String toString() {
        return "QuickBookingReminder{" +
                "buildId='" + buildId + '\'' +
                ", arrivalReminder='" + arrivalReminder + '\'' +
                ", departureReminder='" + departureReminder + '\'' +
                ", bookingExplain='" + bookingExplain + '\'' +
                ", receptionExplain='" + receptionExplain + '\'' +
                ", cashierExplain='" + cashierExplain + '\'' +
                ", houseExplain='" + houseExplain + '\'' +
                ", departureExplain='" + departureExplain + '\'' +
                '}';
    }
}
