package com.h2kinfosys.com;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;


public class SplashScreenActivity extends Activity {

private final int DISPLAY_LENGTH = 1000;

/** Called when the activity is first created. */

@Override
public void onCreate(Bundle icicle) {
super.onCreate(icicle);
requestWindowFeature(Window.FEATURE_NO_TITLE);
getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
WindowManager.LayoutParams.FLAG_FULLSCREEN);
setContentView(R.layout.splash);

/* New Handler to start the Menu-Activity
* and close this Splash-Screen after DISPLAY_LENGTH/1000 seconds.*/
new Handler().postDelayed(new Runnable(){

@Override
public void run() {
/* Create an Intent that will start the Main-Activity. */
Intent mainIntent = new Intent(SplashScreenActivity.this,H2kinfosys.class);
SplashScreenActivity.this.startActivity(mainIntent);
SplashScreenActivity.this.finish();
}}, DISPLAY_LENGTH);
}
}