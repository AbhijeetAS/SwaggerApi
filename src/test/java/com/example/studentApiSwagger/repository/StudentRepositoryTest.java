package com.example.studentApiSwagger.repository;

import com.example.studentApiSwagger.entities.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private  StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        System.out.println("testing up");
    }

    @Test
    void findByStudentId() {
        Student expectedStudent=new Student("80","kiran","kiran@gmail.com",23);
        studentRepository.save(expectedStudent);
        Assertions.assertEquals(expectedStudent.getEmail(),this.studentRepository.findByStudentId("80").getEmail());
//        Assertions.assertEquals(expectedStudent,this.studentRepository.findByStudentId("80"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearing down");
        this.studentRepository.deleteAll();
    }
}