package com.goodsoft.hotel.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * 数据库连接池配置
 * <p>
 * DruidDBConfig类被@Configuration标注，用作配置信息；
 * DataSource对象被@Bean声明，为Spring容器所管理，
 * version v1.0
 *
 * @author 严彬荣
 *         jdbc.url=${jdbc.url}
 *         最新的支持方式如下:
 *         jdbc.url=@jdbc.url@
 * @primary 表示这里定义的DataSource将覆盖其他来源的DataSource。
 */
@SuppressWarnings("ALL")
@Configuration
public class DruidDBConfig {
    @Resource
    private WallFilter wallFilter;
    private final Logger logger = Logger.getLogger(DruidDBConfig.class);
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.initialSize}")
    private int initialSize;
    @Value("${spring.datasource.minIdle}")
    private int minIdle;
    @Value("${spring.datasource.maxActive}")
    private int maxActive;
    @Value("${spring.datasource.maxWait}")
    private int maxWait;
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;
    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;
    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;
    @Value("${spring.datasource.filters}")
    private String filters;
    @Value("${spring.datasource.connectionProperties}")
    private String connectionProperties;
    @Value("${spring.datasource.removeAbandoned}")
    private boolean removeAbandoned;
    @Value("${spring.datasource.removeAbandonedTimeout}")
    private Integer removeAbandonedTimeout;
    @Value("${spring.datasource.logAbandoned}")
    private boolean logAbandoned;

    @Bean // 声明其为Bean实例
    @Primary // 在同样的DataSource中，首先使用被标注的DataSource
    public DruidDataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.dbUrl);
        datasource.setUsername(this.username);
        datasource.setPassword(this.password);
        datasource.setDriverClassName(this.driverClassName);
        // configuration
        datasource.setInitialSize(this.initialSize);
        datasource.setMinIdle(this.minIdle);
        datasource.setMaxActive(this.maxActive);
        datasource.setMaxWait(this.maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(this.timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(this.minEvictableIdleTimeMillis);
        datasource.setValidationQuery(this.validationQuery);
        datasource.setTestWhileIdle(this.testWhileIdle);
        datasource.setTestOnBorrow(this.testOnBorrow);
        datasource.setTestOnReturn(this.testOnReturn);
        datasource.setPoolPreparedStatements(this.poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(this.maxPoolPreparedStatementPerConnectionSize);
        datasource.setRemoveAbandoned(this.removeAbandoned);
        datasource.setRemoveAbandonedTimeout(this.removeAbandonedTimeout);
        datasource.setLogAbandoned(this.logAbandoned);
        datasource.setConnectionProperties(connectionProperties);
        datasource.setAsyncInit(true);
        //datasource.setDefaultAutoCommit(false);
        //添加druid过滤器 设置运行批量更新
        List filter = Arrays.asList(wallFilter);
        datasource.setProxyFilters(filter);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            this.logger.error(e);
        }
        return datasource;
    }

    //允许批量更新
    @Bean
    public WallConfig wallConfig() {
        WallConfig wallConfig = new WallConfig();
        wallConfig.setMultiStatementAllow(true);
        return wallConfig;
    }

    //注入过滤器
    @Bean
    @DependsOn
    public WallFilter wallFilter(WallConfig wallConfig) {
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig);
        return wallFilter;
    }
}
