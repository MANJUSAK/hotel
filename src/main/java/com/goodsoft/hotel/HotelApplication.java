package com.goodsoft.hotel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * function 系统启动程序入口
 * Created by 严彬荣 on 2017/11/7.
 * version v1.0
 */
@ComponentScan(basePackages = "com.goodsoft.hotel.*")
@ServletComponentScan(basePackages = "com.goodsoft.hotel.config.*")
@SpringBootApplication
public class HotelApplication implements CommandLineRunner {


    //实例化日志管理
    private final Logger logger = LoggerFactory.getLogger(HotelApplication.class);

    public static void main(String[] args) {
        System.out.println("=================>系统正在启动............<==============");
        SpringApplication.run(HotelApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        this.logger.info("=================>系统启动成功<==============");
        System.out.println("=================>系统启动成功<==============");
    }
}
