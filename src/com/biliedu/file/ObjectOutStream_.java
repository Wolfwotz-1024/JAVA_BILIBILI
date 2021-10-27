package com.biliedu.file;

import java.io.*;

public class ObjectOutStream_ {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/file/data.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        oos.writeInt(100);
        oos.writeBoolean(true);
        oos.writeChar('a');
        oos.writeDouble(9.5);
        oos.writeUTF("java");

        oos.writeObject(new Dog("旺财", 10));

        oos.close();
        System.out.println("数据保存完毕！");


    }
}

class Dog implements Serializable {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}