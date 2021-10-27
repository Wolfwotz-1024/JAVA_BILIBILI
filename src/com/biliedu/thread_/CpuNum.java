package com.biliedu.thread_;

public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
    }
}
