package com.goodsoft.hotel.config.timer;

import com.goodsoft.hotel.domain.dao.CyReserveDao;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description:
 * ===>定时任务处理类
 *
 * @author 严彬荣 Created on 2017-11-12 10:58
 * @version v1.0
 */
/*@Configuration
@EnableScheduling*/
public class Timer {

    @Resource
    CyReserveDao cyReserveDao;

    //每天凌晨1点执行一次
    /*@Scheduled(cron = "0 59 23 * * ?")*/
    public void timer(){
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("执行时间为：" + date);
    }

    //定时更新预订单状态
    @Scheduled(cron = "0 59 23 * * ?")
    public void reserveStateUpdate(){
    cyReserveDao.updateReserveReState();
    }

}
