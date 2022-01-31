package com.example.mongoDB.springbootmongodbapp.service;

import com.example.mongoDB.springbootmongodbapp.model.Student;
import com.example.mongoDB.springbootmongodbapp.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepositoryImpl;

    @Test
    public void getAllStudentsTest(){
        List<Student> students = new ArrayList<>();
        Student student = Student.builder()
                .id(3)
                .firstName("student3")
                .lastName("3")
                .address("bangalore")
                .department("CSE")
                .phoneNumber(987654323)
                .build();
        students.add(student);
        students.add(student);
        Mockito.when(studentRepositoryImpl.getAllStudents()).thenReturn(students);
        List<Student> studentList = studentService.getAllStudents();
        assertNotNull(studentList);
        assertEquals(2,studentList.size());
    }
}
