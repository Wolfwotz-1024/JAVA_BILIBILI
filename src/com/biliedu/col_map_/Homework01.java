package com.biliedu.col_map_;

import java.util.ArrayList;
import java.util.Collections;

public class Homework01 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new News("新冠确诊病例超千万，数百万印度教信徒赴恒河引起民众担忧"));
        arrayList.add(new News("男子突然想起2个月前的🌧️还在往兜里，捞起一看放生"));
        Collections.reverse(arrayList);
        String str = null;
        for (Object o : arrayList) {
            str = ((News) o).getTitle();
            if(str.length() > 15){
                System.out.println(str.substring(0, 15) + "...");
            }
        }

    }
}

class News{
    private String title;
    private String body;

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }
}