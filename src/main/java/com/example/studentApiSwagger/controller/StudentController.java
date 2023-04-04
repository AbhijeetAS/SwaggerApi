package com.example.studentApiSwagger.controller;

import com.example.studentApiSwagger.entities.Student;
import com.example.studentApiSwagger.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/")
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    @PostMapping("/")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PatchMapping("/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") String id){
        return studentService.updateStudent(student,id);
    }

    @DeleteMapping("/{id}")
    public  String deleteStudent(@PathVariable("id")String id){
        return studentService.deleteStudent(id);
    }
}
