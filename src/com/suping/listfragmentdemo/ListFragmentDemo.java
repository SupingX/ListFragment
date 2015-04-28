package com.suping.listfragmentdemo;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class ListFragmentDemo extends ListFragment {
	private String [] data = new String []{
		"Nevermore"
			,"SilWans"
			,"Media"
			,"TIny"
			,"Zues"
			,"Suping"
			
	};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		
		return 	inflater.inflate(R.layout.list_fragment, null);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		//如果数据为空 则会显示第2个子视图，这里是一张图片
		ArrayAdapter<String> adapter = new ArrayAdapter<>(
				getActivity()
				, android.R.layout.simple_list_item_activated_1
				,data);
		setListAdapter(adapter);
		super.onCreate(savedInstanceState);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		//下面的代码不能放在oncreate里，因为那个时候Activity还没创建，还没有视图，会报错
		getListView().setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getActivity(), "u want to be ..."+data[position], 0).show();
			}
		});
		super.onActivityCreated(savedInstanceState);
	}
}
