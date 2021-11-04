package com.example.assignment4.Model.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Professor {
    @PrimaryKey(autoGenerate = true)
    private int professorId;
    private String firstname, lastname, department, password;

    public Professor(String firstname, String lastname, String department, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.password = password;
    }

    public int getProfessorID() {
        return professorId;
    }

    public void setProfessorID(int id) {
        this.professorId = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String fname) {
        this.firstname = fname;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lname) {this.lastname = lname;}
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String dpt) {this.department = dpt;}
    public String getPassword() {
        return password;
    }
    public void setPassword(String pw) {this.password = pw;}
}
