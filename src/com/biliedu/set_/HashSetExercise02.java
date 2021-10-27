package com.biliedu.set_;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExercise02 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee01("tom", 14, new MyDate(2020, 12, 12)));
        hashSet.add(new Employee01("tom", 14, new MyDate(2020, 12, 12)));

        System.out.println("set=" + hashSet);
    }
}

class Employee01{
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee01(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee01 that = (Employee01) o;
        return Objects.equals(name, that.name) && Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Employee01{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday.toString() +
                '}';
    }
}

class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}