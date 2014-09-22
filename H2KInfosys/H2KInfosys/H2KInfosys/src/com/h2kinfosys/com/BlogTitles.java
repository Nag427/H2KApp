package com.h2kinfosys.com;

import java.util.ArrayList;


import com.h2kinfosys.com.BlogsActivity.BlogsData;

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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class BlogTitles extends Activity {
	
	private ArrayList<String > listBlogTitles  = null;
	private ArrayList<String > listBlogContent  = null;
	private ArrayList<String > blogId  = null;
	ListView listView = null;
	private ArrayList<String> listPostComment = null;
	private ArrayList<String> listViewComment = null;
	private String blogName = null;
	private TextView tvHeading=null;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.sub_forums);
		Bundle bundle = getIntent().getExtras();
		
		listBlogTitles = (ArrayList<String>)bundle.get("blogTitles");
		listBlogContent = (ArrayList<String>)bundle.get("blogContent");
		blogId = (ArrayList<String>)bundle.get("blogId");
		blogName = (String)bundle.get("blogName");
		tvHeading = (TextView)findViewById(R.id.tvHeading);
		tvHeading.setText(blogName);
		/*Log.i("blogIds",""+listBlogTitles);*/
		listView = (ListView)findViewById(R.id.listView);
		listView.setAdapter(new ForumNamesAdapter());
		addListener();
		
		listView.setOnItemClickListener(new OnItemClickListener(){
			
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(BlogTitles.this,Blogs.class);
				intent.putExtra("blogs", listBlogContent.get(position));
				intent.putExtra("blogsId", blogId.get(position));
				intent.putExtra("blogName",blogName);
				startActivity(intent);
				
				}
		});
		
		
	}
	public void init()
	{
		listPostComment.add("");
	}
	public void addListener()
	{

	  
	  findViewById(R.id.ivBack).setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				BlogTitles.this.finish();
			}
		});
		
		findViewById(R.id.ivHome).setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				Intent intent = new Intent(BlogTitles.this,H2kinfosys.class);
				startActivity(intent);
			}
		});
	}
	public class ForumNamesAdapter extends BaseAdapter{
		Context context = BlogTitles.this;
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return listBlogTitles.size();
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
			
			if((listBlogTitles.get(position)) == null)
			{
				showToast("No Topics Found");
			}
			else
			{
				name.setText(listBlogTitles.get(position));
			}
			return view;
		}
		
	}
	public void showToast(String url)
	{
		Toast.makeText(getApplicationContext(),url,Toast.LENGTH_SHORT).show();
	}


}
