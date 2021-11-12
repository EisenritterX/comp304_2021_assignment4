package com.example.assignment4.Model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.assignment4.Model.DAO.ClassroomDao;
import com.example.assignment4.Model.DAO.ProfessorDao;
import com.example.assignment4.Model.DAO.StudentDao;
import com.example.assignment4.Model.Entities.Classroom;
import com.example.assignment4.Model.Entities.Professor;
import com.example.assignment4.Model.Entities.Student;

@Database(entities = {Student.class, Professor.class, Classroom.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "Assignment4AppDB";
    // This Database Class is a Singleton and is being stored in main memory
    private static volatile AppDatabase INSTANCE;

    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            //Create database object
            INSTANCE = Room.databaseBuilder(context,
                    AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public abstract StudentDao studentDao();

    public abstract ProfessorDao professorDao();

    public abstract ClassroomDao classroomDao();
}
