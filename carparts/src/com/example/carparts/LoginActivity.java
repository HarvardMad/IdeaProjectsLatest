package com.example.carparts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by LalinPethiyagoda on 27/09/2015.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    Button registerButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        registerButton=(Button)findViewById(R.id.btnLinkToRegisterScreen);
        registerButton.setOnClickListener( this);
    }

    public void navigatetoRegisterActivity(View view){

        switch(view.getId()){

            case R.id.btnLinkToRegisterScreen:registerButtonClick();
                break;
        }

    }

    public void onClick(View view){
        navigatetoRegisterActivity(view);
    }

    public void registerButtonClick(){
        startActivity(new Intent("com.example.carparts.Register"));
    }

    def loginButtonClick(){

    }
}