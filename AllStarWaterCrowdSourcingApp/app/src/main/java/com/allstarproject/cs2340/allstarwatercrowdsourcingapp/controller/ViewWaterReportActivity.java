package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import java.util.ArrayList;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.WaterResourceReport;

public class ViewWaterReportActivity extends AppCompatActivity {
    Model model = Model.getInstance();
    TextView waterReps;

    /**
     * This method populates the reports in the ViewWaterReport Screen
     * @param savedInstanceState the things that Android needs to run the
     * the screen
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_water_report);

        String toPrint = model.printReports();
        waterReps = (TextView) findViewById(R.id.txtReportList);
        waterReps.setText(toPrint);
    }
}
