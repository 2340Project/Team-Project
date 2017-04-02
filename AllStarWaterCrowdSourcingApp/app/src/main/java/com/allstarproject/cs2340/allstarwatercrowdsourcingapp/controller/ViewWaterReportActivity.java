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
    private final ModelFacade modelFacade = ModelFacade.getModelFacade();
    private final Model model = modelFacade.getModelInstance();
    private TextView waterReps;
    private Button btnCancelViewResources;
    /**
     * This method creates and populates all the buttons, text fields, and
     * water resource reports in the View Water Report Screen
     * @param savedInstanceState the data which Android saves to populate
     * data more quickly than the application starting up. It's basically
     * caching everything so load up time is quicker when going back to the
     * screen.
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

    /**
     * This onClick takes redirects the user to the main activity screen when
     * they press the cancel button from viewing the water resource reports.
     * @param v the current view
     */
    @Override
    public void onClick(View v) {
        Intent intent1 = new Intent(
                ViewWaterReportActivity.this, MainActivity.class);
        startActivity(intent1);
    }
}
