package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.ModelFacade;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;

import java.io.File;
public class WelcomeActivity extends AppCompatActivity
        implements View.OnClickListener {

    private final ModelFacade modelFacade = ModelFacade.getModelFacade();
    private final Model model = modelFacade.getModelInstance();
    /**
     * onCreate method to instantiate the necessary buttons and text fields
     * for the Welcome Screen.
     * @param savedInstanceState the data which Android saves to populate
     * data more quickly than the application starting up. It's basically
     * caching everything so load up time is quicker when going back to the
     * screen.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        File file = new File(this.getFilesDir(),
                ModelFacade.DEFAULT_BINARY_FILE_NAME);
        modelFacade.loadBinary(file);
        model.regenMap();
        Button btnAction = (Button) findViewById(R.id.btnLogin);
        btnAction.setOnClickListener(this);

        Button btnRegister = (Button) findViewById(R.id.btnCancelRegister);
        btnRegister.setOnClickListener(this);


    }

    /**
     * onClick method that handles action when Login or Register buttons are
     * clicked from WelcomeActivity
     * @param view current view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        case R.id.btnLogin:
            Intent intent = new Intent(WelcomeActivity.this,
                    LoginActivity.class);

            startActivity(intent);
            break;
        case R.id.btnCancelRegister:
            Intent intent2 = new Intent(WelcomeActivity.this,
                    RegisterActivity.class);
            startActivity(intent2);
            break;
        default:
        }
    }
}
