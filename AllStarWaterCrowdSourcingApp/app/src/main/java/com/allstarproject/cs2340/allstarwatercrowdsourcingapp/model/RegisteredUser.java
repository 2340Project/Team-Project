package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

/**
 * Created by Austin on 2/12/17.
 */

public class RegisteredUser {
    Model model = Model.getInstance();

    /**
     * constructor to make new user and add to Map in model
     * @param username users chosen username
     * @param password users chosen password
     */
    public RegisteredUser(String username, String password) {
        model.addUser(username, password);
    }
}
