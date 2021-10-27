package com.biliedu.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/file/data.dat";

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));

        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readBoolean());
        System.out.println(objectInputStream.readChar());
        System.out.println(objectInputStream.readDouble());
        System.out.println(objectInputStream.readUTF());
        System.out.println(objectInputStream.readObject());

        objectInputStream.close();
    }
}
