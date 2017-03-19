package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;
public class ViewPurityReportActivity extends AppCompatActivity
        implements View.OnClickListener {
    private Model model = Model.getInstance();
    private TextView purityReps;
    private Button btnCancelPurity;
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

    @Override
    public void onClick(View v) {
        Intent intent1 = new Intent(ViewPurityReportActivity.this,
                MainActivity.class);

        startActivity(intent1);
    }
}
