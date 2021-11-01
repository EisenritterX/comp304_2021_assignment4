package com.example.assignment4;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Professor {
    @PrimaryKey(autoGenerate = true)
    private int professorID;
    private String firstname,lastname,department,password;
}
