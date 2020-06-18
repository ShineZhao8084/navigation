package com.darkblue.navigation.utils;

import com.darkblue.navigation.bean.monitor.CPUProperty;
import com.darkblue.navigation.bean.monitor.FileSystemProperty;
import com.darkblue.navigation.bean.monitor.MemoryProperty;
import com.darkblue.navigation.bean.monitor.SystemProperty;
import org.hyperic.sigar.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class MonitorUtil {

    private static final Sigar SIGAR = new Sigar();

    public static SystemProperty getSystemProperty() throws UnknownHostException, SigarException {
        CpuInfo info = SIGAR.getCpuInfoList()[0];
        SystemProperty systemProperty = new SystemProperty();
        Runtime r = Runtime.getRuntime();
        Properties props = System.getProperties();
        InetAddress addr = InetAddress.getLocalHost();
        Map<String, String> map = System.getenv();
        systemProperty.setComputerName(map.get("COMPUTERNAME"));
        systemProperty.setUserDomain(map.get("USERDOMAIN"));
        systemProperty.setIp(addr.getHostAddress());
        systemProperty.setHostName(addr.getHostName());
        systemProperty.setCpuVendor(info.getVendor());
        systemProperty.setCpuModel(info.getModel());
        systemProperty.setCpuCores(info.getCoresPerSocket());
        systemProperty.setOsName(props.getProperty("os.name"));
        systemProperty.setOsArch(props.getProperty("os.arch"));
        systemProperty.setOsVersion(props.getProperty("os.version"));
        systemProperty.setFileSeparator(props.getProperty("file.separator"));
        systemProperty.setPathSeparator(props.getProperty("path.separator"));
        systemProperty.setLineSeparator(props.getProperty("line.separator"));
        systemProperty.setUserName(props.getProperty("user.name"));
        systemProperty.setUserHome(props.getProperty("user.home"));
        systemProperty.setUserDir(props.getProperty("user.dir"));
        systemProperty.setJavaVersion(props.getProperty("java.version"));
        systemProperty.setJavaVendor(props.getProperty("java.vendor"));
        systemProperty.setJavaVendorUrl(props.getProperty("java.vendor.url"));
        systemProperty.setJavaHome(props.getProperty("java.home"));
        systemProperty.setJavaVmSpecificationVersion(props.getProperty("java.vm.specification.version"));
        systemProperty.setJavaVmSpecificationVendor(props.getProperty("java.vm.specification.vendor"));
        systemProperty.setJavaVmSpecificationName(props.getProperty("java.vm.specification.name"));
        systemProperty.setJavaVmVersion(props.getProperty("java.vm.version"));
        systemProperty.setJavaVmVendor(props.getProperty("java.vm.vendor"));
        systemProperty.setJavaVmName(props.getProperty("java.vm.name"));
        systemProperty.setJavaSpecificationVersion(props.getProperty("java.specification.version"));
        systemProperty.setJavaSpecificationVendor(props.getProperty("java.specification.vender"));
        systemProperty.setJavaSpecificationName(props.getProperty("java.specification.name"));
        systemProperty.setJavaClassVersion(props.getProperty("java.class.version"));
        systemProperty.setJavaClassPath(props.getProperty("java.class.path"));
        systemProperty.setJavaLibraryPath(props.getProperty("java.library.path"));
        systemProperty.setJavaIoTmpdir(props.getProperty("java.io.tmpdir"));
        systemProperty.setJavaExtDirs(props.getProperty("java.ext.dirs"));
        systemProperty.setJvmAvailableProcessors(r.availableProcessors());
        return systemProperty;
    }

    public static HashMap<String, Object> getDynamicProperties() throws SigarException {
        HashMap<String, Object> info = new HashMap<>();
        info.put("cpuProperty", getCPUProperty());
        info.put("memoryProperty", getMemoryProperty());
        info.put("fileSystemProperties", getFileSystemPropertyList());
        return info;
    }

    private static CPUProperty getCPUProperty() throws SigarException {
        CPUProperty cpuProperty = new CPUProperty();
        CpuInfo info = SIGAR.getCpuInfoList()[0];
        CpuPerc cpu = SIGAR.getCpuPerc();
        cpuProperty.setCpuMhz(info.getMhz());
        cpuProperty.setCpuCombined(CpuPerc.format(cpu.getCombined()));
        cpuProperty.setCpuSys(CpuPerc.format(cpu.getSys()));
        cpuProperty.setCpuUser(CpuPerc.format(cpu.getUser()));
        cpuProperty.setCpuIdle(CpuPerc.format(cpu.getIdle()));
        cpuProperty.setCpuWait(CpuPerc.format(cpu.getWait()));
        cpuProperty.setCpuNice(CpuPerc.format(cpu.getNice()));
        return cpuProperty;
    }

    private static MemoryProperty getMemoryProperty() throws SigarException {
        MemoryProperty memoryProperty = new MemoryProperty();
        Runtime r = Runtime.getRuntime();
        Mem mem = SIGAR.getMem();
        Swap swap = SIGAR.getSwap();
        memoryProperty.setMemoryTotal(mem.getTotal() / 1048576L);
        memoryProperty.setMemoryUsed(mem.getUsed() / 1048576L);
        memoryProperty.setMemoryFree(mem.getFree() / 1048576L);
        memoryProperty.setSwapTotal(swap.getTotal() / 1048576L);
        memoryProperty.setSwapUsed(swap.getUsed() / 1048576L);
        memoryProperty.setSwapFree(swap.getFree() / 1048576L);
        memoryProperty.setJvmMemoryTotal(r.totalMemory() / 1048576L);
        memoryProperty.setJvmMemoryFree(r.freeMemory() / 1048576L);
        return memoryProperty;
    }

    private static List<FileSystemProperty> getFileSystemPropertyList() throws SigarException {
        List<FileSystemProperty> fileSystemProperties = new ArrayList<>();
        FileSystem[] fileSystems = SIGAR.getFileSystemList();
        for (FileSystem fileSystem : fileSystems) {
            if (2 == fileSystem.getType()) {
                FileSystemUsage usage = SIGAR.getFileSystemUsage(fileSystem.getDirName());
                FileSystemProperty fileSystemProperty = new FileSystemProperty();
                fileSystemProperty.setDirName(fileSystem.getDirName());
                fileSystemProperty.setSysTypeName(fileSystem.getSysTypeName());
                fileSystemProperty.setFileSystemTotal(usage.getTotal() / 1073741824L);
                fileSystemProperty.setFileSystemFree(usage.getFree() / 1073741824L);
                fileSystemProperty.setFileSystemAvail(usage.getAvail() / 1073741824L);
                fileSystemProperty.setFileSystemUsed(usage.getUsed() / 1073741824L);
                fileSystemProperty.setUsePercent(usage.getUsePercent() * 100D);
                fileSystemProperty.setDiskReads(usage.getDiskReads());
                fileSystemProperty.setDiskWrites(usage.getDiskWrites());
                fileSystemProperties.add(fileSystemProperty);
            }

        }
        return fileSystemProperties;
    }


}
