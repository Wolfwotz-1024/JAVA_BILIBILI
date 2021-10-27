package com.biliedu.synchronize_;

public class DeadLock_ {
    public static void main(String[] args) {
        DeadLockDemo deadLock1 = new DeadLockDemo(true);
        DeadLockDemo deadLock2 = new DeadLockDemo(false);
        deadLock1.start();
        deadLock2.start();

    }
}

// 线程
class DeadLockDemo extends Thread{
    static Object o1 = new Object();
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        if(flag){
            synchronized (o1){
                System.out.println(Thread.currentThread().getName() + "进入1");
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName() + "进入2");
                }
            }
        }else{
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "进入3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "进入4");
                }
            }
        }
    }
}