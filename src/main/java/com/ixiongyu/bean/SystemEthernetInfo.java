package com.ixiongyu.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @author xiongyu
 * @version Create at ：2020/1/9 10:55 下午
 */
@Data
@Builder
public class SystemEthernetInfo {
    /**
     * IP地址
     */
    private  String address;
    /**
     * 网关广播地址
     */
    private  String broadcast;
    /**
     * 网卡MAC地址
     */
    private  String hwaddr;
    /**
     * 子网掩码
     */
    private  String netmask;
    /**
     * 网卡描述信息
     */
    private  String description;
    /**
     * 网卡类型
     */
    private  String type;
}
