package com.example.assignment4.Model.DAO;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.assignment4.Model.Entities.Professor;

import java.util.List;

@Dao
public interface ProfessorDao {
    @Insert
    void insert(Professor prof);

    @Delete
    void delete(Professor prof);

    @Update
    void update(Professor prof);

    @Query("delete from professor")
    void deleteAllProfs();

    @Query("select * from Professor order by professorId")
    LiveData<List<Professor>> getAllProfs();

    @Query("select * from Professor where professorId=:profID")
    LiveData<Professor> DisplayProf(int profID);

    @Query("select * from Professor where professorId=:profID and password =:profPass")
    Professor ProfLogin(int profID, String profPass);
}
