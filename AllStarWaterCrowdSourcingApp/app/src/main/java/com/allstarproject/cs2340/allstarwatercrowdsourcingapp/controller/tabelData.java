package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.provider.BaseColumns;

/**
 * Created by Danny on 2/19/17.
 */

public class tabelData {
    public tabelData() {

    }

    public static abstract class TabelInfo implements BaseColumns {
        public static final String LAST_NAME = "name";
        public static final String EMAIL_NAME = "email";
        public static final String USER_NAME = "user";
        public static final String USER_PASS =  "pass";
        public static final String USER_TYPE =  "tpye";
        public static final String DATABASE_NAME = "user_info";
        public static final String TABLE_NAME = "reg_info";
    }
}
