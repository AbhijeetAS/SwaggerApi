package com.example.studentApiSwagger.service;

import com.example.studentApiSwagger.entities.Student;
import com.example.studentApiSwagger.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class StudentServiceImplementationTest {

    @Mock
    private StudentRepository studentRepository;

    private StudentServiceImplementation studentServiceImplementation;

    @BeforeEach
    void setUp() {
        this.studentServiceImplementation=new StudentServiceImplementation(studentRepository);
    }

    @Test
    void getAllStudents() {
       when(studentRepository.findAll()).thenReturn(Stream.of(new Student("23","rohit","rohit@12",34)).collect(Collectors.toList()));
       assertEquals(1,this.studentServiceImplementation.getAllStudents().size());
    }


    @Test
    void getAllStudentByStudentName()
    {
        String studentName="abhijeet";
        when(studentRepository.findByStudentName(studentName)).thenReturn(Stream.of(new Student("23","abhijeet","rohit@12",34),new Student("24","abhijeet","123@12",34)).collect(Collectors.toList()));
        assertEquals(2,this.studentServiceImplementation.getStudentByStudentName(studentName).size());
    }

    @Test
    void addStudent()
    {
        Student student=new Student("23","abhijeet","rohit@12",34);
        when(this.studentRepository.save(student)).thenReturn(student);
        assertEquals(student,this.studentServiceImplementation.addStudent(student));
    }

    @Test
    void deleteStudent()
    {
        String studentId="123";
        this.studentServiceImplementation.deleteStudent(studentId);
//        this.studentServiceImplementation.deleteStudent(studentId);
        verify(this.studentRepository,times(1)).deleteByStudentId(studentId);
    }

    @Test
    void updateStudent()
    {
        Student student=new Student("23","abhijeet","rohit@12",34);
        String studentId="23";
        this.studentServiceImplementation.updateStudent(student,studentId);
        verify(this.studentRepository,times(1)).findByStudentId(studentId);
        verify(this.studentRepository,times(1)).save(student);
    }
}