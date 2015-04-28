package com.suping.listfragmentdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * 
 * ListFragment
 * 		根视图含2个子视图
 * 			TextView id必须为list （@android:id/list）
 * 			任意控件 id必须为empty （@android:id/empty）
 * 
 * DialogFragment
 * 		dismiss()
 * 		setStyle(int style , int theme)
 * 		show(FragmentManager m , String tag)
 * 
 * @author Administrator
 *
 */
public class Main extends Activity {
	private  FragmentManager manager;
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn = (Button) findViewById(R.id.btn);
		Button btn2 = (Button) findViewById(R.id.btn2);
		Button close = (Button) findViewById(R.id.close);
		manager = getFragmentManager();
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				DialogFragmentDemo dialog = new DialogFragmentDemo(DialogFragment.STYLE_NORMAL
						, android.R.style.Theme_Holo_Light_Dialog);
				dialog.show(manager, "di");				
			}
		});
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DialogFragmentDemo2 dialog = new DialogFragmentDemo2();
				dialog.show(manager, "dii");				
			}
		});
		close.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DialogFragmentDemo2 f = (DialogFragmentDemo2) manager.findFragmentByTag("dii");
				if(f!=null){
					manager.beginTransaction().remove(f);
				}
				manager.beginTransaction().commit();
			}
		});
	}
}
