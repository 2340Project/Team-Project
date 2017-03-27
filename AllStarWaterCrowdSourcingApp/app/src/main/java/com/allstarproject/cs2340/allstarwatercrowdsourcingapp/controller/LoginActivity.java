package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.ModelFacade;

import java.io.File;
import android.util.Log;
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtUser;
    EditText txtPass;
    TextView textView;
    ModelFacade modelFacade = ModelFacade.getModelFacade();
    Model model = modelFacade.getModelInstance();
    /**
     * this is the onCreate for LoginActiviy
     * @param savedInstanceState is the Bundle to be used for creation
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ModelFacade modelFacade = ModelFacade.getModelFacade();
//        File file = new File(this.getFilesDir(), ModelFacade.DEFAULT_BINARY_FILE_NAME);
//        modelFacade.loadBinary(file);
//        model.regenMap();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        txtUser = (EditText) findViewById(R.id.txtCurrentName);
        txtPass = (EditText) findViewById(R.id.txtPassword);
        textView = (TextView) findViewById(R.id.txtlbl1);
        Button btnEnter = (Button) findViewById(R.id.btnEnter);
        btnEnter.setOnClickListener(this);

        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(this);


        //Log.d("Check user after load", model.getUser().getName().toString());

    }

    /**
     * onClick method that will manage the login or cancel button as well as
     * notifying of invalid password if necessary
     * @param view is the current view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        case R.id.btnEnter:
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            if (model.verify(txtUser.getText().toString(),
                    txtPass.getText().toString())) {
                model.setUser(txtUser.getText().toString());
                startActivity(intent);
            } else {

                textView.setText("Wrong Password or Username");
            }
            break;

            case R.id.btnCancel:
                Intent intent2 = new Intent(LoginActivity.this,
                        WelcomeActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
