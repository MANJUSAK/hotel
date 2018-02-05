package com.goodsoft.hotel.config.aop;

import com.goodsoft.hotel.util.GetIpUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * description:
 * ===> 系统访问数据信息AOP
 *
 * @author manjusaka[manjusakachn@gmail.com] on 2017/9/22.
 * @version v1.1.0
 */
@Component
@Aspect
public class ControllerAop {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private static long startTime = 0L;

    /**
     * 匹配com.goodsoft.plantlet.controller包及其子包下的所有类的所有方法
     */
    @Pointcut("execution(* com.goodsoft.hotel.controller.*..*(..))")
    public void executeService() {
    }

    @Before("executeService()")
    public void beFore() {
        startTime = System.currentTimeMillis();
    }

    @After("executeService()")
    public void doAfter(JoinPoint pjp) {
        double between = System.currentTimeMillis() - startTime;
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String queryString = request.getQueryString();
        String ip = GetIpUtil.getIP(request);
        this.LOG.info("接口地址：{}", url);
        this.LOG.info("用户请求接口信息-->ip:{} ,method:{},params:{},接口响应时间:{} ms", ip, method, queryString, between);
    }

}
