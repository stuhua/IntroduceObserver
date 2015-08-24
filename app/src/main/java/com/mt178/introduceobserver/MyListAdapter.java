package com.mt178.introduceobserver;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyListAdapter extends BaseAdapter {

	private Context mContext;
	private List<MyObserver> myObservers;

	public MyListAdapter(Context context, List<MyObserver> myObservers) {
		this.mContext = context;
		this.myObservers = myObservers;
	}

	@Override
	public int getCount() {
		return myObservers.size();
	}

	@Override
	public Object getItem(int position) {
		return myObservers.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView tv = new TextView(mContext);
		tv.setTextSize(15);
		String personContent = "内容还没添加";
		if (myObservers.get(position).getmPerson() != null) {
			personContent = myObservers.get(position).getmPerson().toString();
		}
		tv.setText("观察者ID：------>" + myObservers.get(position).getNum() + "\n"
				+ "观察内容：" + personContent);
		return tv;
	}

}
