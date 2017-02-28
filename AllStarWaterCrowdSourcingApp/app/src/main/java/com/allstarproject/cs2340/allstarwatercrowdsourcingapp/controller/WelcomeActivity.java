package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * onCreate method for initial setup
     * @param savedInstanceState bundled data that contains info necessary or setting up buttons
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button btnAction = (Button) findViewById(R.id.btnLoginWelcome);
        btnAction.setOnClickListener(this);

<<<<<<< HEAD
        Button btnRegister = (Button) findViewById(R.id.btnRegisterWelcome);
=======
        Button btnRegister = (Button) findViewById(R.id.btnCancelRegister);
>>>>>>> 3fed251c40fbdbbd93bc18a81460702448e26f63
        btnRegister.setOnClickListener(this);
    }

    /**
     * onClick method that handles action when Login or Register buttons are clicked from
     * WelcomeActivity
     * @param view current view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLoginWelcome:
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
<<<<<<< HEAD
            case R.id.btnRegisterWelcome:
=======
            case R.id.btnCancelRegister:
>>>>>>> 3fed251c40fbdbbd93bc18a81460702448e26f63
                Intent intent2 = new Intent(WelcomeActivity.this, RegisterActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
