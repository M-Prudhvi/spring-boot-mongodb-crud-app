package com.example.mongoDB.springbootmongodbapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "student")
public class Student {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String department;
    private String address;
    private long phoneNumber;
}
