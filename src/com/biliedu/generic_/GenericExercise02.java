package com.biliedu.generic_;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericExercise02 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("jack", 23000, new MyDate(12, 12, 2000)));
        employees.add(new Employee("tom", 18888, new MyDate(10, 11, 2001)));
        employees.add(new Employee("jack", 66666, new MyDate(10, 14, 1998)));

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int res = o1.getName().compareTo(o2.getName());
                if(res != 0)
                    return res;
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });

        System.out.println("employ = " + employees);
    }
}

class Employee{
    private String name;
    private double sal;
    private MyDate birthday;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }
}

class MyDate implements Comparable{
    private int month;
    private int day;
    private int year;

    public MyDate(int month, int day, int year)  {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int compareTo(Object o) {
        MyDate date = (MyDate) o;
        return year - date.year == 0?(month - date.month == 0?(day - date.day):(month - date.month)):(year - date.year);
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }
}