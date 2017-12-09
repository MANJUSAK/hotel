package com.goodsoft.hotel.controller.guestRoom;

import com.goodsoft.hotel.domain.entity.guestRoom.Guest;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.service.OperationGuestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by zhiWang on 2017/12/9/009.
 */
@RestController
public class OperationGuestController {

    @Resource
    private OperationGuestService operationGuestService;

    /**
     * 修改客人信息
     * @param guest 客人信息
     * @return 响应结果
     */
    @CrossOrigin(origins = "*",maxAge = 3600,methods = RequestMethod.POST)
    @RequestMapping("guest/updateGuest")
    public Status modifyGuest(@RequestBody Guest guest){

        try {
           String str =  this.operationGuestService.updateGuest(guest);
            return new Status(StatusEnum.SUCCESS.getCODE(), str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.QT_MODIFY_ERROR.getCODE(), StatusEnum.QT_MODIFY_ERROR.getEXPLAIN());
        }
    }

    /**
     * 查询客人信息
     * @return 返回结果集
     */
    @CrossOrigin(origins = "*",maxAge = 3600,methods = RequestMethod.POST)
    @RequestMapping("guest/queryGuest")
    public Object queryGuest(){
        try {
            return this.operationGuestService.queryGuest();
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.QT_FIND_ERROR.getCODE(), StatusEnum.QT_FIND_ERROR.getEXPLAIN());
        }
    }

    /**
     * 删除客人信息
     * @return 返回响应状态
     */
    @CrossOrigin(origins = "*",maxAge = 3600,methods = RequestMethod.POST)
    @RequestMapping("guest/deleteGuest")
    public Status deleteGuest(String id){
        try {
           String str =  this.operationGuestService.deleteGuset(id);
            return new Status(StatusEnum.SUCCESS.getCODE(), str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.QT_REMOVE_ERROR.getCODE(), StatusEnum.QT_REMOVE_ERROR.getEXPLAIN());
        }
    }
}
