package com.biliedu.set_;

import java.util.HashSet;

public class HashSet01 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        System.out.println(hashSet.add("john"));
        System.out.println(hashSet.add("lucy"));
        System.out.println(hashSet.add("john"));
        System.out.println(hashSet.add("jack"));
        System.out.println(hashSet.add("Rose"));

        hashSet.remove("john");
        System.out.println("hashset=" + hashSet);

        System.out.println("========");
        hashSet = new HashSet();
        hashSet.add("lucy");
        hashSet.add("lucy");
        hashSet.add(new Dog("tom"));
        hashSet.add(new Dog("tom"));
        System.out.println("hashset=" + hashSet);

        hashSet.add(new String("hsp"));
        hashSet.add(new String("hsp"));
        System.out.println("hashset=" + hashSet);
    }
}

class Dog{
    String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
