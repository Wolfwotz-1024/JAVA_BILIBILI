package com.biliedu.set_;

import java.util.LinkedHashSet;
import java.util.Objects;

public class LinkedHashSet02 {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new B("Jack"));
        linkedHashSet.add(new B("John"));
    }
}

class B{
    private String name;

    public B(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        B b = (B) o;
        return Objects.equals(name, b.name);
    }

    @Override
    public int hashCode() {
        return 110;
    }
}