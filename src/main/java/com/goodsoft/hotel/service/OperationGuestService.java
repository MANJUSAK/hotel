package com.goodsoft.hotel.service;

import com.goodsoft.hotel.domain.entity.guestRoom.Guest;

import java.util.List;

/**
 * Created by zhiWang on 2017/12/9/009.
 */
public interface OperationGuestService {

    //修改客人信息
    public String updateGuest(Guest guest) throws Exception;

    //删除客人信息
    public String deleteGuset(String id) throws Exception;

    //查询客人信息
    public List<Guest> queryGuest()throws Exception;


}
