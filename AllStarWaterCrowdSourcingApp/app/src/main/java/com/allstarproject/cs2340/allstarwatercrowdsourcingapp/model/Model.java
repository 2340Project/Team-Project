package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Austin on 2/12/17.
 */

public class Model {
    /**
     * instance of singleton Model
     */
    private static final Model model = new Model();
    /**
     * map to store user object in current run of app
     */
    private static Map<String, RegisteredUser> map;
    /**
     * current user (could be a RegisteredUser or any subtype)
     */
    private RegisteredUser user;

    /**
     * Singleton
     */
    private Model() {
        map = new HashMap<String, RegisteredUser>();
        //map.put("user", "pass");
    }

    /**
     *
     * @return single instance of model
     */
    public static Model getInstance() {
        return model;
    }

    /**
     *
     * @param username users username from textfield
     * @param password users password from textfield
     * @return boolean if user is valid and password is valid
     */
    public static boolean verify(String username, String password) {
        boolean valid = false;
        System.out.println(map.get(username) + " password in map");
        if (map.containsKey(username) && password.equals(map.get(username).getPassword())) {
            valid = true;
            return valid;
        } else {
            return valid;
        }
    }

    /**
     * method to add user to Map
     */
    public void addUser(String username, RegisteredUser user) {
        map.put(username, user);
        this.user = user;
    }
    /**
     * getter method for current user instance
     */
    public RegisteredUser getUser( ) {
        return user;
    }



}
