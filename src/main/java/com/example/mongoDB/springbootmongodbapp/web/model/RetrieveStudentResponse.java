package com.example.mongoDB.springbootmongodbapp.web.model;

import com.example.mongoDB.springbootmongodbapp.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RetrieveStudentResponse {

    private List<Student> studentList;
}
