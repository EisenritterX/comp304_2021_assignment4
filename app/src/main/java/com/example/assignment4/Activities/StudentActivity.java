package com.example.assignment4.Activities;


import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.assignment4.R;
import com.example.assignment4.ViewModel.AppViewModel;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {

    private ArrayList<String> students;
    private AppViewModel appViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        // get the application view model
        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);
        // Find the list view
        //ListView lstStudents = (ListView) findViewById(R.id.listStudents);

        // Set View Model

        /*students = new ArrayList<String>(Arrays.asList(getResources().
                getStringArray(R.array.Students)));*/

        // POPULATE LIST

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> activitiesArrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, students
        );

//        //if the LiveData already has data it will delivered
//        // to the observer
//
//        appViewModel.getAllStudent().observe(this, new Observer<List<Student>>() {
//            @Override
//            public void onChanged(@Nullable List<Student> students) {
//                if(students!=null){
//                    lstStudents.setAdapter(activitiesArrayAdapter);
//                }
//
//            }
//        });
       /* // Attaching ArrayAdapter to list view
        lstStudents.setAdapter(studentsArrayAdapter);*/

    }
}
