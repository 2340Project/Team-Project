package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DataSet class that generates a set of (x,y) Data objects to be displayed on
 * the graph
 * Created by Austin on 3/27/17.
 */

public class DataSet {
    private final ModelFacade modelFacade = ModelFacade.getModelFacade();
    private final Model model = modelFacade.getModelInstance();
    private final List<WaterPurityReport> list = (List<WaterPurityReport>)
            model.getPurityReportList();
    private final List<Data> dataList = new ArrayList<>();

    /**
     * Constructor to generate data set
     */
    public DataSet() {
        generateSet();
    }
    /**
     * This method generate the data that will go in the data set
     */
    private void generateSet() {
        for (WaterPurityReport wpr : list) {
            Log.d("App:/", "Report month: " + wpr.getDate().getMonth() + 1);
            Log.d("App:/", "Actual requested start month: " + Integer.parseInt(
                    model.txtStartMonth.getText().toString()));
            Log.d("App:/", "Report year: " + wpr.getDate().getYear() + 1900);
            Log.d("App:/", "Actual requested start year: " + Integer.parseInt(
                    model.txtStartYear.getText().toString()));
            Log.d("App:/", "Vir type in report: " + wpr.getVirusType());
            Log.d("App:/", "Requested type: " + model.txtVirus.
                    getText().toString());
            if ((wpr.getDate().getMonth() + 1 >= Integer.parseInt(
                    model.txtStartMonth.getText().toString())
                    && wpr.getDate().getYear() + 1900 == Integer.parseInt(
                            model.txtStartYear.getText().toString()))
                    && (wpr.getDate().getMonth() + 1 <= Integer.parseInt(
                            model.txtEndMonth.getText().toString())
                    && wpr.getDate().getYear() + 1900 == Integer.parseInt(
                            model.txtEndYear.getText().toString()))
                    && wpr.getVirusType().equals(
                            model.txtVirus.getText().toString())) {
                dataList.add(new Data(
                        wpr.getVirusPPM(), wpr.getDate().getMonth()));
                Log.d("Inside if:/", " made it");
            }
            Log.d("OUTside if:/", " possibly skipped the if");
        }
        Collections.sort(dataList);
        Log.d("Sort", " just sorted");

    }

    /**
     * getter for the list of data from the data set
     * @return data set in the form of a list.
     */
    public List<Data> getDataList() {
        return dataList;
    }
}

