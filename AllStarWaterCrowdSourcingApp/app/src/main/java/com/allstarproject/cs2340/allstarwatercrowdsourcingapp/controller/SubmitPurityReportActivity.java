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

public class SubmitPurityReportActivity extends AppCompatActivity implements View.OnClickListener {
    ModelFacade modelFacade = ModelFacade.getModelFacade();
    Model model = modelFacade.getModelInstance();
    Button btnSubmitWaterPurityReport;
    Button btnCancelSubmitPurityReport;
    EditText txtWaterLocationPurity;
    EditText txtContaminantType;
    EditText txtVirusPPM;
    EditText txtWaterConditionPurity;
    EditText txtVirOrContamType;


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
                    txtWaterConditionPurity.getText().toString()
                    ,txtVirOrContamType.getText().toString());
            startActivity(intent2);
            break;
        default:
            //this is here for checkstlye
        }
    }
}
