package com.h2kinfosys.com;

import java.util.ArrayList;



import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SyllabusOne extends Activity{
	private LinearLayout layoutSession1,layoutSession2,layoutSession3 = null;
	private ArrayList<String> listSession1 = null;
	private ArrayList<String> listSession2 = null;
	private ArrayList<String> listSession3 = null;
	private ArrayList<String> listSession4 = null;
	private ArrayList<String> listSession5 = null;
	private ArrayList<String> listSession6 = null;
	private ArrayList<String> listSession7 = null;
	private ArrayList<String> listSession8 = null;
	private ArrayList<String> listSession9 = null;
	private ArrayList<String> listSession10 = null;
	private ArrayList<String> listSession11 = null;
	private ArrayList<String> listSession12 = null;
	private ArrayList<String> listSession13 = null;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		listSession1 = (ArrayList<String>)getIntent().getExtras().get("session1");
		listSession2 = (ArrayList<String>)getIntent().getExtras().get("session2");
		listSession3 = (ArrayList<String>)getIntent().getExtras().get("session3");
		listSession4 = (ArrayList<String>)getIntent().getExtras().get("session4");
		listSession5 = (ArrayList<String>)getIntent().getExtras().get("session5");
		listSession6 = (ArrayList<String>)getIntent().getExtras().get("session6");
		
		setContentView(R.layout.syllabus_one);
		init();
		
	}
	public void init()
	{
		layoutSession1 = (LinearLayout)findViewById(R.id.layout_session1);
		layoutSession2 = (LinearLayout)findViewById(R.id.layout_session2);
		layoutSession3 = (LinearLayout)findViewById(R.id.layout_session3);
		LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		TextView tv = null;
		for(int i =0; i!= listSession1.size();i++)
		{
			tv = new TextView(SyllabusOne.this);
			tv.setLayoutParams(lparams);
			tv.setText(listSession1.get(i));
			layoutSession1.addView(tv);
			
			tv = null;
			
		}
		for(int i =0; i!= listSession2.size();i++)
		{
			tv = new TextView(SyllabusOne.this);
			tv.setLayoutParams(lparams);
			tv.setText(listSession2.get(i));
			layoutSession2.addView(tv);
			
			tv = null;
			
		}
		for(int i =0; i!= listSession3.size();i++)
		{
			tv = new TextView(SyllabusOne.this);
			tv.setLayoutParams(lparams);
			tv.setText(listSession3.get(i));
			layoutSession3.addView(tv);
			
			tv = null;
			
		}
	}

}
