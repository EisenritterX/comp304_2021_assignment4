package com.example.assignment4.Model.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.assignment4.Model.Entities.Classroom;

import java.util.List;

@Dao
public interface ClassroomDao {
    @Insert
    void insert(Classroom classroom);

    @Delete
    void delete(Classroom classroom);

    @Update
    void update(Classroom classroom);

    @Query("delete from classroom")
    void deleteAllClassroom();

    @Query("select * from classroom order by classroomId")
    LiveData<List<Classroom>> getAllClassroom();

    @Query("select * from classroom where classroomId=:classroomID")
    LiveData<Classroom> DisplayClassroom(int classroomID);
}
