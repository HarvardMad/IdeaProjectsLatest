package com.example.carparts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Android Activity life cycle:
 * Once launched: first call onCreate() inside which
 * the main layout of the launcher activity is set
 * then the  onStart() is overridden
 * then onResume()
 *
 * Now the activity is running
 *
 * if you now want to load another activity
 * on to the screen, then run onPause() on the current activity
 * then return to onResume() to launch the new activity
 * if the activity is no longer visible, the onStop()
 * if the user restarts the activity, then invoke onRestart()
 * If you destroy an activity, onDestroy()
 *
 * HTTP is used in REST
 * The main methods are get - to receive from the server
 * put - to update data in the database if you use put to CREATE
 * You must send a unique ID with the record
 * head - simply receive a header without a body
 * Options- tell you the methods supported by the server
 * Post- create a new record - C in CRUD(non idempotent)
 * provides a common interface that can link applications
 * use xml or JSON
 *map above methods to the services written in Java Python etc
 * to link .NET to JAva use REST with XML
 *
 */
public class MyActivity extends Activity implements View.OnClickListener{
    /**
     * Called when the activity is first created.
     */

    Button menuAccessButton;

    public static final String MY_TAG="the_custom_message";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        menuAccessButton=(Button)findViewById(R.id.buttonOne);
        menuAccessButton.setOnClickListener(this);
        Log.i(MY_TAG, "Starting onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(MY_TAG, "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(MY_TAG, "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(MY_TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(MY_TAG, "onStop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(MY_TAG, "onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(MY_TAG, "onDestroy");
    }


public void menuAccessButtonClick(){
    startActivity(new Intent("com.example.carparts.MainMenuActivity"));
}

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonOne:menuAccessButtonClick();
                break;
        }
    }
}
