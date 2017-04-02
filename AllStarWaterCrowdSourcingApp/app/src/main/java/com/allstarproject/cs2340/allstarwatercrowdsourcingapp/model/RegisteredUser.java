package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

import java.io.Serializable;
import android.util.Log;
/**
 * RegisteredUser class
 * RegisteredUser objects are objects representing anyone who has registered in
 * the application Their account type (Manager/Worker/etc) will be specified
 * by which boolean flag is flipped to true for them
 * Created by Austin on 2/12/17.
 */

public class RegisteredUser implements Serializable {
    private final ModelFacade modelFacade = ModelFacade.getModelFacade();
    private String name;
    private String userName;
    private String password;
    private String email;
    private boolean isUser = false;
    private boolean isWorker = false;
    private boolean isManager = false;
    private boolean isAdmin = false;

    /**
     * constructor for instantiating a user object on login
     * @param username users chosen username
     * @param password users chosen password
     */
    private RegisteredUser(String username, String password) {
        this.userName = username;
        this.password = password;
        Model model = modelFacade.getModelInstance();

        model.addUser(username, this);
        //Log.d("Add user", "User was just added to the map");
    }

    /**
     * constructor for creating a new user to be stored in the map
     * @param username the User's username
     * @param password the User's password
     * @param name the User's name
     * @param email the User's email
     * @param acctType string containing the selected acct type
     */
    public RegisteredUser(String username,
                          String password, String name,
                          String email,  String acctType) {
        this(username, password);
        this.name = name;
        this.email = email;
        if (acctType.equals("User")) {
            this.isUser = true;
        } else if (acctType.equals("Worker")) {
            this.isWorker = true;
        } else if (acctType.equals("Manager")) {
            this.isManager = true;
        } else if (acctType.equals("Admin")) {
            this.isAdmin = true;
        }
    }

    /**
     * setter method for changing the user's name
     * @param name new name to set for User
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter method for changing the users email
     * @param email new email to set for user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * setter method for changing the users password
     * @param password new password to set for user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getter method for getting the user's name that is currently stored
     * @return String of the users current name
     */
    public String getName() {
        return name;
    }

    /**
     * getter method for the user's current username
     * @return a String of the users Username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * getter method for the user's email
     * @return a String of the users Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * a getter method for the user's current password
     * @return a String of the user' password
     */
    public String getPassword() {
        return password;
    }


    /**
     * getter method to return the boolean result of the type of User the
     * current RegisteredUser is
     * @return return true/false for is worker
     */
    public boolean getIsWorker() {
        return isWorker;
    }

    /**
     * getter method to return the boolean result of the type of User the
     * current RegisteredUser is
     * @return return true/false for is manager
     */
    public boolean getIsManager() {
        return isManager;
    }

}
