package com.ixiongyu;

import com.ixiongyu.system.SystemInfoUtil;
import org.hyperic.sigar.SigarException;
import org.testng.annotations.Test;

/**
 * @author xiongyu
 * @version Create at ：2020/1/10 10:22 下午
 */

public class SystemInfoUtilTest {

    @Test
    public void test1() throws SigarException {
        SystemInfoUtil.getEthernetInfo();
    }

    public static void main(String[] args) throws SigarException {
        SystemInfoUtil.getEthernetInfo();
    }
}
