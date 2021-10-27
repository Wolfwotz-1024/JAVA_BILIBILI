package com.biliedu.col_map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Homework02 {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("jack", new Integer(650));
        m.put("tom", 1200);
        m.put("smith", 2900);

        // 显示所有员工工资
        System.out.println(m);

        // 将Jack的工资改为2600
        m.put("jack", 2600);

        // 为所有工资加100
        // 方式一
        Set set = m.keySet();
        Iterator iterator = set.iterator();
        for (Object o : set) {
            int val = (Integer) m.get(o);
            m.put(o, val + 100);
            System.out.println(o + " --> " + m.get(o));
        }
    }
}