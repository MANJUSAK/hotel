package com.goodsoft.hotel.config.filter;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * function 配置文件上传请求大小
 * Created by  manjusaka[manjusakachn@gmail.com] on 2017/8/7.
 *
 * @version v1.0
 */
@Configuration
public class MultipartConfig {


    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory multipartConfig = new MultipartConfigFactory();
        //单次上传文件总数最大为50M
        multipartConfig.setMaxFileSize("50MB");
        //每次http请求大小最大为50M
        multipartConfig.setMaxRequestSize("50MB");
        return multipartConfig.createMultipartConfig();
    }
}
