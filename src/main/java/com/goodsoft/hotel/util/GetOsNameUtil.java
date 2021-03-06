package com.goodsoft.hotel.util;

/**
 * function 获取操作系统类型工具类
 *
 * @author manjusaka[manjusakachn@gmail.com] on 2017/9/8.
 * @version V1.0
 */
public class GetOsNameUtil {
    /**
     * 创建本类的单例模式（具体说明参见本包下的UUIDUtil类） start
     */
    private volatile static GetOsNameUtil instance;

    private GetOsNameUtil() {
    }

    public static GetOsNameUtil getInstance() {
        if (instance == null) {
            synchronized (GetOsNameUtil.class) {
                if (instance == null) {
                    instance = new GetOsNameUtil();
                }
            }
        }
        return instance;
        //创建本类的单例模式（具体说明参见本包下的UUIDUtil类） end
    }

    /**
     * 定义初始变量为Linux系统
     */
    private final static String OSNAME = "linux";
    private final static String OS = "os.name";

    /**
     * 获取操作系统类型方法
     *
     * @return 操作系统类型
     */

    public boolean getOsName() {
        String osName = System.getProperty(OS).toLowerCase();
        switch (osName) {
            case OSNAME:
                return true;
            default:
                return false;
        }
    }

}
