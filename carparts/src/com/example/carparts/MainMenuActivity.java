package com.example.carparts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by LalinPethiyagoda on 27/09/2015.
 */
public class MainMenuActivity extends Activity implements View.OnClickListener{
    Button catalogeButton;
    Button loginButton;
    Button findUsButton;
    Button registerButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);

        catalogeButton=(Button)findViewById(R.id.button3);
        catalogeButton.setOnClickListener(this);

        loginButton=(Button)findViewById(R.id.button1);
        loginButton.setOnClickListener(this);

        findUsButton=(Button)findViewById(R.id.button4);
        findUsButton.setOnClickListener(this);

        registerButton=(Button)findViewById(R.id.button2);
        registerButton.setOnClickListener(this);

    }


    public void cataLogueButtonClick(){

        startActivity(new Intent("com.example.carparts.CatalogueActivity"));
    }

    public void loginButtonClick(){
        startActivity(new Intent("com.example.carparts.LoginActivity"));
    }

    public void findUsButtonClick(){
        startActivity(new Intent("com.example.carparts.FindusActivity"));
    }

    public void registerButtonClick(){
        startActivity(new Intent("com.example.carparts.Register"));
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button3:cataLogueButtonClick();
                break;
            case R.id.button1:loginButtonClick();
                break;
            case R.id.button4:findUsButtonClick();
                break;
            case R.id.button2:registerButtonClick();
        }
    }
}