package com.biliedu.reflection_;

/**
 * @Author SHKing
 * @Date 2021/10/31 12:38
 * @Version 1.0
 */

public class Cat {
    private String name;
    private String color;

    public Cat() {
    }

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void hi(){
        System.out.println("hello， I am a cat!");
    }
}
