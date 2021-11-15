package com.example.assignment4.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment4.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    private ArrayList<String> activities;

    private SharedPreferences myPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find the list view
        ListView lstActivities = (ListView) findViewById(R.id.listActivities);

        activities = new ArrayList<String>(Arrays.asList(getResources().
                getStringArray(R.array.Activities)));



        // POPULATE LIST

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> activitiesArrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, activities
        );

        // Attaching ArrayAdapter to list view
        lstActivities.setAdapter(activitiesArrayAdapter);

        // Attaching event lister on list view
        lstActivities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = activities.get(position);
                //Added Shared Preferences
                myPreference = getSharedPreferences("info", MODE_PRIVATE);
                Set<String> loginInfo = myPreference.getStringSet("id",new HashSet<String>());
                // Debug Toast
                Toast.makeText(getApplicationContext(), "Activities Selected : " +
                        position + selectedItem, Toast.LENGTH_SHORT).show();


                // Sent Intent
                switch (position) {
                    case 0:
                        intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        if(loginInfo != null)
                        {
                            intent = new Intent(getApplicationContext(), StudentActivity.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "You are logged in as : " +
                                    loginInfo, Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "You are not logged in", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    case 2:
                        if(loginInfo != null) {
                            intent = new Intent(getApplicationContext(), StudentActivity.class);
                            startActivity(intent);
                        }
                        else
                        break;
                    case 3:
                        if(loginInfo != null) {
                            intent = new Intent(getApplicationContext(), ClassroomActivity.class);
                            startActivity(intent);
                        }
                        else
                        break;
                    case 4:
                        if(loginInfo != null) {
                            intent = new Intent(getApplicationContext(), ViewClassroomInfoActivity.class);
                            startActivity(intent);
                        }
                        else
                        break;
                    case 5:
                        if(loginInfo != null) {
                            intent = new Intent(getApplicationContext(), UpdateInfoActivity.class);
                            startActivity(intent);
                        }
                        else
                        break;
                    default:
                        break;
                }

            }
        });

    }
}