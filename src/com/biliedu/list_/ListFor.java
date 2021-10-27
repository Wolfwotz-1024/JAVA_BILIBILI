package com.biliedu.list_;

import java.util.*;

public class ListFor {
    public static void main(String[] args) {
//        List list = new ArrayList();
//        List list = new Vector();
        List list = new LinkedList();
        list.add("jack");
        list.add("tom");
        list.add("鱼香肉丝");
        list.add("北京烤鸭");


        // 遍历
        // 1。迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // 2. 增强For
        for (Object o : list) {
            System.out.println(o);
        }

        // 3.普通for
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
