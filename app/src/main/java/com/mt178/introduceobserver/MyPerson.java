package com.mt178.introduceobserver;

import java.util.Observable;

/**
 * Created by Administrator on 2015/8/24.
 */
public class MyPerson extends Observable {
    private String name;
    private int age;
    private String sex;


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        setChanged(); //告知数据改变
        notifyObservers();//发送信号通知观察者
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        setChanged();
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "MyPerson [age=" + age + ", name=" + name + ", sex=" + sex + "]";
    }
}
