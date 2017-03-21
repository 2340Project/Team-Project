package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

//import android.support.annotation.NonNull;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.FragmentManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import android.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.util.Log;


import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller.SubmitReportActivity;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.GoogleMap;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller.MapsActivity;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import java.io.Serializable;

/**
 * Created by Austin on 2/12/17.
 */

public class Model extends FragmentActivity implements Serializable {


    /**
     * instance of singleton Model
     */
    private static Model model = new Model();
    /**
     * map to store user object in current run of app
     */
    private Map<String, RegisteredUser> map;
    /**
     * current user (could be a RegisteredUser or any subtype)
     */
    private transient RegisteredUser user;
    private List<MarkerOptions> reportList;
    private List<WaterResourceReport> printList;
    private List<WaterPurityReport> purityReportList;
    private int reportNumber;
    private int purityReportNumber;
    private transient MapsActivity mapsActivity = MapsActivity.getMapActivity();

    public void setMap(Map<String, RegisteredUser> map) {
        this.map = map;
    }

    public void setReportList(List<MarkerOptions> reportList) {
        this.reportList = reportList;
    }

    public void setPrintList(List<WaterResourceReport> printList) {
        this.printList = printList;
    }

    public void setPurityReportList(List<WaterPurityReport> purityReportList) {
        this.purityReportList = purityReportList;
    }

    public void setReportNumber(int reportNumber) {
        this.reportNumber = reportNumber;
    }

    public void setPurityReportNumber(int purityReportNumber) {
        this.purityReportNumber = purityReportNumber;
    }

    public void setMarkerOptions(MarkerOptions markerOptions) {
        this.markerOptions = markerOptions;
    }

    private MarkerOptions markerOptions;


    /**
     * Singleton constructor
     */
    private Model() {
        map = new HashMap<>();
        //map.put("user", "pass");
        reportList = new ArrayList<>();
        printList = new ArrayList<>();
        purityReportList = new ArrayList<>();
        reportNumber = 0;
        purityReportNumber = 0;

    }
    private static ModelFacade mf = ModelFacade.getModelFacade();

    public Map<String, RegisteredUser> getUserMap() {
        return map;
    }


    /**
     * method to get instance of Singleton model object
     * @return single instance of model
     */
    public static Model getInstance() {

        System.out.println(model + " the model instance before passed");
        return model;
    }

    /**
     * method used to verify password on login
     * @param username users username from textfield
     * @param password users password from textfield
     * @return boolean if user is valid and password is valid
     */
    public boolean verify(String username, String password) {
        boolean valid = false;
        //System.out.print(username);
        System.out.println(map.get(username) + " password in map");
        if (map.containsKey(username)) {
            System.out.println("I HAVE THE USERNAME!");
        } else {
            System.out.println("I dont have it");
        }
        if (map.containsKey(username) && password.equals(map.get(username).getPassword())) {
            System.out.println(username);
            valid = true;
            return valid;
        } else {
            return valid;
        }
    }

    /**
     * method to add user to Map
     * @param username is users current username to be stored as key in map
     * @param user is current user object to be stored as value in map
     */
    public void addUser(String username, RegisteredUser user) {
        map.put(username, user);
        this.user = user;
    }
    /**
     * getter method for current user instance
     * @return RegisteredUser current user
     */
    public RegisteredUser getUser() {
        return user;
    }

    /**
     * method to set current user in user var on login
     * @param currentUserName the username of the user logging
     */
    public void setUser(String currentUserName) {
        user = map.get(currentUserName);
    }

    /**
     * Takes in the user's input from the SubmitReportActivity and passes it
     * to Water Resource Report. Adds the Water resource report to a list.
     * @param location The location of the water source
     * @param waterType the type of the water source
     * @param waterCondition the conition of the water source
     */
    public void addReport(String location, String waterType, String waterCondition) {
        reportNumber++;
        WaterResourceReport waterResourceReport = new
                WaterResourceReport(location, waterType, waterCondition,
                reportNumber, mapsActivity.getLatLng(), user.getName());
      // MarkerOptions markerOptions = new MarkerOptions();

        GoogleMap mMap = mapsActivity.getMap();

        //System.out.println(waterResourceReport.getLatLng());
        //System.out.println(waterResourceReport.getLocation());
        LatLng currentLat = MapsActivity.getMapActivity().getLatLng();
        markerOptions = new MarkerOptions();
        System.out.println(currentLat + " latLng when errors");
        markerOptions.position(currentLat);

        markerOptions.title(waterResourceReport.getLocation());
        markerOptions.snippet(waterResourceReport.getWaterType()+ ", " + waterResourceReport.getWaterCondition());
        if (markerOptions == null) {
            System.out.println(markerOptions + " actual marker option");
            System.out.println(markerOptions.getTitle() + " the title");
            System.out.println(markerOptions.getPosition() + " the position");
        }
        //mMap.addMarker(markerOptions.position(waterResourceReport.getLatLng()).title(waterResourceReport.getLocation()));
        else {
            mMap.addMarker(markerOptions);
            reportList.add(markerOptions);
        }

    }

    public String printReports() {
        String total = "";
        for (WaterResourceReport report : printList) {
            total += (report.toString() + "\n");
        }
        return total;
    }

    public String printPurityReports() {
        String total = "";
        for (WaterPurityReport report : purityReportList) {
            total += (report.toString() + "\n");
        }
        return total;
    }

    /**
     * method to add the resourceReports to a list
     * @param location string location of the water
     * @param waterType string type of the water
     * @param waterCondition string condition of water
     */
    public void addReportList(String location, String waterType, String waterCondition) {
        WaterResourceReport waterResourceReport = new WaterResourceReport(location, waterType, waterCondition, reportNumber, user.getName());
        printList.add(waterResourceReport);
    }

    public void addPurityReportList(String location, double contaminantPPM,
                                    double virusPPM, String waterCondition) {
        purityReportNumber++;
        WaterPurityReport waterPurityReport = new WaterPurityReport(location, contaminantPPM, virusPPM, waterCondition, purityReportNumber, user.getName());
        purityReportList.add(waterPurityReport);
    }
    /**
     *
     * @return a List that contains the markerOption objects
     * to be added to the map.  This is used to repopulate the map
     * after closing and returning
     */
    public List getReportList() {
        return reportList;
    }

    public List getPrintList() { return printList; }

    public List getPurityReportList() { return purityReportList; }

    public int getReportNumber() { return reportNumber; }

    public int getPurityReportNumber() { return purityReportNumber; }

    public MarkerOptions getMarkerOptions() { return markerOptions; }

    public void setModelFacade(ModelFacade set) { mf = set; }

    public ModelFacade getModelFacade() { return mf; }

    public ModelFacade getUpdatedModelFacade() { return new ModelFacade(); }

}
