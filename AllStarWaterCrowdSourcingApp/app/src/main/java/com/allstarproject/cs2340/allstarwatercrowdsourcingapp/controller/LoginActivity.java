package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;

public class LoginActivity extends AppCompatActivity
        implements View.OnClickListener {

    private EditText txtUser;
    private EditText txtPass;
    private Model model = Model.getInstance();

    /**
     * this is the onCreate for LoginActiviy
     * @param savedInstanceState is the Bundle to be used for creation
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        Button btnEnter = (Button) findViewById(R.id.btnEnter);
        txtUser = (EditText) findViewById(R.id.txtCurrentName);
        txtPass = (EditText) findViewById(R.id.txtPassword);
        btnEnter.setOnClickListener(this);

        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(this);
    }

    /**
     * onClick method that will manage the login or cancel button as well as
     * notifying of invalid password if necessary
     * @param view is the current view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        case R.id.btnEnter:
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            if (Model.verify(txtUser.getText().toString(),
                    txtPass.getText().toString())) {
                model.setUser(txtUser.getText().toString());
                startActivity(intent);
            } else {
                TextView textView = (TextView) findViewById(R.id.txtlbl);
                textView.setText("Wrong Password or Username");
            }
            break;
        case R.id.btnCancel:
            Intent intent2 = new Intent(LoginActivity.this,
                    WelcomeActivity.class);
            startActivity(intent2);
            break;
        default:
            //this default case is here so checkstyle doesn't bitch
        }
    }
}
