package com.goodsoft.hotel.config.timer;

import com.goodsoft.hotel.domain.dao.CyReserveDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    //更新过期未到预订单状态
    @Scheduled(cron="0 0 1 * * ?")
    public void updateReserveState(){
        try {
            cyReserveDao.updateReserveReState();
        }catch (Exception e){
            logger.error("餐饮预订定时任务更新失败");
        }
    }
}
