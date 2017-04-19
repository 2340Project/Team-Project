package com.allstarproject.cs2340.allstarwatercrowdsourcingapp;


import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.ModelFacade;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrintPurityReportsTest {
    private String list = "";
    private ModelFacade modelFacade = ModelFacade.getModelFacade();
    private Model model = modelFacade.getModelInstance();

    @Before
    public void setUp() {
        model.setUser();

    }
    @Test
    public void hasAllPurityReports() {
        assertEquals(list, model.printPurityReports());
        model.addPurityReportList("Atlanta", 2.256, "Bio-Hazards",
                "Contaminant");
        model.addPurityReportList("Washington D.C.", 3.123, "Erosion",
                "Virus");
        model.addPurityReportList("Tampa Bay", 4.0123, "Pesticides",
                "Contaminant");


        list += ("1. " + model.getLastDateAndTime() + " , "
                + "Submitted by: " + "" + "austin"  + " , " + "Atlanta"
                + ": " + 2.256 + " Virus/Contaminant PPM , "
                + "Bio-Hazards" + "\n");

        list += ("2. " + model.getLastDateAndTime() + " , "
                + "Submitted by: " + "" + "austin"  + " , "
                + "Washington D.C." + ": " + 3.123 + " Virus/Contaminant PPM , "
                + "Erosion" + "\n");


        list += ("3. " + model.getLastDateAndTime() +  " , "
                + "Submitted by: " + "" + "austin"  + " , " + "Tampa Bay"
                + ": " + 4.0123 + " Virus/Contaminant PPM , "
                + "Pesticides" + "\n");

    }
}