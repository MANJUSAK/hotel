package com.goodsoft.hotel.domain.entity.guestRoom;

import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */
public class RealTimeRoomParameter {

    private List<RealTimeRoomPriceParam> msg;

    public RealTimeRoomParameter() {
    }

    public List<RealTimeRoomPriceParam> getMsg() {
        return msg;
    }

    public void setMsg(List<RealTimeRoomPriceParam> msg) {
        this.msg = msg;
    }
}
