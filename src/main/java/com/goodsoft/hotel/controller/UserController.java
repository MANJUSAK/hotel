package com.goodsoft.hotel.controller;

import com.goodsoft.hotel.domain.entity.dto.UserDTO;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.service.UserService;
import com.goodsoft.hotel.service.supp.OrderIdsupp;
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
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-12-03 10:41
 * @version V1.0
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService service;
    @Resource
    private OrderIdsupp od;
    /**
     * 实例化日志管理工具类
     */
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    /**
     * 查询用户信息（带部门）接口
     *
     * @param param 查询条件
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/find/user/msg/data.shtml")
    public <T> T queryUserMsgController(UserDTO param) {
        try {
            return this.service.queryUserMsgService(param);
        } catch (Exception e) {
            this.LOG.error(e.toString());
            return (T) new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }

    /**
     * 用户登录接口
     * 注：此接口只是单纯获取用户名用于跳转至工作流
     *
     * @param uName 用户名
     * @param pwd   密码
     * @param <T>
     * @return Status or Result 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping(value = "/login/data.shtml", method = RequestMethod.POST)
    public <T> T getUserController(String uName, String pwd) {
        try {
            return this.service.getUserService(uName, pwd);
        } catch (Exception e) {
            this.LOG.error(e.toString());
            return (T) new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }


    /**
     * 查询所有部门接口
     *
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/find/dept/msg/data.shtml")
    public <T> T queryDeptNameController() {
        try {
            return this.service.queryDeptNameService();
        } catch (Exception e) {
            this.LOG.error(e.toString());
            return (T) new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }
}
