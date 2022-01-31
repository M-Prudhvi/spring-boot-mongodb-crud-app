package com.example.mongoDB.springbootmongodbapp.repository;

import com.example.mongoDB.springbootmongodbapp.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryImplTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentTest(){
        Student student = Student.builder()
                .id(3)
                .firstName("student3")
                .lastName("3")
                .address("bangalore")
                .department("CSE")
                .phoneNumber(987654323)
                .build();
        Student savedStudent = studentRepository.saveStudent(student);
        assertNotNull(savedStudent);
        assertEquals(3, savedStudent.getId());
    }

    @Test
    public void getAllStudentsTest(){
        List<Student> studentList = studentRepository.getAllStudents();
        assertNotNull(studentList);
        assertEquals(4,studentList.size());
    }
}
