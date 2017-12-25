package com.goodsoft.hotel.controller.guestRoom;

import com.goodsoft.hotel.domain.dao.guestRoom.BookingDao;
import com.goodsoft.hotel.domain.dao.guestRoom.KfCheckOutDao;
import com.goodsoft.hotel.domain.entity.guestRoom.Quickbooking;
import com.goodsoft.hotel.domain.entity.guestRoom.QuickbookingRoomno;
import com.goodsoft.hotel.domain.entity.guestRoom.RoomCheckParam;
import com.goodsoft.hotel.domain.entity.guestRoom.RoomChekcOutParam;
import com.goodsoft.hotel.domain.entity.result.Result;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import javafx.beans.property.ReadOnlyObjectProperty;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by duyuxiang on 2017/12/15.
 * 客房退房收银
 */
@Controller
public class KfCheckOutController {


    @Resource
    KfCheckOutDao kfCheckOutDao;

    @Resource
    BookingDao bookingDao;

    @Resource
    SqlSessionTemplate sqlSessionTemplate;

    private SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 退房列表查询订单详细信息
     * @param bookId
     * @param <T>
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("checkOut/selectOne/Booking")
    @ResponseBody
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
     * @param roomCheckParam
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("checkOut/room")
    @ResponseBody
    public Object bookingTuifang(@RequestBody RoomChekcOutParam roomCheckParam) {
        if(roomCheckParam.getBookid()==null && roomCheckParam.getRoomId()==null && roomCheckParam.getIdenty()==null){
            return new Status(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
        }

        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        KfCheckOutDao mapper = sqlSession.getMapper(KfCheckOutDao.class);

        try {
            //传入预定单订单全部退房
            if ("1".equals(roomCheckParam.getIdenty()) && roomCheckParam.getBookid()!=null) {
                //查询房间所有房间号
                List<String> strings = bookingDao.selectBookingRooms(roomCheckParam.getBookid());
                if (strings.size() != 0) {
                    //修改房间状态为空房
                    mapper.updateCustomerStateByRoom(strings);
                    //修改预订单状态为全部退房
                    mapper.updateBookingFlag(roomCheckParam.getBookid(),"全部退房");
                    //修改客人信息状态为0
                    mapper.updateCustomerStateByBook(roomCheckParam.getBookid());
                    //获取预订单号
                    String bookingno = bookingDao.selectBookNoByBookId(roomCheckParam.getBookid());
                    //修改财务信息状态为0
                    mapper.updateRecordStateByBook(bookingno);
                    sqlSession.commit();
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                } else {
                    return new Status(StatusEnum.NO_PARAM.getCODE(), "该订单无房间号");
                }
                //传入房间号单个或多个退房
            }else if("2".equals(roomCheckParam.getIdenty())&& roomCheckParam.getRoomId()!=null && roomCheckParam.getRoomId().size()!=0&& roomCheckParam.getBookid()!=null){

                //修改房间状态为空房
                mapper.updateRoomFlagEmpty(roomCheckParam.getRoomId());
                //修改客人信息状态为0
                mapper.updateCustomerStateByRoom(roomCheckParam.getRoomId());
                //获取预订单号
                String bookingno = bookingDao.selectBookNoByBookId(roomCheckParam.getBookid());
                //修改财务状态map
                Map recordStateParam =new HashMap();
                recordStateParam.put("bookingno",bookingno);
                recordStateParam.put("rooms",roomCheckParam.getRoomId());
                //修改财务信息状态为0
                mapper.updateRecordStateByRoom(recordStateParam);
                sqlSession.commit();
                //查询预订单全部房间状态
                List<String> strings = bookingDao.selectAllReserveRoomState(roomCheckParam.getBookid());
                int in=0;
                for(String s:strings){
                    if(!s.equals("空房")){
                        in++;
                    }
                }
                if(in==0){
                    //修改预订单状态为全部退房
                    mapper.updateBookingFlag(roomCheckParam.getBookid(),"全部退房");
                }else{
                    //修改预订单状态为部分退房
                    mapper.updateBookingFlag(roomCheckParam.getBookid(),"部分退房");
                }
                sqlSession.commit();
                return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
            }else{
                return new Status(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
            }
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }finally {
            sqlSession.close();
        }

    }


    /**
     * 换房  --入住换空房
     * @param bookId
     * @param baseRoom
     * @param changeRoom
     * @param <T>
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("checkOut/room/exchange")
    @ResponseBody
    public <T> T roomExchange(String bookId,String markets,String baseRoom,String changeRoom){
             //判断参数是否完整
             if(bookId==null || baseRoom==null || changeRoom==null || markets==null){
                 return (T)new Status(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
             }
                 SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
                 KfCheckOutDao mapper = sqlSession.getMapper(KfCheckOutDao.class);
             try {
                 //判断房间要换至房间是否已有人入住
                 String flag = bookingDao.selectFlagByRoomId(changeRoom);
                 if (!"空房".equals(flag)) {
                     return (T) new Status(StatusEnum.DEFEAT.getCODE(), "客房已入住");
                 }
                 //查询预订单号
                 String bookingno = bookingDao.selectBookNoByBookId(bookId);

                 //查询新房间信息
                 QuickbookingRoomno quickbookingRoomno = kfCheckOutDao.selectRoomInfoPrice(changeRoom);
                 System.out.println("kfff:"+quickbookingRoomno);
                 Map <String,String> paramMap =new HashMap<String,String>();
                 paramMap.put("roomNo",quickbookingRoomno.getRoomNo());paramMap.put("typeName",quickbookingRoomno.getTypeName());
                 paramMap.put("doorLockId",quickbookingRoomno.getDoorLockId());paramMap.put("housePrices",quickbookingRoomno.getHousePrices());
                 paramMap.put("roomId",changeRoom);paramMap.put("bookId",bookId);
                 paramMap.put("baseRoomId",baseRoom); paramMap.put("bookingno",bookingno);
                 System.out.println("kkkkk:"+paramMap);

                 //修改预订单关联的房间信息
                 mapper.updateBookingRoomInfo(paramMap);
                 //修改员房间关联消费信息
                 mapper.updateRecordRoomId(paramMap);
                 //修改房间关联客人信息
                 mapper.updateGuestRoomId(paramMap);
                 //修改原房间状态
                 mapper.updateRoomFlag(baseRoom,"空房");
                 mapper.updateRoomFlag(changeRoom,markets);
                 sqlSession.commit();
                 return (T) new Status(StatusEnum.SUCCESS.getCODE(),StatusEnum.SUCCESS.getEXPLAIN());
             }catch (Exception e){
                 sqlSession.rollback();
                 e.printStackTrace();
                 return (T) new Status(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
             }finally {
                 sqlSession.close();
             }

    }


    /**
     * 续房
     * @param <T>
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("checkOut/room/continued")
    @ResponseBody
    public <T> T RoomContinued(String bookingno,String endTime){
             if(bookingno==null || endTime==null){
                 return (T)new Status(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
             }
             try{
                 Date parse = sim.parse(endTime);
                 Integer integer = kfCheckOutDao.updateBookingEndTime(bookingno, endTime);
                 if(integer==0){
                     return (T)new Status(StatusEnum.NO_PARAM.getCODE(),"无此订单号");
                 }
             }catch (ParseException e){
                 e.printStackTrace();
                 return (T)new Status(StatusEnum.NO_PARAM.getCODE(),"时间格式错误");
             }catch (Exception x){
                 x.printStackTrace();
                 return (T)new Status(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
             }
        return (T) new Status(StatusEnum.SUCCESS.getCODE(),StatusEnum.SUCCESS.getEXPLAIN());
    }



    /**
     * 获取订单待结账房间列表
     * @param queryNumber  预订单号或房间号
     * @param roomno
     * @param <T>
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("checkOut/finance/rooms")
    @ResponseBody
    public <T> T financeRooms(String bookingno,String roomno,String queryNumber){

        try {
            if (queryNumber== null) {
                return (T) new Result(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN());
            } else if (queryNumber != null && !"".equals(queryNumber) && queryNumber.length()==20) {   //通过预定单查询
                //查询预订ID
                String bookId= bookingDao.selectBookIdByBookNo(queryNumber);
                if(bookId==null){
                 return (T) new Result(StatusEnum.NO_PARAM.getCODE(),"无此预订单号");
                }
                //查询预订单房间号
                List<String> roomIds = bookingDao.selectBookingNotEmptyRooms(bookId);
                if(roomIds.size()==0){
                 return (T) new Result(StatusEnum.NO_PARAM.getCODE(),"订单号无入住房间");
                }
                //查询预订全部房间信息
                List<QuickbookingRoomno> quickbookingRoomnos = kfCheckOutDao.selectRoomInfoPriceList(roomIds);
                for(int i=0; i<quickbookingRoomnos.size();i++){
                    quickbookingRoomnos.get(i).setBookId(bookId);
                }
                return (T) new Result(StatusEnum.SUCCESS.getCODE(),quickbookingRoomnos);

            }else if (queryNumber != null && !"".equals(queryNumber)&& queryNumber.length()==4) {          //通过房间号查询
                //查询预订单号
                String bookid = kfCheckOutDao.selectQuiRoomsByRoomNo(queryNumber);
               //查询预订单已入住房间号
                List<String> roomIds = bookingDao.selectBookingNotEmptyRooms(bookid);
                if(roomIds.size()==0){
                    return (T) new Result(StatusEnum.NO_PARAM.getCODE(),"订单号无入住房间");
                }
                //查询预订全部房间信息
                List<QuickbookingRoomno> quickbookingRoomnos = kfCheckOutDao.selectRoomInfoPriceList(roomIds);
                for(int i=0; i<quickbookingRoomnos.size();i++){
                    quickbookingRoomnos.get(i).setBookId(bookid);
                }
                return (T) new Result(StatusEnum.SUCCESS.getCODE(),quickbookingRoomnos);
            }else{
                return (T) new Result(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN());
            }

        }catch (Exception e){
            e.printStackTrace();
            return (T)new Result(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }


    /**
     * 获取多个房间类型/价格信息
     * @param roomid
     * @param <T>
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("rooms/select/info")
    @ResponseBody
    public <T>T selectRoomInfo(String roomid){
        if(roomid==null){
            return (T)new Result(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
        }
        try{
            String[] ids = roomid.split(",");
            if(ids.length==0){
                return (T)new Result(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
            }
            List list=new ArrayList();
            for(int i=0;i<ids.length;i++){
                list.add(ids[i]);
            }
            List list1 = kfCheckOutDao.selectRoomInfoPriceList(list);
            return (T) new Result(StatusEnum.SUCCESS.getCODE(),list1);
        }catch (Exception e){
            return (T) new Result(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }




    }


}
