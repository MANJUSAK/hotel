package com.goodsoft.hotel.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

    //实例化时期格式化工具类
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
    //实例化lock，防止线程出现安全性问题
    private Lock lock = new ReentrantLock();

    public StringBuilder getOrderId() {
        this.lock.lock();
        StringBuilder sb = null;
        try {
            sb = new StringBuilder();
            //线程等待1毫秒，防止订单号重复
            Thread.sleep(1);
            sb.append("CY");
            sb.append(this.dateFormat.format(new Date()));
        } catch (Exception e) {
        } finally {
            this.lock.unlock();
        }
        return sb;
    }

    /*public static void main(String[] args) {
        for (int i = 0; i < 1000; ++i) {
            new Thread() {
                public void run() {
                    OrderIdutil or = OrderIdutil.getInstance();
                    or.getOrderId();
                }
            }.start();
        }
    }*/
}
