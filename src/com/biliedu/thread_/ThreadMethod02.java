package com.biliedu.thread_;

public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();

        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程 吃了" + i + " 包子");
            if(i == 5){
                System.out.println("主线程 让 子线程 先吃");
                Thread.yield();
                t2.join();// 相当于先让t2先执行
                System.out.println("子线程吃完，让主线程吃");
            }
        }
    }
}

class T2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程 吃了-----" + i + " 包子");
        }
    }
}