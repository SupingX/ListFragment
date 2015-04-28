package com.suping.listfragmentdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class DialogFragmentDemo extends DialogFragment {
	private int style;
	private int theme;
	public DialogFragmentDemo (int style,int theme){
		this.style = style;
		this.theme = theme;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		setStyle(style, theme);
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.dialog_fragment, container,false);
		ImageView img = (ImageView) view.findViewById(R.id.img);
		img.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dismiss();
			}
		});
		return view;
	}
	

	
}
