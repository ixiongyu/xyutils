package com.ixiongyu.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @author xiongyu
 * @version Create at ：2020/1/9 9:33 下午
 */
@Data
@Builder
public class SystemFileSystem {
    /**
     * 盘符名称
     */
    private String devName;
    /**
     * 盘符路径
     */
    private String dirName;
    /**
     * 盘符标志
     */
    private long flags;
    /**
     * 盘符类型
     */
    private String sysTypeName;
    /**
     * 盘符类型名
     */
    private String typeName;
    /**
     * 盘符文件系统类型
     */
    private int type;
    /**
     * 总大小
     */
    private long total;
    /**
     * 剩余大小
     */
    private long free;
    /**
     * 可用大小
     */
    private long avail;
    /**
     * 已经使用量
     */
    private long used;
    /**
     * 资源的利用率
     */
    private double percent;
    /**
     * 读出
     */
    private double diskReads;
    /**
     * 写入
     */
    private double diskWrites;

}
