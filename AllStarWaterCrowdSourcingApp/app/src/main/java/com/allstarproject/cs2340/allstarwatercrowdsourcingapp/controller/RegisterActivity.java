package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;

public class RegisterActivity extends AppCompatActivity
        implements View.OnClickListener {
    /**
     * onCreate used to setup RegisterActivity on creation
     * @param savedInstanceState is bundled data passed in to use at creation
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnRCancel = (Button) findViewById(R.id.btnRCancel);
        btnRCancel.setOnClickListener(this);
    }

    /**
     * onClick method to handle the cancel button being clicked by returning you to Welcome
     * @param v the current view
     */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
        startActivity(intent);
    }
}
