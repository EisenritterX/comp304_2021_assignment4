package com.example.assignment4;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int studentId;
    private int professorId,classroomId;
    private String firstname,lastname,department;

    public  int getStudentID(){return studentId;}
    public  void setStudentID(int id){this.studentId = id;}
    public int getProfessorID() {
        return professorId;
    }
    public void setProfessorID(int id) {
        this.professorId = id;
    }
    public int getClassroomId() {
        return classroomId;
    }
    public void setClassroomId(int id) {
        this.classroomId = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String fname) {this.firstname = fname;}
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lname) {this.lastname = lname;}
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String dpt) {this.department = dpt;}


}
