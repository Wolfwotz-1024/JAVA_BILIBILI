package com.biliedu.synchronize_;

public class Homework02 {
    public static void main(String[] args) {
        User user = new User();
        Thread thread = new Thread(user);
        Thread thread1 = new Thread(user);
        thread.start();
        thread1.start();
    }
}

class User implements Runnable{
    private double money = 100000;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (money < 1000) {
                    System.out.println("余额不足，不能取款！");
                    System.out.println("本次余额为 " + money);
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() +
                        " 本次取款1千元 " + money);
                try {
                    Thread.sleep(1000 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}