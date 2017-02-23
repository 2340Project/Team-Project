package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

/**
 * Created by Austin on 2/19/17.
 */

public class Worker extends RegisteredUser {
    /**
     * Worker constructor.  A subclass of RegisteredUser.  The class is necessary for using
     * instanceof to verify account type in order to allow access to certain features of the app.
     * @param username username to be set
     * @param password password to be set
     * @param name name to be set
     * @param email email to be set
     */
    public Worker(String username, String password, String name, String email) {
        super(username, password, name, email);
    }
}
