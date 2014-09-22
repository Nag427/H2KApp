package com.h2kinfosys.com;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class SoftwareDevelopment extends Activity{

	private WebView webView = null;
	private String link = null;
	private ImageView ivBack,ivHome = null;
	private TextView tvHeading = null;
	private final String jobUrl = "http://www.h2kinfosys.com/courses";
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.software_development);
		tvHeading = (TextView)findViewById(R.id.tvHeading);

		webView = (WebView)findViewById(R.id.webView);
		webView.setWebViewClient(new myWebClient());
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl(jobUrl);
		init();
	}

	 public class myWebClient extends WebViewClient
	    {
	        @Override
	        public void onPageStarted(WebView view, String url, Bitmap favicon) {
	            // TODO Auto-generated method stub
	            super.onPageStarted(view, url, favicon);
	        }
	 
	        @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            // TODO Auto-generated method stub
	 
	            view.loadUrl(url);
	            return true;
	 
	        }
	    }

	 public void init()
	 {
		 ((ImageView)findViewById(R.id.ivBack)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		 
		 ((ImageView)findViewById(R.id.ivHome)).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(SoftwareDevelopment.this,H2kinfosys.class);
					startActivity(intent);
				}
			});
	 }
}
