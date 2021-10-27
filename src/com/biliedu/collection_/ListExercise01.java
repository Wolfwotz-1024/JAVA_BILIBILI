package com.biliedu.collection_;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListExercise01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("红楼梦", "曹雪芹", 100));
        list.add(new Book("西游记", "吴承恩", 10));
        list.add(new Book("水浒传", "施耐庵", 9));
        list.add(new Book("三国演义", "罗贯中", 80));
        list.add(new Book("西游记", "吴承恩", 10));

        System.out.println("====排序前====");
        System.out.println(list);
        System.out.println("====排序后====");
        sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                if(b1.getPrice() - b2.getPrice() > 0){
                    return 1;
                }else if(b1.getPrice() - b2.getPrice() < 0){
                    return -1;
                }else return 0;
            }
        });
        System.out.println(list);

    }

    public static void sort(List list, Comparator c){
        Object temp = null;
        for(int i = 0; i < list.size() - 1; i++){
            for(int j = 0; j < list.size() - i - 1; j++){
//                if(c.compareTo(((Book) list.get(j)).getPrice(), ((Book) list.get(j + 1)).getPrice()) > 0) {
                if(c.compare(list.get(j), list.get(j + 1)) > 0){
                    temp = list.get(j);
                    list.set(j, list.get(j + 1));
                      list.set(j + 1, temp);
                }
            }
        }
    }
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}