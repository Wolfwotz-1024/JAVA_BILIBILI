package com.biliedu.set_;

import java.util.HashSet;
import java.util.Objects;

public class HashSetIncrement {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
//        for (int i = 0; i < 100; i++) {
//            hashSet.add(i);
//        }

        for (int i = 1; i < 9; i++) {
            hashSet.add(new A(i, 100));
        }

        for (int i = 1; i < 9; i++) {
            hashSet.add(new A(i, 200));
        }
        System.out.println("set=" + hashSet);
    }
}

class A{
    private int n;
    private int hsc;

    public A(int n, int hsc){
        this.n = n;
        this.hsc = hsc;
    }

    @Override
    public int hashCode() {
        return hsc;
    }
}