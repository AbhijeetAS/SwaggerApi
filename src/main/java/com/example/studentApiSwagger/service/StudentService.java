package com.example.studentApiSwagger.service;

import com.example.studentApiSwagger.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface    StudentService {

    List<Student>  getAllStudents();

    List<Student> getStudentByStudentName(String name);
    Student addStudent(Student student);

    Student updateStudent(Student student, String id);

    String deleteStudent(String id);
}
