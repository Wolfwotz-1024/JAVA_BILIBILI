package com.biliedu.reflection_.homework;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author SHKing
 * @Date 2021/10/31 16:33
 * @Version 1.0
 */

public class Homework01 {
    @Test
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.biliedu.reflection_.homework.PrivateTest");

        Object o = aClass.newInstance();
        Field name = aClass.getDeclaredField("name");

        name.setAccessible(true);
        name.set(o, "david");
        System.out.println(aClass.getMethod("getName").invoke(o));

    }

}

class PrivateTest{
    private String name = "hellokitty";

    public String getName(){
        return name;
    }
}