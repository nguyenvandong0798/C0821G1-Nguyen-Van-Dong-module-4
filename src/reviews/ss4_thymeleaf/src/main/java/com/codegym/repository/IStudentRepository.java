package com.codegym.repository;

import com.codegym.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> getAll();

    Student findById(Integer id);

    void save(Student student);
}
