package com.goodsoft.hotel.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description:
 * ===>生成订单号工具类
 *
 * @author 严彬荣 Created on 2017-11-17 14:44
 * @version V1.0
 */
@SuppressWarnings("ALL")
public class OrderIdutil {
    /**
     * 创建本类的单例模式（具体说明参见本包下的UUIDUtil类） start
     */
    private volatile static OrderIdutil instance;

    private OrderIdutil() {
    }

    public static OrderIdutil getInstance() {
        if (instance == null) {
            synchronized (OrderIdutil.class) {
                if (instance == null)
                    instance = new OrderIdutil();
            }
        }
        return instance;
    }
    // 创建本类的单例模式（具体说明参见本包下的UUIDUtil类） end

    public StringBuilder getOrderId() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        synchronized (this) {
            //线程等待2毫秒，防止订单号重复
            Thread.sleep(2);
            sb.append("CY");
            sb.append(new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date()));
        }
        return sb;
    }
}
