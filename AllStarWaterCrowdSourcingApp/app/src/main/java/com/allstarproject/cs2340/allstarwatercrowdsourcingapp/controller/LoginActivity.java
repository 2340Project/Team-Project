package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;


import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtUser;
    EditText txtPass;
<<<<<<< HEAD
    Context ctx = this;
=======
    Model model = Model.getInstance();

    /**
     * this is the onCreate for LoginActiviy
     * @param savedInstanceState is the Bundle to be used for creation
     */
>>>>>>> 3fed251c40fbdbbd93bc18a81460702448e26f63

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        Button btnEnter = (Button) findViewById(R.id.btnEnter);
        txtUser = (EditText) findViewById(R.id.txtCurrentName);
        txtPass = (EditText) findViewById(R.id.txtPassword);
        btnEnter.setOnClickListener(this);

        Button btnCancel = (Button) findViewById(R.id.btnRegisterMain);
        btnCancel.setOnClickListener(this);
    }

    /**
     * onClick method that will manage the login or cancel button as well as notifying of invalid
     * password if necessary
     *
     * @param view is the current view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnEnter:
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
<<<<<<< HEAD
                txtPass = (EditText) findViewById(R.id.txtPassword);
                txtUser = (EditText) findViewById(R.id.txtUserName);
                String uname = txtUser.getText().toString();
                String pass = txtPass.getText().toString();

                DatabseOperations dop = new DatabseOperations(ctx);
                Cursor CR = dop.getInformation(dop);

//                if (Model.verify(txtUser.getText().toString(), txtPass.getText().toString())) {
//                    startActivity(intent);
                boolean longStatus = false;
                do {
                    if(uname.equals(CR.getString(1)) && pass.equals((CR.getString(2)))) {
                        longStatus = true;
                        //uname = CR.getString(0);
                    }
                } while (CR.moveToNext());
                if (longStatus) {
=======
                if (Model.verify(txtUser.getText().toString(), txtPass.getText().toString())) {
                    model.setUser(txtUser.getText().toString());
>>>>>>> 3fed251c40fbdbbd93bc18a81460702448e26f63
                    startActivity(intent);
                } else {
                    TextView textView = (TextView) findViewById(R.id.txtlbl);
                    textView.setText("Wrong Password or Username");
                }
                break;

            case R.id.btnRegisterMain:
                Intent intent2 = new Intent(LoginActivity.this,
                        WelcomeActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
