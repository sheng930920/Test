package com.example.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Tab4 extends Fragment {

	private View myview;
	private ListView lv;

	public List<Person> mylist;
	Myadapter myadapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		myview = inflater.inflate(R.layout.tab4, container, false);
		data();
		return myview;
	}

	public void data() {
		lv = (ListView) myview.findViewById(R.id.lv);
		mylist = new ArrayList<Person>();
		for (int i = 1; i < 100; i++) {
			mylist.add(new Person("张三" + i, "广州" + i));
		}
		myadapter = new Myadapter(mylist);
		lv.setAdapter(myadapter);
	}

	public class Myadapter extends BaseAdapter {

		List<Person> list;

		public Myadapter(List<Person> mylist) {
			this.list = mylist;
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int arg0) {
			return list.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			LayoutInflater myInflater = LayoutInflater.from(getActivity());
			View temp = myInflater.inflate(R.layout.style1, null);
			TextView name = (TextView) temp.findViewById(R.id.tv1);
			TextView address = (TextView) temp.findViewById(R.id.tv2);
			name.setText(list.get(arg0).name);
			address.setText(list.get(arg0).address);
			return temp;
		}

	}

}
