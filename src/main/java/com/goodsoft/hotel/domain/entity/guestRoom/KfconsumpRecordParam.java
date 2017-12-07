package com.goodsoft.hotel.domain.entity.guestRoom;

import java.util.List;

/**
 * Created by duyuxiang on 2017/12/7.
 * 客房消费记录 接收前台参数类
 */
public class KfconsumpRecordParam {

    private String bookingno;
    private List<KfconsumpRecord> consumptions;


    public KfconsumpRecordParam() {
    }

    public String getBookingno() {
        return bookingno;
    }

    public void setBookingno(String bookingno) {
        this.bookingno = bookingno;
    }

    public List<KfconsumpRecord> getConsumptions() {
        return consumptions;
    }

    public void setConsumptions(List<KfconsumpRecord> consumptions) {
        this.consumptions = consumptions;
    }
}
