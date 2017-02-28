package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button btnAction = (Button) findViewById(R.id.btnLoginWelcome);
        btnAction.setOnClickListener(this);

        Button btnRegister = (Button) findViewById(R.id.btnRegisterWelcome);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLoginWelcome:
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btnRegisterWelcome:
                Intent intent2 = new Intent(WelcomeActivity.this, RegisterActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
