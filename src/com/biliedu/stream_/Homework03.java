package com.biliedu.stream_;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

public class Homework03 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("name", "tom");
        properties.setProperty("age", "5");
        properties.setProperty("color", "red");
        String filePath = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/stream_/dog.properties";
        properties.store(new FileWriter(filePath), null);
    }

    @Test
    public void test() throws IOException {
        Properties properties = new Properties();
        String filePath = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/stream_/dog.properties";
        properties.load(new FileReader(filePath));
        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        String color = properties.getProperty("color");

        Dog dog = new Dog(name, Integer.parseInt(age), color);
        System.out.println(dog.toString());


        String dat = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/stream_/dog.dat";
        File file2 = new File(dat);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file2));
        objectOutputStream.writeObject(dog);
        objectOutputStream.writeObject(new Dog("mark", 3, "black"));
        objectOutputStream.writeObject(null);
        objectOutputStream.close();
    }

    @Test
    public void test2() throws IOException, ClassNotFoundException {
        String dat = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/stream_/dog.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dat));
//        Object o = ois.readObject();
//        Dog dog = (Dog) o;
//        System.out.println(dog);
        Object oo = null;
        while ((oo = ois.readObject()) != null) {
            System.out.println(oo);
        }
        ois.close();
    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}