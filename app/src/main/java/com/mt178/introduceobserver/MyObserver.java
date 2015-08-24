package com.mt178.introduceobserver;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2015/8/24.
 */
public class MyObserver implements Observer {
    private int num;
    private MyPerson mPerson;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setmPerson(MyPerson mPerson) {
        this.mPerson = mPerson;
    }

    MyObserver(int num) {
        this.num = num;
    }


    @Override
    public void update(Observable observable, Object data) {
        System.out.println("观察者---->" + num + "得到更新！");
        this.mPerson = (MyPerson) observable;
        System.out.println(((MyPerson) observable).toString());
    }

    public MyPerson getmPerson() {
        return mPerson;
    }
}
