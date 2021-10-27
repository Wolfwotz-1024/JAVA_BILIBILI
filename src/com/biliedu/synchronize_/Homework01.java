package com.biliedu.synchronize_;

import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        Thread01 thread01 = new Thread01();
        Thread02 thread02 = new Thread02(thread01);
        Thread thread = new Thread(thread01);
        Thread thread1 = new Thread(thread02);
        thread.start();
        thread1.start();
    }
}

class Thread01 implements Runnable{
    public boolean loop = true;
    @Override
    public void run() {
        while (loop){
            double num = Math.random() * 100 + 1;
            System.out.println(Thread.currentThread().getName() + " " + num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread02 implements Runnable{
    private Thread01 thread01;
    public Thread02(Thread01 thread011) {
        thread01 = thread011;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("请输入字符【Q】退出：");
            String str = scanner.next();
            if ("Q".equals(str)) {
                thread01.loop = false;
                break;
            }
        }
    }
}