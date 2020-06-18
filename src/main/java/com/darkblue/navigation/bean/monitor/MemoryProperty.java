package com.darkblue.navigation.bean.monitor;

import java.io.Serializable;

public class MemoryProperty implements Serializable {

    private static final long serialVersionUID = 1L;

    //物理内存信息
    private long memoryTotal;  //内存总量
    private long memoryUsed;  //当前内存使用量
    private long memoryFree;  //当前内存剩余量

    //交换分区信息
    private long swapTotal;  //交换区总量
    private long swapUsed;  //当前交换区使用量
    private long swapFree;  //当前交换区剩余量

    //jvm内存信息
    private long jvmMemoryTotal;  //JVM可以使用的总内存
    private long jvmMemoryFree;  //JVM可以使用的剩余内存

    public long getMemoryTotal() {
        return memoryTotal;
    }

    public void setMemoryTotal(long memoryTotal) {
        this.memoryTotal = memoryTotal;
    }

    public long getMemoryUsed() {
        return memoryUsed;
    }

    public void setMemoryUsed(long memoryUsed) {
        this.memoryUsed = memoryUsed;
    }

    public long getMemoryFree() {
        return memoryFree;
    }

    public void setMemoryFree(long memoryFree) {
        this.memoryFree = memoryFree;
    }

    public long getSwapTotal() {
        return swapTotal;
    }

    public void setSwapTotal(long swapTotal) {
        this.swapTotal = swapTotal;
    }

    public long getSwapUsed() {
        return swapUsed;
    }

    public void setSwapUsed(long swapUsed) {
        this.swapUsed = swapUsed;
    }

    public long getSwapFree() {
        return swapFree;
    }

    public void setSwapFree(long swapFree) {
        this.swapFree = swapFree;
    }

    public long getJvmMemoryTotal() {
        return jvmMemoryTotal;
    }

    public void setJvmMemoryTotal(long jvmMemoryTotal) {
        this.jvmMemoryTotal = jvmMemoryTotal;
    }

    public long getJvmMemoryFree() {
        return jvmMemoryFree;
    }

    public void setJvmMemoryFree(long jvmMemoryFree) {
        this.jvmMemoryFree = jvmMemoryFree;
    }
}
