package com.ixiongyu.system;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.ixiongyu.bean.*;
import org.hyperic.sigar.*;

/**
 * @author xiongyu
 * @version Create at ：2020/1/9 8:27 下午
 */

public class SystemUtil {


    public static SystemProperty getProperty() throws UnknownHostException {
        Runtime r = Runtime.getRuntime();
        Properties props = System.getProperties();
        InetAddress addr;
        addr = InetAddress.getLocalHost();
        String ip = addr.getHostAddress();
        Map<String, String> map = System.getenv();
        // 获取用户名
        String userName = map.get("USERNAME");
        // 获取计算机名
        String computerName = map.get("COMPUTERNAME");
        // 获取计算机域名
        String userDomain = map.get("USERDOMAIN");
        return SystemProperty.builder()
                .userName(userName)
                .computerName(computerName)
                .userDomain(userDomain)
                .ip(ip)
                .hostName(addr.getHostName())
                .totalMemory(r.totalMemory())
                .freeMemory(r.freeMemory())
                .availableProcessors(r.availableProcessors())
                .javaVersion(props.getProperty("java.version"))
                .javaVersion(props.getProperty("java.vendor"))
                .javaVersion(props.getProperty("java.vendor.url"))
                .javaVersion(props.getProperty("java.home"))
                .javaVersion(props.getProperty("java.vm.specification.version"))
                .javaVersion(props.getProperty("java.vm.specification.vendor"))
                .javaVersion(props.getProperty("java.vm.specification.name"))
                .javaVersion(props.getProperty("java.vm.version"))
                .javaVersion(props.getProperty("java.vm.vendor"))
                .javaVersion(props.getProperty("java.vm.name"))
                .javaVersion(props.getProperty("java.specification.version"))
                .javaVersion(props.getProperty("java.specification.vendor"))
                .javaVersion(props.getProperty("java.specification.name"))
                .javaVersion(props.getProperty("java.class.version"))
                .javaVersion(props.getProperty("java.class.path"))
                .javaVersion(props.getProperty("java.library.path"))
                .javaVersion(props.getProperty("java.io.tmpdir"))
                .javaVersion(props.getProperty("java.ext.dirs"))
                .javaVersion(props.getProperty("os.name"))
                .javaVersion(props.getProperty("os.arch"))
                .javaVersion(props.getProperty("os.version"))
                .javaVersion(props.getProperty("file.separator"))
                .javaVersion(props.getProperty("path.separator"))
                .javaVersion(props.getProperty("line.separator"))
                .javaVersion(props.getProperty("ser.home"))
                .javaVersion(props.getProperty("user.dir"))
                .build();
    }

    public static SystemMemory getMemoryInfo() throws SigarException {
        Sigar sigar = new Sigar();


        Mem mem = sigar.getMem();

        SystemMemory.SystemMem systemMem = SystemMemory.SystemMem.builder().actualFree(mem.getActualFree())
                .actualUsed(mem.getActualUsed())
                .free(mem.getFree())
                .freePercent(mem.getFreePercent())
                .ram(mem.getRam())
                .total(mem.getTotal())
                .used(mem.getUsed())
                .usedPercent(mem.getUsedPercent())
                .build();
        Swap swap = sigar.getSwap();

        SystemMemory.SystemSwap systemSwap = SystemMemory.SystemSwap.builder().free(swap.getFree())
                .pageIn(swap.getPageIn())
                .pageOut(swap.getPageOut())
                .total(swap.getTotal())
                .used(swap.getUsed())
                .build();
        sigar.close();
        return SystemMemory.builder().systemMem(systemMem)
                .systemSwap(systemSwap).build();
    }

    public static SystemCpuInfo getCpuInfo() throws SigarException {
        Sigar sigar = new Sigar();
        CpuInfo[] infos = sigar.getCpuInfoList();
        CpuPerc[] cpuList;
        SystemCpuInfo systemCpuInfo = SystemCpuInfo.builder().cpu(sigar.getCpu()).cpuPerc(sigar.getCpuPerc()).build();
        cpuList = sigar.getCpuPercList();
        // 不管是单块CPU还是多CPU都适用
        List<SystemCpuInfo.CoreInfo> coreInfos = new ArrayList<>();
        for (int i = 0; i < infos.length; i++) {
            CpuInfo info = infos[i];
            CpuPerc cpuPerc = cpuList[i];
            SystemCpuInfo.CoreInfo coreInfo = SystemCpuInfo.CoreInfo.builder().mhz(info.getMhz())
                    .vendor(info.getVendor())
                    .model(info.getModel())
                    .cacheSize(info.getCacheSize())
                    .user(cpuPerc.getUser())
                    .sys(cpuPerc.getSys())
                    .wait(cpuPerc.getWait())
                    .nice(cpuPerc.getNice())
                    .idle(cpuPerc.getIdle())
                    .combined(cpuPerc.getCombined()).build();
            coreInfos.add(coreInfo);
        }
        systemCpuInfo.setCoreInfoList(coreInfos);
        sigar.close();
        return systemCpuInfo;
    }


    public static SystemOsInfo getOsInfo() {
        OperatingSystem os = OperatingSystem.getInstance();
        return SystemOsInfo.builder().osArch(os.getArch())
                .osCpuEndian(os.getCpuEndian())
                .osDataModel(os.getDataModel())
                .osDescription(os.getDescription())
                .osName(os.getName())
                .osPatchLevel(os.getPatchLevel())
                .osVendor(os.getVendor())
                .osVendorCodeName(os.getVendorCodeName())
                .osVendorName(os.getVendorName())
                .osVendorVersion(os.getVendorVersion())
                .osVersion(os.getVersion())
                .build();

    }

    public static List<SystemWho> getUsrInfo() throws SigarException {
        Sigar sigar = new Sigar();
        Who[] whos = sigar.getWhoList();
        List<SystemWho> systemWhoList = new ArrayList<>();
        if (whos != null && whos.length > 0) {
            for (Who who : whos) {
                SystemWho systemWho = SystemWho.builder().device(who.getDevice())
                        .host(who.getHost())
                        .time(who.getTime())
                        .user(who.getUser()).build();
                systemWhoList.add(systemWho);

            }
        }
        return systemWhoList;
    }

    public static List<SystemFileSystem> getFileSydtemInfo() throws Exception {
        Sigar sigar = new Sigar();
        List<SystemFileSystem> systemFileSystems = new ArrayList<>();
        FileSystem[] fsList = sigar.getFileSystemList();
        for (int i = 0; i < fsList.length; i++) {
            FileSystem fs = fsList[i];
            SystemFileSystem fileSystem = SystemFileSystem.builder()
                    .devName(fs.getDevName())
                    .dirName(fs.getDirName())
                    .flags(fs.getFlags())
                    .sysTypeName(fs.getSysTypeName())
                    .typeName(fs.getTypeName())
                    .type(fs.getType()).build();
            FileSystemUsage usage;
            usage = sigar.getFileSystemUsage(fs.getDirName());
            switch (fs.getType()) {
                // TYPE_UNKNOWN ：未知
                case 0:
                    break;
                // TYPE_NONE
                case 1:
                    break;
                // TYPE_LOCAL_DISK : 本地硬盘
                case 2:
                    // 文件系统总大小
                    fileSystem.setTotal(usage.getTotal());
                    fileSystem.setFree(usage.getFree());
                    fileSystem.setAvail(usage.getAvail());
                    fileSystem.setUsed(usage.getUsed());
                    double usePercent = usage.getUsePercent() * 100D;
                    fileSystem.setPercent(usePercent);

                    break;
                // TYPE_NETWORK ：网络
                case 3:
                    break;
                // TYPE_RAM_DISK ：闪存
                case 4:
                    break;
                // TYPE_CD_ROM ：光驱
                case 5:
                    break;
                // TYPE_SWAP ：页面交换
                case 6:
                    break;
                default:
                    break;
            }
            fileSystem.setDiskReads(usage.getDiskReads());
            fileSystem.setDiskWrites(usage.getDiskWrites());
            systemFileSystems.add(fileSystem);
        }
        sigar.close();
        return systemFileSystems;
    }

    public static List<SystemNetInfo> getNetInfo() throws Exception {
        Sigar sigar = new Sigar();
        List<SystemNetInfo> systemNetInfos = new ArrayList<>();
        String[] ifNames = sigar.getNetInterfaceList();
        for (String name : ifNames) {
            NetInterfaceConfig netInterfaceConfig = sigar.getNetInterfaceConfig(name);
            SystemNetInfo systemNetInfo = SystemNetInfo.builder().build();
            systemNetInfo.setName(name);
            systemNetInfo.setIpAddress(netInterfaceConfig.getAddress());
            systemNetInfo.setNetmask(netInterfaceConfig.getNetmask());
            if ((netInterfaceConfig.getFlags() & 1L) <= 0L) {
                System.out.println("!IFF_UP...skipping getNetInterfaceStat");
                continue;
            }
            NetInterfaceStat interfaceStat = sigar.getNetInterfaceStat(name);
            systemNetInfo.setRxPackets(interfaceStat.getRxPackets());
            systemNetInfo.setTxPackets(interfaceStat.getTxPackets());
            systemNetInfo.setRxBytes(interfaceStat.getRxBytes());
            systemNetInfo.setTxBytes(interfaceStat.getTxBytes());
            systemNetInfo.setRxErrors(interfaceStat.getRxErrors());
            systemNetInfo.setTxErrors(interfaceStat.getTxErrors());
            systemNetInfo.setRxDropped(interfaceStat.getRxDropped());
            systemNetInfo.setTxDropped(interfaceStat.getTxDropped());
            systemNetInfos.add(systemNetInfo);

        }
        return systemNetInfos;
    }

    public static List<SystemEthernetInfo> getEthernetInfo() throws SigarException {
        Sigar sigar;
        sigar = new Sigar();
        String[] ifAces = sigar.getNetInterfaceList();
        List<SystemEthernetInfo> infoList = new ArrayList<>();
        for (String ifAce : ifAces) {
            NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifAce);
            if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress()) || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0
                    || NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) {
                continue;
            }
            infoList.add(SystemEthernetInfo.builder().address(cfg.getAddress())
                    .broadcast(cfg.getBroadcast())
                    .hwaddr(cfg.getHwaddr())
                    .netmask(cfg.getNetmask())
                    .description(cfg.getDescription())
                    .type(cfg.getType()).build());

        }
        for (SystemEthernetInfo systemEthernetInfo : infoList) {
            System.out.println(systemEthernetInfo);
        }
        return infoList;
    }
}

