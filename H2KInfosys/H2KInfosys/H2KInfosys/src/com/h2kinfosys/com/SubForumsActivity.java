package com.h2kinfosys.com;

import java.util.ArrayList;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import android.widget.Toast;

public class SubForumsActivity extends Activity {
	
	private ArrayList<String > arrayListTopics  = null;
	private ArrayList<String > topicId  = null;
	ListView listView = null;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.sub_forums);
		Bundle bundle = getIntent().getExtras();
		
		arrayListTopics = (ArrayList<String>)bundle.get("topics");
		topicId = (ArrayList<String>)bundle.get("topicId");
		Log.i("topics ",""+arrayListTopics);
		Log.i("topicsId ",""+topicId);
		listView = (ListView)findViewById(R.id.listView);
		listView.setAdapter(new ForumNamesAdapter());
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View convertView, int position,
					long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SubForumsActivity.this,ForumContent.class);
				intent.putExtra("topicId",topicId.get(position));
				intent.putExtra("topicName",arrayListTopics.get(position));
				startActivity(intent);
			}
			
		});
		addListener();
		
	}
	public void addListener()
	{
	  ((ImageView)findViewById(R.id.ivBack)).setOnClickListener(new OnClickListener()
		{
			public void onClick(View view)
			{
				SubForumsActivity.this.finish();
			}
		});
	  ((ImageView)findViewById(R.id.ivHome)).setOnClickListener(new OnClickListener()
		{
			public void onClick(View view)
			{
				Intent intent = new Intent(SubForumsActivity.this,H2kinfosys.class);
				startActivity(intent);
			}
		});
	}
	public class ForumNamesAdapter extends BaseAdapter{
		Context context = SubForumsActivity.this;
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return arrayListTopics.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View view =  inflater.inflate(R.layout.forums_child_view, null);
			TextView name = (TextView)view.findViewById(R.id.textBar);
			
			if((arrayListTopics.get(position)) == null)
			{
				showToast("No Topics Found");
			}
			else
			{
				name.setText(arrayListTopics.get(position));
			}
			return view;
		}
		
	}
	public void showToast(String url)
	{
		Toast.makeText(getApplicationContext(),url,Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		System.gc();
		
	}

}
