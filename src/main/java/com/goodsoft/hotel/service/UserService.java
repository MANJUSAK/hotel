package com.goodsoft.hotel.service;

import com.goodsoft.hotel.domain.entity.param.UserParam;

/**
 * description:
 * ===>用户信息获取业务接口类
 *
 * @author 严彬荣 Created on 2017-12-03 10:43
 * @version V1.0
 */
public interface UserService {

    //查询用户信息（带部门）业务方法
    <T> T queryUserMsgService(UserParam param) throws Exception;

    //查询所有部门业务方法
    <T> T queryDeptNameService() throws Exception;

}
