package com.goodsoft.hotel.config.mybatis;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * function 配置mybatis包扫描
 * Created by manjusaka[manjusakachn@gmail.com] on 2017/8/3.
 *
 * @version v1.0
 */
@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MybatisScannerConfig {

    @Bean(name = "mapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.goodsoft.hotel.domain.dao");
        mapperScannerConfigurer.setProcessPropertyPlaceHolders(false);
        return mapperScannerConfigurer;
    }
}
