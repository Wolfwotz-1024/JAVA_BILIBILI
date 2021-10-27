package com.biliedu.map_;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMap01 {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });

        treeMap.put("tgb", "huawei");
        treeMap.put("abc", "tencent");

        System.out.println("treeMap = " + treeMap);
//        TreeSet treeSet = new TreeSet();
    }
}
