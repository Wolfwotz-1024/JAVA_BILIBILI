package com.biliedu.set_;

import java.util.LinkedHashSet;

public class LinkedHashSetSource {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new String("123"));
        linkedHashSet.add(345);
        linkedHashSet.add(456);
        System.out.println("set=" + linkedHashSet);
    }
}
