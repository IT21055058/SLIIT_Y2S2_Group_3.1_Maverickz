package com.maverickz.mad_project_hope;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Home_hospital extends AppCompatActivity {

    private ImageView choose_profile, choose_edit_blood, reminders, event;
    private TextView displayname;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_hospital);


        choose_profile = findViewById(R.id.choose_user_logo);
        choose_edit_blood = findViewById(R.id.hospital_logo);
        reminders = findViewById(R.id.choose_community);
        event = findViewById(R.id.event_logo);
        displayname = findViewById(R.id.uname);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME, null);

        if (name != null) {
            displayname.setText(name);
        }
        choose_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Post_Wall_New_Activity.class);
                startActivity(i);
            }
        });

        choose_edit_blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), edit_Blood_Count_X.class);
                startActivity(i);
            }
        });
        reminders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), HospitalRequestActivity.class);
                startActivity(i);
            }
        });
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), event_sub_menu.class);
                startActivity(i);
            }
        });
    }
}