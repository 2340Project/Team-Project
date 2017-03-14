package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;



import com.google.android.gms.maps.model.LatLng;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Austin on 2/26/17.
 */

public class WaterResourceReport {
    private int reportNumber;
    private String location;
    private String waterType;
    private String waterCondition;
    private String dateAndTime;
    private DateFormat dateFormat;
    private java.util.Date date;
    private String creator;
    private static LatLng latLng;

    /**
     * Constructor to instantiate the fields for the water resource report
     * @param location The location of the water source
     * @param waterType the type of the water source
     * @param waterCondition the conition of the water source
     */

    public WaterResourceReport(String location, String waterType,
                               String waterCondition, int reportNumber, LatLng latLng, String name) {
        this.location = location;
        this.waterType = waterType;
        this.waterCondition = waterCondition;
        this.reportNumber = reportNumber;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = new java.util.Date();
        dateAndTime = dateFormat.format(date);
        creator = name;
        this.latLng = latLng;

    }

    public WaterResourceReport(String location, String waterType, String waterCondition, int reportNumber, String name) {
        this.location = location;
        this.waterType = waterType;
        this.waterCondition = waterCondition;
        this.reportNumber = reportNumber;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
     * setter method for the location of the water report that the user
     * inputted
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * getter method for the water type of the water resource report
     * @return a String of the locations water type
     */
    public String getWaterType() {
        return waterType;
    }

    /**
     * setter method for the water type of the water resource report that the
     * user inputted
     */
    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }

    /**
     * getter method for the water condition of the water resource report
     * @return a String of the locations water condition
     */
    public String getWaterCondition() {
        return waterCondition;
    }

    /**
     * setter method for the locations water condition
     */
    public void setWaterCondition(String waterCondition) {
        this.waterCondition = waterCondition;
    }

    /**
     * getter method for the water resource report number
     * @return an int of the locations report number
     */
    public int getReportNumber() {
        return reportNumber;
    }

    /**
     * setter method for the water resource report number
     */
    public void setReportNumber(int reportNumber) {
        this.reportNumber = reportNumber;
    }

    /**
     * getter method for the water resource lattitude and longitude for the
     * submitted water report on the user's click in the map.
     * @return the lattitude and longitude
     */
    public static LatLng getLatLng() {
        return latLng;
    }

    /**
     * setter method for the water resource lattitude and longitude for the
     * submitted water report on the user's click in the map.
     */
    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }


    /**
     * This represents a String representation of all attributes per report
     * @return the String of report number with the Location: water type,
     * water condition per that report
     */
    @Override
    public String toString() {
        return "" + reportNumber + ". " + dateAndTime + " , " + location + ": " + waterType + ", "
                + waterCondition;
    }

}
