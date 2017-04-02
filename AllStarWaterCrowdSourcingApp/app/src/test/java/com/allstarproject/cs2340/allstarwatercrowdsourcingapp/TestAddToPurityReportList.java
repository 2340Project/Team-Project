package com.allstarproject.cs2340.allstarwatercrowdsourcingapp;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.ModelFacade;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.WaterPurityReport;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TestAddToPurityReportList {
    ModelFacade modelFacade = ModelFacade.getModelFacade();
    Model model = modelFacade.getModelInstance();
    List<WaterPurityReport> list = new ArrayList<WaterPurityReport>(10);

    @Before
    public void setup() {
        //location = atlanta
        //virusPPM = 0.784
        //waterCondition = good
        //virusType = ebola
        for (Object w : model.getPurityReportList()) {
            list.add((WaterPurityReport) w);
        }
        model.setUser();
        list.add(new WaterPurityReport("atlanta", "good", 0.784, "ebola", model.getPurityReportNumber() + 1, model.getUser().getName()));
        model.addPurityReportList("atlanta", 0.784, "good", "ebola");
    }
    @Test
    public void testAddPurityReportList() {
        assertEquals(list.size(), model.getPurityReportList().size());
        WaterPurityReport fromList = null;
        WaterPurityReport fromModel = null;
        for (int i = 0; i < list.size() && i < model.getPurityReportList().size(); i++) {
            fromList = list.get(i);
            fromModel = (WaterPurityReport) model.getPurityReportList().get(i);
            assertEquals(fromList, fromModel);
        }
    }
}