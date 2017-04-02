package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.ModelFacade;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.RegisteredUser;

import java.io.File;

public class RegisterActivity extends AppCompatActivity
        implements View.OnClickListener {
    private Spinner spinner;
    private EditText txtUserName;
    private EditText txtName;
    private EditText txtEmail;
    private EditText txtPassword;
    private EditText txtConfPassword;

    /**
     * onCreate used to setup RegisterActivity on creation. Instantiates all
     * buttons and text fields associated with the Registration screen.
     * @param savedInstanceState the data which Android saves to populate
     * data more quickly than the application starting up. It's basically
     * caching everything so load up time is quicker when going back to the
     * screen.
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtUserName = (EditText) findViewById(R.id.txtCurrentName);
        txtName = (EditText) findViewById(R.id.txtName);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtConfPassword = (EditText) findViewById(R.id.txtConfPassword);

        spinner = (Spinner) findViewById(R.id.spnUserType);

        Button btnRCancel = (Button) findViewById(R.id.btnCancelRegister);
        btnRCancel.setOnClickListener(this);
        Button btnSubmitRegister = (Button) findViewById(
                R.id.btnSubmitRegister);
        btnSubmitRegister.setOnClickListener(this);
    }

    /**
     * This onClick takes redirects the user to the appropiate screen upon
     * pressing a specific button. When the user presses the register button,
     * their profile information will be stored in an instance of ModelFacade
     * and then stored in a binary file (located in some mystery path within
     * your file path) through saveBinary() in ModelFacade.
     * @param v the current view
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        case R.id.btnCancelRegister:
            Intent intent = new Intent(RegisterActivity.this,
                    WelcomeActivity.class);
            startActivity(intent);
            break;

        case R.id.btnSubmitRegister:
            Intent intent2 = new Intent(RegisterActivity.this,
                    LoginActivity.class);
            if (txtConfPassword.getText().toString().isEmpty()
                    || txtPassword.getText().toString().isEmpty()
                    || txtUserName.getText().toString().isEmpty()
                    || txtPassword.getText().toString().isEmpty()
                    || txtName.getText().toString().isEmpty()
                    || txtEmail.getText().toString().isEmpty()) {
                Toast.makeText(getApplication(), "Missing data entry",
                        Toast.LENGTH_LONG).show();
            } else if (txtConfPassword.getText().toString().equals(
                    txtPassword.getText().toString())) {
                if (spinner.getSelectedItem().toString().equals("User")) {
                    new RegisteredUser(txtUserName.getText().toString(),
                            txtPassword.getText().toString(),
                            txtName.getText().toString(),
                            txtEmail.getText().toString(),
                            spinner.getSelectedItem().toString());
                    ModelFacade modelFacade = ModelFacade.getModelFacade();
                    File file = new File(this.getFilesDir(),
                            ModelFacade.DEFAULT_BINARY_FILE_NAME);
                    Log.d("Saving", "About to save data. . .");
                    modelFacade.saveBinary(file);
                    startActivity(intent2);
                } else if (spinner.getSelectedItem().toString().equals(
                        "Manager")) {
                    new RegisteredUser(txtUserName.getText().toString(),
                            txtPassword.getText().toString(),
                            txtName.getText().toString(),
                            txtEmail.getText().toString(),
                            spinner.getSelectedItem().toString());
                    ModelFacade modelFacade = ModelFacade.getModelFacade();
                    File file = new File(this.getFilesDir(),
                            ModelFacade.DEFAULT_BINARY_FILE_NAME);
                    Log.d("Saving", "About to save data. . .");
                    modelFacade.saveBinary(file);
                    startActivity(intent2);
                } else if (spinner.getSelectedItem().toString().equals(
                        "Worker")) {
                    new RegisteredUser(txtUserName.getText().toString(),
                            txtPassword.getText().toString(),
                            txtName.getText().toString(),
                            txtEmail.getText().toString(),
                            spinner.getSelectedItem().toString());
                    ModelFacade modelFacade = ModelFacade.getModelFacade();
                    File file = new File(this.getFilesDir(),
                            ModelFacade.DEFAULT_BINARY_FILE_NAME);
                    Log.d("Saving", "About to save data. . .");
                    modelFacade.saveBinary(file);
                    startActivity(intent2);
                } else if (spinner.getSelectedItem().toString().equals(
                        "Admin")) {
                    new RegisteredUser(txtUserName.getText().toString(),
                            txtPassword.getText().toString(),
                            txtName.getText().toString(),
                            txtEmail.getText().toString(),
                            spinner.getSelectedItem().toString());
                    ModelFacade modelFacade = ModelFacade.getModelFacade();
                    File file = new File(this.getFilesDir(),
                            ModelFacade.DEFAULT_BINARY_FILE_NAME);
                    Log.d("Saving", "About to save data. . .");
                    modelFacade.saveBinary(file);
                    startActivity(intent2);
                } else {
                    Toast.makeText(getApplication(), "User type not selected",
                            Toast.LENGTH_LONG).show();
                }
            }
        default:
            //this is here for checkstyle. Default is messed up because
            // of fall through from prevuous branch opf the switch statement
            //http://stackoverflow.com/questions/188461/switch-statement//
            // -fallthrough-should-it-be-allowed


            //I added the breaks to see if that will get rid of checkstyle
            // but it did not go away - Yamin.
        }
    }
}
