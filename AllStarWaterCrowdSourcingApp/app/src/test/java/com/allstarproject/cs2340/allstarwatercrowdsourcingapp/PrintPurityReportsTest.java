package com.allstarproject.cs2340.allstarwatercrowdsourcingapp;


import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.ModelFacade;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class PrintPurityReportsTest {
    private String list = "";
    private ModelFacade modelFacade = ModelFacade.getModelFacade();
    private Model model = modelFacade.getModelInstance();
    //private final java.util.Date date;
    //private final String dateAndTime;



    @Before
    public void setUp() {
        model.setUser();
        model.addPurityReportList("Atlanta", 2.256, "Bio-Hazards", "Contaminant");
        model.addPurityReportList("Washington D.C.", 3.123, "Erosion", "Virus");
        model.addPurityReportList("Tampa Bay", 4.0123, "Pesticides", "Contaminant");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                Locale.US);
        //date = new java.util.Date();
        //dateAndTime = dateFormat.format(date);



        list += (1 + ". "   + " , "
                + "Submitted by: " + "" + "aduncan37"  + " , " + "Atlanta" + ": "
                + 2.256 + " Virus/Contaminant PPM , "  + "Bio-Hazards" + "\n");

        list += (2 + ". "  + " , "
                + "Submitted by: " + "" + "aduncan37"  + " , " + "Washington D.C." + ": "
                + 3.123 + " Virus/Contaminant PPM , "  + "Erosion" + "\n");


        list += (3 + ". "  + " , "
                + "Submitted by: " + "" + "aduncan37"  + " , " + "Tampa Bay" + ": "
                + 4.0123 + " Virus/Contaminant PPM , "  + "Pesticides" + "\n");

}
    @Test
    public void hasAllPurityReports() {
        assertEquals(list, model.printPurityReports());
    }
}