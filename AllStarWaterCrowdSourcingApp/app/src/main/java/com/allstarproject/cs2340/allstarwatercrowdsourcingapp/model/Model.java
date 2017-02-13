package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Austin on 2/12/17.
 */

public class Model {
    private static final Model model = new Model();
    private static Map<String, String> map;

    private RegisteredUser registeredUser;

    /**
     * Singleton
     */
    private Model() {
        map = new HashMap<String, String>();
        map.put("user", "pass");
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
        if (map.containsKey(username) && password == map.get(username)) {
            valid = true;
            return valid;
        } else {
            return valid;
        }
    }

    /**
     * method to create new user
     */
    public void createUser() {
    }

    /**
     * method to add user to Map
     */
    public void addUser(String user, String password) {
    }



}
