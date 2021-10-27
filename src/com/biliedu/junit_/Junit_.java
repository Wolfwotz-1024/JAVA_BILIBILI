package com.biliedu.junit_;

import org.junit.jupiter.api.Test;

public class Junit_ {
    public static void main(String[] args) {

    }

    @Test
    public void m1(){
        System.out.println("m1 方法被调用");
    }

    @Test
    public void m2(){
        System.out.println("m2 方法被调用");
    }

    @Test
    public void m3(int a){
        System.out.println(a + "a");
    }
}
