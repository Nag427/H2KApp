package com.h2kinfosys.com;

import java.io.InputStream;
import java.util.ArrayList;

import javabeans.Post;

import org.apache.http.protocol.HTTP;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Blogs extends Activity {
	String content = null;
	private TextView tvContent = null;
	private String id,fullName,mail,webUrl,message,blogName = null;
	private ImageView ivLeave = null;
	EditText etFullName,etMail,etUrl,etMessage = null;
	private Button btnSubmit = null;
	private AlertDialog ad = null;
	String url = null;
	String postStatus = null;
	String postMessage = null;
	private TextView tvHeading = null;
	public void onCreate(Bundle saveInstanceState)
	{
		super.onCreate(saveInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.blog_content);
		Bundle bundle = getIntent().getExtras();
		
		content = (String)bundle.get("blogs");
		id = (String)bundle.get("blogsId");
		blogName = (String)bundle.get("blogName");
		tvHeading = (TextView)findViewById(R.id.tvHeading);
		tvHeading.setText(blogName);
		/*Log.i("",""+content);
		Log.i("blog id",""+id);
		Log.i("blog name",blogName);*/
		tvContent = (TextView)findViewById(R.id.tvContent);
		tvContent.setText(content);
		init();
		
	}
	public void init()
	{
		findViewById(R.id.ivBack).setOnClickListener(new OnClickListener(){
		public void onClick(View view)
		{
			Blogs.this.finish();
		}
		});

		findViewById(R.id.ivHome).setOnClickListener(new OnClickListener(){
		public void onClick(View view)
		{
			Intent intent = new Intent(Blogs.this,H2kinfosys.class);
			startActivity(intent);
		}
		});
		
		ivLeave  = (ImageView)findViewById(R.id.ivLeave);
		ivLeave.setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				
				Blogs.this.showDialogBox();
			}
			});
	}
	
	public String postUrl(String name,String id,String userName,String email,String url,String content)
	{
		url = "http://h2kinfosys.com/h2kIsoftWebs/"+name+"_cmt_add.php?id=20&name="+userName+"&email="+email+"&url="+url+"&content="+content;
		
		return url;
	}
	
	public void showDialogBox()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(Blogs.this);
		LayoutInflater inflater = (LayoutInflater)Blogs.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		builder.setTitle("Leave A Comment");
		View view = inflater.inflate(R.layout.custom_dialog,null);
		etFullName =(EditText)view.findViewById(R.id.etFullName);
		etMail =(EditText)view.findViewById(R.id.etEmail);
		etUrl =(EditText)view.findViewById(R.id.etUrl);
		etMessage =(EditText)view.findViewById(R.id.etMessage);
		btnSubmit = (Button)view.findViewById(R.id.btnSubmit);
		
		builder.setView(view);
		 ad =  builder.create();	
		btnSubmit.setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				fullName = etFullName.getText().toString();
				/*Log.i("fullName",fullName);*/
				mail = etMail.getText().toString();
				webUrl = etUrl.getText().toString();
				 message = etMessage.getText().toString();
				 new postCommentTask().execute();
				 ad.dismiss();
				 
			}
			});
		
		
			
			ad.show();
	}
	@Override
	public void onResume()
	{
		super.onResume();
		if(fullName != null)
		{
			Toast.makeText(getApplicationContext(), "welcome back", Toast.LENGTH_LONG).show();
		/*Log.i("name",fullName);*/
		}
	}
	
	class postCommentTask extends AsyncTask<Void,Void,Void>
	{

		@Override
		public void onPostExecute(Void result)
		{
			super.onPostExecute(result);
			if(postStatus.equals("1") && postMessage != null)
			{
			 showToast("Your comment is awaiting moderation");}
			else
			{
				
			}
			
		}
		
		@Override
		public Void doInBackground(Void... params)
		{
			InputStream in  = null;
			if(Utility.isOnline(getApplicationContext()))
			{
				in = Utility.connect(postUrl(blogName,id,fullName,mail,webUrl,message));
				/*Log.i("","connected");*/
				
			}
			else 
			{
				/*Log.i("","check your network connection");*/
			}
			if(in != null)
			{
				//parse the data
			
				
				getDetails(in);
				
			
			
			}
			return null;
		}
		@Override
		public void onPreExecute()
		{
			
		}
	}
	public void getDetails(InputStream in)
	{
		final int status = 1;
		final int message1 = 2;
		final int post_name = 3;
		final int post_content = 4;
		int tagName = 0;
		
		
		
		try
		{
			XmlPullParserFactory parserFactory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = parserFactory.newPullParser();
			parser.setInput(in,HTTP.UTF_8);
			int eventType = parser.getEventType();
			
			 while (eventType != XmlPullParser.END_DOCUMENT) 
			 {
		         
		           if(eventType == XmlPullParser.START_TAG) {
		              if(parser.getName().equals("post"))
		              {
		            	 
		            	 
		              }
		              else if(parser.getName().equals("status")){
		            	  
		            	 tagName = status;
		              }
		              else if(parser.getName().equals("message")){
		            	  
			            	 tagName = message1;
			              }
		            
		          } 
		           
		         if(eventType == XmlPullParser.TEXT) {
		             switch(tagName)
		             {
		           
		             case status:
		            	 postStatus = parser.getText();
		            	 
		            	 break;
		             case message1:
		            	 postMessage = parser.getText();
		            	 break;
		            
		            	 
		            	 default :break;
		             }
		             
		            	 
		             tagName = 0;
		          }
		         
		          eventType = parser.next();
		    }
			
		
			 
		}
		catch(Exception e){}
		/*Log.i("post status",postStatus);
		Log.i("post message",postMessage);*/
	}
	
	public void showToast(String msg)
	{
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
	}
	
}
