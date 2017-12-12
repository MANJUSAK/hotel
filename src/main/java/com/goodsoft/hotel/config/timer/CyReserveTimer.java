package com.goodsoft.hotel.config.timer;

import com.goodsoft.hotel.domain.dao.CyReserveDao;
import com.goodsoft.hotel.domain.dao.guestRoom.RoomSDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import javax.annotation.Resource;


/**
 * Created by duyuxiang on 2017/11/29.
 * 餐饮预订定时任务
 */
@Configuration
@EnableScheduling
public class CyReserveTimer{

    @Resource
    CyReserveDao cyReserveDao;

    @Resource
    RoomSDao roomSDao;

    private Logger logger= LoggerFactory.getLogger(this.getClass());


    @Scheduled(cron="0 0 1 * * ?")
    public void updateReserveState(){
        try {
            //更新过期未到预订单状态
            cyReserveDao.updateReserveReState();
            //更新过期实时房价
            roomSDao.deleteLastRealTimePrice();
        }catch (Exception e){
            logger.error("定时任务更新失败:"+e.getMessage());
        }
    }

    @Scheduled(cron="0 50 23 * * ?")
    public void updateRoomSflag(){

        try{
            roomSDao.updateRoomSflagTimer();
        }catch (Exception e){
            logger.error("定时任务更新失败:"+e.getMessage());
        }

    }


}
