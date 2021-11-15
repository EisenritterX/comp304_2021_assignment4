package com.example.assignment4.Activities;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.assignment4.R;
import com.example.assignment4.ViewModel.AppViewModel;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {

    private ArrayList<String> students;
    private AppViewModel appViewModel;
    EditText studentID, studentFName, studentLName, studentDept;
    Button addStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);

//        studentID = findViewById(R.id.editTextStudentId);
//        studentFName = findViewById(R.id.editTextStudentFirstName);
//        studentLName = findViewById(R.id.editTextStudentLastName);
//        studentDept = findViewById(R.id.editTextStudentDepartment);
//
//        addStudent = findViewById(R.id.btnAddStudent);
//        addStudent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int studentIDInt;
//                studentIDInt = Integer.parseInt(studentID.getText().toString());
//                newStudent = new Student(studentIDInt, studentFName.getText().toString(),
//                        studentLName.getText().toString(),studentDept.getText().toString(),0,0);
//                appViewModel.insert(newStudent);
//                Toast.makeText(getApplicationContext(), newStudent.toString(),
//                        Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}
