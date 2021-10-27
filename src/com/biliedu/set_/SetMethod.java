package com.biliedu.set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMethod {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("john");
        set.add("lucy");
        set.add("john");
        set.add("jack");
        set.add("hsp");
        set.add("mary");
        set.add(null);
        System.out.println("set=" + set);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }

        for (Object o : set) {
            System.out.println(o);
        }
    }
}
