package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            Log.d("Entered Type:/", model.txtVirus.getText().toString() + ".");
            //virus type is virus or contaminant
            Log.d("Stored Type:/", wpr.getWaterCondition() + ".");


            if ((wpr.getDate().getMonth() + 1 >= Integer.parseInt(model.txtStartMonth.getText().toString())
                    && wpr.getDate().getYear() + 1900 == Integer.parseInt(model.txtStartYear.getText().toString()))
                    && (wpr.getDate().getMonth() + 1 <= Integer.parseInt(model.txtEndMonth.getText().toString())
                    && wpr.getDate().getYear() + 1900 == Integer.parseInt(model.txtEndYear.getText().toString()))
                    && wpr.getWaterCondition().equals(model.txtVirus.getText().toString())){
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

