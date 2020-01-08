package com.ixiongyu.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author xiongyu
 * @version Create at ：2020/1/7 5:34 下午
 */

public class ThreadPoolUtil {
    /**
     * 新建线程池
     * @param corePoolSize 初始化大小
     * @param maximumPoolSize 最大大小
     * @param keepAliveTime 存活时间
     * @param unit 时间单位
     * @return 线程池
     */
    public static ExecutorService createThreadPool(int corePoolSize,
                                                   int maximumPoolSize,
                                                   long keepAliveTime,
                                                   TimeUnit unit) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, new LinkedBlockingQueue<>(), namedThreadFactory);

    }
}
