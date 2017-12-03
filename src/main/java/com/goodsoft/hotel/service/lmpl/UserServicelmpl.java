package com.goodsoft.hotel.service.lmpl;

import com.goodsoft.hotel.domain.dao.UserDao;
import com.goodsoft.hotel.domain.entity.param.UserParam;
import com.goodsoft.hotel.domain.entity.result.Result;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.domain.entity.user.UserMsg;
import com.goodsoft.hotel.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 * ===>用户信息获取业务接口实现类
 *
 * @author 严彬荣 Created on 2017-12-03 10:43
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
    public <T> T queryUserMsgService(UserParam param) throws Exception {
        List<UserMsg> data = this.dao.queryUserMsgDao(param);
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
}
