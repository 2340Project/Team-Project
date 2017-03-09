package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

/**
 * Created by Austin on 2/19/17.
 */

public class Manager extends RegisteredUser {
    /**
     * Manager constructor.  A subclass of RegisteredUser.  Is necessary for using instanceof
     * to validate account type in order to give access to certain functionality
     * @param username username to be set
     * @param password password to be set
     * @param name name to be set
     * @param email email to be set
     */
    public Manager(String username, String password, String name, String email) {
        super(username, password, name, email);
    }
}
