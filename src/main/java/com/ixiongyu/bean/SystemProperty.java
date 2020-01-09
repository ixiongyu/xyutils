package com.ixiongyu.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @author xiongyu
 * @version Create at ：2020/1/9 9:03 下午
 */

@Data
@Builder
public class SystemProperty {
    /**
     * 用户的账户名称
     */
    private String userName;
    /**
     * 用户的主目录
     */
    private String userHome;
    /**
     * 计算机名
     */
    private String computerName;
    /**
     * 计算机域名
     */
    private String userDomain;
    /**
     * 本地ip地址
     */
    private String ip;
    /**
     * 本地主机名
     */
    private String hostName;
    /**
     * JVM可以使用的总内存
     */
    private long totalMemory;
    /**
     * JVM可以使用的剩余内存
     */
    private long freeMemory;
    /**
     * JVM可以使用的处理器个数
     */
    private long availableProcessors;
    /**
     * Java的运行环境版本
     */
    private String javaVersion;
    /**
     * Java的运行环境供应商
     */
    private String javaVendor;
    /**
     * Java供应商的URL
     */
    private String javaVendorUrl;
    /**
     * Java的安装路径
     */
    private String javaHome;
    /**
     * Java的虚拟机规范版本
     */
    private String javaVmSpecificationVersion;
    /**
     * Java的虚拟机规范供应商
     */
    private String javaVmSpecificationVendor;
    /**
     * Java的虚拟机规范名称
     */
    private String javaVmSpecificationName;
    /**
     * Java的虚拟机实现版本
     */
    private String javaVmVersion;
    /**
     * Java的虚拟机实现供应商
     */
    private String javaVmVendor;
    /**
     * Java的虚拟机实现名称
     */
    private String javaVmName;
    /**
     * Java运行时环境规范版本
     */
    private String javaSpecificationVersion;
    /**
     * Java运行时环境规范供应商
     */
    private String javaSpecificationVendor;
    /**
     * Java运行时环境规范名称
     */
    private String javaSpecificationName;
    /**
     * Java的类格式版本号
     */
    private String javaClassVersion;
    /**
     * Java的类路径
     */
    private String javaClassPath;
    /**
     * 加载库时搜索的路径列表
     */
    private String javaLibraryPath;
    /**
     * 默认的临时文件路径
     */
    private String javaIoTmpdir;
    /**
     * 一个或多个扩展目录的路径
     */
    private String javaExtDir;
    /**
     * 操作系统的名称
     */
    private String osName;
    /**
     * 操作系统的构架
     */
    private String osArch;
    /**
     * 操作系统的版本
     */
    private String osVersion;
    /**
     * 文件分隔符
     */
    private String fileSeparator;
    /**
     * 行分隔符
     */
    private String pathSeparator;
    /**
     * 用户的账户名称
     */
    private String lineSeparator;
    /**
     * 用户的当前工作目录
     */
    private String userDir;
}
