package com.example.assignment4.Model.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.assignment4.Model.Entities.Student;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert
    void insert(Student student);

    @Delete
    void delete(Student student);

    @Update
    void update(Student student);

    @Query("delete from student")
    void deleteAllStudents();

    @Query("select * from Student order by studentId")
    LiveData<List<Student>> getAllPerson();

    @Query("select * from Student where studentId=:stuID")
    LiveData<Student> DisplayStudent(int stuID);
}
