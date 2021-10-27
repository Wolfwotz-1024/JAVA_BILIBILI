package com.biliedu.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我的坦克
    Hero hero = null;
    //定义敌人坦克，放入到Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel(){
        hero = new Hero(100, 100);
        //初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirect(2);
            new Thread(enemyTank).start();
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            new Thread(shot).start();
            enemyTanks.add(enemyTank);
        }
    }

    public static void hitTank(Shot s, EnemyTank enemyTank){
        switch (enemyTank.getDirect()){
            case 0:
            case 2:
                if(s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40
                && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60){
                    s.islive = false;
                    enemyTank.isLive = false;
                }
                break;
            case 1:
            case 3:
                if(s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60
                && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40){
                    s.islive = false;
                    enemyTank.isLive = false;
                }
                break;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        if(hero.vectorShot != null && hero.vectorShot.size() > 0){
            for (int i = 0; i < hero.vectorShot.size(); i++) {
                Shot shot = hero.vectorShot.get(i);
                if (shot != null && shot.islive != false) {
                    g.fill3DRect(shot.x, shot.y, 3, 3, false);
                }else if(shot.islive == false){
                    hero.vectorShot.remove(shot);
                }
            }
        }
        // 画出敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if(enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
                    if (shot.islive) {
                        g.draw3DRect(shot.x, shot.y, 2, 2, false);
                    } else {
                        enemyTank.shots.remove(shot);
                    }
                }
            }else{
                enemyTanks.remove(enemyTank);
            }
        }


    }

    /**
     *
     * @param x
     * @param y
     * @param g
     * @param direct
     * @param type
     */
    // 编写方法画坦克
    public void drawTank(int x, int y, Graphics g, int direct, int type){
        switch (type){
            case 0: //我们的坦克
                g.setColor(Color.yellow);
                break;
            case 1: //敌人的坦克
                g.setColor(Color.cyan);
                break;
        }

        // 根据坦克方向，来绘制坦克
        // 0 向上 1 向右 2向下 3向左
        // 为了监听 键盘时间，实现 KeyListener
        switch (direct){
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y, x + 20, y + 30);
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 60, y + 20, x + 30, y + 20);
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 60, x + 20, y + 30);
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x, y + 20, x + 30, y + 20);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            hero.setDirect(0);
            hero.moveUp();
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            hero.setDirect(1);
            hero.moveRight();
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            hero.setDirect(2);
            hero.moveDown();
        }else if(e.getKeyCode() == KeyEvent.VK_A){
            hero.setDirect(3);
            hero.moveLeft();
        }

        if(e.getKeyCode() == KeyEvent.VK_J){
            hero.shotEnemyTank();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(hero.vectorShot != null && hero.vectorShot.size() > 0) {
                for (int i = 0; i < hero.vectorShot.size(); i++) {
                    Shot shot = hero.vectorShot.get(i);
                    if(shot != null && shot.islive) {
                        for (int j = 0; j < enemyTanks.size(); j++) {
                            EnemyTank enemyTank = enemyTanks.get(j);
                            hitTank(shot, enemyTank);
                        }
                    }
                }
            }
            this.repaint();
        }
    }
}
