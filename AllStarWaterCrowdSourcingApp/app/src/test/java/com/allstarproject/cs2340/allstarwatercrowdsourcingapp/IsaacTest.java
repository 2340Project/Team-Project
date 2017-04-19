package com.allstarproject.cs2340.allstarwatercrowdsourcingapp;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.ModelFacade;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.RegisteredUser;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Austin on 4/4/17.
 */

public class IsaacTest {

    ModelFacade modelFacade = ModelFacade.getModelFacade();
    Model model = modelFacade.getModelInstance();
    LinkedList<RegisteredUser> list = new LinkedList<>();
    Map<String, RegisteredUser> map = new HashMap<>();
    @Before
    public void setup() {
        //location = atlanta
        //virusPPM = 0.784
        //waterCondition = good
        //virusType = ebola
        for (int i = 0; i < 100; i++) {
            list.add(new RegisteredUser("user" + i*i, "password" + i*i));
        }
        for (RegisteredUser u : list) {
            map.put(u.getUserName(), u);
        }
        model.setUserList(list);
        //model.setUser();
    }

    @Test
    public void testMapSize() {
        assertTrue(map.size() == 100);
    }
    //regen map test
    @Test
    public void testAddedTrue() {
        model.regenMap();
        assertTrue(model.getUserMap().size() == 100);

    }



    @Test
    public void testUserEquality() {
        model.setUserList(new LinkedList<RegisteredUser>());
        model.regenMap();
        int count = 0;
        for (int i = 0; i < 100; i ++) {
            assertEquals( model.getUserMap().get("user" + i*i), map.get("user" + i*i) );
            //model.getUserMap().get("sa" + i*i).equals(map.get("sa" + i*i));

        }
    }
}
