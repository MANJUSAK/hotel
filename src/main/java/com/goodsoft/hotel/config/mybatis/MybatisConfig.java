package com.goodsoft.hotel.config.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * description:
 * ===> mybatis配置文件
 *
 * @author manjusaka[manjusakachn@gmail.com] Created by on 2017/8/3.
 * @version v1.1.5
 */
@EnableTransactionManagement
@Configuration("mybatisConfig")
public class MybatisConfig {

    @Resource
    private DruidDataSource druidDataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext applicationContext) throws Exception {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        //使用缓存
        configuration.setCacheEnabled(true);
        //懒加载
        configuration.setLazyLoadingEnabled(false);
        configuration.setAggressiveLazyLoading(false);
        //单一语句返回多结果集
        configuration.setMultipleResultSetsEnabled(true);
        //列标签代替列名
        configuration.setUseColumnLabel(true);
        //设置数据库响应超时时间为180秒
        configuration.setDefaultStatementTimeout(180);
        //允许嵌套语句中使用分页
        configuration.setSafeRowBoundsEnabled(true);
        //开启驼峰命名（false为关闭）
        configuration.setMapUnderscoreToCamelCase(true);
        //设置参数为jdbc类型
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        //日志管理（使用slf4j）
        configuration.setLogImpl(org.apache.ibatis.logging.slf4j.Slf4jImpl.class);
        //支持自动生成主键
        configuration.setUseGeneratedKeys(true);
        //对于批量更新操作缓存SQL以提高性能
        configuration.setDefaultExecutorType(ExecutorType.REUSE);
        //mybatis日志前缀
        configuration.setLogPrefix("hotel");
        //设置返回数据默认大小（可重写）
        configuration.setDefaultFetchSize(100);
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(druidDataSource);
        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath*:static/mapper/*/*.xml"));
        //分页插件
        PageInterceptor pageHelper = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("pageSizeZero", "true");
        pageHelper.setProperties(properties);
        sqlSessionFactory.setPlugins(new Interceptor[]{pageHelper});
        //设置映射对象别名
        /*sqlSessionFactory.setTypeAliasesPackage("com.goodsoft.plantlet.domain.entity");*/
        //设置数据库厂商标识
        /* sqlSessionFactory.setDatabaseIdProvider();*/
        return sqlSessionFactory;
    }

}
