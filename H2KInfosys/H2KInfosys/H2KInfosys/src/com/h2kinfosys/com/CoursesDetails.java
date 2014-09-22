package com.h2kinfosys.com;

import java.util.ArrayList;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class CoursesDetails extends Activity {
	private TextView tvName = null;
	private LinearLayout layoutContent = null;
	private String name = null;
	private Button btnCoursesHighlights,btnSyllabus = null;
	private ArrayList<String> courseHighlightsGp1 = null;
	private ArrayList<String> courseContentGp1 = null;
	
	private ArrayList<String> courseHighlightsGp2 = null;
	private ArrayList<String> courseContentGp2 = null;
	
	private ArrayList<String> courseHighlightsGp3 = null;
	private ArrayList<String> courseContentGp3 = null;
	
	private ArrayList<String> courseHighlightsGp4 = null;
	private ArrayList<String> courseContentGp4 = null;
	
	private ArrayList<String> courseHighlightsGp5 = null;
	private ArrayList<String> courseContentGp5 = null;
	
	private ArrayList<String> courseHighlightsGp6 = null;
	private ArrayList<String> courseContentGp6 = null;
	
	private ArrayList<String> courseHighlightsGp7 = null;
	private ArrayList<String> courseContentGp7 = null;
	
	private ArrayList<String> courseHighlightsGp8 = null;
	private ArrayList<String> courseContentGp8 = null;
	
	private ArrayList<String> courseHighlightsGp9 = null;
	private ArrayList<String> courseContentGp9 = null;
	
	private ArrayList<String> courseHighlightsGp10 = null;
	private ArrayList<String> courseContentGp10 = null;
	
	private ArrayList<String> courseHighlightsGp11 = null;
	private ArrayList<String> courseContentGp11 = null;
	
	private ArrayList<String> courseHighlightsGp12 = null;
	private ArrayList<String> courseContentGp12 = null;
	
	private ArrayList<String> courseHighlightsGp13 = null;
	private ArrayList<String> courseContentGp13 = null;
	
	private ArrayList<String> courseHighlightsGp14 = null;
	private ArrayList<String> courseContentGp14 = null;
	
	private ArrayList<String> courseHighlightsGp15 = null;
	private ArrayList<String> courseContentGp15 = null;
	
	
	private ArrayList<String> courseHighlightsGp16 = null;
	private ArrayList<String> courseContentGp16 = null;
	
	private ArrayList<String> courseHighlightsGp17 = null;
	private ArrayList<String> courseContentGp17 = null;
	
	private ArrayList<String> courseHighlightsGp18 = null;
	private ArrayList<String> courseContentGp18 = null;
	
	private ArrayList<String> courseHighlightsGp19 = null;
	private ArrayList<String> courseContentGp19 = null;
	
	private ArrayList<String> courseHighlightsGp20 = null;
	private ArrayList<String> courseContentGp20 = null;
	
	
	private ArrayList<String> content = null;
	private ArrayList<String> session1 = null;
	private ArrayList<String> session2 = null;
	private ArrayList<String> session3 = null;
	private ArrayList<String> session4 = null;
	private ArrayList<String> session5 = null;
	private ArrayList<String> session6 = null;
	private ArrayList<String> session7 = null;
	
	private ArrayList<String> session8 = null;
	private ArrayList<String> session9 = null;
	private ArrayList<String> session10 = null;
	private ArrayList<String> session11 = null;
	private ArrayList<String> session12 = null;
	private ArrayList<String> session13 = null;
	private ArrayList<String> session14 = null;
	private ArrayList<String> session15 = null;
	private ArrayList<String> session16 = null;
	private ArrayList<String> session17 = null;
	private ArrayList<String> session18 = null;
	private ArrayList<String> session19 = null;
	private ArrayList<String> session20 = null;
	private ArrayList<String> session21 = null;
	private ArrayList<String> session22 = null;
	private ArrayList<String> session23 = null;
	private ArrayList<String> session24 = null;
	
	
	private ArrayList<String> loadMore = new ArrayList<String>();
	private int gp = 0;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.courses_details);
		name = (String)(getIntent().getExtras()).get("name");
		gp = (Integer)(getIntent().getExtras()).get("groupPosition");
		Log.i("gp position ",""+gp);
		content = (ArrayList)(getIntent().getExtras()).get("content");
		
		init();
	}
	public void init()
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
				Intent intent = new Intent(CoursesDetails.this,H2kinfosys.class);
				startActivity(intent);
			}
			});
			
			findViewById(R.id.btnDemo).setOnClickListener(new OnClickListener(){
				public void onClick(View view)
				{
					Intent intent = new Intent(CoursesDetails.this,ContactFormActivity.class);
					startActivity(intent);
				}
				});

			
			
		tvName = (TextView)findViewById(R.id.tvName);
		tvName.setText(name+" | "+name+" Training Quality Assurance Training");
		
		 ((TextView)findViewById(R.id.tvHeading)).setText(name);
		
		 layoutContent = (LinearLayout)findViewById(R.id.layoutContent);
		 TextView tvContent = null;
		 LinearLayout.LayoutParams lparams = null;
		for(int i=0 ;i != content.size();i++)
		{
			tvContent = new TextView(getApplicationContext());
			lparams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
			tvContent.setLayoutParams(lparams);
			tvContent.setText(content.get(i));
			tvContent.setTextColor(Color.BLACK);
			layoutContent.addView(tvContent);
			tvContent = null;
		}
		
		btnCoursesHighlights = (Button)findViewById(R.id.btnCourseHighlights);
		btnSyllabus = (Button)findViewById(R.id.btnSyllabus);
		
		btnSyllabus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(CoursesDetails.this,Syllabus.class);
				intent.putExtra("gp",gp);
				intent.putExtra("name",name);
				startActivity(intent);
			}
		});
		
		btnCoursesHighlights.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(gp == 0)
				{
					coursesHighlightsAndSyllabusForGp1();
				Intent intent = new Intent(getApplicationContext(),CoursesHighlights.class);
				intent.putExtra("courseHighlightsGp", courseHighlightsGp1);
				intent.putExtra("courseContentGp", courseContentGp1);
				intent.putExtra("name",name);
				startActivity(intent);
				}
				else if(gp == 1)
				{
					coursesHighlightsAndSyllabusForGp2();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlights.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp2);
					intent.putExtra("courseContentGp", courseContentGp2);
					intent.putExtra("name",name);
					startActivity(intent);
				}
				else if(gp == 2)
				{
					coursesHighlightsAndSyllabusForGp3();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlightsOther.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp3);
					intent.putExtra("courseContentGp", courseContentGp3);
					intent.putExtra("name",name);
					startActivity(intent);
				}
				else if(gp == 3)
				{
					coursesHighlightsAndSyllabusForGp4();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlights.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp4);
					intent.putExtra("courseContentGp", courseContentGp4);
					intent.putExtra("name",name);
					startActivity(intent);
				}
				else if(gp == 4)
				{
					coursesHighlightsAndSyllabusForGp5();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlightsOther.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp5);
					intent.putExtra("courseContentGp", courseContentGp5);
					intent.putExtra("name",name);
					startActivity(intent);
				}
				else if(gp == 5)
				{
					coursesHighlightsAndSyllabusForGp6();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlightsOther.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp6);
					intent.putExtra("courseContentGp", courseContentGp6);
					intent.putExtra("name",name);
					startActivity(intent);
				}
				else if(gp == 6)
				{
					coursesHighlightsAndSyllabusForGp7();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlightsOther.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp7);
					intent.putExtra("courseContentGp", courseContentGp7);
					intent.putExtra("name",name);
					startActivity(intent);
				}
				else if(gp == 7)
				{
					coursesHighlightsAndSyllabusForGp8();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlights.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp8);
					intent.putExtra("courseContentGp", courseContentGp8);
					intent.putExtra("name",name);
					startActivity(intent);
				}
				else if(gp == 8)
				{
					
					coursesHighlightsAndSyllabusForGp9();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlightsOther.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp9);
					intent.putExtra("courseContentGp", courseContentGp9);
					intent.putExtra("name",name);
					startActivity(intent);
				}
				else if(gp == 9)
				{
					coursesHighlightsAndSyllabusForGp10();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlightsOther.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp10);
					intent.putExtra("courseContentGp", courseContentGp10);
					intent.putExtra("name",name);
					startActivity(intent);
				}
				else if(gp == 10)
				{
					coursesHighlightsAndSyllabusForGp11();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlights.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp11);
					intent.putExtra("courseContentGp", courseContentGp11);
					intent.putExtra("name",name);
					startActivity(intent);
				}
				else if(gp == 11)
				{
					coursesHighlightsAndSyllabusForGp12();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlightsOther.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp12);
					intent.putExtra("courseContentGp", courseContentGp12);
					intent.putExtra("name",name);
					startActivity(intent);
				}
				else if(gp == 12)
				{
					coursesHighlightsAndSyllabusForGp13();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlights.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp13);
					intent.putExtra("courseContentGp", courseContentGp13);
					intent.putExtra("name",name);
					startActivity(intent);
				}
				else if(gp == 13)
				{
					coursesHighlightsAndSyllabusForGp14();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlights.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp14);
					intent.putExtra("courseContentGp", courseContentGp14);
					intent.putExtra("name",name);
					startActivity(intent);
				}
				else if(gp == 14)
				{
					coursesHighlightsAndSyllabusForGp15();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlights.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp15);
					intent.putExtra("courseContentGp", courseContentGp15);
					intent.putExtra("name",name);
					startActivity(intent);
				}
				else if(gp == 15)
				{
					coursesHighlightsAndSyllabusForGp16();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlights.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp16);
					intent.putExtra("courseContentGp", courseContentGp16);
					intent.putExtra("name",name);
					startActivity(intent);
				}
				else if(gp == 16)
				{
					coursesHighlightsAndSyllabusForGp17();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlights.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp17);
					intent.putExtra("courseContentGp", courseContentGp17);
					intent.putExtra("name",name);
					startActivity(intent);
				}
				else if(gp == 17)
				{
					coursesHighlightsAndSyllabusForGp18();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlights.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp18);
					intent.putExtra("courseContentGp", courseContentGp18);
					intent.putExtra("name",name);
					startActivity(intent);
				}
				else if(gp == 18)
				{
					coursesHighlightsAndSyllabusForGp19();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlights.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp19);
					intent.putExtra("courseContentGp", courseContentGp19);
					intent.putExtra("name",name);
					startActivity(intent);
				}
				else if(gp == 19)
				{
					coursesHighlightsAndSyllabusForGp20();
					Intent intent = new Intent(getApplicationContext(),CoursesHighlights.class);
					intent.putExtra("courseHighlightsGp", courseHighlightsGp20);
					intent.putExtra("courseContentGp", courseContentGp20);
					intent.putExtra("name",name);
					startActivity(intent);
				}
			}
		});
		
		
	}

	public void coursesHighlightsAndSyllabusForGp1()
	{
		courseHighlightsGp1 = new ArrayList<String>();
		courseHighlightsGp1.add("Module 1:");
		courseHighlightsGp1.add("Module 2:");
		courseHighlightsGp1.add("Module 3:");
		courseHighlightsGp1.add("Module 4:");
		courseHighlightsGp1.add("Module 5:");
		courseHighlightsGp1.add("Module 6:");
		courseHighlightsGp1.add("Module 7:");
		courseHighlightsGp1.add("Module 8:");
		courseHighlightsGp1.add("Module 9:");
		courseHighlightsGp1.add("Module 10:");
		courseHighlightsGp1.add("Module 11:");
		courseHighlightsGp1.add("Module 12:");
	
		
		loadMore.add("Manual Testing");
		loadMore.add("Software Testing Life Cycle - SDLC - Waterfall vs. Agile");
		loadMore.add("QA Tester Role - Test Metrics - Types of Testing");
		loadMore.add("Software Testing Life Cycle - STLC & Defect Life Cycle");
		loadMore.add("Testing Methodologies, Software Testing process");
		loadMore.add("Test case, Test plan, RTM, Defect tracking");
		loadMore.add("Home works / Off line student assignments.");
		loadMore.add("Telecom, Banking, HealthCare, Supply chain domains.");
		loadMore.add("Role of QA, BA, Developer, Technical Architects etc.");
		
		courseContentGp1 = new ArrayList<String>();
		courseContentGp1.add("Manual Testing"+"\n"+"Software Testing Life Cycle - SDLC - Waterfall vs. Agile \n QA Tester Role - Test Metrics - Types of Testing" );
		courseContentGp1.add("HP Quality Center - ALM for Test management/ Defect Tracking");
		courseContentGp1.add("SQL (Database / Back End Testing)");
		courseContentGp1.add("UNIX / Linux Operating System / Backend Testing");
		courseContentGp1.add("HP QTP (Quick Test Professional) for Automation Testing");
		courseContentGp1.add("HP Loadrunner for Performance Testing");
		courseContentGp1.add("Review & questions on all topics, Configuration Management, CMMI, Six Sigma principles, Regulatory compliance, Requirement (e.g. Sarbanes Oxley, HIPPA-Medical related), Interview Questions. How to prepare professional resume?");
		courseContentGp1.add("IBM Mainframe Testing");
		courseContentGp1.add("SAP Testing (Sales & Distribution (SD), Production Planning or CRM Or any one of the SAP)");
		courseContentGp1.add("WebServices (SOA) Testing using SoapUI tool");
		courseContentGp1.add("Concepts of what is ETL and Data warehouse Testing");
		courseContentGp1.add("IBM Rational Quality Manager (RQM) Tool (It was Rational Test Manager)");
		
		
		
	}
	public void syllabusOne()
	{
		session1 = new ArrayList<String>();
		session1.add("Telecom Domain Project");
		session1.add("Application / Project Architecture");
		session1.add("Understanding SRS - Software Requirement Specification Document \nBRD - Business Requirement Document \nFRD - Functional Requirement Document \n SDLC - Software Development Life Cycle \nWaterfall, Agile, SCRUM, Sprint, User Stories etc. \n Introduction to software Quality Analysis & Testing, Role of a Tester");
		session1.add("Why QA team is required. Testing Process(STLC), test cases, Test Data \nTypes of software Applications, Windows based, web based etc.\n Different types of testing methodologies \n Practice - Group Discussion");
		
		
		session2 = new ArrayList<String>();
		session2.add("Types of Testing, Unit testing, functional testing, integration test, Regression Test, System Testing, Smoke Testing, Data Driven Testing");
		session2.add("Black Box Testing and White Box testing, UAT testing");
		session2.add("Smoke Testing, Sanity Testing, Backend Testing, Data Driven Testing. \nBrowser compatibility Testing, External Interface Testing and \nFunctional Testing, Integration Testing, Unit Testing, HA Testing, Security Testing, Cross browser testing,  \nManual Testing, Automation Testing and Performance Testing. \nValidation vs Verification");
		session2.add("Few more types of testing types will be discussed based on the topics we discuss in this course. \nFor example, while teaching QTP - Automation Testing, we can discuss about Data Driven Testing. \nThis can be done manually also but when we discuss while doing Automation testing with multiple sets of Data, you can understand more detailed way. \nWhile Teaching �LoadRunner� we discuss different type of Performance Testing types like Stress test, Load Test etc");
		session2.add("session2");
		
		session3 = new ArrayList<String>();
		session3.add("QA Tester Role - Software Testing Life Cycle \nUnderstanding the requirement document and writing Test cases in Excel, Writing Test Data \nHome Assignments and also Practice sessions in class. \nPractice - Group Discussion , Domain related discussion on Banking, Mobile/Telecom, Supply chain, Healthcare");
		
		session4 = new ArrayList<String>();
		session4.add("How to write Test Cases on Telecom, Health care projects, Prepare RTM and test matrices \nBoundary Value analysis. \nReview Test cases written by students.");
		
		session5 = new ArrayList<String>();
		session5.add("How to write Test Plan >> Objective, Scope and Strategy of the test plan \nEntry and Exit criteria. Testing Techniques. \nHome Assignments and also Practice sessions in class.");
		
		session6 = new ArrayList<String>();
		session6.add("Review Test Plan and Test cases.  \nDiscuss Defect Life Cycle while teaching Quality center Defect module \nWhat is clustering, Load Balancer, Front end, Back End, Middle ware, etc.. about Project and Application architecture, External Systems etc. \nHigh Availability / Clustering - HA Testing (other training centers do not cover this topic)");
	}
	
	public void coursesHighlightsAndSyllabusForGp2()
	{
		courseHighlightsGp2 = new ArrayList<String>();
		courseHighlightsGp2.add("Module 1:");
		courseHighlightsGp2.add("Module 2:");
		courseHighlightsGp2.add("Module 3:");
		courseHighlightsGp2.add("Module 4:");
		courseHighlightsGp2.add("Module 5:");
		courseHighlightsGp2.add("Module 6:");
		courseHighlightsGp2.add("Module 7:");
		courseHighlightsGp2.add("Module 8:");
		courseHighlightsGp2.add("Module 9:");
		courseHighlightsGp2.add("Module 10:");
		courseHighlightsGp2.add("Module 11:");
		courseHighlightsGp2.add("Module 12:");
		courseHighlightsGp2.add("Module 13:");
		courseHighlightsGp2.add("Module 14:");
		courseHighlightsGp2.add("Module 15:");
		courseHighlightsGp2.add("Module 16:");
		courseHighlightsGp2.add("Module 17:");
		courseHighlightsGp2.add("Module 18:");
		courseHighlightsGp2.add("Module 19:");
		courseHighlightsGp2.add("Module 20:");
		courseHighlightsGp2.add("Module 21:");
		courseHighlightsGp2.add("Module 22:");
		courseHighlightsGp2.add("Module 23:");
		courseHighlightsGp2.add("Module 24:");
		courseHighlightsGp2.add("Module 25:");
		courseHighlightsGp2.add("Module 26:");
		courseHighlightsGp2.add("Module 27:");
		courseHighlightsGp2.add("Module 28:");
		courseHighlightsGp2.add("Module 29:");
		
		
		courseContentGp2 = new ArrayList<String>();
		courseContentGp2.add("Overview of Business Analysis");
		courseContentGp2.add("IT Slang/Jargon/Basic definition of IT");
		courseContentGp2.add("Software Development Life Cycle (SDLC)");
		courseContentGp2.add("SDLC Methodologies");
		courseContentGp2.add("Requirement Gathering Methods");
		courseContentGp2.add("JAD Session");
		courseContentGp2.add("Analysis");
		courseContentGp2.add("UML");
		courseContentGp2.add("Tools");
		courseContentGp2.add("Mock up�s");
		courseContentGp2.add("Documentation");
		courseContentGp2.add("Introduction: Project Management");
		courseContentGp2.add("Project Organization: Project Management");
		courseContentGp2.add("Project Process Group: Project Management");
		courseContentGp2.add("Scope Management: Project Management");
		courseContentGp2.add("Time Management: Project Management");
		courseContentGp2.add("Cost Management: Project Management");
		courseContentGp2.add("Quality Management: Project Management");
		courseContentGp2.add("Human Resource Management: Project Management");
		courseContentGp2.add("Communication Management: Project Management");
		courseContentGp2.add("Risk Management: Project Management");
		courseContentGp2.add("Procurement Management: Project Management");
		courseContentGp2.add("Quality Analysis (QA=Testing concepts, Test Plan, Test case, SQL, UNIX/Linux, HP Quality Center tool)");
		courseContentGp2.add("Relevant Certification");
		courseContentGp2.add("Resume Preparation");
		courseContentGp2.add("Manual Testing, Software Testing Life Cycle � SDLC - Waterfall vs. Agile QA Tester Role - Test Metrics - Types of Testing, Software Testing Life Cycle � STLC &  Defect Life Cycle");
		courseContentGp2.add("HP Quality Center - ALM for Test management/ Defect Tracking");
		courseContentGp2.add("SQL (Database / Back End Testing)");
		courseContentGp2.add("UNIX / Linux Operating System / Backend Testing.");
		
	}
	
	public void coursesHighlightsAndSyllabusForGp3()
	{
		courseHighlightsGp3 = new ArrayList<String>();
		courseHighlightsGp3.add("QTP Course Overview");
		
		courseContentGp3 = new ArrayList<String>();
		courseContentGp3.add("Basic QTP Course Topics");
		courseContentGp3.add("Benefits of Automation");
		courseContentGp3.add("Benefits of Manual testing");
		courseContentGp3.add("Introduction to QTP");
		courseContentGp3.add("Main stages of QTP");
		courseContentGp3.add("Plan / Create / Enhance");
		courseContentGp3.add("Record and playback");
		courseContentGp3.add("How to understand the Results, Report Results");
		courseContentGp3.add("Key word view and expert view etc...");
		courseContentGp3.add("How to understand the VB Script etc. (Discuss more details about VB script in last session of QTP)");
		courseContentGp3.add("Students have to practice above topics then we start the following");
		courseContentGp3.add("SystemUtil.Run() function to bring the application windows or web. Also discuss");
		courseContentGp3.add("About other VB built functions in QTP.");
		courseContentGp3.add("Object Repository (Types of Object Repositories will be discussed)");
		courseContentGp3.add("Parameterization");
		courseContentGp3.add("Data Driven Test");
		courseContentGp3.add("Parameterization");
		courseContentGp3.add("After student practice this, we can explain about how to import the excel");
		courseContentGp3.add("Sheet and read the data from excel sheet.");
		courseContentGp3.add("Data Table - Importing Excel Sheet, Database Connection from QTP");
		courseContentGp3.add("Two types of repository");
		courseContentGp3.add("Synchronization");
		courseContentGp3.add("Check Points: All types of Check points");
		courseContentGp3.add("Actions: Calling actions from the existing actions, splitting actions etc.");
		courseContentGp3.add("Parameterization in actions:");
		courseContentGp3.add("Regular Expressions");
		courseContentGp3.add("After practicing by students, Faculty will start teaching below Topics.");
		courseContentGp3.add("Regular expressions is added while inserting checkpoint for text");
		courseContentGp3.add("How to Enhance the VB Script, write functions and call the function in another script.");
		courseContentGp3.add("Batch Runner");
		courseContentGp3.add("Multiple scripts can be run from batch runner");
		courseContentGp3.add("Connecting QTP with Quality Center. How to integrate Quality center with QTP");
		courseContentGp3.add("Descriptive Programming: VB Scripting");
		courseContentGp3.add("Without recording, how to write the script, how to resolve the run time errors.");
		courseContentGp3.add("QTP Interview Questions.");
	}
	
	public void coursesHighlightsAndSyllabusForGp4()
	{
		courseHighlightsGp4 = new ArrayList<String>();
		courseContentGp4 = new ArrayList<String>();
		
		courseHighlightsGp4.add("Module 1:");
		courseHighlightsGp4.add("Module 2:");
		courseHighlightsGp4.add("Module 3:");
		courseHighlightsGp4.add("Module 4:");
		courseHighlightsGp4.add("Module 5:");
		courseHighlightsGp4.add("Module 6:");
		courseHighlightsGp4.add("Module 7:");
		courseHighlightsGp4.add("Module 8:");
		
		courseContentGp4.add("Core Java, JDBC");
		courseContentGp4.add("J2EE Concepts, Servlets, JSP, EL Expressions");
		courseContentGp4.add("XML, Struts MVC Framework");
		courseContentGp4.add("Hibernate ORM Technology");
		courseContentGp4.add("Spring Framework");
		courseContentGp4.add("Web Services, Design Patterns");
		courseContentGp4.add("JMS, JNDI, EJB, Ant, Ajax");
		courseContentGp4.add("Application Servers, CVS, JUnit");
		
		
	}
	
	public void coursesHighlightsAndSyllabusForGp5()
	{
		courseHighlightsGp5 = new ArrayList<String>();
		courseContentGp5 = new ArrayList<String>();
		
		courseHighlightsGp5.add("MICROSOFT .NET Course Highlights");
		courseContentGp5.add(".NET Overview");
		courseContentGp5.add("C#-THE LANGUAGE");
		courseContentGp5.add("OBJECTS ORIENTED PROGRAMMING");
		courseContentGp5.add("MEMORY MANGEMENT");
		courseContentGp5.add("EXCEPTION HANDLING");
		courseContentGp5.add("GUI APPLICATION DEVELOPMENT");
		courseContentGp5.add("WINDOWS CONTROL LIBRARY");
		courseContentGp5.add("DELEGATES");
		courseContentGp5.add("DATA ACCESS WITH ADO.NET");
		courseContentGp5.add("MULTI THREADING");
		courseContentGp5.add("ASSEMBLIES");
		courseContentGp5.add("WINDOWS SERVICES");
		courseContentGp5.add("MICROSOFT .NET OVERVIEW");
		courseContentGp5.add("INTRODUCTION TO VB.NET");
		courseContentGp5.add("INTRODUCTION TO VISUAL STUDIO .NET VS 6.0 vs. VS .NET");
		courseContentGp5.add("OBJECT ORIENTED PROGRAMMING");
		courseContentGp5.add("GUI APPLICATION DEVELOPMENT");
		courseContentGp5.add("WINDOWS CONTROL LIBRARY");
		courseContentGp5.add("DELEGATES");
		courseContentGp5.add("ASSEMBLIES");
		courseContentGp5.add("DATA ACCESS WITH ADO.NET");
		courseContentGp5.add("MULTI-THREADING");
		courseContentGp5.add("WINDOWS SERVICES");
		courseContentGp5.add("WEB TECHNOLOGIES");
		courseContentGp5.add("ASP.NET");
		courseContentGp5.add("CONTROLS");
		courseContentGp5.add("VALIDATION CONTROL");
		courseContentGp5.add("STATE MANAGEMENT");
		courseContentGp5.add("CACHING");
		courseContentGp5.add("ASP.NET CONFIGERATION");
		courseContentGp5.add("ADO.NET");
		courseContentGp5.add("ASP.NET TRACING");
		courseContentGp5.add("SECURITY IN ASP.NET");
		courseContentGp5.add("XMLPROGRAMMING");
		courseContentGp5.add("WEB SERVICES");
		courseContentGp5.add("CRYSTAL REPORTS");
		courseContentGp5.add("SSRS (SQL Server Reporting Services)");
		courseContentGp5.add("MS-Reports");
		courseContentGp5.add("LINQ: NET Language-Integrated Query");
		courseContentGp5.add("WCF: Windows Communication Foundation");
		courseContentGp5.add("WPF: Windows Presentation Foundation");

		
	}
	public void coursesHighlightsAndSyllabusForGp6()
	{
		courseHighlightsGp6 = new ArrayList<String>();
		courseContentGp6 = new ArrayList<String>();
		courseHighlightsGp6.add("Business Objects Course Training Highlights");
		
		courseContentGp6.add("100% Job Oriented Business Objects (BO) Online Training");
		courseContentGp6.add("Instructor Led - Face2Face True Live Online class");
		courseContentGp6.add("More interaction with student to faculty and student to student.");
		courseContentGp6.add("Detailed presentations. Soft copy of Materiel to refer any time.");
		courseContentGp6.add("Practical oriented / Job oriented Training. Practice on Software Tools & Real Time project scenarios.");
		courseContentGp6.add("Mock interviews / group discussions / interview related questions.");
		courseContentGp6.add("Test Lab is in Cloud Technology - to practice on software tools if needed.");
		courseContentGp6.add("Pay onetime fee & repeat attending classes multiple times until student is comfortable with every topic. This feature is helpful to students who are new to I.T. Field.");
		courseContentGp6.add("We discuss about the real time project domains.");
		courseContentGp6.add("The teaching methods / tools / topics we chosen are based on the current competitive job market.");
		
	}
	public void coursesHighlightsAndSyllabusForGp7()
	{
		courseHighlightsGp7 = new ArrayList<String>();
		courseContentGp7 = new ArrayList<String>();
		courseHighlightsGp7.add("Informatica Training Advantages");
		
		courseContentGp7.add("100% Job Oriented Informatica Training");
		courseContentGp7.add("Instructor Led - Face2Face True Live Online class");
		courseContentGp7.add("More interaction with student to faculty and student to student.");
		courseContentGp7.add("Detailed presentations. Soft copy of Materiel to refer any time.");
		courseContentGp7.add("Practical oriented / Job oriented Training. Practice on Software Tools & Real Time project scenarios.");
		courseContentGp7.add("Mock interviews / group discussions / interview related questions.");
		courseContentGp7.add("Test Lab is in Cloud Technology - to practice on software tools if needed.");
		courseContentGp7.add("Pay onetime fee & repeat attending classes multiple times until student is comfortable with every topic. This feature is helpful to students who are new to I.T. Field.");
		courseContentGp7.add("We discuss about the real time project domains.");
		courseContentGp7.add("The teaching methods / tools / topics we chosen are based on the current competitive job market.");
		
	}
	
	public void coursesHighlightsAndSyllabusForGp8()
	{
		courseHighlightsGp8 = new ArrayList<String>();
		courseContentGp8 = new ArrayList<String>();
		courseHighlightsGp8.add("Module 1:");
		courseHighlightsGp8.add("Module 2:");
		courseHighlightsGp8.add("Module 3:");
		courseHighlightsGp8.add("Module 4:");
		courseHighlightsGp8.add("Module 5:");
		courseHighlightsGp8.add("Module 6:");
		courseHighlightsGp8.add("Module 7:");
		courseHighlightsGp8.add("Module 8:");
		
		
		courseContentGp8.add("Performance Test Plan");
		courseContentGp8.add("LoadRunner - VUGen Scripting");
		courseContentGp8.add("LoadRunner Controller � Scenarios � to run VUGen scripts");
		courseContentGp8.add("LoadRunner � Analysis � to report the results");
		courseContentGp8.add("Performance Monitors");
		courseContentGp8.add("Overview of Site Scope");
		courseContentGp8.add("Overview of Diagnostics");
		courseContentGp8.add("Overview of Performance Center");
		
	}
	public void coursesHighlightsAndSyllabusForGp9()
	{
		courseHighlightsGp9 = new ArrayList<String>();
		courseContentGp9 = new ArrayList<String>();
		courseHighlightsGp9.add("Oracle DBA Course Highlights");
		courseContentGp9.add("Installing the Oracle Database 10g");
		courseContentGp9.add("Creating an Oracle 10g Database");
		courseContentGp9.add("Managing the Oracle Instance");
		courseContentGp9.add("Managing Database Storage");
		courseContentGp9.add("Administering User Security");
		courseContentGp9.add("Managing Schema Objects in Oracle");
		courseContentGp9.add("Managing Undo Data");
		courseContentGp9.add("Configuring the Oracle Network Environment");
		courseContentGp9.add("Proactive Maintenance");
		courseContentGp9.add("Performance Management");
		courseContentGp9.add("Oracle 10g Database Backup");
		courseContentGp9.add("Performing Database Backups");
		courseContentGp9.add("Performing Database Recovery");
		courseContentGp9.add("Performing Flashback");
		courseContentGp9.add("Moving Data");
		courseContentGp9.add("Configuring Recovery Manager");
		courseContentGp9.add("Recovery Manager (RMAN)");
		courseContentGp9.add("Incomplete Recovery");
		courseContentGp9.add("Flashback");
		courseContentGp9.add("Monitoring and Managing Memory");
		courseContentGp9.add("Performance Management");
		courseContentGp9.add("Monitoring and Managing Storage");
		courseContentGp9.add("Automatic Storage Management");
		courseContentGp9.add("Automating Tasks");
		
	}
	
	public void coursesHighlightsAndSyllabusForGp10()
	{
		courseHighlightsGp10 = new ArrayList<String>();
		courseContentGp10 = new ArrayList<String>();
		
		courseHighlightsGp10.add("Oracle DATA GUARD Course Highlights");
		courseContentGp10.add("Use Data Guard to achieve a highly available Oracle Database");
		courseContentGp10.add("Describe the Data Guard architecture");
		courseContentGp10.add("Modify the Data Guard services");
		courseContentGp10.add("Use the Data Guard broker");
		courseContentGp10.add("Implement physical and logical standby databases");
		courseContentGp10.add("Perform failover and switchover operations");
		courseContentGp10.add("Enable fast-start failover");
		
		
	}
	public void coursesHighlightsAndSyllabusForGp11()
	{
		courseHighlightsGp11 = new ArrayList<String>();
		courseContentGp11 = new ArrayList<String>();
		
	
		courseHighlightsGp11.add("Audience:");
		courseHighlightsGp11.add("Prerequisites:");
		courseHighlightsGp11.add("Skills Gained:");
		
		courseContentGp11.add("Data Warehouse Administrator \nDatabase Administrators \nDatabase Designers \nProject Manager \nSupport Engineer \nSystem Analysts \nTechnical Administrator \nTechnical Consultant");
		courseContentGp11.add("Single-instance Oracle Database 10g Architecture and Experience");
		courseContentGp11.add("Identify Real Application Clusters components \nInstall, create, administer, and monitor a Real Application Clusters database \nUse configuration and management tools for Real Application Clusters databases \nSetup services for workloads management, and applications high availability \nDevelop a backup and recovery strategy for Real Application Clusters databases \nConfigure and monitor Oracle Clusterware resources \nReview high availability best practices");
		
	}
	
	public void coursesHighlightsAndSyllabusForGp12()
	{
		courseHighlightsGp12 = new ArrayList<String>();
		courseContentGp12 = new ArrayList<String>();
		courseHighlightsGp12.add("SQL Server DBA Course Highlights");
		courseContentGp12.add("SQL Server 2008 Overview and Installation");
		courseContentGp12.add("Creating and Managing Databases");
		courseContentGp12.add("Creating and Managing Tables and implementing Data Integrity");
		courseContentGp12.add("Data Manipulation and Data Correlation");
		courseContentGp12.add("SQL Server Built in Functions");
		
		courseContentGp12.add("Creating and Managing Views");
		courseContentGp12.add("Introduction to T-SQL Programming");
		courseContentGp12.add("Creating and Modifying Procedures and Cursors");
		courseContentGp12.add("Creating and modifying user defined Functions");
		courseContentGp12.add("Creating and Modifying Triggers");
		courseContentGp12.add("Working with distributed Data");
		courseContentGp12.add("SQL Server Security");
		courseContentGp12.add("Creating and Managing Indexes");
		courseContentGp12.add("Backup/Recovery");
		courseContentGp12.add("Database Mail");
		courseContentGp12.add("SQl Server Scheduling and Notification");
		courseContentGp12.add("Monitoring and Troubleshooting SQL Server Performance");
		courseContentGp12.add("SQL Server Clustering (High availability Solutions) Concept");
		courseContentGp12.add("Database Mirroring");
		courseContentGp12.add("Replication");
		courseContentGp12.add("Migrate or Upgrade to SQL Server 2008");
		courseContentGp12.add("Log shipping");
		courseContentGp12.add("Resource Governor (new Feature in SQL Server 2008");
		courseContentGp12.add("SQL Server Integration Services (SSIS)");
		
		courseContentGp12.add("SQL Server Reporting Services (SSRS)");
		courseContentGp12.add("Database Design Concepts and Design Tool (ERWin Tool)");
		
	}
	
	public void coursesHighlightsAndSyllabusForGp13()
	{
		courseHighlightsGp13 = new ArrayList<String>();
		courseContentGp13 = new ArrayList<String>();
		
		courseHighlightsGp13.add("Ruby Rails  Watir  Selenium Training Course Highlights:");
		courseHighlightsGp13.add("Selenium");
		courseHighlightsGp13.add("Watir: ");
		courseContentGp13.add("Introduction \nStrings and Methods \nClasses and Objects \nClass Hierarchies \nAccessors, Attributes, Class Variables \nArrays Using Arrays \nHashes \nLoops and Iterators \nConditional Statements \nModules and Mixins \nSaving Files, Moving On...");
		courseContentGp13.add("Selenium Introduction \nSelenium IDE \nSelenium RC \nSelenium Grid");
		courseContentGp13.add("please refer our course syllabus.");
	}
	public void coursesHighlightsAndSyllabusForGp14()
	{
		courseHighlightsGp14 = new ArrayList<String>();
		courseContentGp14 = new ArrayList<String>();
		
		courseHighlightsGp14.add("SAP HR Course Highlights");
		courseContentGp14.add("Organization Management (OM) \nTime Management (TM) \nPersonnel Management \nRecruitment \nBenefits \nESS / MSS \nReporting Tools");
	}
	public void coursesHighlightsAndSyllabusForGp15()
	{
		courseHighlightsGp15 = new ArrayList<String>();
		courseContentGp15 = new ArrayList<String>();
		
		courseHighlightsGp15.add("Module 1:");
		courseHighlightsGp15.add("Module 2:");
		courseHighlightsGp15.add("Module 3:");
		courseHighlightsGp15.add("Module 4:");
		courseHighlightsGp15.add("Module 5:");
		courseHighlightsGp15.add("Module 6:");
		courseHighlightsGp15.add("Module 7:");
		courseHighlightsGp15.add("Module 8:");
		courseHighlightsGp15.add("Module 9:");
		courseHighlightsGp15.add("Module 10:");
		
		courseContentGp15.add("Manual Testing \nSoftware Testing Life Cycle - SDLC - Waterfall vs. Agile \nQA Tester Role - Test Metrics - Types of Testing \nSoftware Testing Life Cycle - STLC & Defect Life Cycle \nesting Methodologies, Software Testing process \nTest case, Test plan, RTM, Defect tracking \nHomeworks / Off line student assignments. \nTelecom, Banking, HealthCare, Supply chain domains. \nRole of QA, BA, Developer, Technical Architects etc.");
		courseContentGp15.add("HP Quality Center - ALM for Test management/ Defect Tracking");
		courseContentGp15.add("SQL (Database / Back End Testing)");
		courseContentGp15.add("UNIX / Linux Operating System / Backend Testing");
		courseContentGp15.add("Review & questions on all topics, Configuration Management, CMMI, Six Sigma principles, Regulatory compliance, Requirement (e.g. Sarbanes Oxley, HIPPA-Medical related), Interview Questions. How to prepare professional resume?");
		courseContentGp15.add("IBM Mainframe Testing");
		courseContentGp15.add("SAP Testing (Sales & Distribution (SD), Production Planning or CRM Or any one of the SAP)");
		courseContentGp15.add("WebServices (SOA) Testing using SoapUI tool");
		courseContentGp15.add("Concepts of what is ETL and Data warehouse Testing");
		courseContentGp15.add("IBM Rational Quality Manager (RQM) Tool (It was Rational Test Manager)");
	}
	public void coursesHighlightsAndSyllabusForGp16()
	{
		courseHighlightsGp16 = new ArrayList<String>();
		courseContentGp16 = new ArrayList<String>();
		
		courseHighlightsGp16.add("Module 1:");
		courseHighlightsGp16.add("Module 2:");
		courseHighlightsGp16.add("Module 3:");
		courseHighlightsGp16.add("Module 4:");
		courseHighlightsGp16.add("Module 5:");
		
		
		courseContentGp16.add("Introduction to Data ware house, purpose of dwh with examples \nDWH Architecture \nOLTP System vs OLAP System \nWhat is a fact table? \nWhat is a dimension table? \nFact vs. Dimension \nWhat is star schema? \nWhat is snow flake schema?");
		courseContentGp16.add("DWH Tools (different types of dwh tools) \nTypes of data bases used in ETL testing \nexplaining about data mapping document \nTesting tools used for ETL testing");
		courseContentGp16.add("Explaining Informatica Tool (Mapping Designer, Work flow Manager,Work Flow Monitor \nDifferent types of transformations used in ETLs and uses of these transformation \n Process flow in ETL Testing");
		courseContentGp16.add("Writing test cases for mapping documents\n SQL \nUNIX Commands used");
		courseContentGp16.add("Installation of Informatica Power Center explanation in PowerPoint \nHow we will be planning ETL testing, explain how to generate testing reports \nWill explain total SDLC of ETL testing\n Will show some informatica mapping already development and explain how to trouble shoot them");
		
	}
	public void coursesHighlightsAndSyllabusForGp17()
	{
		courseHighlightsGp15 = new ArrayList<String>();
		courseContentGp15 = new ArrayList<String>();
		
		courseHighlightsGp15.add("Module 1:");
		courseHighlightsGp15.add("Module 2:");
		courseHighlightsGp15.add("Module 3:");
		courseHighlightsGp15.add("Module 4:");
		courseHighlightsGp15.add("Module 5:");
		courseHighlightsGp15.add("Module 6:");
		courseHighlightsGp15.add("Module 7:");
		courseHighlightsGp15.add("Module 8:");
		courseHighlightsGp15.add("Module 9:");
		courseHighlightsGp15.add("Module 10:");
		
		courseContentGp15.add("Manual Testing \nSoftware Testing Life Cycle - SDLC - Waterfall vs. Agile \nQA Tester Role - Test Metrics - Types of Testing \nSoftware Testing Life Cycle - STLC & Defect Life Cycle \nesting Methodologies, Software Testing process \nTest case, Test plan, RTM, Defect tracking \nHomeworks / Off line student assignments. \nTelecom, Banking, HealthCare, Supply chain domains. \nRole of QA, BA, Developer, Technical Architects etc.");
		courseContentGp15.add("HP Quality Center - ALM for Test management/ Defect Tracking");
		courseContentGp15.add("SQL (Database / Back End Testing)");
		courseContentGp15.add("UNIX / Linux Operating System / Backend Testing");
		courseContentGp15.add("Review & questions on all topics, Configuration Management, CMMI, Six Sigma principles, Regulatory compliance, Requirement (e.g. Sarbanes Oxley, HIPPA-Medical related), Interview Questions. How to prepare professional resume?");
		courseContentGp15.add("IBM Mainframe Testing");
		courseContentGp15.add("SAP Testing (Sales & Distribution (SD), Production Planning or CRM Or any one of the SAP)");
		courseContentGp15.add("WebServices (SOA) Testing using SoapUI tool");
		courseContentGp15.add("Concepts of what is ETL and Data warehouse Testing");
		courseContentGp15.add("IBM Rational Quality Manager (RQM) Tool (It was Rational Test Manager)");
	}
	public void coursesHighlightsAndSyllabusForGp18()
	{
		courseHighlightsGp15 = new ArrayList<String>();
		courseContentGp15 = new ArrayList<String>();
		
		courseHighlightsGp15.add("Module 1:");
		courseHighlightsGp15.add("Module 2:");
		courseHighlightsGp15.add("Module 3:");
		courseHighlightsGp15.add("Module 4:");
		courseHighlightsGp15.add("Module 5:");
		courseHighlightsGp15.add("Module 6:");
		courseHighlightsGp15.add("Module 7:");
		courseHighlightsGp15.add("Module 8:");
		courseHighlightsGp15.add("Module 9:");
		courseHighlightsGp15.add("Module 10:");
		
		courseContentGp15.add("Manual Testing \nSoftware Testing Life Cycle - SDLC - Waterfall vs. Agile \nQA Tester Role - Test Metrics - Types of Testing \nSoftware Testing Life Cycle - STLC & Defect Life Cycle \nesting Methodologies, Software Testing process \nTest case, Test plan, RTM, Defect tracking \nHomeworks / Off line student assignments. \nTelecom, Banking, HealthCare, Supply chain domains. \nRole of QA, BA, Developer, Technical Architects etc.");
		courseContentGp15.add("HP Quality Center - ALM for Test management/ Defect Tracking");
		courseContentGp15.add("SQL (Database / Back End Testing)");
		courseContentGp15.add("UNIX / Linux Operating System / Backend Testing");
		courseContentGp15.add("Review & questions on all topics, Configuration Management, CMMI, Six Sigma principles, Regulatory compliance, Requirement (e.g. Sarbanes Oxley, HIPPA-Medical related), Interview Questions. How to prepare professional resume?");
		courseContentGp15.add("IBM Mainframe Testing");
		courseContentGp15.add("SAP Testing (Sales & Distribution (SD), Production Planning or CRM Or any one of the SAP)");
		courseContentGp15.add("WebServices (SOA) Testing using SoapUI tool");
		courseContentGp15.add("Concepts of what is ETL and Data warehouse Testing");
		courseContentGp15.add("IBM Rational Quality Manager (RQM) Tool (It was Rational Test Manager)");
	}
	public void coursesHighlightsAndSyllabusForGp19()
	{
		courseHighlightsGp15 = new ArrayList<String>();
		courseContentGp15 = new ArrayList<String>();
		
		courseHighlightsGp15.add("Module 1:");
		courseHighlightsGp15.add("Module 2:");
		courseHighlightsGp15.add("Module 3:");
		courseHighlightsGp15.add("Module 4:");
		courseHighlightsGp15.add("Module 5:");
		courseHighlightsGp15.add("Module 6:");
		courseHighlightsGp15.add("Module 7:");
		courseHighlightsGp15.add("Module 8:");
		courseHighlightsGp15.add("Module 9:");
		courseHighlightsGp15.add("Module 10:");
		
		courseContentGp15.add("Manual Testing \nSoftware Testing Life Cycle - SDLC - Waterfall vs. Agile \nQA Tester Role - Test Metrics - Types of Testing \nSoftware Testing Life Cycle - STLC & Defect Life Cycle \nesting Methodologies, Software Testing process \nTest case, Test plan, RTM, Defect tracking \nHomeworks / Off line student assignments. \nTelecom, Banking, HealthCare, Supply chain domains. \nRole of QA, BA, Developer, Technical Architects etc.");
		courseContentGp15.add("HP Quality Center - ALM for Test management/ Defect Tracking");
		courseContentGp15.add("SQL (Database / Back End Testing)");
		courseContentGp15.add("UNIX / Linux Operating System / Backend Testing");
		courseContentGp15.add("Review & questions on all topics, Configuration Management, CMMI, Six Sigma principles, Regulatory compliance, Requirement (e.g. Sarbanes Oxley, HIPPA-Medical related), Interview Questions. How to prepare professional resume?");
		courseContentGp15.add("IBM Mainframe Testing");
		courseContentGp15.add("SAP Testing (Sales & Distribution (SD), Production Planning or CRM Or any one of the SAP)");
		courseContentGp15.add("WebServices (SOA) Testing using SoapUI tool");
		courseContentGp15.add("Concepts of what is ETL and Data warehouse Testing");
		courseContentGp15.add("IBM Rational Quality Manager (RQM) Tool (It was Rational Test Manager)");
	}
	public void coursesHighlightsAndSyllabusForGp20()
	{
		courseHighlightsGp20 = new ArrayList<String>();
		courseContentGp20 = new ArrayList<String>();
		
		courseHighlightsGp20.add("Overview/Introduction to Mobile application testing:");
		courseHighlightsGp20.add("Mobile Applications:");
		courseHighlightsGp20.add("Mobile Platforms:");
		courseHighlightsGp20.add("What is Emulator and Simulator?:");
		courseHighlightsGp20.add("Android Mobile App testing:");
		courseHighlightsGp20.add("iPhone mobile app:");
		courseHighlightsGp20.add("Portrait mode Vs Landscape mode testing :");
		courseHighlightsGp20.add("Testing the application with emulators:");
		courseHighlightsGp20.add("Testing the application with the physical devices:");
		courseHighlightsGp20.add("Mobile Testing Utilities:");
		courseHighlightsGp20.add("Defect tracking:");
		courseHighlightsGp20.add("Real time project testing:");
		courseHighlightsGp20.add("Introduction to automation tools:");
		courseHighlightsGp20.add("Overview of Robotium:");
		
		
		courseContentGp20.add("What is Mobile Application Testing? \nDifferences between Mobile and Mobile application testing. \nDifferences between Native, Hybrid and Web application? \nComplexity of mobile testing domain.");
		courseContentGp20.add("Architecture of Native applications. \nArchitecture of Hybrid applications. \nRecommended strategy for mobile application testing. \nUnique challenges in mobile application testing");
		courseContentGp20.add("Types of Mobiles\nAndroid\niOS\nWindows7\nBada\nSymbian\nBlackberry");
		courseContentGp20.add("Basics of mobile testing Mobile application testing strategy:\nBuilding a Mobile Testing Strategy\nHow to choose which devices to test, planning what to test and how to review strategy ?");
		courseContentGp20.add("History\nAndroid Architecture\nAndroid Components (Activities, Views, Intents, Services , Content providers, receivers)\nAndroid SDK environment \nHow to install the Android emulator \nADB commands\nAndroid testing criteria\nAndroid UI test cases\nFunctionality test cases\nInterrupt test cases\nHow to install the application to test in the emulator\nConfigure the SD card in emulator\nDDMS\nVM Heap\nEclipse Overview\nCapture logs using Logcat\nScreenshot capture in Android devices");
		courseContentGp20.add("History\nXcode\nHow to install the application iOS Simulator\niOS architecture\nDifferent layers in iOS architecture\nHow to install the app in iOS simulator");
		courseContentGp20.add(" Functional testing in mobile environnement:\nSmoke testing\n Functional testing\n UI testing\nRegression testing\nPerformance testing\nRetesting\nCompatibility testing with the devices");
		courseContentGp20.add("Install the application\nCreate multiple devices\nTest with multiple devices\nCreate SD card");
		courseContentGp20.add("Introduction to Device Anywhere\nPerfecto Mobile\nSeeTest");
		courseContentGp20.add("Screenshots capturing tools\nUDID Finders\nMemory Usage Tools\nFile Explorers in Android\nLog Collectors");
		courseContentGp20.add("How to Log the issues\nHow track the issues in the bug tracking tool");
		courseContentGp20.add("Installation of SeeTest Manual\nConfigure the devices in SeeTest Manual\nTest execution with SeeTest Manual\nReport generation with SeeTest Manual");
		courseContentGp20.add("When to automate:\nWhat to automate:\nDifferent automation tools available for mobile app testing:\nSeeTest Automation\nIntroduction to SeeTest Automation\nConfigure the Seetest Automation with iPhone\nConfigure the Seetest Automation with Android\nRecord and play back \nObject repository and object spy\nObject identification\nScript enhancement\nExport to QTP\nExecute the SeeTest Automation scripts in QTP\nAdd the objects to Object repository through object spy\nDynamic recording\nWrite the scripts without object repository\nProject");
		courseContentGp20.add("Introduction to Robotium \nBenefits of Robotium \nDrawbacks of Robotium ");
		
		
	}
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		System.gc();
		
	}
}
