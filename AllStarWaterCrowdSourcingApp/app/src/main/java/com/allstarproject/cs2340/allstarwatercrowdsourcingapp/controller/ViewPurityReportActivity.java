package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.ModelFacade;

public class ViewPurityReportActivity extends AppCompatActivity
        implements View.OnClickListener {
    private final ModelFacade modelFacade = ModelFacade.getModelFacade();
    private final Model model = modelFacade.getModelInstance();
    private TextView purityReps;
    private Button btnCancelPurity;
    /**
     * This method creates and populates all the buttons, text fields, water
     * purity reports in the View Purity Report Screen
     * @param savedInstanceState the data which Android saves to populate
     * data more quickly than the application starting up. It's basically
     * caching everything so load up time is quicker when going back to the
     * screen.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_purity_report);
        btnCancelPurity = (Button) findViewById(R.id.btnCancelViewPurity);
        btnCancelPurity.setOnClickListener(this);
        String toPrint = model.printPurityReports();
        //txtPurityReportList
        purityReps = (TextView) findViewById(R.id.txtPurityReportList);
        purityReps.setText(toPrint);
    }
    /**
     * This onClick takes redirects the user to the main activity screen when
     * they press the cancel button from viewing the water resource purity
     * reports.
     * @param v the current view
     */
    @Override
    public void onClick(View v) {
        Intent intent1 = new Intent(ViewPurityReportActivity.this,
                MainActivity.class);

        startActivity(intent1);
    }
}