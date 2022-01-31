package com.example.mongoDB.springbootmongodbapp.repository;

import com.example.mongoDB.springbootmongodbapp.model.Student;

import java.util.List;

public interface StudentRepository {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    List<Student> getStudentByDepartment(String department);

    List<Student> getStudentById(int id);
}
