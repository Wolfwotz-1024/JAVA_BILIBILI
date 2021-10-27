package com.biliedu.stringbuffer_;

public class StringBufferMethod {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("hello");
        s.append(",");
        s.append("张三丰");
        System.out.println(s);

        s.delete(0,5);
        System.out.println(s);

        s.replace(0, 1, "周子若");
        System.out.println(s);
    }
}
