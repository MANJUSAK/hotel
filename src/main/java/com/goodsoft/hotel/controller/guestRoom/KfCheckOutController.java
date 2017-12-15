package com.goodsoft.hotel.controller.guestRoom;

import com.goodsoft.hotel.domain.dao.guestRoom.KfCheckOutDao;
import com.goodsoft.hotel.domain.entity.guestRoom.Quickbooking;
import com.goodsoft.hotel.domain.entity.guestRoom.QuickbookingRoomno;
import com.goodsoft.hotel.domain.entity.result.Result;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by duyuxiang on 2017/12/15.
 * 客房退房收银
 */
@Controller
public class KfCheckOutController {


    @Resource
    KfCheckOutDao kfCheckOutDao;


    /**
     * 退房列表查询订单详细信息
     * @param bookId
     * @param <T>
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("checkOut/selectOne/Booking")
    public <T> T  selectOneBooking (String bookId){
        if(bookId==null ||"".equals(bookId)){
            return (T) new Result(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
        }
        try{
            Quickbooking quickbooking = kfCheckOutDao.selectBookingInfo(bookId);
            List<QuickbookingRoomno> quickbookingRoomnos = kfCheckOutDao.selectBookingCheckRooms(bookId);
            quickbooking.setRoomno(quickbookingRoomnos);
            return (T) new Result(StatusEnum.SUCCESS.getCODE(),quickbooking);
        }catch (Exception e){
            e.printStackTrace();
            return (T) new Result(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }


    /**
     * 退房
     * @param bookid
     * @param roomno
     * @param roomId
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("checkOut/room")
    public Object bookingTuifang(String bookid ,String roomno,String roomId) {



        return null;
    }




}
