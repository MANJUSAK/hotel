package com.goodsoft.hotel.controller;

import com.goodsoft.hotel.domain.entity.param.HotelParam;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.domain.entity.sys.Printer;
import com.goodsoft.hotel.service.SysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * description:
 * ===>系统组件访问接口实现类,设置系统功能属性
 *
 * @author manjusaka Created on 2017-12-09 16:35
 * @version V1.0
 */
@RestController
@RequestMapping("/sys")
public class SysController {
    @Resource
    private SysService sysService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取系统打印机接口
     *
     * @param param 分页信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping(value = "/find/printer/data.shtml", method = RequestMethod.GET)
    public Object queryPrinterController(HotelParam param) {
        try {
            return this.sysService.queryPrinterService(param);
        } catch (Exception e) {
            e.printStackTrace();
            this.logger.error(e.toString());
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }

    /**
     * 添加系统打印机接口
     *
     * @param msg 打印机数据
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/add/printer/data.shtml", method = RequestMethod.POST)
    public Status addPrinterController(Printer msg) {
        try {
            return this.sysService.addPrinterService(msg);
        } catch (Exception e) {
            e.printStackTrace();
            this.logger.error(e.toString());
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }

    /**
     * 更换系统打印机接口
     *
     * @param msg 打印机数据
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/update/printer/data.shtml", method = RequestMethod.POST)
    public Status updatePrinterController(Printer msg) {
        try {
            return this.sysService.updatePrinterService(msg);
        } catch (Exception e) {
            e.printStackTrace();
            this.logger.error(e.toString());
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }

}
