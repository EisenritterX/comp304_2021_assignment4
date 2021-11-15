package com.example.assignment4.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.example.assignment4.R;

import java.util.HashSet;
import java.util.Set;

public class ClassroomActivity extends AppCompatActivity {

    private Intent intent;
    private SharedPreferences myPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


            intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);

            setContentView(R.layout.activity_classroom_update);


    }
}
