package com.example.assignment4.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.assignment4.Model.Entities.Student;
import com.example.assignment4.R;
import com.example.assignment4.ViewModel.AppViewModel;

public class AddStudent extends Fragment {
    private AppViewModel appViewModel;
    EditText studentID, studentFName, studentLName, studentDept;
    Button addStudent;
    Student newStudent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.add_student_fragment, container, false);
        Toast.makeText(getContext(),"AddStudent onCreateView Started",Toast.LENGTH_LONG).show();
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);

        studentID = getView().findViewById(R.id.editTextStudentId);
        studentFName = getView().findViewById(R.id.editTextStudentFirstName);
        studentLName = getView().findViewById(R.id.editTextStudentLastName);
        studentDept = getView().findViewById(R.id.editTextStudentDepartment);

        addStudent = getView().findViewById(R.id.btnAddStudent);
        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int studentIDInt;
                studentIDInt = Integer.parseInt(studentID.getText().toString());
                newStudent = new Student(studentIDInt, studentFName.getText().toString(),
                        studentLName.getText().toString(),studentDept.getText().toString(),0,0);
                appViewModel.insert(newStudent);
                Toast.makeText(getContext(), newStudent.toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }



}
