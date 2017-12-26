package com.goodsoft.hotel.domain.dao.guestRoom;

import com.goodsoft.hotel.domain.entity.guestRoom.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/12/2/002.
 */

@Repository
public interface ReportListDao {

    // 查询出预定的信息
    public List<Quickbooking> findBookingListMapper(String bookid) throws Exception;


}
