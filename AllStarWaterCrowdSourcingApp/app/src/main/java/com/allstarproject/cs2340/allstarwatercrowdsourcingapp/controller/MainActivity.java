package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.ModelFacade;
import java.io.File;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ModelFacade modelFacade = ModelFacade.getModelFacade();
    Model model = modelFacade.getModelInstance();
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

        Button btnHistReport = (Button) findViewById(R.id.btnHistReport);
        btnHistReport.setOnClickListener(this);

        Button btnViewMap = (Button) findViewById(R.id.btnViewMap);
        btnViewMap.setOnClickListener(this);
        Log.d("Check model instance", model.toString());
        Log.d("Check User instance", model.getUser().toString());
        if (model.getUser().getIsManager() || model.getUser().getIsWorker()) {
            Button btnSubmitPurityReport = (Button) findViewById(
                    R.id.btnSubmitPurityReport);
            btnSubmitPurityReport.setOnClickListener(this);
            if(model.getUser().getIsManager()) {
                btnHistReport.setVisibility(View.VISIBLE);
            }
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
                Intent intent1 = new Intent(MainActivity.this, EditProfileActivity.class);
                startActivity(intent1);
                break;

            case R.id.btnLogout:
                File file = new File(this.getFilesDir(), ModelFacade.DEFAULT_BINARY_FILE_NAME);
                Intent intent2 = new Intent(MainActivity.this, WelcomeActivity.class);
                Log.d("Saving", "About to save data. . .");
                modelFacade.saveBinary(file);
                startActivity(intent2);
                break;

            case R.id.btnViewMap:
                Intent intent5 = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent5);
                break;

            case R.id.btnSubmitPurityReport:
                Intent intent6 = new Intent(MainActivity.this, SubmitPurityReportActivity.class);
                startActivity(intent6);
                break;

            case R.id.btnViewPurityReports:
                Intent intent7 = new Intent(MainActivity.this, ViewPurityReportActivity.class);
                startActivity(intent7);
                break;

            case R.id.btnViewSourceReport:
                Intent intent8 = new Intent(MainActivity.this, ViewWaterReportActivity.class);
                startActivity(intent8);
                break;
            case R.id.btnHistReport:
                Intent intent9 = new Intent(MainActivity.this,
                        HistoricalReportActivity.class);
                startActivity(intent9);
                break;
            default:
        }
    }
}
