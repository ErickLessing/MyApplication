package com.dolphin.grizzly.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    ArrayList<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //------------------------------------


        //List of users

        userList.add(new User("ErickL","123"));
        userList.add(new User("MiguelDS","123"));
        userList.add(new User("Jan","1"));
    }
    public void clkLogin(View view){
        TextView username = findViewById(R.id.txtUsername);
        TextView password = findViewById(R.id.txtPassword);
        Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
        String toaster = "";
        for (User user:
             userList) {
            if (user.getUsername().equals(username.getText().toString())){ //Correct credentials, continue to next activity
                if(user.getPassword().equals(password.getText().toString())){
                    toaster = "Welcome, "+username.getText();
                    startActivity(intent);
                    //finish();
                    break;
                }
                else{ //Incorrect Password
                    toaster = "Incorrect Password";
                    break;

                }
            }
            else{ //Incorrect username
               toaster = "User does not exist";


            }

        }
        if (toaster.equals("User does not exist")){
            username.setText("");
            password.setText("");
            username.requestFocus();
        }
        else if(toaster.equals("Incorrect Password")){
            password.setText("");
            password.requestFocus();
        }
        Toast.makeText(this, toaster, Toast.LENGTH_SHORT).show();
    }
}
