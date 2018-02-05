package com.goodsoft.hotel.util;

import javax.servlet.http.HttpServletRequest;

/**
 * function 获取服务器域名工具类
 * <p>
 * date 2017.08.04
 *
 * @author manjusaka[manjusakachn@gmail.com]
 * @version v1.1.2
 */
public class DomainNameUtil {

    /**
     * 创建本类的单例模式（具体说明参见本包下的UUIDUtil类）start
     */
    private volatile static DomainNameUtil instance;

    private DomainNameUtil() {
    }

    public static DomainNameUtil getInstance() {
        if (instance == null) {
            synchronized (DomainNameUtil.class) {
                if (instance == null) {
                    instance = new DomainNameUtil();
                }
            }
        }
        return instance;
    }
    // 创建本类的单例模式（具体说明参见本包下的UUIDUtil类）end


    /**
     * @param request http请求
     * @return 服务器域名
     */
    public StringBuilder getServerDomainName(HttpServletRequest request) {
        StringBuilder str;
        //判断服务器端口是否为80端开口 start
        if (request.getServerPort() == 80) {
            str = new StringBuilder(request.getScheme());
            str.append("://").append(request.getServerName());
        } else {
            str = new StringBuilder(request.getScheme());
            str.append("://").append(request.getServerName()).append(":").append(request.getServerPort());
        }
        //判断服务器端口是否为80端开口 end
        return str;
    }
}
