package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;



import com.google.android.gms.maps.model.LatLng;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.Serializable;
import java.util.Locale;

/**
 * WaterResourceReport class
 * these objects will represent reports submitted that tell others where water
 * is located, what type of water it is, and the current status of the water
 * (based on looks, these people are not experts)
 * Created by Austin on 2/26/17.
 */

public class WaterResourceReport implements Serializable {
    private int reportNumber;
    private String location;
    private String waterType;
    private String waterCondition;
    private final String dateAndTime;
    private final DateFormat dateFormat;
    private final java.util.Date date;
    private final String creator;
    private LatLng latLng;

    /**
     * Constructor to instantiate the fields for the water resource report
     * @param location The location of the water source
     * @param waterType the type of the water source
     * @param waterCondition the condition of the water source
     * @param reportNumber the report number of the water resource report
     * @param latLng the latitude and longitude of the water resource report
     * that the user reported
     * @param name the name of the user who is submitting the water resource
     * report
     */
    public WaterResourceReport(String location, String waterType,
                               String waterCondition, int reportNumber,
                               LatLng latLng, String name) {
        this.location = location;
        this.waterType = waterType;
        this.waterCondition = waterCondition;
        this.reportNumber = reportNumber;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        date = new java.util.Date();
        dateAndTime = dateFormat.format(date);
        creator = name;
        this.latLng = latLng;
    }
    /**
     * Old constructor without the map data. *Only kept for testing*
     *
     * @param location The location of the water source
     * @param waterType the type of the water source
     * @param waterCondition the condition of the water source
     * @param reportNumber the report number of the water resource report
     * @param name the name of the user who is submitting the water resource
     * report
     */
    public WaterResourceReport(String location, String waterType,
                               String waterCondition, int reportNumber,
                               String name) {
        this.location = location;
        this.waterType = waterType;
        this.waterCondition = waterCondition;
        this.reportNumber = reportNumber;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        date = new java.util.Date();
        dateAndTime = dateFormat.format(date);
        creator = name;
    }

    /**
     * getter method for the user's input of the water resource report
     * @return a String of the location of the water resource report
     */
    public String getLocation() {
        return location;
    }


    /**
     * getter method for the water type of the water resource report
     * @return a String of the locations water type
     */
    public String getWaterType() {
        return waterType;
    }

    /**
     * getter method for the water condition of the water resource report
     * @return a String of the locations water condition
     */
    public String getWaterCondition() {
        return waterCondition;
    }

    /**
     * This represents a String representation of all attributes per report
     * @return the String of report number with the Location: water type,
     * water condition per that report
     */
    @Override
    public String toString() {

        return "" + reportNumber + ". " + dateAndTime + " , " + creator + " , "
                + location + ": " + waterType + ", " + waterCondition;
    }

    /**
     * Method to get the date and time for this report. *Only for testing*
     *
     * @return the reports date and time
     */
    public String getDateAndTime() {
        return dateAndTime;
    }
}
