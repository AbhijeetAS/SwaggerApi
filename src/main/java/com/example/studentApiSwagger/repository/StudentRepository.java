package com.example.studentApiSwagger.repository;

import com.example.studentApiSwagger.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
    public Student findByStudentId(String id);

    public List<Student> findByStudentName(String name);
    public void deleteByStudentId(String id);
}
