package com.biliedu.set_;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetSource {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        System.out.println("set=" + hashSet);

        //        Set 的 iterator方法
        Iterator iterator = hashSet.iterator();
    }
}
