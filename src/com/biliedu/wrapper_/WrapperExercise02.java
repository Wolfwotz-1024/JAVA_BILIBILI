package com.biliedu.wrapper_;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

public class WrapperExercise02 {
    public static void main(String[] args) {
        Integer i11 = 127;
        int i12 = 127;
        System.out.println(i11 == i12);

        Integer i13 = 128;
        int i14 = 128;
        System.out.println(i13 == i14);

        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2);

        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        System.out.println(i3 == i4);

        Integer i5 = 127;
        Integer i6 = 127;
        System.out.println(i5 == i6);

        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i7 == i8);

        Integer i9 = 127;
        Integer i10 = new Integer(127);
        System.out.println(i9 == i10);
    }
}
