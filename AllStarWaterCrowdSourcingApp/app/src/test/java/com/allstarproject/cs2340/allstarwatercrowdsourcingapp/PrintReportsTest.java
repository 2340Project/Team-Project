package com.allstarproject.cs2340.allstarwatercrowdsourcingapp;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.ModelFacade;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A JUnit test written for the printReports() method in Model. Ensures that
 * the method returns a correctly formatted string to display the reports.
 *
 * Created by Brian on 4/2/2017.
 */

public class PrintReportsTest {
    private ModelFacade modelFacade = ModelFacade.getModelFacade();
    private Model model = modelFacade.getModelInstance();
    private String expectedList;

    @Before
    public void setup() {
        model.setUser();
        expectedList = "";
    }

    @Test
    public void testPrintReports() {
        assertEquals(model.printReports(), expectedList); // case with no water reports added

        model.addReportList("Atlanta", "Bottle", "Good");
        expectedList += "1. " + model.getLastDateAndTime() + " , austin , Atlanta: Bottle, Good\n";

        assertEquals(model.printReports(), expectedList); // case with 1 report

        model.addReportList("Albany", "Fountain", "Bad");
        expectedList += "2. " + model.getLastDateAndTime() + " , austin , Albany: Fountain, Bad\n";

        assertEquals(model.printReports(), expectedList); // case with 2 reports
    }
}

//waterResourceReport toString returns-
//return "" + reportNumber + ". " + dateAndTime + " , " + creator + " , "
//        + location + ": " + waterType + ", " + waterCondition;