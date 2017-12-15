package com.goodsoft.hotel.domain.entity.guestRoom;

import java.util.List;

/**
 * Created by duyuxiang on 2017/12/7.
 * 客房消费记录 接收前台参数类
 */
public class KfconsumpRecordParam {

    private List<KfconsumpRecord> consumptions;


    public KfconsumpRecordParam() {
    }


    public List<KfconsumpRecord> getConsumptions() {
        return consumptions;
    }

    public void setConsumptions(List<KfconsumpRecord> consumptions) {
        this.consumptions = consumptions;
    }
}
