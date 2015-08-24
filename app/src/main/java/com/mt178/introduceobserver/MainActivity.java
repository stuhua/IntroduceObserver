package com.mt178.introduceobserver;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    private Button add;
    private MyPerson observable;
    private int i = 1;
    private Button change;
    private ListView lv;
    private List<MyObserver> myObservers;

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            // 将信息加入list中显示
            MyListAdapter myListAdapter = new MyListAdapter(MainActivity.this, myObservers);
            lv.setAdapter(myListAdapter);
            return false;
        }
    });

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.add);
        observable = new MyPerson();
        myObservers = new ArrayList<MyObserver>();
        lv = getListView();
        //添加观察者
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MyObserver myObserver = new MyObserver(i);
                i++;
                observable.addObserver(myObserver);//为被观察者添加观察者的
                myObservers.add(myObserver);
                handler.sendEmptyMessage(0);
            }
        });
        change = (Button) findViewById(R.id.change);
        //通知数据改变
        change.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                observable.setAge(10 + i);
                observable.setName("a" + i);
                observable.setSex("男" + i);
                handler.sendEmptyMessage(0);
            }
        });
    }


}
