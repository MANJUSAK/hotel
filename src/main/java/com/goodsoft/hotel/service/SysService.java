package com.goodsoft.hotel.service;

import com.goodsoft.hotel.domain.entity.param.HotelParam;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.sys.Printer;

/**
 * description:
 * ===>系统组件业务接口,设置系统功能属性模块组件
 *
 * @author manjusaka Created on 2017-12-09 16:14
 * @version V1.0
 */
public interface SysService {
    /**
     * 获取系统打印机业务方法
     *
     * @param <T> 泛型
     * @return 打印机数据
     * @throws Exception
     */
    <T> T queryPrinterService(HotelParam param) throws Exception;

    /**
     * 添加系统打印机业务方法
     *
     * @param msg 打印机数据
     * @return 添加结果
     * @throws Exception
     */
    Status addPrinterService(Printer msg) throws Exception;

    /**
     * 更新打印机业务方法
     *
     * @param msg 打印机数据
     * @return 添加结果
     * @throws Exception
     */
    Status updatePrinterService(Printer msg) throws Exception;

    /**
     * 删除打印机业务方法
     *
     * @param id 数据id
     * @return 添加结果
     * @throws Exception
     */
    Status deletePrinterService(String... id) throws Exception;
}
