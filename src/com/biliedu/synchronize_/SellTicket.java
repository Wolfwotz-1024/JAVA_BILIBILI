package com.biliedu.synchronize_;

public class SellTicket {
    public static void main(String[] args) {

        // 测试
        SellTicket01 sellTicket01 = new SellTicket01();
        SellTicket01 sellTicket02 = new SellTicket01();
        SellTicket01 sellTicket03 = new SellTicket01();

        sellTicket01.start();
        sellTicket02.start();
        sellTicket03.start();

//        SellTicket02 sellTicket02 = new SellTicket02();
//        new Thread(sellTicket02).start();
//        new Thread(sellTicket02).start();
//        new Thread(sellTicket02).start();
    }
}

// 使用Thread 方式
class SellTicket01 extends Thread{
    private static int ticketNum = 500;
    @Override
    public void run() {
        while(true) {
            synchronized (SellTicket01.class) {
                if (ticketNum <= 0) {
                    System.out.println("售票结束...");
                    break;
                }

                //休眠50毫秒
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("窗口 " + Thread.currentThread().getName()
                        + " 售出一张票" + " 剩余票数=" + (--ticketNum));
            }
        }
    }
}

class SellTicket02 implements Runnable{
    private int ticketNum = 500;
    private boolean loop = true;

    private synchronized void sell(){ // 同步方法，在同一时刻只能有一个线程执行
        if(ticketNum <= 0){
            System.out.println("售票结束...");
            loop = false;
            return;
        }

        //休眠50毫秒
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("窗口 " + Thread.currentThread().getName()
                + " 售出一张票" + " 剩余票数=" + (--ticketNum));
    }

    @Override
    public void run() {
        while(loop){
            sell();
        }
    }
}