package com.h2kinfosys.com;

import java.io.InputStream;
import java.util.ArrayList;

import javabeans.Post;

import org.apache.http.protocol.HTTP;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BlogsActivity extends Activity{
	
	private ArrayList<String> listBlogs = null;
	private ArrayList<String> listUrls = null;
	private ArrayList<String> listUrlName = null;
	private ListView listViewBlogs = null;
	private String URL = null;
	private ArrayList<ArrayList> blogDetails = null;
	private ProgressDialog pd = null;
	private ArrayList<String> blogTitles = null;
	private ArrayList<String> postId = null;
	private ArrayList<String> blogContent= null;
	private String blogName = null;
	
	public void onCreate(Bundle savedInstaceState)
	{
		super.onCreate(savedInstaceState);
		 this.requestWindowFeature(Window.FEATURE_NO_TITLE);
			this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.blog);
		
		
		init();
		addListener();
		listViewBlogs = (ListView)findViewById(R.id.listViewBlog);
		
		
		listViewBlogs.setAdapter(new HighlightAdapter(this));
		listViewBlogs.setOnItemClickListener(new OnItemClickListener(){
			
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				/*Log.i("position of list",""+position);*/
				blogUrl(listUrls.get(position));
				/*Log.i("",listUrls.get(position));*/
			 blogName = listUrlName.get(position);
				new BlogsData().execute();
				}
		});
		
		
	}
	public void init()
	{
		listBlogs = new ArrayList<String>();
	listBlogs.add("Quality Assurance (QA)");
		listBlogs.add("Business/Systems Analysis (BA)");
		listBlogs.add("QTP Blog");
		listBlogs.add("Microsoft .Net");
		listBlogs.add("Java/J2EE");
		listBlogs.add("Real time projects");
		listBlogs.add("LoadRunner");
		listBlogs.add("Automation Testing");
		listBlogs.add("Performance Testing");
		listBlogs.add("Back end Testing");
		listBlogs.add("Middle ware Testing");
		listBlogs.add("Data warehousing testing");
		listBlogs.add("Siebel Testing");
		listBlogs.add("Selenium Testing");
		listBlogs.add("ETL Testing");
		listBlogs.add("WebServices Testing");
		listBlogs.add("Mobile Devices Testing");
		listBlogs.add("Unix Linux Testing");
		listBlogs.add("Software Testing");
		
		
		listUrlName = new ArrayList<String>();
		listUrlName.add("qualityAssurance");
		listUrlName.add("businessAnalysis");
		listUrlName.add("qtpBlog");
		listUrlName.add("dotNet");
		listUrlName.add("java");
		
		listUrlName.add("realTime");
		listUrlName.add("loadRunner");
		listUrlName.add("automation");
		listUrlName.add("performance");
		listUrlName.add("backendTesting");
		listUrlName.add("middleware");
		listUrlName.add("datawarehouse");
		listUrlName.add("siebel");
		listUrlName.add("selenium");
		listUrlName.add("etl");
		listUrlName.add("webservicesv");
		listUrlName.add("mobileTesting");
		listUrlName.add("unixLinuxTesting");
		listUrlName.add("softwareTesting");
		
		
		
		listUrls = new ArrayList<String>();
		
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/qualityAssurance.php");
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/businessAnalysis.php");
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/qtpBlog.php");
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/dotNet.php");
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/java.php");
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/realTime.php");
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/loadRunner.php");
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/automation.php");
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/performance.php");
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/backendTesting.php");
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/middleware.php");
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/datawarehouse.php");
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/siebel.php");
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/selenium.php");
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/etl.php");
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/webservices.php");
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/mobileTesting.php");
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/unixLinuxTesting.php");
		listUrls.add("http://h2kinfosys.com/h2kIsoftWebs/softwareTesting.php");
	}
	public void addListener()
	{
		findViewById(R.id.ivBack).setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				BlogsActivity.this.finish();
			}
		});
		
		findViewById(R.id.ivHome).setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				Intent intent = new Intent(BlogsActivity.this,H2kinfosys.class);
				startActivity(intent);
			}
		});
		
	}
	
/*
 * my blog adapter
 * 
 * */
	class HighlightAdapter extends BaseAdapter
	{
		Context c;
		public HighlightAdapter(Context c)
		{
			this.c = c;
		}
		
		
		
		public int getCount()
		{
			return listBlogs.size();
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
			
				LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflater.inflate(R.layout.custom_blogs,null);
				TextView tvBlog = (TextView)convertView.findViewById(R.id.tvBlog);
				tvBlog.setText(listBlogs.get(position));
			return convertView;
		}
		
		
	}
	
	//$$$$$$$$$$$$$$$$$$$$$$$$$ blogs data $$$$$$$$$$$$$$$$$$$/
	public void  blogUrl(String url)
	{
		 URL  = url;
	}
	
	class BlogsData extends AsyncTask<Void,Void,Void>
	{
		@Override
		public void onPostExecute(Void result)
		{
			super.onPostExecute(result);
			if(Utility.isOnline(getApplicationContext()) && ((postId != null) &&(blogTitles != null)))
			{
				
				
				
			
			/*Log.i("post ids",""+postId);
			 Log.i("post ids",""+blogTitles)*/;
			 pd.dismiss();
			 Intent intent = new Intent(getApplicationContext(),BlogTitles.class);
			 intent.putExtra("blogTitles", blogTitles);
			 intent.putExtra("blogContent", blogContent);
			 intent.putExtra("blogId", postId);
			 intent.putExtra("blogName",blogName);
			 startActivity(intent);
			}
			else
			{
				showToast("Check your NetworkConnections");
				 pd.dismiss();
			}
			 
		}
		
		@Override
		public Void doInBackground(Void... params)
		{
			InputStream in  = null;
			if(Utility.isOnline(getApplicationContext()))
			{
				in = Utility.connect(URL);
				/*Log.i("","connected");*/
				
			}
			else 
			{
				/*Log.i("","check your network connection");*/
			}
			if(in != null)
			{
				//parse the data
				/*Log.i("","response is not null");*/
				getBlogsData(in);
				
				
			
			
			}
			return null;
		}
		@Override
		public void onPreExecute()
		{
			loadTask("Loading");
			super.onPreExecute();
		}
	}
	
	public ArrayList<ArrayList> getBlogsData(InputStream in)
	{
		
		final int post_id = 1;
		final int post_title = 2;
		final int post_name = 3;
		final int post_content = 4;
		int tagName = 0;
		Post post = null;
		ArrayList<ArrayList> listBlogCategory = null;
		ArrayList<String> listPostId = new ArrayList<String>();
		ArrayList<String> listPostTitle = new ArrayList<String>();
		ArrayList<String> listPostContent = new ArrayList<String>();
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
		            	  post = new Post();
		            	 
		              }
		              else if(parser.getName().equals("ID")){
		            	  
		            	 tagName = post_id;
		              }
		              else if(parser.getName().equals("post_title")){
		            	  
			            	 tagName = post_title;
			              }
		              else if(parser.getName().equals("post_content"))
		              {
		            	  
		            	  tagName = post_content;
		              }
		          } 
		           
		         if(eventType == XmlPullParser.TEXT) {
		             switch(tagName)
		             {
		           
		             case post_id:
		            	 post.setPostId(parser.getText());
		            	 
		            	 break;
		             case post_content:
		            	post.setPostContent(parser.getText());
		            	
		            	 break;
		             case post_title:
		            	 post.setPostTitle(parser.getText());
		            	
		            	 break;
		            	 
		            	 default :break;
		             }
		             
		            	 
		             tagName = 0;
		          }
		         if(eventType == XmlPullParser.END_TAG) {
			             if(parser.getName().equals("post"))
			             {
			            	
			            	 
			            	 listPostId.add(post.getPostId());
			            	 listPostTitle.add(post.getPostTitle());
			            	 listPostContent.add(post.getPostContent());
			            	 post = null;
			             }
			          } 
		          eventType = parser.next();
		    }
			
			/* Log.i("post contents",""+listPostContent);*/
			 blogTitles = listPostTitle;
			 postId = listPostId;
			 
			 blogContent = listPostContent;
			 listPostId = null;
			 listPostTitle = null;
			 listPostContent = null;
			
			/* listBlogCategory.add(listPostId);
			 listBlogCategory.add(listPostTitle);
			 listBlogCategory.add(listPostContent);*/
			 
		}
		catch(Exception e){}
		return listBlogCategory;
	}
	
	 public void loadTask(String msg)
	 {

			pd = new ProgressDialog(BlogsActivity.this);
			pd.setMessage(msg);
			pd.setCancelable(true);
			pd.setIndeterminate(false);
			pd.show();
	 }
	 //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&//
	 @Override
	 public void onStop()
	 {
		 super.onStop();
		 postId = null;
		 blogTitles = null;
		 blogContent = null;
	 }
	 public void showToast(String msg)
		{
			Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
		}
	 
	
}
