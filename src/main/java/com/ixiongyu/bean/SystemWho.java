package com.ixiongyu.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @author xiongyu
 * @version Create at ：2020/1/9 9:33 下午
 */
@Data
@Builder
public class SystemWho {
    private String user;
    private String device;
    private String host;
    private long time;
}
