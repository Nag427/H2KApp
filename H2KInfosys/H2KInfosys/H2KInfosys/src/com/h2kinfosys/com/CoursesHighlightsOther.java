package com.h2kinfosys.com;

import java.util.ArrayList;



import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class CoursesHighlightsOther extends Activity{

	private TextView tvTitle = null;
	private ArrayList<String> courseTitle = null;
	private ArrayList<String> courseContent = null;
	private LinearLayout linearLayout = null;
	private TextView tvHeading = null;
	private String name = null;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.courses_highlights_other);
		courseTitle = (ArrayList)getIntent().getExtras().get("courseHighlightsGp");
		name = (String)getIntent().getExtras().get("name");
		courseContent = (ArrayList)getIntent().getExtras().get("courseContentGp");
		linearLayout = (LinearLayout)findViewById(R.id.layoutCourseOther);
		init();
	}
	public void init()
	{

		tvHeading = (TextView)findViewById(R.id.tvHeading);
		tvHeading.setText(name+" Highlights");
		

		((ImageView)findViewById(R.id.ivBack)).setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				CoursesHighlightsOther.this.finish();
			}
			
		});
		

		((ImageView)findViewById(R.id.ivHome)).setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				Intent intent = new Intent(CoursesHighlightsOther.this,H2kinfosys.class);
				startActivity(intent);
			}
			
		});
		
		
		TextView tvContent = null;
		tvTitle = (TextView)findViewById(R.id.tvTitle);
		tvTitle.setText(courseTitle.get(0));
		for(int i =0;i !=courseContent.size();i++)
		{
			tvContent = new TextView(CoursesHighlightsOther.this);
			LinearLayout.LayoutParams lparams  = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT
					,LayoutParams.WRAP_CONTENT);
			tvContent.setLayoutParams(lparams);
			
			tvContent.setText(courseContent.get(i));
			tvContent.setTextColor(Color.BLACK);
			linearLayout.addView(tvContent);
			
			tvContent = null;
			
		}
	}
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		System.gc();
		
	}
}
