package com.h2kinfosys.com;

import java.util.ArrayList;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class VideosActivity extends Activity{
	
	ListView listVideos = null;
	ArrayList<String > links,names = null;
	int[] imagesIds = null;
	
	int count = 0;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.video);
		listVideos = (ListView)findViewById(R.id.listView);
		intialization();
		listVideos.setAdapter(new HighlightAdapter(this));
		init();
		listVideos.setOnItemClickListener(new OnItemClickListener(){
			
			
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(VideosActivity.this,PlayVideo.class);
				intent.putExtra("link", links.get(position));
				startActivity(intent);
			}
			
		});
		
	
	}
	
	public void init()
	{
		findViewById(R.id.ivBack).setOnClickListener(new OnClickListener(){
		public void onClick(View view)
		{
			VideosActivity.this.finish();
		}
		});

		findViewById(R.id.ivHome).setOnClickListener(new OnClickListener(){
		public void onClick(View view)
		{
			Intent intent = new Intent(VideosActivity.this,H2kinfosys.class);
			startActivity(intent);
		}
		});
	}
	
	
	public void intialization()
	{ 
		links = new ArrayList<String>();
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=RC02WBF5nhg");
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=AEbo5efYrA4");
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=3DMQW9EtamY");
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=4YUv9eLcxHU");
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=l7GP0B7dqqM");
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=0qpFcF2mbfs");
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=5YVEmrXfuas");
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=FCsWjHo4oP4");
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=VZg9KA6BeUo");
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=x7jIQriDGxs");
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=_3xpKOncvSI");
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=KCvum7qV2iE");
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=wFX5a6FQEVY");
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=JLe1XIsbxYQ");
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=ZbAlvXcH58w");
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=N6ULrCp0ZdU");
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=Zd3Hqbsw8YM");
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=aBY7lyADvag");
		links.add("http://www.youtube.com/watch?feature=player_embedded&v=okU71l_Hex8");
		
		
		
		imagesIds = new int[]{R.drawable.one,R.drawable.two,R.drawable.three,
				R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven,
				R.drawable.eight,R.drawable.nine,R.drawable.ten,R.drawable.eleven,
				R.drawable.twelve,
				R.drawable.thirteen,R.drawable.forteen,R.drawable.fifteen,R.drawable.sixteen,
				R.drawable.seventeen,R.drawable.eighteen,R.drawable.ninteen};
		
		names = new ArrayList<String>();
		names.add("Java WebServices tutorial, soapui, webservices videos");
		names.add("Core java tutorial, java videos,java training, j2ee, struts, spring,hibernate,webservices");
		names.add("QTP Framework Data Driven Frame work");
		names.add("LoadRunner VUGen Scripting interview questions tutorial, Performance, load, stress testing");
		names.add("QTP Descriptive Programming, QTP Tutorial, interview questions, qtp keyword data driven framework");
		names.add("What is Test case? Software QA Tester Interview Questions, Manual testing tutorial testcase");
		names.add("Advantages of attending Software training with H2K Infosys");
		names.add("QTP part 2 of Descriptive programming Shared object repository");
		names.add("Software Training QATesting.wmv");
		names.add("UNIX Linux commands tutorial for QA Tester interview questions");
		names.add("What is Regression Testing,ReTesting,Manual Testing FAQ");
		names.add("Software QA Testing,QTP,LoadRunner,ETL Testing,Manual Testing,Java,BA");
		names.add("ETL TEsting FAQ,Data warehouse Testing, Informatica, ETL Testing Tutorial,Informatica");
		names.add("H2kinfosys provides instructor led live online training");
		names.add("Software testing QA Testing interview questions Automation Testing Integration");
		names.add("Online Qa training interview questions QTP Automation Testing");
		names.add("Quality assurance testing interview questions");
		names.add("Online Qa training interview questions Quality Assurance Integration Testing QTP");
		names.add("Mock interview Online Qa training interview questions QA Testing Quality Assurance Testing");
	}
	public void playVideo(String url)
	{
		 startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
	}
	
	
	class HighlightAdapter extends BaseAdapter
	{
		Context c;
		public HighlightAdapter(Context c)
		{
			this.c = c;
		}
		
		
		
		public int getCount()
		{
			return links.size();
		}
		public long getItemId(int position)
		{
			return position;
		}

		public Object getItem(int position)
		{
			return position;
		}
		public View getView(int position ,View convertView,ViewGroup parent)
		{
			
				count = position;
				LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflater.inflate(R.layout.custom_video_list,null);
				TextView textName = (TextView)convertView.findViewById(R.id.textName);
				ImageView imageVideo = (ImageView)convertView.findViewById(R.id.ivVideo);
				textName.setText(names.get(count));
				imageVideo.setImageResource(imagesIds[count]);
				/*imageVideo.setOnClickListener(new OnClickListener(){
					public void onClick(View view)
					{
						playVideo(links.get(count));
					}
				});*/
			
			
			return convertView;
		}
	
	}
}
