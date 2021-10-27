package com.biliedu.col_map_;

import java.util.HashSet;
import java.util.Objects;

public class Homework04 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        Person1 p1 = new Person1(1001, "AA");
        Person1 p2 = new Person1(1002, "BB");
        set.add(p1);
        set.add(p2);
        p1.setName("CC");
        set.remove(p1);
        System.out.println(set); // p2
        set.add(new Person1(1001, "CC"));
        System.out.println(set);// p2, new p
        set.add(new Person1(1001, "AA"));
        System.out.println(set);// p2, new p, new p

    }
}

class Person1{
    private int ID;
    private String name;

    public Person1(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

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
        Person1 person1 = (Person1) o;
        return ID == person1.ID && Objects.equals(name, person1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name);
    }

    @Override
    public String toString() {
        return "Person1{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }
}