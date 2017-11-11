package com.goodsoft.hotel.controller;

import com.goodsoft.hotel.domain.entity.param.PageParam;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.service.CookBookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * description:
 * ===>菜单管理访问入口接口处理类
 *
 * @author 严彬荣 Created on 2017-11-07 16:27
 * @version V1.0
 */
@RestController
@RequestMapping("/cookbook")
public class CookBookController {
    @Resource
    private CookBookService service;

    /**
     * 菜单子类型数据过滤接口
     *
     * @param tid 菜单类型编号
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/mean/sub/type/by/id/data.shtml")
    public Object queryMeanStypeByidController(String tid) {
        try {
            return this.service.queryMenuStypeService(tid);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

    /**
     * 查询菜单类型接口
     *
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/mean/type/data.shtml")
    public Object queryMeanTypeController() {
        try {
            return this.service.queryMenuTypeService();
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

    /**
     * 菜单子类型查询接口
     *
     * @param tid  菜单类型编号
     * @param page 分页信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/mean/sub/type/data.shtml")
    public Object queryMeanStypeController(String tid, PageParam page) {
        try {
            return this.service.queryMenuStypeService(tid, page);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

    /**
     * 菜单查询接口
     *
     * @param stid 菜单字类型编号
     * @param page 分页信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/mean/data.shtml")
    public Object queryMeanController(String stid, PageParam page) {
        try {
            return this.service.queryMenuService(stid, page);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

    /**
     * 菜单做法查询接口
     *
     * @param cbid 菜单编号
     * @param page 分页信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/query/mean/means/data.shtml")
    public Object queryMeanMeansController(String cbid, PageParam page) {
        try {
            return this.service.queryMenuMeansService(cbid, page);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
        }

    }

}
