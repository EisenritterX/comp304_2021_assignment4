package com.example.assignment4.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.assignment4.R;

public class DisplayAllStudents extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.student_list_fragment, container, false);
        Toast.makeText(getContext(),"Student List onCreateView Started",Toast.LENGTH_LONG).show();
        return view;
    }
}
