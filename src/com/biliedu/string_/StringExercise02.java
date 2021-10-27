package com.biliedu.string_;

import java.util.Objects;

public class StringExercise02 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "hspedu";
        Person p2 = new Person();
        p2.name = "hspedu";

        System.out.println(p1.name.equals(p2.name));
        System.out.println(p1.name == p2.name);
        System.out.println(p1.name == "hspedu");

        String s1 = new String("bcde");
        String s2 = new String("bcde");
        System.out.println(s1 == s2);
    }
}

class Person{
    public String name;

//    public Person(String name) {
//        this.name = name;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}