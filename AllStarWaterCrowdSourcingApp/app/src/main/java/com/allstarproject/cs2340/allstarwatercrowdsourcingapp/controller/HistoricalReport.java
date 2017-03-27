package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Spinner;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;

public class HistoricalReport extends AppCompatActivity {
    private  Button btnEnter;
    private Button btnCancel;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_report);

        btnEnter = (Button) findViewById(R.id.btnViewReport);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        spinner = (Spinner) findViewById(R.id.spnUserType);
    }
}
