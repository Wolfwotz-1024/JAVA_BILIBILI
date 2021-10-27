package com.biliedu.stringbuffer_;

public class StringBuffer02 {
    public static void main(String[] args) {
        // String --> StringBuffer
        String str = "hello";
        StringBuffer stringBuffer = new StringBuffer(str);

        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1.append(str);

        // StringBuffer --> String
        StringBuffer macbookpro = new StringBuffer("macbookpro");
        String s = macbookpro.toString();
        String s1 = new String(macbookpro);
    }
}
