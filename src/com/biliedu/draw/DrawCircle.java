package com.biliedu.draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame {
    public static void main(String[] args) {
        new DrawCircle();
    }

    private MyPanel mp = null;
    public DrawCircle(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

// 在java中画一个园

//先定一个一个MyPanel，继承Jpanel类
class MyPanel extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        g.drawOval(10, 10,  100, 100);

        Image image = Toolkit.getDefaultToolkit().getImage("ByteDance.png");
        g.drawImage(image, 10, 10, 200, 100, this);
    }
}