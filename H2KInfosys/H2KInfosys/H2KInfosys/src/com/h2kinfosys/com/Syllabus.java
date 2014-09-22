package com.h2kinfosys.com;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class Syllabus extends Activity {

	private WebView webView = null;
	private int gp = 0;
	private String name = null;
	private ProgressDialog pd = null;
	private TextView tvHeading = null;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.syllabus);
		loadTask("loading...");
		gp = (Integer)getIntent().getExtras().get("gp");
		name = (String)getIntent().getExtras().get("name");
		webView = (WebView)findViewById(R.id.webView);
		
		
		webView.setWebViewClient(new WebViewClient(){
			  ProgressDialog dialog = new ProgressDialog(Syllabus.this);
			
			 @Override
             public boolean shouldOverrideUrlLoading(WebView view, String url)
             {
				 loadTask("Loading...");
                 view.loadUrl(url);
                 
 				 
                 return true;
             }
			
          
            @Override
            public void onPageFinished(WebView view, String url) {
            	pd.dismiss();
           }
           
		});
		
		init();
	}
	public void init()
	{
		addListener();
		
		tvHeading = (TextView)findViewById(R.id.tvHeading);
		tvHeading.setText(name+" Syllabus");
		
		switch(gp)
		{
		case 0:
			webView.loadUrl("file:///android_res/raw/syllabus1.html");
			break;
		case 1:
			webView.loadUrl("file:///android_res/raw/syllabus2.html");
			break;
			
		case 2:
			webView.loadUrl("file:///android_res/raw/syllabus3.html");
			break;
			
		case 3:
			webView.loadUrl("file:///android_res/raw/syllabus4.html");
			break;
		
		case 4:
			webView.loadUrl("file:///android_res/raw/syllabus5.html");
			break;
			
		case 5:
			webView.loadUrl("file:///android_res/raw/syllabus6.html");
			break;
		
		case 6:
			webView.loadUrl("file:///android_res/raw/syllabus7.html");
			break;
			
		case 7:
			webView.loadUrl("file:///android_res/raw/syllabus8.html");
			break;	
			
		case 8:
			webView.loadUrl("file:///android_res/raw/syllabus9.html");
			break;	
			
		case 9:
			webView.loadUrl("file:///android_res/raw/syllabus10.html");
			break;	
			
		case 10:
			webView.loadUrl("file:///android_res/raw/syllabus11.html");
			break;	
		
		case 11:
			webView.loadUrl("file:///android_res/raw/syllabus12.html");
			break;	
			
		case 12:
			webView.loadUrl("file:///android_res/raw/syllabus13.html");
			break;	
			
		case 13:
			webView.loadUrl("file:///android_res/raw/syllabus14.html");
			break;	
			
		case 14:
			webView.loadUrl("file:///android_res/raw/syllabus15.html");
			break;	
			
			
		default :
				break;
		}
		
		
	}
	public void addListener()
	{
		 ((ImageView)findViewById(R.id.ivBack)).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
			        webView.goBack();
					finish();
				}
			});
			 
			 ((ImageView)findViewById(R.id.ivHome)).setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						  webView.goBack();
						Intent intent = new Intent(Syllabus.this,H2kinfosys.class);
						startActivity(intent);
					}
				});
	}
	
	 public void loadTask(String msg)
	 {

			pd = new ProgressDialog(Syllabus.this);
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
