package com.goodsoft.hotel.timers;

import com.goodsoft.hotel.domain.dao.RepastOrderDao;
import com.goodsoft.hotel.domain.entity.dto.OrderDTO;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * description:
 * ===>餐饮定时器业务处理，用于餐饮实现业务辅助功能模块
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-11-30 17:35
 * @version V1.0
 */
@Configuration
@EnableScheduling
@Async
public class RepastOrderTimer {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;
    /**
     * 实例化日志管理工具类
     */
    private Logger logger = LoggerFactory.getLogger(RepastOrderTimer.class);

    /**
     * 超时订单定时任务
     */
    /*@Scheduled(cron = "0/10 * * * * ?")*/
    @Scheduled(cron = "0 30 4 * * ?")
    @Transactional(rollbackFor = Exception.class)
    public void orderTimeoutService() {
        SqlSession sqlSession = this.sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        RepastOrderDao dao = sqlSession.getMapper(RepastOrderDao.class);
        try {
            List<Map> list = dao.queryKtOrderTimeDao();
            int len = list.size();
            if (len > 0) {
                OrderDTO order = new OrderDTO();
                for (Map map : list) {
                    if (getHourBetween((String) map.get("KT_TIME"))) {
                        order.setId((String) map.get("ID"));
                        order.setStatus(3);
                        dao.updateOrderStatusDao(order);
                    }
                }
                sqlSession.commit();
            }
            this.logger.info("订单状态定时检测成功!检查超时订单数为" + len + "条");
        } catch (Exception e) {
            sqlSession.rollback();
            System.out.println("订单状态定时检测失败");
            this.logger.error("订单状态定时检测失败---" + e.getMessage());
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 时间判断
     *
     * @param hour 时间
     * @return true/false
     */
    private boolean getHourBetween(String hour) {
        long odTime = 0;
        try {
            odTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(hour).getTime();
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
        long currentTime = System.currentTimeMillis();
        long timeBetween = currentTime - odTime;
        int hourBetween = (int) (timeBetween / 3600000);
        return hourBetween > 5;
    }


}
