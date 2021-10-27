package com.biliedu.tankgame;

import java.util.Vector;

public class Hero extends Tank{
    // 申请一个子弹集合
    Vector<Shot> vectorShot = new Vector<>();
    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotEnemyTank(){
        Shot shot = null;
         switch (getDirect()){
             case 0:
                 shot = new Shot(getX() + 20, getY(), 0);
                 break;
             case 1:
                 shot = new Shot(getX() + 60, getY() + 20, 1);
                 break;
             case 2:
                 shot = new Shot(getX() + 20, getY() + 60, 2);
                 break;
             case 3:
                 shot = new Shot(getX(), getY() + 20, 3);
                 break;
         }
         vectorShot.add(shot);
         Thread thread = new Thread(shot);
         thread.start();
    }


}
