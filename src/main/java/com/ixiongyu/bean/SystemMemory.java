package com.ixiongyu.bean;

import lombok.Builder;
import lombok.Data;
import org.hyperic.sigar.Mem;

/**
 * @author xiongyu
 * @version Create at ：2020/1/9 9:17 下午
 */

@Builder
@Data
public class SystemMemory {

    private SystemMem systemMem;
    private SystemSwap systemSwap;

    @Builder
    @Data
    public static class SystemMem {
        /**
         * 内存总量
         */
        long total;
        long ram;
        /**
         * 当前内存使用量
         */
        long used;
        /**
         * 当前内存剩余量
         */
        long free;
        long actualUsed;
        long actualFree;
        /**
         * 使用百分比
         */
        double usedPercent;
        /**
         * 空闲百分比
         */
        double freePercent;
    }

    @Builder
    @Data
    public static class SystemSwap {
        /**
         * 交换区总量
         */
        long total;
        /**
         * 当前交换区使用量
         */
        long used;
        /**
         * 当前交换区剩余量
         */
        long free;
        long pageIn;
        long pageOut;
    }
}
