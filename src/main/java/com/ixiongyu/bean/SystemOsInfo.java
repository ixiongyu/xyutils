package com.ixiongyu.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @author xiongyu
 * @version Create at ：2020/1/9 9:31 下午
 */

@Data
@Builder
public class SystemOsInfo {
    /**
     * 操作系统
     */
    private String osArch;
    /**
     * 操作系统CpuEndian
     */
    private String osCpuEndian;
    /**
     * 操作系统DataModel
     */
    private String osDataModel;
    /**
     * 操作系统的描述
     */
    private String osDescription;
    /**
     * 操作系统名称
     */
    private String osName;
    /**
     * 修补版本号
     */
    private String osPatchLevel;
    /**
     * 操作系统的卖主
     */
    private String osVendor;
    /**
     * 操作系统的卖主名
     */
    private String osVendorCodeName;
    /**
     * 操作系统名称
     */
    private String osVendorName;
    /**
     * 操作系统卖主类型
     */
    private String osVendorVersion;
    /**
     * 操作系统的版本号
     */
    private String osVersion;
}
