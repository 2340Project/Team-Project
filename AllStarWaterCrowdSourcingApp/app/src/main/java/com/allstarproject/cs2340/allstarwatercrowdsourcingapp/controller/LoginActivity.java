package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtUser;
    EditText txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnEnter = (Button) findViewById(R.id.btnEnter);
        txtUser = (EditText) findViewById(R.id.txtUserName);
        txtPass = (EditText) findViewById(R.id.txtPassword);
        btnEnter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        Intent stay = new Intent(LoginActivity.this, LoginActivity.class);
        if (Model.verify(txtUser.getText().toString(), txtPass.getText().toString())) {
            startActivity(intent);
        } else {
            startActivity(stay);
        }
    }

}
