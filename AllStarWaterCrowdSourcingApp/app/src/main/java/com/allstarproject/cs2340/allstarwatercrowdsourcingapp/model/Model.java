package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.EditText;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.GoogleMap;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller.MapsActivity;
import java.io.Serializable;

/**
 * Model class for this application
 * Created by Austin on 2/12/17.
 */

public class Model extends FragmentActivity implements Serializable {

    public transient EditText txtVirus;
    public transient EditText txtStartYear;
    public transient EditText txtStartMonth;
    public transient EditText txtEndYear;
    public transient EditText txtEndMonth;

    /**
     * map to store user objects
     */
    private final Map<String, RegisteredUser> map;

    /**
     * userList
     */
    private final List<RegisteredUser> users;
    /**
     * current user (could be a RegisteredUser or any subtype)
     */
    private static transient RegisteredUser user;
    /**
     * list containing WaterReports
     */
    private final List<Markers> reportList = new java.util.LinkedList<>();
    /**
     * list containing data to be printed for WaterReports
     */
    private final List<WaterResourceReport> printList;
    /**
     * list containing WaterPurityReports
     */
    private final List<WaterPurityReport> purityReportList;
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
    private transient MarkerOptions markerOptions;

    // for testing only
    private String lastDateAndTime = "";

    /**
     * Singleton constructor
     */
    public Model() {
        map = new HashMap<>();
        users = new java.util.LinkedList<>();
        printList = new ArrayList<>();
        purityReportList = new ArrayList<>();
        reportNumber = 0;
        purityReportNumber = 0;

    }

    /**
     * method used to verify password on login
     * @param username users username from text field
     * @param password users password from text field
     * @return boolean if user is valid and password is valid
     */
    public boolean verify(String username, String password) {
        System.out.println(map.get(username) + " password in map");
        if (map.containsKey(username)) {
            System.out.println("I HAVE THE USERNAME!");
        } else {
            System.out.println("I dont have it");
        }
        if (map.containsKey(username) && password.equals(
                map.get(username).getPassword())) {
            System.out.println(username);
            return true;
        } else {
            return false;
        }
    }

    /**
     * method to add user to Map
     * @param username is users current username to be stored as key in map
     * @param user is current user object to be stored as value in map
     */
    public void addUser(String username, RegisteredUser user) {
        //Log.d("Verify user add model", username + " was added");
        users.add(user);
        map.put(username, user);
        Model.user = user;
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
     * this is for testing purposes.  adds a current user to the Model
     *
     */
    public void setUser() {
        user = new RegisteredUser("aduncan37", "abcd", "austin", "aduncan37", "Manager" );
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
                reportNumber, MapsActivity.getLatLng(), user.getName());
        GoogleMap mMap = MapsActivity.getMap();
        Markers marker = new Markers(waterResourceReport.getLocation(),
                MapsActivity
                .getLatLng(), waterResourceReport.getWaterType()
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
        } else {
            mMap.addMarker(markerOptions);
            System.out.println(marker + "HERE LINE 177!");
            System.out.println(reportList + "HERE LINE 178!");
            reportList.add(marker);
        }

        printList.add(waterResourceReport);
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
     * Old method to add the reports to a list. *only kept for testing*
     *
     * @param location string location of the water
     * @param waterType string type of the water
     * @param waterCondition string condition of water
     */
    public void addReportList(String location, String waterType,
                              String waterCondition) {
        WaterResourceReport waterResourceReport = new WaterResourceReport(
                location, waterType, waterCondition, ++reportNumber,
                user.getName());
        printList.add(waterResourceReport);
        lastDateAndTime = waterResourceReport.getDateAndTime();
    }
    /**
     * method to add the purityReports to a list
     * @param location string location of the water
     * @param virusPPM double type of the virusPPM
     * @param waterCondition string type of the water condition
     * @param virusType string type of whether it's a contaminant or virus
     */
    public void addPurityReportList(String location, double virusPPM,
                                    String waterCondition, String virusType) {
        purityReportNumber++;
        WaterPurityReport waterPurityReport = new WaterPurityReport(location,
                waterCondition, virusPPM, virusType, purityReportNumber,
                user.getName());
        purityReportList.add(waterPurityReport);
        lastDateAndTime = waterPurityReport.getDateAndTime();
    }

    /**
     * method for Juit testing.  Returns the auto-generated purity report number
     * @return the auto-generated purity report number
     */
    public int getPurityReportNumber() {
        return purityReportNumber;
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

    /**
     * getter method to return the list of all submitted PurityReports
     * @return the list of Submitted PurityReports
     */
    public List getPurityReportList() {
        return purityReportList;
    }

    /**
     * utility method to regenerate the RegisteredUser Map object after load
     * from binary
     */
    public void regenMap() {
        Log.d("List size after load:", users.size() + " .");
        for (RegisteredUser u : users) {
            map.put(u.getUserName(), u);
        }
        Log.d("Regen map:", map.size() + " is the size");
    }

    /**
     * Method to get the date and time for the last report created.
     * *Only for testing*
     *
     * @return the date and time of the last report added
     */
    public String getLastDateAndTime() {
        return lastDateAndTime;
    }

}
