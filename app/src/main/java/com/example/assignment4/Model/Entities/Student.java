package com.example.assignment4.Model.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int studentId;
    int professorId;
    int classroomId;
    private String firstname, lastname, department;

    public Student(int studentId, String firstname, String lastname, String department,
                   int professorId, int classroomId) {
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.professorId = professorId;
        this.classroomId = classroomId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public int getStudentId() {
        return studentId;
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

    @Override
    public String toString(){
        return "Student ID: " + studentId + "\n" +
                "Name: "+firstname+" "+lastname+"\n"+
                "Department: " + department +"\n"+
                "Professor: " +professorId+"\n"+
              "Classroom: " + classroomId +"\n";
    }

}
