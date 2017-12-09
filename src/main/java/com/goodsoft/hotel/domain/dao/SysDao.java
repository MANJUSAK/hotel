package com.goodsoft.hotel.domain.dao;

import com.goodsoft.hotel.domain.entity.sys.Printer;
import com.goodsoft.hotel.domain.entity.sys.SerialNum;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description:
 * ===>系统功能设置dao接口
 * 用于设置系统功能属性
 *
 * @author manjusaka Created on 2017-12-05 11:50
 * @version V1.0
 */
@Repository
public interface SysDao {

    //查询当天流水中最大值
    String querySerialNumDao(@Param("date") String date, @Param("tp") int tp) throws Exception;

    //获取系统打印机
    List<Printer> queryPrinterDao() throws Exception;

    //记录流水号
    int addSerialNumDao(SerialNum msg) throws Exception;

    //添加系统打印机
    int addPrinterDao(Printer msg) throws Exception;

    //更换打印机
    int updatePrinterDao(Printer msg) throws Exception;

}
