package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    EditText LNAME,EMAIL,USER_NAME,USER_PASS,CON_PASS;
    Spinner U_TYPE;
    String lname, uname, email, pword, utype, cpass;
    Button RG;
    Context ctx = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        LNAME = (EditText) findViewById(R.id.txtName);
        EMAIL = (EditText) findViewById(R.id.txtEmail);
        USER_NAME = (EditText) findViewById(R.id.txtUserName);
        USER_PASS = (EditText) findViewById(R.id.txtPassword);
        CON_PASS = (EditText) findViewById(R.id.txtConfPassword);
        U_TYPE = (Spinner) findViewById(R.id.cmbUType);

        RG = (Button) findViewById(R.id.btnRegisterMain);
        RG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lname = LNAME.getText().toString();
                uname = USER_NAME.getText().toString();
                pword = USER_PASS.getText().toString();
                email = EMAIL.getText().toString();
                cpass = CON_PASS.getText().toString();
                utype = U_TYPE.getSelectedItem().toString();

                if(! (pword.equals(cpass))) {
                    Toast.makeText(getBaseContext(), "Passwords dont mach", Toast.LENGTH_LONG).show();
                } else {
                    DatabseOperations db = new DatabseOperations(ctx);
                    db.putInformation(db, lname, uname, pword, email, utype);
                    Toast.makeText(getBaseContext(), "You are Registered!!", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });


        Button btnRCancel = (Button) findViewById(R.id.btnRegisterWelcome);
        btnRCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
        startActivity(intent);
    }
}
