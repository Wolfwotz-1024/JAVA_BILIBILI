package com.biliedu.set_;

public class HashSetStructure {
    public static void main(String[] args) {
        // 模拟一个HashSet的底层（HashMap的底层）
        Node[] table = new Node[16];
        System.out.println("table=" + table);

        Node john = new Node("john", null);
        table[2] = john;
        Node jack = new Node("jack", null);
        john.next = jack;
        Node rose = new Node("Rose", null);
        jack.next = rose;

        Node lucy = new Node("lucy", null);
        table[3] = lucy;
        System.out.println("table=" + table);

    }
}

class Node{// 节点，存放数据
    Object item;
    Node next;

    public Node(Object item) {
        this.item = item;
    }

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}