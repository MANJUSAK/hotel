package com.goodsoft.hotel.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * description:
 * ===>定时任务测试
 *
 * @author 严彬荣 Created on 2017-11-12 10:42
 */
public class TimeTest {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                // task to run goes here
                System.out.println("Hello !!");
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 3, 3, TimeUnit.SECONDS);
    }
}
