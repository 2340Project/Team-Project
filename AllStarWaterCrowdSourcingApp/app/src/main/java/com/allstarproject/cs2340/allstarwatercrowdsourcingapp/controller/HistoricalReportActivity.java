package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.ModelFacade;

public class HistoricalReportActivity extends AppCompatActivity
        implements View.OnClickListener {
    private final ModelFacade modelFacade = ModelFacade.getModelFacade();
    private final Model model = modelFacade.getModelInstance();

    private EditText txtVirus;
    private EditText txtStartYear;
    private EditText txtStartMonth;
    private EditText txtEndYear;
    private EditText txtEndMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_report);

        Button btnEnter = (Button) findViewById(R.id.btnViewHistReport);
        btnEnter.setOnClickListener(this);
        Button btnCancel = (Button) findViewById(R.id.btnCancelHist);
        btnCancel.setOnClickListener(this);
        txtVirus = (EditText) findViewById(R.id.txtVirusType);
        txtStartYear = (EditText) findViewById(R.id.txtStartYear);
        txtStartMonth = (EditText) findViewById(R.id.txtStartMonth);
        txtEndYear = (EditText) findViewById(R.id.txtEndYear);
        txtEndMonth = (EditText) findViewById(R.id.txtEndMonth);

    }
    @Override
    public void onClick(View v) {
        Log.d("APP:/", " the click caused enter of onClick");
        switch (v.getId()) {
        case R.id.btnViewHistReport:
//                if (list.size() == 0) {
//                    AlertDialog.Builder alertDialogBuilder = new
//                            AlertDialog.Builder(context);
//                    alertDialogBuilder.setTitle(
//                            "You cannot create a report because there is "
//                                    + "no data in the system at this time");
//
//                    alertDialogBuilder
//                            .setMessage("")
//                            .setCancelable(false)
//                            .setPositiveButton("Yes", new DialogInterface
//                                    .OnClickListener() {
//
//                               public void onClick(DialogInterface dialog, int
//                                        id) {
//                                    dialog.cancel();
//                                }
//                            })
//                            .setNegativeButton("No", new
//                                    DialogInterface.OnClickListener() {
//                                        public void onClick(
//                                          DialogInterface dialog, int id) {
//                                      // if this button is clicked, just close
//                                         // the dialog box and do nothing
//                                            dialog.cancel();
//                                        }
//                                    });
//                    // create alert dialog
//                    AlertDialog alertDialog = alertDialogBuilder.create();
//
//                    // show it
//                    alertDialog.show();
//       } else {
            Log.d("APP:/", " The onClick is attempting to go to the graph");
            setTxtEndMonth();
            setTxtEndYear();
            setTxtStartMonth();
            setTxtStartYear();
            setTxtVirus();
            Intent intent1 = new Intent(HistoricalReportActivity.this,
                    ChartActivity.class);
            startActivity(intent1);
//          }
            break;
        case R.id.btnCancelHist:
            Intent intent2 = new Intent(HistoricalReportActivity.this,
                    MainActivity.class);
            startActivity(intent2);
            break;
        default:
        }
    }

    /**
     * this sets the contaminant or virus txt of the data in the historical
     * report activity to the txt that is in Model. It generates the data
     * that already exists.
     */
    private void setTxtVirus() {
        model.txtVirus = txtVirus;
    }
    /**
     * this sets the start year of the virus or contaminant data in the
     * historical report activity to the txt that is in Model. It generates
     * the data that already exists.
     */
    private void setTxtStartYear() {
        model.txtStartYear = txtStartYear;
    }
    /**
     * this sets the start month of the virus or contaminant data in the
     * historical report activity to the txt that is in Model. It generates
     * the data that already exists.
     */
    private void setTxtStartMonth() {
        model.txtStartMonth = txtStartMonth;
    }

    /**
     * this sets the end month of the virus or contaminant data in the
     * historical report activity to the txt that is in Model. It generates
     * the data that already exists.
     */
    private void setTxtEndMonth() {
        model.txtEndMonth = txtEndMonth;
    }
    /**
     * this sets the end year of the virus or contaminant data in the
     * historical report activity to the txt that is in Model. It generates
     * the data that already exists.
     */
    private void setTxtEndYear() {
        model.txtEndYear = txtEndYear;
    }


}
