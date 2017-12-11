package com.goodsoft.hotel.domain.dao.guestRoom;

import com.goodsoft.hotel.domain.entity.guestRoom.Guest;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhiWang on 2017/12/9/009.
 */
@Repository
public interface OperationGuestDao {


    public Integer updateGuestMapper(Guest guest) throws Exception;

    public List<Guest> selectGuestMapper() throws Exception;

    public Integer deleteGuestMapper(String id) throws Exception;

}
