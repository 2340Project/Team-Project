package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Austin on 3/12/17.
 */

public class WaterPurityReport {

    private int reportNumber;
    private static String location;
    private double virusPPM;
    private double contaminantPPM;
    private String waterCondition;
    private DateFormat dateFormat;
    private java.util.Date date;
    private String dateAndTime;
    private String creator;


    /**
     * Constructor to instantiate the fields for the water resource report
     * @param location The location of the water source
     * @param waterCondition the condition of the water source
     */

    public WaterPurityReport(String location, double contaminantPPM,
                               double virusPPM, String waterCondition, int reportNumber, String name) {
        this.location = location;
        this.contaminantPPM = contaminantPPM;
        this. virusPPM = virusPPM;
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
    public static String getLocation() {
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

    public double getVirusPPM() {
        return virusPPM;
    }

    public void setVirusPPM(double virusPPM) {
        this.virusPPM = virusPPM;
    }

    public double getContaminantPPM() {
        return contaminantPPM;
    }

    public void setContaminantPPM(double contaminantPPM) {
        this.contaminantPPM = contaminantPPM;
    }


    /**
     * This represents a String representation of all attributes per report
     * @return the String of report number with the Location: water type,
     * water condition per that report
     */
    @Override
    public String toString() {
        return "" + reportNumber + ". " + dateAndTime + " , " + "Submitted by: " + creator + " , " + location + ": " + virusPPM + " Virus PPM , " + contaminantPPM + " Contaminant PPM , "
                + waterCondition + "\n";
    }
}
