package com.biliedu.stringbuilder_;

public class StringBuilder01 {
    public static void main(String[] args) {
        String text = "";
        long startTime = 0L;
        long endTime = 0L;

        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 80000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));

        for (int i = 0; i < 80000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));


        for (int i = 0; i < 80000; i++) {
            text += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));

    }
}
