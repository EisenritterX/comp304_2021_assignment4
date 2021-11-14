package com.example.assignment4.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.assignment4.R;
import com.example.assignment4.ViewModel.AppViewModel;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentActivity extends AppCompatActivity {

    private ArrayList<String> students;
    private AppViewModel appViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        // Find the list view
        ListView lstStudents = (ListView) findViewById(R.id.listStudents);

        // Set View Model
        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);



        /*students = new ArrayList<String>(Arrays.asList(getResources().
                getStringArray(R.array.Students)));*/


        // POPULATE LIST

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> activitiesArrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, students
        );

       /* // Attaching ArrayAdapter to list view
        lstStudents.setAdapter(studentsArrayAdapter);*/

    }
}
