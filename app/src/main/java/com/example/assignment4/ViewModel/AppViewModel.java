package com.example.assignment4.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.assignment4.Model.COM304Assign4Repository;
import com.example.assignment4.Model.Entities.Classroom;
import com.example.assignment4.Model.Entities.Professor;
import com.example.assignment4.Model.Entities.Student;

import java.util.List;

public class AppViewModel extends AndroidViewModel {
    private COM304Assign4Repository appRepository;
    private LiveData<Integer> insertResult;
    private LiveData<List<Student>> allStudent;

    private LiveData<String> profName;

//    private LiveData<List<Professor>> allProfessors;
//    private LiveData<List<Classroom>> allClassrooms;

    public AppViewModel(@NonNull Application application) {
        super(application);
        appRepository = new COM304Assign4Repository(application);
        insertResult = appRepository.getInsertResult();
        allStudent = appRepository.getAllStudents();
    }

    //calls repository to insert a table
    public void insert(Student student) {
        appRepository.insert(student);
    }

    public void insert(Professor professor) {
        appRepository.insert(professor);
    }

    public void insert(Classroom classroom) {
        appRepository.insert(classroom);
    }

    //calls repository to update a table
    public void update(Student student) {
        appRepository.update(student);
    }

    public void update(Professor professor) {
        appRepository.update(professor);
    }

    public void update(Classroom classroom) {
        appRepository.update(classroom);
    }

    //calls repository to delete a item
    public void delete(Student student) {
        appRepository.delete(student);
    }

    public void delete(Professor professor) {
        appRepository.delete(professor);
    }

    public void delete(Classroom classroom) {
        appRepository.delete(classroom);
    }

    // Professor Login
    public MutableLiveData<Professor> ProfLogin(int profId, String profPass){

        return  appRepository.profLogin(profId,profPass);
    }

    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    //returns query results as live data object
    LiveData<List<Student>> getAllStudent() {
        return allStudent;
    }
}


