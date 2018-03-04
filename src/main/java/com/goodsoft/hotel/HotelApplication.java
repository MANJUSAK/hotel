package com.goodsoft.hotel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * function 系统启动程序入口
 *
 * @author manjusaka[manjusakachn@gmail.com] on 2017/11/7.
 * @version v1.1.0
 */
@ComponentScan(basePackages = "com.goodsoft.hotel.*")
@ServletComponentScan(basePackages = "com.goodsoft.hotel.config.*")
@SpringBootApplication
public class HotelApplication extends SpringBootServletInitializer implements CommandLineRunner {


    /**
     * 实例化日志管理
     */
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private static long startTime = 0L;
    private static long endTime = 0L;
    private static double between = 0.0;
    private static final int MS = 1000;
    private final static String SEC = "S";
    private final static String MSEC = "MS";

    /**
     * 系统内置服务器启动入口
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        startTime = System.currentTimeMillis();
        System.out.println("=================>正在启动系统！请等待...<==============");
        SpringApplication.run(HotelApplication.class, args);
    }

    /**
     * 系统外置服务器启动入口
     *
     * @param application 程序启动实例
     * @return SpringApplicationBuilder
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        startTime = System.currentTimeMillis();
        return application.sources(HotelApplication.class);
    }

    @Override
    public void run(String... strings) {
        endTime = System.currentTimeMillis();
        between = endTime - startTime;
        if (between > MS) {
            between = between / MS;
            this.LOG.info("=================>系统启动成功!启动用时：" + between + SEC + "<==============");
        } else {
            this.LOG.info("=================>系统启动成功!启动用时：" + between + MSEC + "<==============");
        }
        System.out.println("=================>系统启动成功，请使用！<==============");
    }
}
