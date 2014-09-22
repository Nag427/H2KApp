package com.h2kinfosys.com;

import java.util.ArrayList;



import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CoursesHighlights extends Activity{
	private LinearLayout linearLayout = null;
	private ArrayList<String> module = null;
	private ArrayList<String> moduleContent = null;
	private TextView tvHeading = null;
	private String name = null;
	LayoutParams lparams = null;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		module = (ArrayList<String>)(getIntent().getExtras()).get("courseHighlightsGp");
		
		name = (String)(getIntent().getExtras()).get("name");
		moduleContent = (ArrayList<String>)(getIntent().getExtras()).get("courseContentGp");
		setContentView(R.layout.courses_highlights);
		init();
		
		linearLayout = (LinearLayout)findViewById(R.id.layoutCourses);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		for(int i =0;i != module.size();i++)
		{
			TextView tvModule = new TextView(CoursesHighlights.this);
			TextView tvContent = new TextView(CoursesHighlights.this);
			tvModule.setText(module.get(i));
			tvModule.setLayoutParams(layoutParams);
			tvModule.setTextSize(15);
			tvModule.setTextColor(Color.BLACK);
			tvModule.setTypeface(null, Typeface.BOLD);
			linearLayout.addView(tvModule);
			
			
			
				tvContent.setText(moduleContent.get(i));
			
			tvContent.setLayoutParams(layoutParams);
			tvContent.setTextColor(Color.BLACK);
			linearLayout.addView(tvContent);
			
		}
	}
	
	public void init()
	{
		tvHeading = (TextView)findViewById(R.id.tvHeading);
		tvHeading.setText(name+" Highlights");
		findViewById(R.id.ivBack).setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				finish();
			}
			});

			findViewById(R.id.ivHome).setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				Intent intent = new Intent(CoursesHighlights.this,H2kinfosys.class);
				startActivity(intent);
			}
			});

	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		System.gc();
		
	}
}
