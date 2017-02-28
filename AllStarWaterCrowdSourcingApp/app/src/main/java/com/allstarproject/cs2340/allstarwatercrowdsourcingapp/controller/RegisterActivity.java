package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.EditText;
import android.content.Intent;
<<<<<<< HEAD
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
=======
import android.widget.TextView;
>>>>>>> 3fed251c40fbdbbd93bc18a81460702448e26f63

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.RegisteredUser;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.*;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
<<<<<<< HEAD
    EditText LNAME,EMAIL,USER_NAME,USER_PASS,CON_PASS;
    Spinner U_TYPE;
    String lname, uname, email, pword, utype, cpass;
    Button RG;
    Context ctx = this;
=======
    Model model = Model.getInstance();
    Spinner spinner;
    EditText txtUserName;
    EditText txtName;
    EditText txtEmail;
    EditText txtPassword;
    EditText txtConfPassword;

    /**
     * onCreate used to setup RegisterActivity on creation
     * @param savedInstanceState is bundled data passed in to use at creation
     */
>>>>>>> 3fed251c40fbdbbd93bc18a81460702448e26f63
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

<<<<<<< HEAD

        Button btnRCancel = (Button) findViewById(R.id.btnRegisterWelcome);
=======
        txtUserName = (EditText) findViewById(R.id.txtCurrentName);
        txtName = (EditText) findViewById(R.id.txtName);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtConfPassword = (EditText) findViewById(R.id.txtConfPassword);

        spinner = (Spinner) findViewById(R.id.spinner);

        Button btnRCancel = (Button) findViewById(R.id.btnCancelRegister);
>>>>>>> 3fed251c40fbdbbd93bc18a81460702448e26f63
        btnRCancel.setOnClickListener(this);
        Button btnSubmitRegister = (Button) findViewById(R.id.btnSubmitRegister);
        btnSubmitRegister.setOnClickListener(this);
    }

    /**
     * onClick method to handle the cancel button being clicked by returning you to Welcome
     * @param v the current view
     */
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
           case R.id.btnCancelRegister:
               Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
               startActivity(intent);
               break;

            case R.id.btnSubmitRegister:
                Intent intent2 = new Intent(RegisterActivity.this, LoginActivity.class);
                if (txtConfPassword.getText().toString().equals(txtPassword.getText().toString())) {
                    if (spinner.getSelectedItem() == "User") {
                        new RegisteredUser(txtUserName.getText().toString()
                                , txtPassword.getText().toString(), txtName.getText().toString()
                                ,txtEmail.getText().toString());
                    } else if (spinner.getSelectedItem() == "Manager") {
                        new Manager(txtUserName.getText().toString()
                                , txtPassword.getText().toString(), txtName.getText().toString()
                                ,txtEmail.getText().toString());
                    } else if (spinner.getSelectedItem() == "Worker") {
                        new Worker(txtUserName.getText().toString()
                                , txtPassword.getText().toString(), txtName.getText().toString()
                                ,txtEmail.getText().toString());
                    } else {
                        new Admin(txtUserName.getText().toString()
                                , txtPassword.getText().toString(), txtName.getText().toString()
                                ,txtEmail.getText().toString());
                    }
                    startActivity(intent2);

                } else {
                    TextView textView = (TextView) findViewById(R.id.txtlbl);
                    textView.setText("Passwords do not match");
                }

                break;
        }
    }
}
