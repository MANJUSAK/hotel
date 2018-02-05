package com.goodsoft.hotel.util;

import javax.servlet.http.HttpServletRequest;

/**
 * function 获取客户端ip工具类
 *
 * @author manjusaka[manjusakachn@gmail.com] on 2017/8/14.
 * @version v1.1.2
 */
public class GetIpUtil {
    /**
     * HTTP的请求端真实的IP
     */
    private final static String XFF = "x-forwarded-for";
    private final static String PCI = "Proxy-Client-IP";
    private final static String WPCI = "WL-Proxy-Client-IP";
    private final static String UNKNOWN = "unknown";

    /**
     * @param request http请求
     * @return 访问服务器客户端ip
     */
    public static String getIP(HttpServletRequest request) {
        //获取用户ip地址 start
        String ip = request.getHeader(XFF);
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(PCI);
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(WPCI);
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        //获取用户ip地址 start
        return ip;
    }
}
