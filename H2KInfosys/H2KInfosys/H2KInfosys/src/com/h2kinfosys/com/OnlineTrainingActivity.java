package com.h2kinfosys.com;



import javabeans.UserDetails;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class OnlineTrainingActivity extends Activity{
	private EditText  etFullName,etEmail,etPhone,etCountry,etMessage;
	private Button btnSubmit;
	private Spinner spiFromWhere;
	private UserDetails userDetails = null;
	boolean b = false;
    String msg = null;
    public static final int SHORT_TIME= 500;
	private Spinner spFromWhere  = null;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		 this.requestWindowFeature(Window.FEATURE_NO_TITLE);
			this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
	
			getWindow().setSoftInputMode(
					WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
//					              InputMethodManager imm = (InputMethodManager)
					getSystemService(Context.INPUT_METHOD_SERVICE);
//					              imm.hideSoftInputFromInputMethod(null, 0);
			
			setContentView(R.layout.online_training);
		initialization();
		addListener();
		
	}
	
	public void initialization()
	{
		etFullName = (EditText)findViewById(R.id.etFullName);
		etEmail = (EditText)findViewById(R.id.etEmail);
		etPhone = (EditText)findViewById(R.id.etPhone);
		etCountry = (EditText)findViewById(R.id.etCountry);
		etMessage = (EditText)findViewById(R.id.etMessage);
		btnSubmit = (Button)findViewById(R.id.btnSubmit);
	}
	
	public void addListener()
	{
		
		findViewById(R.id.ivBack).setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				OnlineTrainingActivity.this.finish();
			}
		});
		
		findViewById(R.id.ivHome).setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				Intent intent = new Intent(OnlineTrainingActivity.this,H2kinfosys.class);
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
