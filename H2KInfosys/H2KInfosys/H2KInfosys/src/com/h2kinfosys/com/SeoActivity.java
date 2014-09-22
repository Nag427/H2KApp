package com.h2kinfosys.com;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;

/*import com.example.h2kinfosys.adapter.ExpAdapter;*/

public class SeoActivity extends Activity{
	private ExpandableListView expListView = null;
	private String[] groupElement = new String[]{"Website Design","Website Development",
			"Internet Marketing","Web Hosting"};
	
	/*ExpAdapter expAdapter = null;*/
	private String[][] childElement = new String[4][];
		public void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			this.requestWindowFeature(Window.FEATURE_NO_TITLE);
			this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
			setContentView(R.layout.blank);
			/*expListView = (ExpandableListView)findViewById(R.id.expListView);*/
			addListener();
			init();
			/*expAdapter = new ExpAdapter(SeoActivity.this,groupElement,childElement);
			
			expListView.setAdapter(expAdapter);*/
		}
		
		public void addListener()
		{
			findViewById(R.id.ivBack).setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				SeoActivity.this.finish();
			}
			});

			findViewById(R.id.ivHome).setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				Intent intent = new Intent(SeoActivity.this,H2kinfosys.class);
				startActivity(intent);
			}
			});
			findViewById(R.id.btnContactUs).setOnClickListener(new OnClickListener(){
				public void onClick(View view)
				{
					Intent intent = new Intent(SeoActivity.this,ContactFormActivity.class);
					startActivity(intent);
				}
				});;
		}
			
		public void init()
		{
			childElement[0] = new String[]{"Static Web Design","CMS Website Design","Website Redesign / Maintenance",
					"Website Maintenance","Flash Intro / Presentation","Web Template Design"};
			childElement[1]  = new String[]{"eCommerce Website Development",
					"Web Application Development","Web Portal Development",
					"Social Networking Sites"};
			childElement[2] = new String[]{"Search Engine Optimization","Social Media Optimization"};
			
			childElement[3] = new String[]{"Website Hosting","Domain Name Registration","Google Apps Configuration"};
			
		}
}
