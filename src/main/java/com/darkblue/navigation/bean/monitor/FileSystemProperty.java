package com.darkblue.navigation.bean.monitor;

import java.io.Serializable;

public class FileSystemProperty implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dirName;  //盘符路径
    private String sysTypeName;  //文件系统类型
    private long fileSystemTotal;  //总大小
    private long fileSystemFree;  //剩余大小
    private long fileSystemAvail;  //可用大小
    private long fileSystemUsed;  //已经使用量
    private double usePercent;  //资源的利用率
    private long diskReads;  //读出
    private long diskWrites;  //写入

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public String getSysTypeName() {
        return sysTypeName;
    }

    public void setSysTypeName(String sysTypeName) {
        this.sysTypeName = sysTypeName;
    }

    public long getFileSystemTotal() {
        return fileSystemTotal;
    }

    public void setFileSystemTotal(long fileSystemTotal) {
        this.fileSystemTotal = fileSystemTotal;
    }

    public long getFileSystemFree() {
        return fileSystemFree;
    }

    public void setFileSystemFree(long fileSystemFree) {
        this.fileSystemFree = fileSystemFree;
    }

    public long getFileSystemAvail() {
        return fileSystemAvail;
    }

    public void setFileSystemAvail(long fileSystemAvail) {
        this.fileSystemAvail = fileSystemAvail;
    }

    public long getFileSystemUsed() {
        return fileSystemUsed;
    }

    public void setFileSystemUsed(long fileSystemUsed) {
        this.fileSystemUsed = fileSystemUsed;
    }

    public double getUsePercent() {
        return usePercent;
    }

    public void setUsePercent(double usePercent) {
        this.usePercent = usePercent;
    }

    public long getDiskReads() {
        return diskReads;
    }

    public void setDiskReads(long diskReads) {
        this.diskReads = diskReads;
    }

    public long getDiskWrites() {
        return diskWrites;
    }

    public void setDiskWrites(long diskWrites) {
        this.diskWrites = diskWrites;
    }
}
