package com.biliedu.set_;

import java.util.ArrayList;
import java.util.Vector;

public class LogicAnd {
    public static void main(String[] args) {
        System.out.println(15 & 3254803);
        int i = 3;
        System.out.println((1 == 2) & (i++ == 3));//F
        System.out.println(i);//4
        System.out.println((1 == 1) && (i++ == 4));//T
        System.out.println(i);//5

//        ArrayList
//        Vector
    }
}
