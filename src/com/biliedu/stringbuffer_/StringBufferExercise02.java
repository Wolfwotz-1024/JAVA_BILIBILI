package com.biliedu.stringbuffer_;

import java.util.Scanner;

public class StringBufferExercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String price = scanner.next();

        StringBuffer sb = new StringBuffer(price);
        for (int i = sb.lastIndexOf(".") - 3; i > 0 ; i -= 3) {
            sb = sb.insert(i, ",");
        }

        System.out.println(sb);
    }
}
