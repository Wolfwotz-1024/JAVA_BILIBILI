package com.biliedu.reflection_.question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Author SHKing
 * @Date 2021/10/31 12:37
 * @Version 1.0
 */

public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 使用 Properties 类，读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream(
                "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/" +
                        "com/biliedu/reflection_/re." +
                        "properties"));
        String classfullpath = properties.getProperty("classfullpath");
        String method = properties.getProperty("method");
        System.out.println("classfullpath = " + classfullpath);
        System.out.println("method = " + method);

        // 使用反射机制解决
        Class<?> aClass = Class.forName(classfullpath);

        Object o = aClass.newInstance();
        System.out.println("o的运行类型 = " + o.getClass());
        Method method1 = aClass.getMethod(method);
        System.out.println("================");
        method1.invoke(o);
    }
}
