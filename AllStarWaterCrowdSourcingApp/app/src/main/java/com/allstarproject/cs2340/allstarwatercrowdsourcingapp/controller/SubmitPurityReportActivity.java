package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.ModelFacade;

public class SubmitPurityReportActivity extends AppCompatActivity
        implements View.OnClickListener {
    private final ModelFacade modelFacade = ModelFacade.getModelFacade();
    private final Model model = modelFacade.getModelInstance();
    private Button btnSubmitWaterPurityReport;
    private Button btnCancelSubmitPurityReport;
    private EditText txtWaterLocationPurity;
    private EditText txtVirusPPM;
    private EditText txtWaterConditionPurity;
    private EditText txtVirOrContamType;

    /**
     * This onCreate populates all the buttons and text fields in the
     * Submit Purity Report Screen
     * @param savedInstanceState the data which Android saves to populate
     * data more quickly than the application starting up. It's basically
     * caching everything so load up time is quicker when going back to the
     * screen.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_purity_report);

        btnCancelSubmitPurityReport = (Button) findViewById(
                R.id.btnCancelSubmitPurityReport);
        btnCancelSubmitPurityReport.setOnClickListener(this);
        btnSubmitWaterPurityReport = (Button) findViewById(
                R.id.btnSubmitWaterPurityReport);
        btnSubmitWaterPurityReport.setOnClickListener(this);

        txtWaterLocationPurity = (EditText) findViewById(
                R.id.txtWaterLocationPurity);
        txtVirusPPM = (EditText) findViewById(R.id.txtVirusPPM);
        txtWaterConditionPurity = (EditText) findViewById(
                R.id.txtWaterConditionPurity);

        txtVirOrContamType = (EditText) findViewById(R.id.txtVirOrContamType);
    }
    /**
     * This onClick takes redirects the user to the appropiate screen upon
     * pressing a specific button. When the user submits a water purity
     * report, that report is added to a water purity report list and then it
     * takes you back to the Main Activity Screen.
     * @param v the current view
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.btnCancelSubmitPurityReport:
            Intent intent1 = new Intent(SubmitPurityReportActivity.this,
                    MainActivity.class);
            startActivity(intent1);
            break;
        case R.id.btnSubmitWaterPurityReport:
            Intent intent2 = new Intent(SubmitPurityReportActivity.this,
                    MainActivity.class);
            model.addPurityReportList(txtWaterLocationPurity.getText().
                            toString(),
                    Double.parseDouble(txtVirusPPM.getText().toString()),
                    txtWaterConditionPurity.getText().toString(),
                    txtVirOrContamType.getText().toString());
            startActivity(intent2);
            break;
        default:
        }
    }
}
