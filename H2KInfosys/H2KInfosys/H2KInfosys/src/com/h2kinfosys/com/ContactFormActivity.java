package com.h2kinfosys.com;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class ContactFormActivity extends Activity{

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
//				              InputMethodManager imm = (InputMethodManager)
				getSystemService(Context.INPUT_METHOD_SERVICE);
//				              imm.hideSoftInputFromInputMethod(null, 0);
		setContentView(R.layout.contact_submit_form);
		addListener();
		
	}
	public void addListener()
	{
		((ImageView)findViewById(R.id.ivBack)).setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				ContactFormActivity.this.finish();
			}
			
		});
		

		((ImageView)findViewById(R.id.ivHome)).setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				Intent intent = new Intent(ContactFormActivity.this,H2kinfosys.class);
				startActivity(intent);
			}
			
		});
	}
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		System.gc();
		
	}
}
