package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Admin;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Manager;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.RegisteredUser;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Worker;



public class SubmitReportActivity extends AppCompatActivity implements View.OnClickListener {


    Model model = Model.getInstance();
    EditText txtLocation;
    EditText txtWaterType;
    EditText txtWaterCondition;

    /**
     * This method creates the buttons and text fields associated with the
     * SubmitReportActivity Screen
     * @param savedInstanceState the things that Android needs to run and
     * display the screen
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_report);
        txtLocation = (EditText) findViewById(R.id.txtWaterLocation);
        txtWaterType = (EditText) findViewById(R.id.txtWaterType);
        txtWaterCondition = (EditText) findViewById(R.id.txtWaterCondition);

        Button btnSubmitWaterReport = (Button) findViewById(R.id.btnSubmitWaterReport);
        btnSubmitWaterReport.setOnClickListener(this);
        Button btnCancelSubmitReport = (Button) findViewById(R.id.btnCancelSubmitReport);
        btnCancelSubmitReport.setOnClickListener(this);
    }

    /**
     * onClick method to handle the cancel button being clicked by returning
     * you to Main Activity and the submit button submitsthe reports and takes
     * you to the Main Activity screen.
     * @param v the current view
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCancelSubmitReport:
                Intent intent = new Intent(SubmitReportActivity.this, MapsActivity.class);
                startActivity(intent);
                break;

            case R.id.btnSubmitWaterReport:
//                Intent intent2 = new Intent(SubmitReportActivity.this, MapsActivity.class);


                model.addReport(txtLocation.getText().toString(), txtWaterType.getText().toString(),
                        txtWaterCondition.getText().toString());
//                startActivity(intent2);
                break;
        }
    }
}


