package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Austin on 3/12/17.
 */

public class WaterPurityReport implements Serializable{

    private int reportNumber;
    private String virusAndContamType;
    private String location;
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
     * @param virusPPM the amount of the virusPPM
     * @param waterCondition the water condition of the water purity report
     * @param reportNumber the number associated with the water purity report
     * @param name the name of the workers || managers who created the water
     * purity report
     */

    public WaterPurityReport(String location, String waterCondition ,
                               double virusPPM, String vType,
                             int reportNumber, String name) {
        this.location = location;
        this.virusAndContamType = vType;
        this.virusPPM = virusPPM;
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

    public java.util.Date getDate() { return date; }
    /**
     * getter method for returning type of virus/contaminant in a report
     * @return the type of virus
     */
    public String getVirusType() { return virusAndContamType; }

    /**
     * setter method for the location of the water report that the user
     * inputted
     * @param location the location of the water resource
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
     * @param waterCondition the water condition of a particular water source
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
     * @param reportNumber the report number of a particular water resource
     * report
     */
    public void setReportNumber(int reportNumber) {
        this.reportNumber = reportNumber;
    }

    /**
     * A getter for the virusPPM
     * @return the amount of the virus PPM corresponding to a particular
     * water purity report
     */
    public double getVirusPPM() {
        return virusPPM;
    }

    /**
     * A setter for the virusPPM
     * @param virusPPM setting the amount of the virus PPM corresponding to a
     * particular water purity report
     */
    public void setVirusPPM(double virusPPM) {
        this.virusPPM = virusPPM;
    }
    /**
     * A getter for the contaminantPPM
     * @return the amount of the contaminant PPM corresponding to a particular
     * water purity report
     */
    public double getContaminantPPM() {
        return contaminantPPM;
    }
    /**
     * A setter for the ContaminantPPM
     * @param contaminantPPM setting the amount of the contaminant PPM
     *                       corresponding to a
     * particular water purity report
     */
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
        return "" + reportNumber + ". " + dateAndTime + " , "
                + "Submitted by: " + "" + creator + " , " + location + ": "
                + virusPPM + " Virus PPM , " + contaminantPPM
                + " Contaminant PPM , " + waterCondition + "\n";
    }
}
