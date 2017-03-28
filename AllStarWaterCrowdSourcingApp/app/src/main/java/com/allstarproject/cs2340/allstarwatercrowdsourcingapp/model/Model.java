package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.GoogleMap;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller.MapsActivity;
import java.io.Serializable;

/**
 * Created by Austin on 2/12/17.
 */

public class Model extends FragmentActivity implements Serializable {

    public EditText txtVirus;
    public EditText txtStartYear;
    public EditText txtStartMonth;
    public EditText txtEndYear;
    public EditText txtEndMonth;

    /**
     * map to store user objects
     */
    private Map<String, RegisteredUser> map;

    /**
     * userList
     */
    private List<RegisteredUser> users;
    /**
     * current user (could be a RegisteredUser or any subtype)
     */
    private static transient RegisteredUser user;
    /**
     * list containing WaterReports
     */
    private List<Markers> reportList = new java.util.LinkedList();
    /**
     * list containing data to be printed for WaterReports
     */
    private List<WaterResourceReport> printList;
    /**
     * list containing WaterPurityReports
     */
    private List<WaterPurityReport> purityReportList;
    /**
     * Report number for WaterResourceReport
     */
    private int reportNumber;
    /**
     * report number for WaterPurityReport
     */
    private int purityReportNumber;
    /**
     * mapsActivity instance
     */
    private transient MapsActivity mapsActivity = MapsActivity.getMapActivity();

    private transient MarkerOptions markerOptions;

    /**
     * Singleton constructor
     */
    public Model() {
        map = new HashMap<>();
        users = new java.util.LinkedList<>();
//        reportList = new ArrayList<>();
        printList = new ArrayList<>();
        purityReportList = new ArrayList<>();
        reportNumber = 0;
        purityReportNumber = 0;

    }
    public Map<String, RegisteredUser> getUserMap() {
        return map;
    }


    /**
     * method to get instance of Singleton model object
     * @return single instance of model
     */
//    public static Model getInstance() {
//
//        System.out.println(model + " the model instance before passed");
//        return model;
//    }

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
        Log.d("Verify user add model", username + " was added");
        users.add(user);
        map.put(username, user);
        this.user = user;
    }

    /**
    /**
     * getter method for current user instance
     * @return RegisteredUser current user
     */
    public static RegisteredUser getUser() {
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
    public void addReport(String location, String waterType,
                          String waterCondition) {
        reportNumber++;

        WaterResourceReport waterResourceReport = new
                WaterResourceReport(location, waterType, waterCondition,
                reportNumber, mapsActivity.getLatLng(), user.getName());
        GoogleMap mMap = mapsActivity.getMap();
        Markers marker = new Markers(waterResourceReport.getLocation(), MapsActivity
                .getMapActivity().getLatLng(), waterResourceReport.getWaterType()
                + ", " + waterResourceReport.getWaterCondition());


        System.out.println(marker + "HERE LINE 163!");
        markerOptions = new MarkerOptions();
        markerOptions.position(marker.getLatLong());

        markerOptions.title(marker.getTitle());
        markerOptions.snippet(marker.getSnippet());
        if (markerOptions == null) {
            System.out.println(markerOptions + " actual marker option");
            System.out.println(markerOptions.getTitle() + " the title");
            System.out.println(markerOptions.getPosition() + " the position");
        }
        //mMap.addMarker(markerOptions.position(waterResourceReport.getLatLng()).title(waterResourceReport.getLocation()));
        else {
            mMap.addMarker(markerOptions);
            System.out.println(marker + "HERE LINE 177!");
            System.out.println(reportList + "HERE LINE 178!");
            reportList.add(marker);
        }
    }

    /**
     * this method prints the water resource reports
     * @return a string representation of the water resource reports
     */
    public String printReports() {
        String total = "";
        for (WaterResourceReport report : printList) {
            total += (report.toString() + "\n");
        }
        return total;
    }
    /**
     * this method prints the water purity reports
     * @return a string representation of the water purity reports
     */
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
    public void addReportList(String location, String waterType,
                              String waterCondition) {
        WaterResourceReport waterResourceReport = new WaterResourceReport(
                location, waterType, waterCondition, reportNumber,
                user.getName());
        printList.add(waterResourceReport);
    }
    /**
     * method to add the purityReports to a list
     * @param location string location of the water
     * @param virusPPM double type of the virusPPM
     * @param waterCondition string type of the water condition
     */
    public void addPurityReportList(String location,
                                    double virusPPM, String waterCondition, String virusType) {
        purityReportNumber++;
        WaterPurityReport waterPurityReport = new WaterPurityReport(location,
                waterCondition, virusPPM, virusType, purityReportNumber,
                user.getName());
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

    public ModelFacade getUpdatedModelFacade() { return new ModelFacade(); }

    public void regenMap() {
        Log.d("List size after load:", users.size() + " .");
        for (RegisteredUser u : users) {
            map.put(u.getUserName(), u);
        }
        Log.d("Regen map:", map.size() + " is the size");
    }

}
