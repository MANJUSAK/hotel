package com.goodsoft.hotel.service;



/**
 * Created by wangzhi on 2017/12/25.
 */

public interface ReportListService {

    //修改预定取消生成报表
    public Object operationBookingQuXiaoList(String bookid,String reason) throws Exception;

}
