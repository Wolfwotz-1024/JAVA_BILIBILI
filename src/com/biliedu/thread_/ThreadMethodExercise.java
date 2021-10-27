package com.biliedu.thread_;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        SubThread subThread = new SubThread();
        Thread thread = new Thread(subThread);
        for (int i = 0; i < 10; i++) {
            if(i == 5){
                thread.start();
                thread.join();
            }
            System.out.println("hi " + (i + 1));
        }
        System.out.println("主线程结束...");
    }
}

class SubThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello " + (i + 1));
        }
        System.out.println("子线程结束...");
    }
}