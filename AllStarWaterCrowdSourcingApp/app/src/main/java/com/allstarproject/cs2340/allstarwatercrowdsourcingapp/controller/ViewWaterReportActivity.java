package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.ModelFacade;

import android.widget.Button;

public class ViewWaterReportActivity extends AppCompatActivity implements View.OnClickListener {
    ModelFacade modelFacade = ModelFacade.getModelFacade();
    Model model = modelFacade.getModelInstance();
    TextView waterReps;
    Button btnCancelViewResources;
    /**
     * This method populates the reports in the ViewWaterReport Screen
     * @param savedInstanceState the things that Android needs to run the
     * the screen
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_water_report);
        btnCancelViewResources = (Button) findViewById(
                R.id.btnCancelViewResources);
        btnCancelViewResources.setOnClickListener(this);
        String toPrint = model.printReports();
        waterReps = (TextView) findViewById(R.id.txtReportList);
        waterReps.setText(toPrint);
    }

    @Override
    public void onClick(View v) {
        Intent intent1 = new Intent(
                ViewWaterReportActivity.this, MainActivity.class);
        startActivity(intent1);
    }
}
