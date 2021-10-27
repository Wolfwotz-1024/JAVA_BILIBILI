package com.biliedu.generic_;

import java.util.*;

public class GenericExercise {
    public static void main(String[] args) {
        //1 HashSet
        HashSet<Student> set = new HashSet<>();
        set.add(new Student("john", 12));
//        set.add(100);
        Iterator<Student> iterator = set.iterator();
        while(iterator.hasNext()){
            Student next = iterator.next();
            System.out.println(next);
        }

        //2 HashMap
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("john", new Student("john", 12));
        Set<Map.Entry<String, Object>> entries = hashMap.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }
}

class Student{
    private String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}