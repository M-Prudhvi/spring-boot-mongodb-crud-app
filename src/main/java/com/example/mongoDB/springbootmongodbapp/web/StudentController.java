package com.example.mongoDB.springbootmongodbapp.web;

import com.example.mongoDB.springbootmongodbapp.model.Student;
import com.example.mongoDB.springbootmongodbapp.service.StudentService;
import com.example.mongoDB.springbootmongodbapp.web.model.RetrieveStudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/app/mongo-app")
public class StudentController {

    @Autowired
    StudentService studentServiceImpl;

    @PostMapping("add-student")
    public ResponseEntity<Object> saveStudent(@RequestBody Student student){
        Student savedStudent = studentServiceImpl.saveStudent(student);
        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(savedStudent);
    }

    @GetMapping("retrieve-all-students")
    public ResponseEntity<Object> getAllStudents(){
        List<Student> studentList = studentServiceImpl.getAllStudents();
        RetrieveStudentResponse retrieveStudentResponse = RetrieveStudentResponse.builder()
                .studentList(studentList)
                .build();
        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(retrieveStudentResponse);
    }

    @GetMapping("retrieve-students-by-department")
    public ResponseEntity<Object> getStudentByDepartment(String department){
        List<Student> studentList = studentServiceImpl.getStudentByDepartment(department);
        RetrieveStudentResponse retrieveStudentResponse = RetrieveStudentResponse.builder()
                .studentList(studentList)
                .build();
        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(retrieveStudentResponse);
    }

    @GetMapping("retrieve-students-by-id")
    public ResponseEntity<Object> getStudentById(int id){
        List<Student> studentList = studentServiceImpl.getStudentById(id);
        RetrieveStudentResponse retrieveStudentResponse = RetrieveStudentResponse.builder()
                .studentList(studentList)
                .build();
        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(retrieveStudentResponse);
    }
}

