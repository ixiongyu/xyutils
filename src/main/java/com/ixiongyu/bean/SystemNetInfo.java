package com.ixiongyu.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @author xiongyu
 * @version Create at ：2020/1/9 10:49 下午
 */

@Data
@Builder
public class SystemNetInfo {
    /**
     * 网络设备名
     */
    private String name;
    /**
     * IP地址
     */
    private String ipAddress;
    /**
     * 子网掩码
     */
    private String netmask;
    /**
     * 接收的总包裹数
     */
    private long rxPackets;
    /**
     * 发送的总包裹数
     */
    private long txPackets;
    /**
     * 接收到的总字节数
     */
    private long rxBytes;
    /**
     * 发送的总字节数
     */
    private long txBytes;
    /**
     * 接收到的错误包数
     */
    private long rxErrors;
    /**
     * 发送数据包时的错误数
     */
    private long txErrors;
    /**
     * 接收时丢弃的包数
     */
    private long rxDropped;
    /**
     * 发送时丢弃的包数
     */
    private long txDropped;

}
