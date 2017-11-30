package com.goodsoft.hotel.service;

import com.goodsoft.hotel.domain.entity.guestRoom.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/16/016.
 */

public interface FloorRoomService {

    //公共信息发布 添加
    public void addMsgMapper(GsPublicMsgIssuance gsPublicMsgIssuance) throws Exception;

    //预定信息添加
    public Map<String, String> insertQuickBooking(Quickbooking quickbooking) throws Exception;


    //预定入住
    public String updateRoomFlagRuZhuService(List<Map<String,Object>> list) throws Exception;

}
