package com.example.assignment4;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Classroom {
    @PrimaryKey(autoGenerate = true)
    private int classroomId;
    private int studentId, professorId, floor;
    private boolean airconditioned;
}
