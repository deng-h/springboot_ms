package com.dh.ms.Utils;


import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

public class CPUMonitor {
    private static final CPUMonitor instance = new CPUMonitor();
    private static final OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    public double getCPUUsage(){
        //获取CPU
        double cpuLoad = osmxb.getSystemCpuLoad();
        //获取内存
//        double totalvirtualMemory = osmxb.getTotalPhysicalMemorySize();
//        double freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
//        double value = freePhysicalMemorySize/totalvirtualMemory;
//        int percentMemoryLoad = (int) ((1-value)*100);
        return (int) (cpuLoad * 100);
    }

    public static CPUMonitor getInstance() {
        return instance;
    }
}
