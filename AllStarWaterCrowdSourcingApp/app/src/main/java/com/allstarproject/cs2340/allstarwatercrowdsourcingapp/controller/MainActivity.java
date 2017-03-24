package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Model model = Model.getInstance();
    Button btnViewSourceReport;

    /**
     * onCreate method for MainActivity. Setup for Logout button and its
     * listener
     * * @param savedInstanceState Bundled data passed in for creation
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);

        Button btnEditProf = (Button) findViewById(R.id.btnEditProf);
        btnEditProf.setOnClickListener(this);

        Button btnViewSourceReport = (Button) findViewById(
                R.id.btnViewSourceReport);
        btnViewSourceReport.setOnClickListener(this);

        Button btnViewMap = (Button) findViewById(R.id.btnViewMap);
        btnViewMap.setOnClickListener(this);
        if (model.getUser().getIsManager() || model.getUser().getIsWorker()) {
            Button btnSubmitPurityReport = (Button) findViewById(
                    R.id.btnSubmitPurityReport);
            btnSubmitPurityReport.setOnClickListener(this);
        } else {
            Button btnSubmitPurityReport = (Button) findViewById(
                    R.id.btnSubmitPurityReport);
            btnSubmitPurityReport.setVisibility(View.GONE);
        }
        if (model.getUser().getIsManager()) {
            Button btnViewPurityReport = (Button) findViewById(
                    R.id.btnViewPurityReports);
            btnViewPurityReport.setOnClickListener(this);
        } else {
            Button btnViewPurityReport = (Button) findViewById(
                    R.id.btnViewPurityReports);
            btnViewPurityReport.setVisibility(View.GONE);
        }

    }

    /**
     * onClick for MainActivity.  Setup for main act when screen is launched
     * from login
     * @param v current view
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.btnEditProf:
            Intent intent1 = new Intent(MainActivity.this,
                    EditProfileActivity.class);
            startActivity(intent1);
            break;

        case R.id.btnLogout:
            Intent intent2 = new Intent(MainActivity.this,
                    WelcomeActivity.class);
            startActivity(intent2);
            break;

        case R.id.btnViewMap:
            Intent intent5 = new Intent(MainActivity.this,
                    MapsActivity.class);
            startActivity(intent5);
            break;

        case R.id.btnSubmitPurityReport:
            Intent intent6 = new Intent(MainActivity.this,
                    SubmitPurityReportActivity.class);
            startActivity(intent6);
            break;

        case R.id.btnViewPurityReports:
            Intent intent7 = new Intent(MainActivity.this,
                    ViewPurityReportActivity.class);
            startActivity(intent7);
            break;

        case R.id.btnViewSourceReport:
            Intent intent8 = new Intent(MainActivity.this,
                    ViewWaterReportActivity.class);
            startActivity(intent8);
            break;
        default:
                //this is here for checkstyle
        }
    }
}
