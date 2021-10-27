package com.biliedu.list_;

import java.util.*;

public class ListExercise01 {
    public static void main(String[] args) {
//        List list = new ArrayList();
//        List list = new LinkedList();
        List list = new Vector();

        list.add(new Book("红楼梦", "曹雪芹", 100));
        list.add(new Book("西游记", "吴承恩", 10));
        list.add(new Book("水浒传", "施耐庵", 9));
        list.add(new Book("三国", "罗贯中", 30));
        list.add(new Book("西游记", "吴承恩", 109));

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("===排序之后的结果===");
        Object[] objects = list.toArray();
        sortByPrice(objects);
        Iterator<Object> iterator1 = Arrays.stream(objects).iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }

    public static void sortByPrice(Object[] obj){
//        Object[] objects = list.toArray();
        Arrays.sort(obj, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                if(b1.getPrice() - b2.getPrice() > 0)  {
                    return 1;
                }else if(b1.getPrice() - b2.getPrice() < 0) {
                    return -1;
                }else return 0;
            }
        });
        };
}

class Book{
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "名称：" + name + "\t\t" +
                "价格：" + price + "\t" +
                "作者：" + author;
    }
}