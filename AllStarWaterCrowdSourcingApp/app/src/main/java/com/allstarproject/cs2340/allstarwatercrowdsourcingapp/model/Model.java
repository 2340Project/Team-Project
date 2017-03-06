package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

//import android.support.annotation.NonNull;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.FragmentManager;

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


import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.MarkerOptions;


import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller.SubmitReportActivity;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.GoogleMap;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller.MapsActivity;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;


/**
 * Created by Austin on 2/12/17.
 */

public class Model extends FragmentActivity {

    GoogleMap mMap = MapsActivity.getmMap();

    /**
     * instance of singleton Model
     */
    private static final Model model = new Model();
    /**
     * map to store user object in current run of app
     */
    private static Map<String, RegisteredUser> map;
    /**
     * current user (could be a RegisteredUser or any subtype)
     */
    private RegisteredUser user;
    private List<WaterResourceReport> reportList;
    private int reportNumber;



    /**
     * Singleton constructor
     */
    private Model() {
        map = new HashMap<String, RegisteredUser>();
        //map.put("user", "pass");
        reportList = new ArrayList<WaterResourceReport>();
        reportNumber = 0;
    }

    /**
     * This method prints the reports and stores them in a String which then
     * is used invoked in ViewWaterReportActivity
     * @return the string containing all submitted water reports with each
     * one on its own line.
     */
    public String printReports() {
        String total = "";
        for (WaterResourceReport report : reportList) {
            total += (report.toString() + "\n");
        }
        return total;
    }
    /**
     * method to get instance of Singleton model object
     * @return single instance of model
     */
    public static Model getInstance() {
        return model;
    }

    /**
     * method used to verify password on login
     * @param username users username from textfield
     * @param password users password from textfield
     * @return boolean if user is valid and password is valid
     */
    public static boolean verify(String username, String password) {
        boolean valid = false;
        System.out.println(map.get(username) + " password in map");
        if (map.containsKey(username) && password.equals(map.get(username).getPassword())) {
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
    public RegisteredUser getUser( ) {
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
                reportNumber, MapsActivity.getLatLng());
      // MarkerOptions markerOptions = new MarkerOptions();

        GoogleMap mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

        System.out.println(waterResourceReport.getLatLng());
        System.out.println(waterResourceReport.getLocation());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(waterResourceReport.getLatLng());

        markerOptions.title(waterResourceReport.getLocation());

//        mMap.addMarker(markerOptions.position(waterResourceReport.getLatLng()).title(waterResourceReport.getLocation()));
        markerOptions.snippet(waterResourceReport.getWaterType()+ ", " + waterResourceReport.getWaterCondition());
        mMap.addMarker(markerOptions);



    }

}
