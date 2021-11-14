package com.example.assignment4.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment4.Model.Entities.Student;
import com.example.assignment4.R;
import com.example.assignment4.ViewModel.AppViewModel;

import java.util.List;

public class DisplayAllStudents extends Fragment {
    private AppViewModel appViewModel;
    RecyclerView studentsList;
    Context curContext;
    TextView txtDisplayStudents;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.student_list_fragment, container, false);
        Toast.makeText(getContext(),"Student List onCreateView Started",Toast.LENGTH_LONG).show();
        curContext= getContext();
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        studentsList = getView().findViewById(R.id.recViewStudent);
        txtDisplayStudents = getView().findViewById(R.id.txtDisplayStudents);


        appViewModel.getAllStudent().observe(getViewLifecycleOwner(), new Observer<List<Student>>() {
            @Override
            public void onChanged(@Nullable List<Student> students) {
                String output="";
                for(Student s : students) {
                    output+= s.toString() +"\n";
                }
                txtDisplayStudents.setText(output);

//                StudentRecyclerAdapter adapter = new StudentRecyclerAdapter(students, getContext());
//                studentsList.setAdapter(adapter);
//                studentsList.setLayoutManager(new LinearLayoutManager(getContext()));
            }
        });
    }
}
