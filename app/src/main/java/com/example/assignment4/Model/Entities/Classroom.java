package com.example.assignment4.Model.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Classroom {
    @PrimaryKey(autoGenerate = true)
    private int classroomId;
    private int studentId, professorId, floor;
    private boolean airconditioned;


    public Classroom(int floor, boolean airconditioned) {
        this.floor = floor;
        this.airconditioned = airconditioned;
    }



    // Getters & Setters
    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int id) {
        this.classroomId = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int id) {
        this.studentId = id;
    }
    public int getProfessorId() {
        return professorId;
    }
    public void setProfessorId(int id) {
        this.professorId = id;
    }
    public int getFloor() {
        return floor;
    }
    public void setFloor(int floornum) {
        this.floor = floornum;
    }
    public boolean isAirconditioned() {
        return airconditioned;
    }
    public void setAirconditioned(boolean ac) {
        this.airconditioned = ac;
    }
}
