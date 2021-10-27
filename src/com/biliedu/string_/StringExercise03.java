package com.biliedu.string_;

public class StringExercise03 {
    public static void main(String[] args) {
        String a = "hello";
        String b = "abc";

        String c = a + b;
        String d = "helloabc";

        System.out.println(c == d);
        System.out.println(c.intern() == d);
        System.out.println(c.intern());
    }
}
