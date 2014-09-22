package com.h2kinfosys.com;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javabeans.ForumDetails;

import org.apache.http.protocol.HTTP;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;




public class ForumsActivity extends Activity{
	ExpandableListView expListView ;
	/*ExpAdapter expAdapter  = null;*/
	String[][] childElements ;
	String[] groupElements ;
	Context context = this;
	ListView listView = null;
	ArrayList<ArrayList> listsTopics = new ArrayList<ArrayList>();
	ArrayList<String> forumNames = null;
	ProgressDialog pd = null;
	private ArrayList<ArrayList> topicId = new ArrayList<ArrayList>(); ;
	private ImageView ivHome,ivBack;
	
	private static final String URL = "http://h2kinfosys.com/h2kIsoftWebs/forums.php";
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.forums);
		/*expListView = (ExpandableListView)findViewById(R.id.expListView);*/
		listView = (ListView)findViewById(R.id.listView);

		addListener();

		
		listView.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> adapter,View view,int position,long id)
			{
				Intent intent   = new Intent(ForumsActivity.this,SubForumsActivity.class);
				listsTopics.get(position);
				intent.putExtra("topics",listsTopics.get(position));
				intent.putExtra("topicId",topicId.get(position));
				startActivity(intent);
			}
		});
		getForumsNamesAndItsTopics();
	}
	
	/*public void intialization()
	{
		String [] name  = new String[]{"WebService Required","WebService Required",
				"WebService Required","WebService Required"};
		childElements = new String[6][];
		childElements[0]  = name;
		childElements[1]  = name;
		childElements[2]  = name;
		childElements[3]  = name;
		childElements[4]  = name;
		childElements[5]  = name;
		
		groupElements = new String[]{"QualityAssurance","java","JEE","Oracle",
				".Net","Anroid"
				};
	}*/
	public void addListener()
	{
		findViewById(R.id.ivBack).setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				ForumsActivity.this.finish();
			}
		});
		
		findViewById(R.id.ivHome).setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				Intent intent = new Intent(ForumsActivity.this,H2kinfosys.class);
				startActivity(intent);
			}
		});
	}
	/////my Adapter ////
	
	public class ForumNamesAdapter extends BaseAdapter{
		Context context = ForumsActivity.this;
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return forumNames.size();
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
			convertView =  inflater.inflate(R.layout.forums_group_view, null);
			TextView name = (TextView)convertView.findViewById(R.id.tvForumName);
			name.setText(forumNames.get(position));
	
			
			
			
			
			return convertView;
		}
		
	}

	
	/*
	 * get forums name thourgh webservice
	 * */
	public void getForumsNamesAndItsTopics()
	 {
		 new ForumsDetails().execute();
	 }
	 
	class ForumsDetails extends AsyncTask<Void,Void,Void>
	{
		
		@Override
		protected void onPostExecute(Void result)
		{
			super.onPostExecute(result);
			if(Utility.isOnline(getApplicationContext()) && ((listsTopics != null) &&(forumNames != null)))
			{
			/*Log.i("forum names = ",""+forumNames);
			Log.i("topics ",""+listsTopics.get(0));*/
			
			listView.setAdapter(new  ForumNamesAdapter());
			pd.dismiss();
			}
			else
			{
				pd.dismiss();
				showToast("check your network Connection");
			}
			
			
		}		 
		@Override
		protected Void doInBackground(Void...  arg0)
		{
			// TODO Auto-generated method stub
			InputStream in = null;
			if(Utility.isOnline(getApplicationContext()))
			{
				/*Log.i("networkstatus ","wifi connnected");*/
				in = Utility.connect(URL);
		
			}
			else
			{
			
			}
			
			if(in != null)
			{	
				getForumDetails(in);
			}
			
			return null;
		}
		@Override
		protected void onPreExecute()
		{
			loadTask("Loading.... ");
			super.onPreExecute();
		}
		
	 }
	
	public void getForumDetails(InputStream in)
	{
		final int forum = 1;
		final int forum_id = 2;
		final int forum_name = 3;
		final int topic_details = 4;
		final int topic_id = 5;
		final int topic_title =6;
		
		
		int tagName = 0;
		ForumDetails forumDetails = null;
		ArrayList<String > topics = null;
		ArrayList<String > topicsId = null;
		forumNames = new  ArrayList<String>();
		
		try
		{
			XmlPullParserFactory parserFactory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = parserFactory.newPullParser();
			parser.setInput(in,HTTP.UTF_8);
			int eventType = parser.getEventType();
			
			 while (eventType != XmlPullParser.END_DOCUMENT) 
			 {
		         
		           if(eventType == XmlPullParser.START_TAG) {
		              if(parser.getName().equals("forum"))
		              {
		            	  forumDetails = new ForumDetails();
		            	  topics  = new ArrayList<String>();
		            	  topicsId = new ArrayList<String>();
		            	  tagName = forum;
		              }
		              else if(parser.getName().equals("forum_id")){
		            	  
		            	 tagName = forum_id;
		              }
		              else if(parser.getName().equals("forum_name"))
		              {
		            	  tagName = forum_name;
		              }
		              else if(parser.getName().equals("topic_title"))
		              {
		            	  
		            	  tagName = topic_title;
		              }
		              else if(parser.getName().equals("topic_id"))
		              {
		            	  tagName = topic_id;
		              }
		          } 
		           
		         if(eventType == XmlPullParser.TEXT) {
		             switch(tagName)
		             {
		             case forum: break;
		             case forum_id:
		            	 break;
		             case forum_name:
		            	 forumDetails.setForumName(parser.getText());
		            	 forumNames.add(forumDetails.getForumName());
		            	 break;
		             case topic_title:
		            	 topics.add(parser.getText());
		            	 break;
		             case topic_id:
		            	 topicsId.add(parser.getText());
		            	 break;
		            	 
		            	 default :break;
		             }
		            
		             
		            	 
		             tagName = 0;
		          }
		         if(eventType == XmlPullParser.END_TAG) {
			             if(parser.getName().equals("forum"))
			             {
			            	 listsTopics.add(topics);
			            	 topicId.add(topicsId);
			            	 forumDetails = null;
			            	 topics = null;
			             }
			          } 
		          eventType = parser.next();
		    }
			
		}
		catch(Exception e){}
		
	}
	/*
	 * show message
	 * */
	 public void showToast(String msg)
	 {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
	 }
	 
	 public void loadTask(String msg)
	 {

			pd = new ProgressDialog(ForumsActivity.this);
			pd.setMessage(msg);
			pd.setCancelable(true);
			pd.setIndeterminate(false);
			pd.show();
	 }
	 
	 @Override
		public void onDestroy()
		{
			super.onDestroy();
			System.gc();
			
		}

}
