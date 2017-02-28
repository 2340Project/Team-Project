package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Danny on 2/19/17.
 */

public class DatabseOperations extends SQLiteOpenHelper {
    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE " + tabelData.TabelInfo.DATABASE_NAME + "("
            + tabelData.TabelInfo.USER_NAME + " TEXT PRIMARY KEY,"
            + tabelData.TabelInfo.USER_PASS + " TEXT,"
            + tabelData.TabelInfo.LAST_NAME + " TEXT,"
            + tabelData.TabelInfo.EMAIL_NAME + " TEXT,"
            + tabelData.TabelInfo.USER_TYPE + " TEXT);";

    public DatabseOperations(Context context) {
        super(context,  tabelData.TabelInfo.DATABASE_NAME, null, database_version);
        Log.d("Databse Operations", "DB Created");
    }


    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
        Log.d("Databse Operations", "TABLE Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void putInformation(DatabseOperations dob, String lName, String uName, String pWord, String email, String accType) {
        SQLiteDatabase SQ = dob.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(tabelData.TabelInfo.LAST_NAME, lName);
        cv.put(tabelData.TabelInfo.USER_NAME, uName);
        cv.put(tabelData.TabelInfo.USER_PASS, pWord);
        cv.put(tabelData.TabelInfo.EMAIL_NAME, email);
        cv.put(tabelData.TabelInfo.USER_TYPE, accType);
        long k = SQ.insert(tabelData.TabelInfo.TABLE_NAME, null, cv);
        Log.d("Databse Operations", "DATA SAVED");
    }

    public Cursor getInformation(DatabseOperations dobp) {
        SQLiteDatabase SQ = dobp.getReadableDatabase();
        String[] columns = {tabelData.TabelInfo.USER_NAME, tabelData.TabelInfo.USER_PASS};
        Cursor CR = SQ.query(tabelData.TabelInfo.TABLE_NAME, columns, null, null, null, null, null);
        return CR;
    }
}
