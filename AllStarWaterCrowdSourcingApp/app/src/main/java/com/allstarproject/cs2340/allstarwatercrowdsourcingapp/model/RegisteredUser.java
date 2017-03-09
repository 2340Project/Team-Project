package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

/**
 * Created by Austin on 2/12/17.
 */

public class RegisteredUser {
    Model model = Model.getInstance();
    private String name;
    private String userName;
    private String password;
    private String email;

    /**
     * constructor for instantiating a user object on login
     * @param username users chosen username
     * @param password users chosen password
     */
    public RegisteredUser(String username, String password) {
        this.userName = username;
        this.password = password;
        model.addUser(username, this);

    }

    /**
     * constructor for creating a new user to be stored in the map
     * @param username the User's username
     * @param password the User's password
     * @param name the User's name
     * @param email the User's email
     */
    public RegisteredUser(String username
            , String password, String name
            , String email) {
        this(username, password);
        this.name = name;
        this.email = email;
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
     * setter method for changing the users username
     * @param username new username to set for user
     */
    public void setUserName(String username) {
        this.userName = username;
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
}
