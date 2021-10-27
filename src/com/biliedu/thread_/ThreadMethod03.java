package com.biliedu.thread_;

public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        // 如果我们希望当mian线程结束后，子线程自动结束
        // ，只需要将子线程设为守护线程即可
//        MyDaemonThread myDaemonThread1 =
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();
        for (int i = 0; i <= 10; i++) {
            System.out.println("You work hard");
            Thread.sleep(1000);
        }
    }
}

class MyDaemonThread extends Thread{
    @Override
    public void run() {
        for (;;){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("You and I~~~");
        }
    }
}