package com.biliedu.map_;

import java.io.ObjectStreamException;
import java.util.*;

public class MapFor {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("邓超", "杨笠");
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("荣立", "马蓉");
        map.put("刘", null);
        map.put(null, "杨笠");
        map.put("鹿晗","关晓彤");

        // 第一组
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        Object next = null;
        Object val = null;
        while (iterator.hasNext()){
            next = iterator.next();
            val = map.get(next);
            System.out.println(next+ " - " + val);
        }

        for (Object o : set) {
            System.out.println(o + "->" + map.get(o));
        }
//        HashMap
        // 第二组：把所有的value取出
        Collection values = map.values();
        System.out.println(values.getClass());
        // 有两种方式


        // 第三组：使用EntrySet方法
        System.out.println("----第三组第一种方法----");
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        Object next1, key, value; Map.Entry entry;
        while (iterator1.hasNext()){
            next1 = iterator1.next();
            entry = (Map.Entry) next1;
            key = entry.getKey();
            value = entry.getValue();
            System.out.println(key + " -- " + value);
        }

        System.out.println("----第三组第二种方法----");
        for (Object o : set1) {
            entry = (Map.Entry) o;
            System.out.println(entry.getKey() + " --- " + entry.getValue());
        }

//        Hashtable
    }
}
