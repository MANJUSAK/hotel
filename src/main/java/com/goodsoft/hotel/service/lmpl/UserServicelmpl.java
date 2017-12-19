package com.goodsoft.hotel.service.lmpl;

import com.goodsoft.hotel.domain.dao.UserDao;
import com.goodsoft.hotel.domain.entity.dto.UserDTO;
import com.goodsoft.hotel.domain.entity.result.Result;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.domain.entity.user.UserDO;
import com.goodsoft.hotel.service.UserService;
import com.horizon.util.encrypt.DESEDE;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 * ===>用户信息获取业务接口实现类
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-12-03 10:43
 * @version V1.0
 */
@SuppressWarnings("ALL")
@Service
public class UserServicelmpl implements UserService {

    @Resource
    private UserDao dao;


    /**
     * 查询用户信息（带部门）业务方法
     *
     * @param param 查询条件
     * @param <T>
     * @return 查询结果
     * @throws Exception
     */
    @Override
    public <T> T queryUserMsgService(UserDTO param) throws Exception {
        List<UserDO> data = this.dao.queryUserMsgDao(param);
        if (data.size() > 0) {
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 查询所有部门业务方法
     *
     * @param <T>
     * @return 查询结果
     * @throws Exception
     */
    @Override
    public <T> T queryDeptNameService() throws Exception {
        List<String> data = this.dao.queryDeptNameDao();
        if (data.size() > 0) {
            return (T) new Result(0, data);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 用户登录业务方法
     * 注：此业务方法只是单纯获取用户名用于跳转至工作流
     *
     * @param uName 用户名
     * @param pwd   密码
     * @param <T>
     * @return 登录结果
     * @throws Exception
     */
    @Override
    public <T> T getUserService(String uName, String pwd) throws Exception {
        if (pwd != null) {
            pwd = DESEDE.encryptIt(pwd);
            String userName = this.dao.getUserDao(uName, pwd);
            if (userName != null) {
                return (T) new Result(0, userName);
            }
        }
        return (T) new Status(StatusEnum.NO_USER.getCODE(), StatusEnum.NO_USER.getEXPLAIN());
    }
}
