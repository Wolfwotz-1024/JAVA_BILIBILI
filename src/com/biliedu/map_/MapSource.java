package com.biliedu.map_;

import java.util.*;

public class MapSource {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1", "David");
        map.put("no2", "tom");

        /**
         * 1、这里的entrySet() 方法返回一个 set 集合, 这个set是Set<Map.Entry<K,V>>
         * 这里的set里面放的是MapEntry<K, V>类型的对象
         *
         * 2、注意，这里的Map.Entry 是一个接口而已，但是实际上是需要存放一个实现类，在HashMap
         * 中存放的是 HashMap$Node，也就是说Node类实现了接口Map.Entry
         */

        Set set = map.entrySet();
        System.out.println(set.getClass());

        for (Object obj : set) {
//            System.out.println(obj.getClass());
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        Set set1 = map.keySet();
        System.out.println(set1.getClass());
        Collection values = map.values();
        System.out.println(values.getClass());
    }
}
