package com.ixiongyu.bean;

import lombok.Builder;
import lombok.Data;
import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuPerc;

import java.util.List;

/**
 * @author xiongyu
 * @version Create at ：2020/1/9 9:29 下午
 */
@Data
@Builder
public class SystemCpuInfo {

    /**
     * cpu 总量参数情况
     */
    private Cpu cpu;
    /**
     * cpu 总百分比情况
     */
    private CpuPerc cpuPerc;

    private List<CoreInfo> coreInfoList;

    @Data
    @Builder
     public   static class CoreInfo {
        /**
         * CPU生产商
         */
        private String vendor;
        /**
         * CPU类别
         */
        private String model;
        /**
         * PU的总量MHz
         */
        private int mhz;
        /**
         * CPU缓存数量
         */
        private long cacheSize;

        /**
         * cpu核心数
         */
        private int totalCores;
        private int totalSockets;
        private int coresPerSocket;
        /**
         * CPU用户使用率
         */
        private double user;
        /**
         * CPU系统使用率
         */
        private double sys;
        /**
         * CPU当前错误率
         */
        private double nice;
        /**
         * CPU当前空闲率
         */
        private double idle;
        /**
         * CPU当前等待率
         */
        private double wait;
        private double irq;
        private double softIrq;
        private double stolen;
        /**
         * CPU总的使用率
         */
        private double combined;
    }
}
