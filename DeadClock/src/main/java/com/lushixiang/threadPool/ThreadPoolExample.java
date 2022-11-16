package com.lushixiang.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 本类显示如何使用ThreadPoolExecutor
 */
public class ThreadPoolExample {
    public static int CORE_THREAD_SIZE = 6;
    public static int MAX_CORE_THREAD_SIZE = 10;
    public static long THREAD_LIVE_TIME = 60;
    private static final int QUEUE_CAPACITY = 100;

    public static void main(String[] args) {
        // 测试字符串常量池
        String s1 = new StringBuilder("计算机").append("科学与技术").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("ja").append("va").toString();
        String s3 = "java";
        String s4 = "java";
        System.out.println(s2 == s3);
        System.out.println(s3 == s4);
        System.out.println(s2.intern() == s2);
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_THREAD_SIZE, MAX_CORE_THREAD_SIZE, THREAD_LIVE_TIME, TimeUnit.SECONDS, new ArrayBlockingQueue<>(QUEUE_CAPACITY), new ThreadPoolExecutor.CallerRunsPolicy());

    }
}
