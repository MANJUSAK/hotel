package com.goodsoft.hotel.service.supp;

import com.goodsoft.hotel.domain.dao.SysDao;
import com.goodsoft.hotel.domain.entity.sys.SerialNum;
import com.goodsoft.hotel.exception.HotelApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
@Service
public class OrderIdsupp {
    @Resource
    private SysDao dao;
    //实例化日志管理工具类
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //实例化时期格式化工具类
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    //实例化lock，防止线程出现安全性问题
    private Lock lock = new ReentrantLock();
    //初始化增长id
    private static int serial_num = 0;
    private static int serial_num1 = 0;

    @Transactional
    public StringBuilder getOrderId() throws HotelApplicationException {
        this.lock.lock();
        StringBuilder sb = null;
        Date date = new Date();
        String dateStr = this.dateFormat.format(date);
        SerialNum sn = new SerialNum();
        try {
            if (serial_num == 0) {
                String numStr = this.dao.querySerialNumDao(dateStr, 2);
                if (numStr != null) {
                    serial_num = Integer.parseInt(numStr);
                }
            } else {
                String numStr = this.dao.querySerialNumDao(dateStr, 2);
                if (numStr == null) {
                    serial_num = 0;
                }
            }
            sb = new StringBuilder();
            sb.append("CY");
            sb.append(dateStr);
            String code = String.format("%05d", ++serial_num);
            sb.append(code);
            sn.setId(sb.toString());
            sn.setMaxSerial(serial_num);
            sn.setModuleCode(code);
            sn.setModuleName("订单流水号");
            sn.setConfigTemplet("餐饮");
            sn.setPreMaxNum("1");
            sn.setSysDate(date);
            sn.setSerlType(2);
            this.dao.addSerialNumDao(sn);
            return sb;
        } catch (Exception e) {
            e.printStackTrace();
            this.logger.error(e.toString());
            throw new HotelApplicationException("生成订单号失败");
        } finally {
            this.lock.unlock();
        }

    }

    /**
     * 订单流水号生成策略
     *
     * @param var  标识
     * @param var1 类型
     * @param arg  类型编码
     * @return 流水号
     * @throws HotelApplicationException
     */
    @Transactional
    public StringBuilder getOrderId(String var, String var1, int arg) throws HotelApplicationException {
        this.lock.lock();
        StringBuilder sb = null;
        Date date = new Date();
        String dateStr = this.dateFormat.format(date);
        SerialNum sn = new SerialNum();
        try {
            if (serial_num1 == 0) {
                String numStr = this.dao.querySerialNumDao(dateStr, arg);
                if (numStr != null) {
                    serial_num1 = Integer.parseInt(numStr);
                }
            } else {
                String numStr = this.dao.querySerialNumDao(dateStr, arg);
                if (numStr == null) {
                    serial_num1 = 0;
                }
            }
            sb = new StringBuilder();
            sb.append(var);
            sb.append(dateStr);
            String code = String.format("%05d", ++serial_num1);
            sb.append(code);
            sn.setId(sb.toString());
            sn.setMaxSerial(serial_num1);
            sn.setModuleCode(code);
            sn.setModuleName("订单流水号");
            sn.setConfigTemplet(var1);
            sn.setPreMaxNum("1");
            sn.setSysDate(date);
            sn.setSerlType(arg);
            this.dao.addSerialNumDao(sn);
            return sb;
        } catch (Exception e) {
            e.printStackTrace();
            this.logger.error(e.toString());
            throw new HotelApplicationException("生成订单号失败");
        } finally {
            this.lock.unlock();
        }

    }
}
