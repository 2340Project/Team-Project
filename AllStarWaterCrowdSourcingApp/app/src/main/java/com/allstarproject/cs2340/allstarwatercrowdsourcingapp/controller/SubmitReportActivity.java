package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.ModelFacade;

public class SubmitReportActivity extends AppCompatActivity
        implements View.OnClickListener {

    private final ModelFacade modelFacade = ModelFacade.getModelFacade();
    private final Model model = modelFacade.getModelInstance();
    private EditText txtLocation;
    private EditText txtWaterType;
    private EditText txtWaterCondition;

    /**
     * This onCreate populates all the buttons and text fields in the
     * Submit Report Screen
     * @param savedInstanceState the data which Android saves to populate
     * data more quickly than the application starting up. It's basically
     * caching everything so load up time is quicker when going back to the
     * screen.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_report);
        txtLocation = (EditText) findViewById(R.id.txtWaterLocation);
        txtWaterType = (EditText) findViewById(R.id.txtWaterType);
        txtWaterCondition = (EditText) findViewById(R.id.txtWaterCondition);

        Button btnSubmitWaterReport = (Button) findViewById(
                R.id.btnSubmitWaterReport);
        btnSubmitWaterReport.setOnClickListener(this);


        Button btnCancelSubmitReport = (Button) findViewById(
                R.id.btnCancelSubmitWaterReport);

        btnCancelSubmitReport.setOnClickListener(this);
    }

    /**
     * onClick method to handle the cancel button being clicked by returning
     * you to Main Activity and the submit button submits the reports in a
     * water resource report list and takes you to the Main Activity screen.
     * @param v the current view
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.btnCancelSubmitWaterReport:
            super.finish();
            break;

        case R.id.btnSubmitWaterReport:
            model.addReport(txtLocation.getText().toString(),
                    txtWaterType.getText().toString(),
                    txtWaterCondition.getText().toString());
            super.finish();
            break;
        default:
            //this is here for checkstyle
        }
    }
}


