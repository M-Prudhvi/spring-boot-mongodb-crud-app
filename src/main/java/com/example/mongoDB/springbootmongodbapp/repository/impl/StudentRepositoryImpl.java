package com.example.mongoDB.springbootmongodbapp.repository.impl;

import com.example.mongoDB.springbootmongodbapp.model.Student;
import com.example.mongoDB.springbootmongodbapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Student saveStudent(Student student) {
        return mongoTemplate.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return mongoTemplate.findAll(Student.class);
    }

    @Override
    public List<Student> getStudentByDepartment(String department) {
        Query query = new Query();
//        query.addCriteria(Criteria.where("department").is(department));
        query.addCriteria(Criteria.where("department").regex(department,"E"));
        return mongoTemplate.find(query, Student.class);
    }

    @Override
    public List<Student> getStudentById(int id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").gte(id));
        return mongoTemplate.find(query, Student.class);
    }
}
