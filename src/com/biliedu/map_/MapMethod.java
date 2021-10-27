package com.biliedu.map_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MapMethod {
    public static void main(String[] args) {
        // 演示map的常用方法

        Map map = new HashMap();
        map.put("邓超", "杨笠");
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("荣立", "马蓉");
        map.put("刘", null);
        map.put(null, "杨笠");
        map.put("鹿晗","关晓彤");

        System.out.println("map=" + map);

        map.remove(null);
        System.out.println("map=" + map);

        Object val = map.get("鹿晗");
        System.out.println(val);

        System.out.println(map.size());

        System.out.println(map.isEmpty());

        map.clear();
        System.out.println(map);

        System.out.println(map.containsKey("hsp"));
    }
}
