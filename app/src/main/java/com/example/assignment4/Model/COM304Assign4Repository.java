package com.example.assignment4.Model;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.assignment4.Model.DAO.ClassroomDao;
import com.example.assignment4.Model.DAO.ProfessorDao;
import com.example.assignment4.Model.DAO.StudentDao;
import com.example.assignment4.Model.Entities.Classroom;
import com.example.assignment4.Model.Entities.Professor;
import com.example.assignment4.Model.Entities.Student;

import java.util.List;
import java.util.concurrent.Callable;

public class COM304Assign4Repository {

    private final StudentDao studentDao;
    private final ProfessorDao professorDao;
    private final ClassroomDao classroomDao;
    private final MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private final LiveData<List<Student>> allStudents;
    private final LiveData<List<Professor>> allProfessors;
    private final LiveData<List<Classroom>> allClassrooms;



    public COM304Assign4Repository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        studentDao = db.studentDao();
        professorDao = db.professorDao();
        classroomDao = db.classroomDao();
        allStudents = studentDao.getAllStudents();
        allProfessors = professorDao.getAllProfs();
        allClassrooms = classroomDao.getAllClassroom();
    }

    // Inserts
    public void insert(Student student) {
        insertStudentAsync(student);
    }

    public void insert(Professor professor) {
        insertProfAsync(professor);
    }

    public void insert(Classroom classroom) {
        insertClassroomAsync(classroom);
    }

    // Updates
    public void update(Student student) {
        updateStudentAsync(student);
    }

    public void update(Professor professor) {
        updateProfAsync(professor);
    }

    public void update(Classroom classroom) {
        updateClassroomAsync(classroom);
    }

    // Deletes
    public void delete(Student student) {
        deleteStudentAsync(student);
    }

    public void delete(Professor professor) {
        deleteProfAsync(professor);
    }

    public void delete(Classroom classroom) {
        deleteClassroomAsync(classroom);
    }

    public void deleteAllStudents() {
        deleteAllStudentsAsync();
    }

    public void deleteAllProfs() {
        deleteAllProfessorsAsync();
    }

    public void deleteAllClassrooms() {
        deleteAllClassroomsAsync();
    }



    // returns query result as LiveData object
    public LiveData<List<Student>> getAllStudents() {
        return allStudents;
    }

    // returns insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    // returns professor as LiveData object
    public Professor profLogin(final int profId, final String profPass) throws InterruptedException {
        return profLoginAsync(profId, profPass);
    }

    private Professor profLoginAsync(final int profId, final String profPass) throws InterruptedException {
        final Professor[] prof = new Professor[1];
        Thread t= new Thread(new Runnable() {
            @Override
            public void run() {
                prof[0] = professorDao.ProfLogin(profId, profPass);
            }
        });
        t.start();
        t.join();
        return prof[0];
    }

    //ASYNCS

    private void insertStudentAsync(final Student student) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    studentDao.insert(student);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    private void insertProfAsync(final Professor prof) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    professorDao.insert(prof);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    private void insertClassroomAsync(final Classroom classroom) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    classroomDao.insert(classroom);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    private void updateStudentAsync(final Student student) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    studentDao.update(student);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    private void updateProfAsync(final Professor prof) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    professorDao.update(prof);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    private void updateClassroomAsync(final Classroom classroom) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    classroomDao.update(classroom);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    private void deleteStudentAsync(final Student student) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    studentDao.delete(student);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    private void deleteProfAsync(final Professor prof) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    professorDao.delete(prof);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    private void deleteClassroomAsync(final Classroom classroom) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    classroomDao.delete(classroom);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    private void deleteAllStudentsAsync() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    studentDao.deleteAllStudents();
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    private void deleteAllProfessorsAsync() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    professorDao.deleteAllProfs();
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    private void deleteAllClassroomsAsync() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    classroomDao.deleteAllClassroom();
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }





}