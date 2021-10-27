package com.biliedu.map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExercise {
    public static void main(String[] args) {
        Employee emp1 = new Employee("111", "David", 8889);
        Employee emp2 = new Employee("222", "tom", 11111);
        Employee emp3 = new Employee("333", "jack", 22222);

        Map map = new HashMap();
        map.put(emp1.geteID(), emp1);
        map.put(emp2.geteID(), emp2);
        map.put(emp3.geteID(), emp3);

        // 遍历方式一：keySet方法
        System.out.println("----方式一遍历-----");
        Set set = map.keySet();
        Employee val = null; double sal;
        for (Object o : set) {
            val =(Employee) map.get(o);
            sal = val.getSalary();
            if(sal > 18000)
                System.out.println(o + " " + val);
        }

        // 遍历方式二：entrySet方法
        Set set1 = map.entrySet();
        Iterator iterator = set1.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            Object value = entry.getValue();
            Employee emp = (Employee) value;
            sal = emp.getSalary();
            if(sal > 18000){
                System.out.println(emp);
            }
        }
    }
}

class Employee{
    private String eID;
    private String name;
    private double salary;

    public Employee(String eID, String name, double salary) {
        this.eID = eID;
        this.name = name;
        this.salary = salary;
    }

    public String geteID() {
        return eID;
    }

    public void seteID(String eID) {
        this.eID = eID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eID='" + eID + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}