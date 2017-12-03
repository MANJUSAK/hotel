package com.goodsoft.hotel.controller;

import com.goodsoft.hotel.domain.entity.param.UserParam;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * description:
 * ===>用户数据获取接口访问处理类
 *
 * @author 严彬荣 Created on 2017-12-03 10:41
 * @version V1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService service;
    //实例化日志管理工具类
    private Logger logger = LoggerFactory.getLogger(CookBookController.class);

    /**
     * 查询用户信息（带部门）接口
     *
     * @param param 查询条件
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/find/user/msg/data.shtml")
    public Object queryUserMsgController(UserParam param) {
        try {
            return this.service.queryUserMsgService(param);
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }

    }

    /**
     * 查询所有部门接口
     *
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/find/dept/msg/data.shtml")
    public Object queryDeptNameController() {
        try {
            return this.service.queryDeptNameService();
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }

    }

}
