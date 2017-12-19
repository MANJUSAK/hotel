package com.goodsoft.hotel.timers;

import com.goodsoft.hotel.domain.dao.CyReserveDao;
import com.goodsoft.hotel.domain.dao.guestRoom.BookingDao;
import com.goodsoft.hotel.domain.dao.guestRoom.RoomSDao;
import com.goodsoft.hotel.domain.entity.guestRoom.Quickbooking;
import com.goodsoft.hotel.domain.entity.guestRoom.QuickbookingRoomno;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by duyuxiang on 2017/11/29.
 * 餐饮预订定时任务
 */
@Configuration
@EnableScheduling
@Async
public class CyReserveTimer {

    @Resource
    private CyReserveDao cyReserveDao;

    @Resource
    private BookingDao bookingDao;
    @Resource
    RoomSDao roomSDao;

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Scheduled(cron = "0 0 1 * * ?")
    public void updateReserveState() {
        try {
            //更新过期未到预订单状态
            cyReserveDao.updateReserveReState();
            //更新过期实时房价
            roomSDao.deleteLastRealTimePrice();
        } catch (Exception e) {
            logger.error("定时任务更新失败:" + e.getMessage());
        }
    }


    /**
     * 定时修改客房净房脏房状态
     */
    @Scheduled(cron = "0 50 23 * * ?")
    public void updateRoomSflag(){
        try {
            roomSDao.updateRoomSflagTimer();
        } catch (Exception e) {
            logger.error("定时任务更新失败:" + e.getMessage());
        }
    }


    /**
     * 定时更新当天未入住的客房订单
     */
    @Scheduled(cron = "0 3 1 * * ?")
    public void updateQuiRooms(){

        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        RoomSDao mapper = sqlSession.getMapper(RoomSDao.class);
        try{
        //获取所有今天以前的订单
        List<Quickbooking> quickbookings = roomSDao.selectPastQuickbooking();
        for(int i=0;i<quickbookings.size();i++) {
            if ("明确预定".equals(quickbookings.get(i).getBookingFlag())) {
                //修改预订单状态为到期未到
                mapper.updateQuickbookingState("到期未到", quickbookings.get(i).getId());
            } else if ("部分入住".equals(quickbookings.get(i).getBookingFlag())) {
                //查询订单剩余房间
                List<QuickbookingRoomno> quickbookingRoomnos = bookingDao.selectAllQuiNotPeckRoom(quickbookings.get(i).getId());
                //删除订单剩余未入住房间
                 for(int j=0;j<quickbookingRoomnos.size();j++){
                    mapper.deleteQuickBookingRoom(quickbookingRoomnos.get(j).getBookId(),quickbookingRoomnos.get(j).getRoomId());
                 }
                //修改预订单状态为全部入住
                mapper.updateQuickbookingState("全部入住", quickbookings.get(i).getId());
            }
        }
         sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }


    }


}
