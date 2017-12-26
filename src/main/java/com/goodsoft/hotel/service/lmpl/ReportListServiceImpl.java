package com.goodsoft.hotel.service.lmpl;

import com.goodsoft.hotel.domain.dao.guestRoom.ReportListDao;
import com.goodsoft.hotel.domain.entity.guestRoom.Quickbooking;
import com.goodsoft.hotel.service.ReportListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangzhi on 2017/12/25.
 */

@Service
public class ReportListServiceImpl implements ReportListService{
    @Resource
    private ReportListDao reportListDao;


    @Override
    public Object operationBookingQuXiaoList(String bookid,String reason) throws Exception {
        System.out.println(bookid);
        List<Quickbooking> bookingListMapper = this.reportListDao.findBookingListMapper(bookid);
        return bookingListMapper;
    }
}
