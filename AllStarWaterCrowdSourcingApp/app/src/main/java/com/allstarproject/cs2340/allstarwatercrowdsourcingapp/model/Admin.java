package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

/**
 * Created by Austin on 2/19/17.
 */

public class Admin extends RegisteredUser {
    /**
     * Constructor for creating Admin
     * this is a subclass of RegisteredUser
     * is necessary for using instanceof and validating proper account type for access to certain
     * app features and functions
     * @param username username to be set
     * @param password password to be set
     * @param name name to be set
     * @param email email to be set
     */
    public Admin(String username, String password, String name, String email) {
        super(username, password, name, email);
    }
}
