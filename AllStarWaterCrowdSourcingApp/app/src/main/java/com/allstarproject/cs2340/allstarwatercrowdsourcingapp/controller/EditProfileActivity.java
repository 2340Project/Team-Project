package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.RegisteredUser;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;


public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener {

    Model model = Model.getInstance();
    RegisteredUser currentUser = model.getUser();
    TextView txtCurrentName;
    TextView txtCurrentEmail;
    EditText txtEmail;
    EditText txtName;
    EditText txtPassword;
    EditText txtConfPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        txtCurrentEmail = (TextView) findViewById(R.id.txtCurrentEmail);
        txtCurrentName = (TextView) findViewById(R.id.txtCurrentName);
        txtCurrentEmail.setText("Current Email: " + currentUser.getEmail() );
        txtCurrentName.setText("Current Name: " + currentUser.getName());

        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtName = (EditText) findViewById(R.id.txtName);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtConfPassword = (EditText) findViewById(R.id.txtConfPassword);

        Button editSubmit = (Button) findViewById(R.id.btnSubmitEdit);
        editSubmit.setOnClickListener(this);

        Button cancelEdit = (Button) findViewById(R.id.btnCancelEdit);
        cancelEdit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCancelEdit:
                Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
                startActivity(intent);
            break;
            case R.id.btnSubmitEdit:
                //get the user instance
                //set new user data
                Intent intent1 = new Intent(EditProfileActivity.this, EditProfileActivity.class);
                if (txtConfPassword.getText().toString().equals(txtPassword.getText().toString())) {
                    if (!(txtEmail.getText().toString().equals(""))) {
                        currentUser.setEmail(txtEmail.getText().toString());
                    }
                    if (!(txtName.getText().toString().equals(""))) {
                        currentUser.setName(txtName.getText().toString());
                    }
                    if (!(txtPassword.getText().toString().equals(""))) {
                        currentUser.setPassword(txtPassword.getText().toString());
                    }
                    startActivity(intent1);
                } else {
                    TextView textView = (TextView) findViewById(R.id.txtlbl);
                    textView.setText("Passwords do not match");
                }

            break;
        }
    }

}
