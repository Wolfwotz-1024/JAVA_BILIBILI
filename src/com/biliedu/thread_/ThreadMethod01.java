package com.biliedu.thread_;

public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        TT tt = new TT();
        tt.setName("SHKing");
        tt.setPriority(Thread.MIN_PRIORITY);
        tt.start();

        System.out.println(tt.getName() + " " + tt.getPriority());
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
        }
        tt.interrupt();
    }
}

class TT extends Thread{
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " 吃包子～～～" + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + " 休眠中～～～");
                Thread.sleep(5);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 被 interrupt了");
            }
        }
    }
}