package com.h2kinfosys.com;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.h2kinfosys.ui.ContactForm;

public class H2kinfosys extends Activity {
	private ImageView ivItJobs,ivBlogs,ivForums,ivTesting,ivSeo,ivContactForm,ivVideos,ivTrainingCourses = null;
	private Button ivOnlineTraining = null;
	private Intent intent = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.home);
        viewInitialization();
        addListeners();
    }

   
    public void viewInitialization()
    {
    	ivOnlineTraining = (Button)findViewById(R.id.imageOnlineTraining);
    	ivItJobs = (ImageView)findViewById(R.id.imageItJobs);
    	ivBlogs =(ImageView) findViewById(R.id.imageBlogs);
    	ivForums = (ImageView)findViewById(R.id.imageForums);
    	ivTrainingCourses = (ImageView)findViewById(R.id.imageTrainingCourses);
    	ivVideos = (ImageView)findViewById(R.id.imageVideos);
    	ivTesting = (ImageView)findViewById(R.id.imageTesting);
    	ivSeo = (ImageView)findViewById(R.id.imageSeo);
    	ivContactForm = (ImageView)findViewById(R.id.imageContactForm);
    }
    public void addListeners()
    {
    	ivOnlineTraining.setOnClickListener(new OnClickListener(){
    		public void onClick(View view)
    		{
    			intent = new Intent(H2kinfosys.this,OnlineTrainingActivity.class);
    			startActivity(intent);
    		}
    	});
    	ivTrainingCourses.setOnClickListener(new OnClickListener(){
    		public void onClick(View view)
    		{
    			intent = new Intent(H2kinfosys.this,CoursesActivity.class);
    			startActivity(intent);
    		}
    		
    	});
    	
    	ivItJobs.setOnClickListener(new OnClickListener(){
    		public void onClick(View view)
    		{
    			intent = new Intent(H2kinfosys.this,JobList.class);
    			startActivity(intent);
    		}
    	});
    	
    	ivBlogs.setOnClickListener(new OnClickListener(){
    		public void onClick(View view)
    		{
    			intent = new Intent(H2kinfosys.this,BlogsActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	ivForums.setOnClickListener(new OnClickListener(){
    		public void onClick(View view)
    		{
    			intent = new Intent(H2kinfosys.this,ForumsActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	ivVideos.setOnClickListener(new OnClickListener(){
    		public void onClick(View view)
    		{
    			intent = new Intent(H2kinfosys.this,VideosActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	ivSeo.setOnClickListener(new OnClickListener(){
    		public void onClick(View view)
    		{
    			intent = new Intent(H2kinfosys.this,SeoActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	ivContactForm.setOnClickListener(new OnClickListener(){
    		public void onClick(View view)
    		{
    			intent = new Intent(H2kinfosys.this,ContactFormActivity.class);
    			startActivity(intent);
    		}
    	});
    	
    	ivTesting.setOnClickListener(new OnClickListener(){
    		public void onClick(View view)
    		{
    			intent = new Intent(H2kinfosys.this,SoftwareDevelopment.class);
    			startActivity(intent);
    		}
    	});
    }
    public void showToast(String msg)
    {
    	Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
    @Override
	public void onDestroy()
	{
		super.onDestroy();
		System.gc();
		
	}
}
