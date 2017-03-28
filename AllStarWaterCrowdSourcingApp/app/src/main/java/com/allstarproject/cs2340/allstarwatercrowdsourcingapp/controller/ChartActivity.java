package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Data;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.DataSet;

public class ChartActivity extends AppCompatActivity {

    private DataSet data = new DataSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        LineChart lineChart = (LineChart) findViewById(R.id.chart);

        List<Entry> entries = convertDataSetToEntry(data.getDataList());

        LineDataSet dataset = new LineDataSet(entries, "ppm in a month");

        Log.d("APP", "Made dataset with : " + entries.size());

        LineData data = new LineData(dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //

        dataset.setDrawFilled(true);

        lineChart.setData(data);
        lineChart.animateY(5000);

        lineChart.getDescription().setText("PPM Virus/Contaminant per Month");

    }

    private List<Entry> convertDataSetToEntry(List<Data> data) {
        List<Entry> entries = new ArrayList<>();

        for (Data d : data) {
            entries.add(new Entry(d.y, (float) d.x));
        }
            entries.add(new Entry(9f, 4.38f));

        return entries;
    }
}

