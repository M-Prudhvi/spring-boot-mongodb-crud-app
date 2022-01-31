package com.example.mongoDB.springbootmongodbapp.service.impl;

import com.example.mongoDB.springbootmongodbapp.model.Student;
import com.example.mongoDB.springbootmongodbapp.repository.StudentRepository;
import com.example.mongoDB.springbootmongodbapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepositoryImpl;

    @Override
    public Student saveStudent(Student student) {
        return studentRepositoryImpl.saveStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepositoryImpl.getAllStudents();
    }

    @Override
    public List<Student> getStudentByDepartment(String department) {
        return studentRepositoryImpl.getStudentByDepartment(department);
    }

    @Override
    public List<Student> getStudentById(int id) {
        return studentRepositoryImpl.getStudentById(id);
    }
}
