package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller.HistoricalReportActivity;

/**
 * Created by Austin on 3/27/17.
 */

public class DataSet {
    ModelFacade modelFacade = ModelFacade.getModelFacade();
    Model model = modelFacade.getModelInstance();
    private List<WaterPurityReport> list = model.getPurityReportList();
    private List<Data> dataList = new ArrayList<>();

    public DataSet() {
        generateSet();
    }

    private void generateSet() {
        for (WaterPurityReport wpr : list) {
            int count = 1;
            Log.d("Count:/", count + ".");
            count++;
            Log.d("WPR month:/",wpr.getDate().getMonth() + ".");
            Log.d("Entered start month:/", Integer.parseInt(model.txtStartMonth.getText().toString()) + ".");
            Log.d("Entered end month:/", Integer.parseInt(model.txtStartMonth.getText().toString()) + ".");
            Log.d("WPR year:/",wpr.getDate().getYear() + ".");
            Log.d("Entered end year:/", Integer.parseInt(model.txtEndYear.getText().toString()) + ".");
            Log.d("Entered start year:/", model.txtStartYear + ".");


            if ((wpr.getDate().getMonth() >= Integer.parseInt(model.txtStartMonth.getText().toString())
                    && wpr.getDate().getYear() + 1900 == Integer.parseInt(model.txtStartYear.getText().toString()))
                    || (wpr.getDate().getMonth() <= Integer.parseInt(model.txtEndMonth.getText().toString())
                    && wpr.getDate().getYear() + 1900 == Integer.parseInt(model.txtEndYear.getText().toString()))) {
                dataList.add(new Data(wpr.getVirusPPM(), wpr.getDate().getMonth()));
                Log.d("Inside if:/", " made it");
            }
            Log.d("OUTside if:/", " possibly skipped the if");
        }

        Collections.sort(dataList);
        Log.d("Sort", " just sorted");

    }

    public List<Data> getDataList() { return dataList; }
}

