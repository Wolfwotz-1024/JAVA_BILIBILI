package com.biliedu.thread_;

public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();

        Thread.sleep(10000);
        t.setLoop(false);
    }
}

class T extends Thread{
    // 设置一个控制变量
    private boolean loop = true;
    @Override
    public void run() {
        while (loop){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T Thread 运行中...");
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}