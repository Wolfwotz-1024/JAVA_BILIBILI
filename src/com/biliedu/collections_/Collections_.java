package com.biliedu.collections_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Collections_ {
    public static void main(String[] args) {
        // 创建ArrayList 集合用于测试
        ArrayList arrayList = new ArrayList();
        arrayList.add("tom");
        arrayList.add("smith");
        arrayList.add("king");
        arrayList.add("milan");
        System.out.println("arrayList = " + arrayList);

        Collections.reverse(arrayList);
        System.out.println("arrayList = " + arrayList);

        Collections.shuffle(arrayList);
        System.out.println("arrayList = " + arrayList);

        Collections.sort(arrayList);
        System.out.println("arrayList = " + arrayList);

        Collections.sort(arrayList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {

                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println("arrayList = " + arrayList);





    }
}
