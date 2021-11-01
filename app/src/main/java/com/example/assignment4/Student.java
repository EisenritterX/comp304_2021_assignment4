package com.example.assignment4;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int studentid;
    private String firstname,lastname,department,professorID,classroomID;
}
