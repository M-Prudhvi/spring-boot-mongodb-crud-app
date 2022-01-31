package com.example.mongoDB.springbootmongodbapp.service;

import com.example.mongoDB.springbootmongodbapp.model.Student;
import java.util.List;

public interface StudentService  {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    List<Student> getStudentByDepartment(String department);

    List<Student> getStudentById(int id);
}
