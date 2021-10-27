package com.biliedu.customGeneric;

public class CustomInterfaceGeneric {
    public static void main(String[] args) {

    }
}

class AA<K, T, V> implements IA<K, T, V>{


    @Override
    public K get(T t) {
        return null;
    }

    @Override
    public void set(V v) {

    }
}

interface IA<K, T, V> extends IUsb<K, T, V>{

}

interface IUsb<K, T, V>{
//    public  static final U name;
    K get(T t);
    void set(V v);
}