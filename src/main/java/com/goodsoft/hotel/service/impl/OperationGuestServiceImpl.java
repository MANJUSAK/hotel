package com.goodsoft.hotel.service.impl;

import com.goodsoft.hotel.domain.dao.guestRoom.OperationGuestDao;
import com.goodsoft.hotel.domain.entity.guestRoom.Guest;
import com.goodsoft.hotel.service.OperationGuestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhiWang on 2017/12/9/009.
 */
@Service
public class OperationGuestServiceImpl implements OperationGuestService {

    @Resource
    private OperationGuestDao operationGuestDao;

    /**
     * 修改客人信息
     * @param guest 获取客人信息
     * @return 返回结果
     */
    @Transactional
    @Override
    public String updateGuest(Guest guest) {
        Integer x = 0;
        try {
            x = this.operationGuestDao.updateGuestMapper(guest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x>0?"修改成功,修改"+x+"条客人信息":"修改失败";
    }

    /**
     * 删除客人信息
     * @param str 传递的ID信息
     * @return 返回结果
     *
     * 事物控制
     */
    @Transactional
    @Override
    public String deleteGuset(String str) {
        Integer x = 0;
        try {
            x =  this.operationGuestDao.deleteGuestMapper(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x>0?"删除成功,删除"+x+"条信息":"删除失败";
    }

    /**
     *查询客人信息
     * @return 返回结果集
     */
    @Override
    public List<Guest> queryGuest() {
        try {
          return  this.operationGuestDao.selectGuestMapper();
        } catch (Exception e) {
            e.printStackTrace();
          return null;
        }
    }
}
