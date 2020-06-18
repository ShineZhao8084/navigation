package com.darkblue.navigation.bean.monitor;

import java.io.Serializable;

public class CPUProperty implements Serializable {

    private static final long serialVersionUID = 1L;

    private int cpuMhz;  //CPU频率
    private String cpuCombined;  //CPU总的使用率
    private String cpuUser;  //CPU用户使用率
    private String cpuSys;  //CPU系统使用率
    private String cpuIdle;  //CPU当前空闲率
    private String cpuWait;  //CPU当前等待率
    private String cpuNice;  //CPU当前错误率

    public int getCpuMhz() {
        return cpuMhz;
    }

    public void setCpuMhz(int cpuMhz) {
        this.cpuMhz = cpuMhz;
    }

    public String getCpuCombined() {
        return cpuCombined;
    }

    public void setCpuCombined(String cpuCombined) {
        this.cpuCombined = cpuCombined;
    }

    public String getCpuUser() {
        return cpuUser;
    }

    public void setCpuUser(String cpuUser) {
        this.cpuUser = cpuUser;
    }

    public String getCpuSys() {
        return cpuSys;
    }

    public void setCpuSys(String cpuSys) {
        this.cpuSys = cpuSys;
    }

    public String getCpuIdle() {
        return cpuIdle;
    }

    public void setCpuIdle(String cpuIdle) {
        this.cpuIdle = cpuIdle;
    }

    public String getCpuWait() {
        return cpuWait;
    }

    public void setCpuWait(String cpuWait) {
        this.cpuWait = cpuWait;
    }

    public String getCpuNice() {
        return cpuNice;
    }

    public void setCpuNice(String cpuNice) {
        this.cpuNice = cpuNice;
    }
}
