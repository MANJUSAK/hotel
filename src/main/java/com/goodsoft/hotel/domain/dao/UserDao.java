package com.goodsoft.hotel.domain.dao;

import com.goodsoft.hotel.domain.entity.dto.UserDTO;
import com.goodsoft.hotel.domain.entity.user.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description:
 * ===>用户信息获取访问数据库dao接口
 *
 * @author 严彬荣 Created on 2017-12-03 10:44
 * @version V1.0
 */
@Repository("userDao")
public interface UserDao {

    //查询用户信息（带部门）
    List<UserDO> queryUserMsgDao(UserDTO param) throws Exception;

    //查询所有部门
    List<String> queryDeptNameDao() throws Exception;

    //用户登录
    String getUserDao(@Param("uName") String uName, @Param("pwd") String pwd) throws Exception;

}
