package com.h2kinfosys.com;

import java.util.ArrayList;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

/*import com.example.h2kinfosys.adapter.ExpAdapter;*/

public class CoursesActivity extends Activity {
	private ExpandableListView expListView = null;
	private String[] groupElement = new String[]{"Quality Assurance (QA)",
			"Business/Systems Analysis (BA)","Advanced QTP","Java/J2EE","Microsoft .Net",
			"Business Objects (BO)","Informatica","LoadRunner - Advanced",
			"Oracle DBA","Oracle Data Guard","Oracle RAC","SQL Server DBA","Ruby / Rails/ Watir / Selenium",
			"SAP - Human Resource","Manual Testing","ETL Testing Training",
			"WebServices / Soap UI Testing Training","SAP Testing Training",
			"Live Project work training for fresh graduates / new to IT field",
			"Mobile Application Testing Training"};
	ArrayList<String> listOfContents = null;
	/*ExpAdapter expAdapter = null;*/
	private ListView listView = null;
	private String[][] childElement = new String[15][];
	
	public void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);

		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.courses);
		
				
				listView = (ListView)findViewById(R.id.ListView);
			
				addListener();
				
				addListener();
				
				
				listView.setAdapter(new MyAdapter());
				listView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int groupPosition, long arg3) {
						// TODO Auto-generated method stub
						content(groupPosition);
						Intent intent = new Intent(CoursesActivity.this,CoursesDetails.class);
						intent.putExtra("name", groupElement[groupPosition]);
						intent.putExtra("groupPosition",groupPosition);
						intent.putExtra("content", listOfContents);
						startActivity(intent);
					}
				});
			}
	
	class MyAdapter extends BaseAdapter 
	{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return groupElement.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return groupElement[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parentView) {
			// TODO Auto-generated method stub
			
			 LayoutInflater inflater  =  (LayoutInflater) CoursesActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			    convertView = inflater.inflate(R.layout.custom_blogs, null);
			  
			    
			    TextView textName = (TextView)convertView.findViewById(R.id.tvBlog);
			    textName.setText(groupElement[position]);
			   
			    return convertView;
			    
			
		}
		
	}
			
			public void addListener()
			{
				findViewById(R.id.ivBack).setOnClickListener(new OnClickListener(){
				public void onClick(View view)
				{
					finish();
				}
				});

				findViewById(R.id.ivHome).setOnClickListener(new OnClickListener(){
				public void onClick(View view)
				{
					Intent intent = new Intent(CoursesActivity.this,H2kinfosys.class);
					startActivity(intent);
				}
				});

					
			}
			
			
				
	
			public void content(int gp)
			{
				listOfContents = new ArrayList<String>();
				switch(gp)
				{
				case 0:listOfContents.add("QA Online Training by Software Testing Professional from H2Kinfosys with live projects and job placement assistance. The Real reward is making H2Kinfosys Students Happy by providing best hands on Software Testing Training.");
				listOfContents.add("The real world competition pushes H2K to innovate new methods and processes in Quality Assurance (QA) towards training improvements.");
				listOfContents.add(" It keeps us focused on delivering only the best knowledgeable student in multiple skills in QA Testing to compete with others to successfully find a job. Competition drives H2Kinfosys to lead the way with forward thinking green initiatives.");
				break;
				
				case 1:listOfContents.add("Business Analysis Training Online and Onsite Training Placement by BA experienced professionals with real time scenarios. Business Analyst (BA) Online Training is live LED face to face classes with latest updates in BA, ");
				listOfContents.add("recorded videos of daily sessions, Resume preparation, mock interview sessions, BA Job placement assistance and without paying again you can update your Business Analyst (BA) skills at any time after you completion of your course.");
				break;
				
				case 2:listOfContents.add("Quick Test Professional (QTP) Automation Online Training and Onsite Training by QTP Automation Testing experienced professionals with real time scenarios and cloud testing lab 24x7 accesses if required. Basic QTP");
				listOfContents.add("Automation Online Training is live LED face to face classes with latest updates in Quick Test Professional (QTP) Automation, recorded videos of daily ");
				listOfContents.add("sessions, Resume preparation, mock interview sessions, Job placement assistance and without paying again you can update your Quick Test Professional (QTP) Automation Technical skills at any time after you completion of your course.");
				break;
				
				case 3:listOfContents.add("Java / J2EE Online Training and Onsite Training Placement by Java experienced professionals with real time scenarios. Advanced Java Online Training is live LED face to face classes with latest");
				listOfContents.add(" updates in Java Technology, recorded videos of daily sessions, Resume preparation, mock interview sessions, Job placement assistance and without paying again you can update your Java Technical skills at any time after you completion of your course.");
				break;
				
				case 4:listOfContents.add(".NET Online Training and Onsite Training by experienced professionals with real time scenarios and cloud testing lab 24x7 accesses if required. MICROSOFT .NET Online Training is live LED");
				listOfContents.add(" face to face classes with latest updates in MICROSOFT .NET, recorded videos of daily sessions, Resume preparation, mock interview sessions,");
				listOfContents.add("Job placement assistance and without paying again you can update your MICROSOFT .NET Technical skills at any time after you completion of your course.");
				break;
				
				case 5:listOfContents.add("Business Objects (BO) Online Training and Onsite Training by experienced SAP professionals with real time scenarios and cloud testing lab 24x7 accesses if required. ");
				listOfContents.add("Business Objects (BO) Online Training is live LED face to face classes with latest updates in Business Objects (BO), recorded videos of daily sessions, ");
				listOfContents.add(" Resume preparation, mock interview sessions, Job placement assistance and without paying again you can update your Business Objects (BO) Technical skills at any time after you completion of your course.");
				break;
				
				case 6:listOfContents.add("Informatica Online Training and Onsite Training by Informatica experienced professionals with real time scenarios and cloud testing lab 24x7 accesses if required.");
				listOfContents.add("Informatica Online Training is live LED face to face classes with latest updates in Business Objects (BO), recorded videos of daily sessions, Resume preparation, mock interview sessions, Job placement assistance ");
				listOfContents.add(" and without paying again you can update your Informatica Technical skills at any time after you completion of your course.");
			
				break;
				
				case 7:listOfContents.add("LoadRunner is an automated load testing tool that allows you to test the performance/load of the application before, during, and after deployment. ");
				listOfContents.add("This course is designed to give you a foundation in load testing tasks. The LoadRunner Virtual User Generator (VUGen), Controller and Analysis (Report tool) will be covered in this course. ");
				listOfContents.add(" You will create VUGen script to create scenarios and run load test scenarios using the Controller. The Analysis is used to analyze load test results. ");
				listOfContents.add("You will learn to work with the graphs to display data after a test is run. All topics are supported by hands-on labs designed to provide you with the knowledge necessary to load test the system using LoadRunner. You also practice on the LoadRunner to get hands on experience.");
				
				break;
				
				case 8:listOfContents.add("Oracle DBA Online Training and Onsite Training by experienced Oracle professionals with real time scenarios and cloud testing lab 24x7 accesses if required.");
				listOfContents.add(" Oracle DBA Online Training is live LED face to face classes with latest updates in Oracle DBA, Oracle 11g and etc, recorded videos of daily sessions, Resume preparation, mock interview sessions, Job placement assistance ");
				listOfContents.add("and without paying again you can update your Oracle DBA Technical skills at any time after you completion of your course.");
				
				break;
				
				case 9:listOfContents.add("Oracle DATA GUARD Online Training and Onsite Training by experienced Oracle professionals with real time scenarios and cloud testing lab 24x7 accesses if required. ");
				listOfContents.add(". Oracle DATA GUARD Online Training is live LED face to face classes with latest updates in Oracle DATA GUARD, Oracle 11g and etc, recorded videos of daily sessions, Resume preparation, mock interview sessions, ");
				listOfContents.add("Job placement assistance and without paying again you can update your Oracle DATA GUARD Technical skills at any time after you completion of your course.");
				break;
				
				case 10:listOfContents.add("This course offers students an introduction to the general features and capabilities of Oracle Database 10g Release 2 for Oracle Real Application Clusters (RAC). ");
				listOfContents.add(" Students learn how to install and administer Oracle Clusterware, Real Application Clusters, and Automatic Storage Management. Students also learn how to administer their Database in a Real Application Clusters environment using Enterprise Manager Grid Control.");
				listOfContents.add("Increase your efficiency by learning how to configure and use database services as well as the Load Balancing Advisory in a RAC environment. Learn how to add and remove nodes in clusters and how to patch both Oracle Clusterware and Real Application Clusters software in a rolling fashion.");
				
				break;
				
				case 11:listOfContents.add("SQL Server DBA Online Training and Onsite Training by experienced SQL Server professionals with real time scenarios and cloud testing lab 24x7 accesses if required. ");
				listOfContents.add(". SQL Server DBA Online Training is live LED face to face classes with latest updates in SQL Server DBA etc, recorded videos of daily sessions, Resume preparation, mock interview sessions, Job placement assistance ");
				listOfContents.add("and without paying again you can update your SQL Server DBA Technical skills at any time after you completion of your course.");
				break;
			
				case 12:listOfContents.add("Ruby Rails Watir Selenium Online Training and Onsite Training by experienced professionals with real time scenarios and cloud testing lab 24x7 accesses if required.");
				listOfContents.add(" Ruby Rails, Watir and SeleniumOnline Training is live LED face to face classes with latest updates in Ruby Rails, Watir and Selenium, recorded videos of daily sessions, Resume preparation, mock interview sessions, Job placement assistance ");
				listOfContents.add("and without paying again you can update your Ruby Rails, Watir and Selenium Technical skills at any time after you completion of your course.");
				break;
				
				case 13:listOfContents.add("SAP HR Online Training and Onsite Training by experienced professionals with real time scenarios and cloud testing lab 24x7 accesses if required. ");
				listOfContents.add("SAP HR Online Training is live LED face to face classes with latest updates in SAP HR, recorded videos of daily sessions, Resume preparation, mock interview sessions, Job placement assistance and without paying again you can update your SAP HR Technical skills at any time after you completion of your course.");
				
				break;
				
				case 14:listOfContents.add("Manual Testing Online Training and Onsite Training by QA Testing experienced professionals with real time scenarios and cloud testing lab 24x7 access if required.");
				listOfContents.add("Manual Testing Online Training is live LED face to face classes with latest updates in Testing, recorded videos of daily sessions, professional resume preparation, mock interview sessions, Job placement assistance ");
				listOfContents.add("and without paying again you can update your Manual Testing Technical skills at any time after you completion of your course.");
				break;
				
				case 15:listOfContents.add("ETL- Extract, Load, Transform – as the name implies is all the processes and technologies that revolve around finding the data, formatting it as needed and loading it to the relevant database systems for retrieval and usage. Data’s importance and its key role in the current day’s market is no secret. It is extremely important more than before to make sure that the ETL processes around the data are reliable, accurate and productive in order to ensure that the Business intelligence and data warehouse systems are everything they are supposed to be.");
				listOfContents.add("ETL Testers are on constant demand in the industry. However, for ETL testers not only is it a challenging and lucrative position- it is a role that comes with lots of responsibility and need for expertise.");
				listOfContents.add("Our course can help you gain that expertise from experienced and passionate teachers.");
				break;
				
				case 16:listOfContents.add("Manual Testing Online Training and Onsite Training by QA Testing experienced professionals with real time scenarios and cloud testing lab 24x7 access if required.");
				listOfContents.add("Manual Testing Online Training is live LED face to face classes with latest updates in Testing, recorded videos of daily sessions, professional resume preparation, mock interview sessions, Job placement assistance ");
				listOfContents.add("and without paying again you can update your Manual Testing Technical skills at any time after you completion of your course.");
				break;
				
				case 17:listOfContents.add("Manual Testing Online Training and Onsite Training by QA Testing experienced professionals with real time scenarios and cloud testing lab 24x7 access if required.");
				listOfContents.add("Manual Testing Online Training is live LED face to face classes with latest updates in Testing, recorded videos of daily sessions, professional resume preparation, mock interview sessions, Job placement assistance ");
				listOfContents.add("and without paying again you can update your Manual Testing Technical skills at any time after you completion of your course.");
				break;
				
				case 18:listOfContents.add("Manual Testing Online Training and Onsite Training by QA Testing experienced professionals with real time scenarios and cloud testing lab 24x7 access if required.");
				listOfContents.add("Manual Testing Online Training is live LED face to face classes with latest updates in Testing, recorded videos of daily sessions, professional resume preparation, mock interview sessions, Job placement assistance ");
				listOfContents.add("and without paying again you can update your Manual Testing Technical skills at any time after you completion of your course.");
				break;
				
				case 19:listOfContents.add("We all have the iPhones, androids buzzing in our hands all the time. Did you ever wonder what happens if mobile phones or the apps stop working for 10 minutes? Chaos prevails. The world will come to a standstill. This is what the mobile testers are working to avoid. They test all the phones, the apps, the websites before we use them. All testing before the apps make our life simpler by the minute. Now you know the importance of Mobile apps testing. You want to learn how it is done? Here is the opportunity. H2K Infosys is conducting Mobile apps testing training for iPhone and Android mobile phones. Join the community of mobile testers in making users’ life much simpler.");
				listOfContents.add("Why Mobile Testing Training?" +
						"You already know why mobile testing training in iPhone and Android is needed for the consumers. You should also know why the companies are investing such amounts in mobile testing. In this world of cut throat competition, there is no time for waiting or wasting time. If the phone is not good looking, the OS is not fast enough, the apps are not new enough, the users go to a different provider. No wasting time. So the mobile phone companies and the service providers are constantly pushing the products to the best on the market. So, Mobile and apps testing is the fastest growing testing field.");
				listOfContents.add("Mobile apps testing training:" +
						"There is not much to explain what Mobile apps testing training. It is simply testing the mobile apps before they are made available for the users. But you need to know that there are three parts in this. Device testing, OS testing, Website testing. You need to test if the device is working properly, test OS if it is fast enough and stable enough and test the websites if they are built perfectly to operate in the mobiles and all the functionalities are working in it. It is technically like all other kinds of testing.  It has functional testing, performance testing, load testing etc. There are also tools available to automate the testing. The talented and the experienced tutors at H2K will teach you all about mobile testing and the tools you need for mobile testing.");
				break;
				}
			}
			@Override
			public void onDestroy()
			{
				super.onDestroy();
				System.gc();
				
			}	
	}


