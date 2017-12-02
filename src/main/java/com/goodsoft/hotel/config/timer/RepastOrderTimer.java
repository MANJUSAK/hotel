package com.goodsoft.hotel.config.timer;

import com.goodsoft.hotel.domain.dao.RepastOrderDao;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * description:
 * ===>餐饮定时器业务处理，用于餐饮实现业务辅助功能模块
 *
 * @author 严彬荣 Created on 2017-11-30 17:35
 * @version V1.0
 */
@Configuration
@EnableScheduling
@Async
public class RepastOrderTimer {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;
    //实例化日志管理工具类
    private Logger logger = LoggerFactory.getLogger(RepastOrderTimer.class);

    /**
     * 检查超时的订单定时器
     */
    @Scheduled(cron = "0 50 9 * * ?")
    /*@Scheduled(cron = "0/5 * * * * ?")*/
    public void orderTimeoutService() {
        SqlSession sqlSession = this.sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        RepastOrderDao dao = sqlSession.getMapper(RepastOrderDao.class);
        try {
            List<Map> list = dao.queryKtOrderTimeDao();
            int len = list.size();
            if (len > 0) {
                for (Map map : list) {
                    if (getHourBetween((String) map.get("KT_TIME"))) {
                        dao.updateOrderStatusDao((String) map.get("ID"), 3, null);
                    }
                }
                sqlSession.commit();
            }
        } catch (Exception e) {
            sqlSession.rollback();
            this.logger.error(e.getMessage());
        } finally {
            sqlSession.close();
        }
    }

    private boolean getHourBetween(String hour) {
        long odTime = 0;
        try {
            odTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(hour).getTime();
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
        long currentTime = System.currentTimeMillis();
        long timeBetween = currentTime - odTime;
        int hourBetween = (int) timeBetween / (3600 * 1000);
        return hourBetween > 4;
    }
}
