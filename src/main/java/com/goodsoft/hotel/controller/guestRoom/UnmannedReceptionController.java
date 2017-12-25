package com.goodsoft.hotel.controller.guestRoom;

import com.goodsoft.hotel.domain.dao.guestRoom.BookingDao;
import com.goodsoft.hotel.domain.dao.guestRoom.KfCheckOutDao;
import com.goodsoft.hotel.domain.dao.guestRoom.RoomSDao;
import com.goodsoft.hotel.domain.entity.guestRoom.KfconsumpRecord;
import com.goodsoft.hotel.domain.entity.guestRoom.Quickbooking;
import com.goodsoft.hotel.domain.entity.guestRoom.QuickbookingRoomno;
import com.goodsoft.hotel.domain.entity.result.Result;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by duyuxiang on 2017/12/22.
 * 无人前台controller
 */
@Controller
public class UnmannedReceptionController {


    @Resource
    private BookingDao bookingDao;
    
    @Resource
    private KfCheckOutDao kfCheckOutDao;
    
    @Resource
    private RoomSDao roomSDao;
    
    /**
     * 输入订单号查询相关订单
     * @param bookingno
     * @param <T>
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("unmanned/finance/booking")
    @ResponseBody
    public <T> T financeBooking(String bookingno){

        Map returnMap =new HashMap();
        if (bookingno== null) {
            return (T) new Result(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN());
        }

        try {
            //查询预订ID
            String bookId = bookingDao.selectBookIdByBookNo(bookingno);
            if (bookId == null) {
                return (T) new Result(StatusEnum.NO_PARAM.getCODE(), "无此预订单号");
            }

            //查询预订单信息
            Quickbooking quickbooking = bookingDao.selectReserveInfo(bookId);
            returnMap.put("quickbooking",quickbooking);
            //查询预订单房间号
            List<QuickbookingRoomno> quickbookingRoomnos1 = bookingDao.selectAllQuiNotPeckRoom(bookId);
            if (quickbookingRoomnos1.size() == 0) {
                return (T) new Result(StatusEnum.NO_PARAM.getCODE(), "订单无可入住房间");
            }
            returnMap.put("rooms",quickbookingRoomnos1);

            //查询房间押金信息  selectRoomConsumptionInfo
            List<KfconsumpRecord> kfconsumpRecords = roomSDao.selectRoomConsumptionInfo(bookingno);
            for (int i = 0; i < kfconsumpRecords.size(); i++) {
                if ("押金".equals(kfconsumpRecords.get(i).getProject())) {
                    returnMap.put("finance",kfconsumpRecords.get(i));
                }
            }
            if(returnMap.get("finance")==null){
                return  (T)new Result(StatusEnum.NO_PARAM.getCODE(),"订单无付款信息");
            }

            return (T) new Result(StatusEnum.SUCCESS.getCODE(),returnMap);
        }catch (Exception e){
            e.printStackTrace();
            return  (T)new Result(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }

    }
    

}
