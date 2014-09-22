package com.h2kinfosys.com;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;


public class PlayVideo extends Activity {
	private WebView webView = null;
	private String link = null;
	private ImageView ivBack,ivHome = null;
	private ProgressDialog pd = null;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.web_view);
		link = (String)getIntent().getExtras().get("link");
		webView = (WebView)findViewById(R.id.webView);
		
		webView. getSettings().setPluginsEnabled (true);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setAllowFileAccess(true);
		 webView.getSettings().setSupportZoom(true);
		    webView.getSettings().setBuiltInZoomControls(true);
		    webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
		    webView.getSettings().setLoadWithOverviewMode(true);
		    webView.getSettings().setUseWideViewPort(true);
		 webView.setWebChromeClient(new WebChromeClient() {
	            public void onProgressChanged(WebView view, int progress)
	            {
	            	PlayVideo.this.setTitle("Loading...");
	            	PlayVideo.this.setProgress(progress * 100);
	  
	                if(progress == 100)
	                	PlayVideo.this.setTitle(R.string.app_name);
	            }
	        });
		 webView.loadUrl(link);
		 webView.setWebViewClient(new myWebClient());
		
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
	        
            @Override
            public void onPageFinished(WebView view, String url) {
            	
           }
	    }

	 public void init()
	 {
		 ((ImageView)findViewById(R.id.ivBack)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				link = null;
		        webView.goBack();
				finish();
			}
		});
		 
		 ((ImageView)findViewById(R.id.ivHome)).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					  webView.goBack();
					Intent intent = new Intent(PlayVideo.this,H2kinfosys.class);
					startActivity(intent);
				}
			});
	 }
	 
	 public void onDestroy()
	    {
	        super.onDestroy();     
	       
	    }
	 
	 public void loadTask(String msg)
	 {

			pd = new ProgressDialog(PlayVideo.this);
			pd.setMessage(msg);
			pd.setCancelable(true);
			pd.setIndeterminate(false);
			pd.show();
	 }

	 

}
