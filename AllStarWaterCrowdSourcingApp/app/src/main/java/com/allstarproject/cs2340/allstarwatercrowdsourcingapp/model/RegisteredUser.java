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
     * constructor to make new user and add to Map in model
     * @param username users chosen username
     * @param password users chosen password
     */
    public RegisteredUser(String username, String password) {
        this.userName = username;
        this.password = password;
        model.addUser(username, this);

    }
    public RegisteredUser(String username
            , String password, String name
            , String email) {
        this(username, password);
        this.name = name;
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setUserName(String username) {
        this.userName = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public String getUserName() {
        return userName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}
