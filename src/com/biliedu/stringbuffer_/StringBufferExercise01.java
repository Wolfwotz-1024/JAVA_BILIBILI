package com.biliedu.stringbuffer_;

public class StringBufferExercise01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());//4?

        System.out.println(sb);// null
        StringBuffer sb1 = new StringBuffer(str); // Error
        System.out.println(sb1);
    }
}
