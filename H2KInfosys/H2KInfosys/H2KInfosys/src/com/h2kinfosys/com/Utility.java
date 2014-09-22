package com.h2kinfosys.com;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.util.Log;

public class Utility {
	public static boolean isOnline(Context ctx) 
	{
		boolean isConnected = false;
		try
		{
			ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
			isConnected = cm.getActiveNetworkInfo().isConnectedOrConnecting();
		}
		catch(Exception ex)
		{
			isConnected = false;
		}
		return isConnected;
	}
	public static InputStream connect(String url)
    {
		String xml = null;
		InputStream in = null;
		try
		{
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
					
				HttpEntity httpEntity = response.getEntity();
			
				
					in = entity.getContent();
			}
			
		}catch (Exception e) {e.printStackTrace();}
		
		return in;
     }
	public static Bitmap getImageBitmap(URL url) {
		Bitmap bitmap = null;
		URLConnection connection = null;
		try {
			connection = url.openConnection();
		} catch (IOException e1) {e1.printStackTrace();}
		try {
			connection.connect();
		} catch (IOException e1) {e1.printStackTrace();}
		InputStream is = null;
		try {
			is = connection.getInputStream();
		} catch (IOException e1) {e1.printStackTrace();}
		BufferedInputStream bis = new BufferedInputStream(is);
		
		try{
			bitmap = BitmapFactory.decodeStream(bis);
		}catch (OutOfMemoryError e) {bitmap = null;}
		bis = null;
		is = null;
		Runtime.getRuntime().gc();
	return bitmap;
 }
}
