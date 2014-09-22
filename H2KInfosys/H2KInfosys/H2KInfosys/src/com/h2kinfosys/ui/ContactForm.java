package com.h2kinfosys.ui;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.h2kinfosys.com.R;
import com.h2kinfosys.com.Utility;

public class ContactForm extends LinearLayout{

	Context context = null;
	private EditText  etFullName,etEmail,etPhone,etCountry,etMessage = null;
	private String name,email,phoneNo,country,message = null;
	private Button btnSubmit;
	private View view = null;
	LayoutInflater inflater = null;
	private boolean b = true;
	ViewHolder holder = null;
	Spinner spFromWhere = null;
	private String URL = null;
	private String msg = null;
	private ProgressDialog pd = null;
	public ContactForm(Context context)
	{
		super(context);
		this.context = context;
		inflater  = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = inflater.inflate(R.layout.submit_form, null);
		addView(view);
		init();
		
	
	}
	public ContactForm(Context context ,AttributeSet atts)
	{
		super(context,atts);
		this.context = context;
		inflater  = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = inflater.inflate(R.layout.submit_form, null);
		addView(view);
		init();
		
	}
	public void httpUrl(String name,String urMail,String phoneNo,String country,String courseInterest,String msg)
	{
		URL = "http://h2kinfosys.com/h2kIsoftWebs/contactUs_email.php?fullName="+name+"&userEmail="+urMail+"&phoneNum="+phoneNo+"&cityCountry="+country+"&courseIntrest="+courseInterest+"&userView="+msg;
	}
	public void init()
	{/*
		holder = new ViewHolder();
		removeAllViews();*/
		etFullName = (EditText)findViewById(R.id.etFullName);
		etEmail = (EditText)findViewById(R.id.etEmail);
		etPhone = (EditText)findViewById(R.id.etPhone);
		
		etCountry = (EditText)findViewById(R.id.etCountry);
		etMessage = (EditText)findViewById(R.id.etMessage);
		btnSubmit = (Button)findViewById(R.id.btnSubmit);
		
		spFromWhere = (Spinner)findViewById(R.id.spiFromWhere);
		final String[]  from_where = {"Google","Google Ad","Yahoo search","Classifieds","Friends",
				"Articles","Blogs","Display Ads","Other Search Engine","Other Way"};
		spFromWhere.setAdapter(new ArrayAdapter(context, android.R.layout.simple_spinner_item,from_where));

		btnSubmit.setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				name = etFullName.getText().toString();
				/*if(postData.matches(".*\\w.*")){*/
				email = etEmail.getText().toString();
				phoneNo = etPhone.getText().toString();
				country = etCountry.getText().toString();
				message = etMessage.getText().toString();
				if(name.matches(".*\\w.*"))
				{
					name = name.replace(" ","%20");
				}
				else if(email.matches(".*\\w.*")){
					email = email.replace(" ", "%20");
				}
				else if(phoneNo.matches(".*\\w.*"))
				{
					phoneNo = phoneNo.replace(" ","%20");
				}
				else if(message.matches(".*\\w.*"))
				{
					message = message.replace(" ","%20");
				}
				if(getDetails())
				{
					try{
						
						Double.parseDouble(etPhone.getText().toString());
						
						
						httpUrl(name,email,phoneNo,country,null,message);
						new SubmitFormTask().execute(URL);
						/*Thread.currentThread().sleep(3*1000);*/
						
					}
					catch(NumberFormatException e)
					{
						showToast("phone no must be in digits");
					}
					/*catch(InterruptedException e)
					{
						e.printStackTrace();
					}*/
				}
				else	
				{
					getDetails();
				}	
			}
	});
		System.gc();
		
	}
	
	
	public boolean getDetails()
	{
		
		b = true;
       
		if(name.equals(""))
		{
			showToast("Enter your first name");
			b = false;
		}
		
		else if(email.equals("")  || !email.matches("[a-z0-9._-]+@[a-z]+.[a-z]+") )
		{
			showToast("Check Your Email Id ");
			b = false;
		}
		
		else if((etPhone.getText().toString()).equals("") || (etPhone.getText().toString()).length() !=  10) 
		{
			showToast("CHECK YOUR PHONE NO.");
			b = false;
		}
		
		
		else if(country.equals(""))
		{
			showToast("Enter your Country");
			b = false;
		}
		
		else if(message.equals(""))
		{
			showToast("Enter your Message");
			b = false;
		}
		 return b;
      		
	}
	class ViewHolder
	{}
	
	//$$$$$$$$ MY FORM SERVICE $$$$$$$$$$$$$//
	class SubmitFormTask extends AsyncTask<String,String,String>
	{
		@Override 
		public void onPostExecute(String result)
		{
			super.onPostExecute(result);
			if(Utility.isOnline(context))
			{
				pd.dismiss();
			showToast(msg);
			Activity activity = (Activity)context;
			activity.finish();
			}
			
		}
		@Override
		public String doInBackground(String... params)
		{
			InputStream in = null;
			if(Utility.isOnline(context))
			{
				in = getResponse(params[0]);
				
			}
			else{}
			if(in != null)
			{
				Log.i("","in is not null");
				msg = getResponseMsg(in);
			}
			if(msg != null)
			{
				Log.i("response message",msg);
				
			}
			return null;
		}
		@Override
		public void onPreExecute()
		{
			super.onPreExecute();
		loadTask("Loading..");
		}
	}
	public String getResponseMsg(InputStream in)
	{
		
		final int message = 1;
		String textMsg = null;
		int tagName = 0;
		try
		{
			XmlPullParserFactory parserFactory = XmlPullParserFactory.newInstance();
			XmlPullParser xmlParser = parserFactory.newPullParser();
			
			xmlParser.setInput(in,HTTP.UTF_8);
			int eventType = xmlParser.getEventType();
			Log.i("","running in getResponseMSg");
			while(eventType != XmlPullParser.END_DOCUMENT)
			{

		           if(eventType == XmlPullParser.START_TAG) {
		              if(xmlParser.getName().equals("message"))
		              {
		            	 
		            	 tagName = message;
		              }
		             
		          } 
		           
		         if(eventType == XmlPullParser.TEXT) {
		             switch(tagName)
		             {
		           
		           
		             case message:
		            	textMsg =xmlParser.getText();
		            	
		            	 break;
		            	 
		            	 default :break;
		             }
		             
		            	 
		             tagName = 0;
		          }
		         if(eventType == XmlPullParser.END_TAG) {
			            
			          } 
		          eventType = xmlParser.next();
		    }
			
			
			 
		}
		catch(XmlPullParserException e)
		{e.printStackTrace();
		}
		catch(IOException e){e.printStackTrace();}
		return textMsg;
	}
	public InputStream getResponse(String url)
	{
		String xml = null;
		InputStream in = null;
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		try
		{
			HttpResponse reponse = httpClient.execute(httpGet);
			HttpEntity entity = reponse.getEntity();
			if(entity != null)
			{
				/*xml = EntityUtils.toString(entity);
				Log.i("xml response",xml);*/
				in = entity.getContent();
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return in;
	}
	
	public void showToast(String msg)
	{
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
	public boolean checkMail(String... pattern)
	{
		Pattern p= Pattern.compile(pattern[0]);
		Matcher m = p.matcher(etEmail.getText().toString());
		return m.matches();
	}
	public void loadTask(String title)
	{
		pd = new ProgressDialog(context);
		pd.setTitle(title);
		pd.setCancelable(true);
		pd.setIndeterminate(false);
		pd.show();
	}
}
