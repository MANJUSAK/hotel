package com.goodsoft.hotel.config.aop;

import com.goodsoft.hotel.util.GetIPUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * function 系统访问数据信息增强工具类-aop
 * Created by  manjusaka[manjusakachn@gmail.com] on 2017/9/22.
 * version v1.0
 */
@SuppressWarnings("ALL")
@Component
@Aspect
public class ControllerAop {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //匹配com.goodsoft.plantlet.controller包及其子包下的所有类的所有方法
    @Pointcut("execution(* com.goodsoft.hotel.controller.*..*(..))")
    public void executeService() {
    }

    @After("executeService()")
    public void doAfter(JoinPoint pjp) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String queryString = request.getQueryString();
        String ip = GetIPUtil.getIP(request);
        logger.info("ip:{} 请求信息：,url:{},method:{},params:{}", ip, url, method, queryString);
    }

}
