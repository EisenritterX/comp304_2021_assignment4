package com.example.assignment4.Activities;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    private ArrayList<String> activities;

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
                        intent = new Intent(getApplicationContext(), AddStudentActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), AddStudentActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getApplicationContext(), ClassroomActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getApplicationContext(), ViewClassroomInfoActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getApplicationContext(), ModifyStudentActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }

            }
        });

    }
}