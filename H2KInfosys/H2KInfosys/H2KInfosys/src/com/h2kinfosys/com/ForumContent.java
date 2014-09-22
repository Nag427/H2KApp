package com.h2kinfosys.com;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javabeans.ForumDetail;

import org.apache.http.protocol.HTTP;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

public class ForumContent extends Activity {
	
	private LinearLayout linearLayout = null;
	private String topicId,topicName,url = null;
	private  TextView tvName = null;
	private ArrayList<HashMap> hashMap = new ArrayList<HashMap>();
	private ProgressDialog pd = null;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.forum_content);
		
		topicId = (String)getIntent().getExtras().get("topicId");
		topicName  = (String)getIntent().getExtras().get("topicName");
		tvName = (TextView)findViewById(R.id.tvName);
		tvName.setText(topicName);
		url(topicId);
		Log.i("topicId",topicId);
		init();
		new MyBgTask1().execute();
	}
	
	public void init()
	{
		findViewById(R.id.ivBack).setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				ForumContent.this.finish();
			}
		});
		
		findViewById(R.id.ivHome).setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				Intent intent = new Intent(ForumContent.this,H2kinfosys.class);
				startActivity(intent);
			}
		});
	}
	public void addViews()
	{
		linearLayout = (LinearLayout)findViewById(R.id.layoutContent);
		TextView tvSubject,tvPosterName,tvTime,tvPostText = null;
		LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.MATCH_PARENT);
		View convertView = null;
		String time = null;
		long longTime = 0;
		Date date = null;
		 long millis  = 0;
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		
		for(int i =0; i!=hashMap.size();i++)
		{
			LayoutInflater inflater = (LayoutInflater)ForumContent.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.custom_forum_content, null);
			tvSubject  = (TextView)convertView.findViewById(R.id.tvSubject);
			tvSubject.setLayoutParams(lparams);
			tvSubject.setTextColor(Color.BLACK);
			tvSubject.setText((String)hashMap.get(i).get("postSubject"));
			
			tvPosterName  = (TextView)convertView.findViewById(R.id.tvPosterName);
			tvPosterName.setText("By: "+(String)hashMap.get(i).get("posterName"));
			tvPosterName.setTextColor(Color.BLACK);
			tvTime  = (TextView)convertView.findViewById(R.id.tvTime);
			time = (String)hashMap.get(i).get("postTime");
			longTime = Long.parseLong(time);
			
			

			 millis = new Date().getTime();
			


			 longTime = millis -longTime*1000;
			 Date d = new Date(millis - longTime);
			 
			 System.out.println(df.format(d)); 
			 
			 
			tvTime.setText("Time: "+df.format(d));
			tvTime.setTextColor(Color.BLACK);
			
			tvPostText  = (TextView)convertView.findViewById(R.id.tvPostText);
			tvPostText.setLayoutParams(lparams);
			tvPostText.setTextColor(Color.BLACK);
			tvPostText.setText((String)hashMap.get(i).get("postText"));
		
			linearLayout.addView(convertView);
			convertView = null;
			tvSubject= null;
			tvPosterName = null;
			tvTime = null;
			tvPostText = null;
		}
	}
	public void url(String topicId)
	{
		url = "http://h2kinfosys.com/h2kIsoftWebs/forums_child.php?topic_id="+topicId;
	}
	class MyBgTask1 extends AsyncTask<Void,Void,Void>
	{
		@Override 
		protected void onPostExecute(Void result)
		{
			if(hashMap != null && Utility.isOnline(getApplicationContext()))
					{
						addViews();
						pd.dismiss();
					}
			else
			{
				showToast("plz check your network connection!");
			}
		}

		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			
			InputStream in = null;
			if(Utility.isOnline(getApplicationContext()))
			{
				in = Utility.connect(url);
				
			}
			if(in != null)
			{
				try
				{
					hashMap = getDetails(in);
				}
				catch(IOException e){}
			}
			return null;
		}
		@Override
		protected void onPreExecute()
		{
			super.onPreExecute();
			loadTask("Loading ...");
		}
		
	}
	public ArrayList<HashMap> getDetails(InputStream in) throws IOException
	{
		final int poster_name = 1;
		final int post_subject = 2;
		final int post_time = 3;
		final int post_text = 4;
		ForumDetail forumDetail = null;
		int tagName = 0;
		HashMap<String,String> hashMap = null;
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		try
		{
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		XmlPullParser parser = factory.newPullParser();
		
		parser.setInput(in,HTTP.UTF_8);
		int eventType = parser.getEventType();
		
		 while (eventType != XmlPullParser.END_DOCUMENT) 
		 {
	         
	           if(eventType == XmlPullParser.START_TAG) {
	              if(parser.getName().equals("forum"))
	              {
	            	  forumDetail = new ForumDetail();
	            	  hashMap = new HashMap<String,String>();
	              }
	              else if(parser.getName().equals("poster_name")){
	            	  
		            	 tagName = poster_name;
		              }
	              else if(parser.getName().equals("post_subject")){
	            	  
	            	 tagName = post_subject;
	              }
	              else if(parser.getName().equals("post_time")){
	            	  
		            	 tagName = post_time;
		              }
	              else if(parser.getName().equals("post_text")){
	            	  
		            	 tagName = post_text;
		              }
	          } 
	           
	         if(eventType == XmlPullParser.TEXT) {
	             switch(tagName)
	             {
	             case poster_name: 
	            	 forumDetail.setPosterName(parser.getText());
	            	 break;
	             
	             case post_subject:
	            	 forumDetail.setPostSubject(parser.getText());
	            	 break;
	             
	             case post_time:
	            	 forumDetail.setPostTime(parser.getText());
	            	 Log.i("post time",forumDetail.getPostTime());
	            	 break;
	             
	             case post_text:
	            	 forumDetail.setPostText(parser.getText());
	            	 Log.i("post text",forumDetail.getPostText());
	            	 break;
	            	 
	            	 default :break;
	             }
	            
	             
	            	 
	             tagName = 0;
	          }
	         if(eventType == XmlPullParser.END_TAG) {
		             if(parser.getName().equals("forum"))
		             {
		            	 hashMap.put("posterName",forumDetail.getPosterName());
		            	 Log.i("posterName",hashMap.get("posterName"));
		            	 hashMap.put("postSubject",forumDetail.getPostSubject());
		            	 hashMap.put("postTime",forumDetail.getPostTime());
		            	 hashMap.put("postText",forumDetail.getPostText());
		            	 list.add(hashMap);
		            	 forumDetail = null;
		            	 
		             }
		          } 
	          eventType = parser.next();
	    }
		}
		catch(XmlPullParserException e){}
		
		return list;
	}
	
	 public void showToast(String msg)
	 {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
	 }
	 
	 public void loadTask(String msg)
	 {

			pd = new ProgressDialog(ForumContent.this);
			pd.setMessage(msg);
			pd.setCancelable(true);
			pd.setIndeterminate(false);
			pd.show();
	 }
	 
	
}
