package com.example.studentApiSwagger.service;

import com.example.studentApiSwagger.entities.Student;
import com.example.studentApiSwagger.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    //it is generated for teting purpose
    public StudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentByStudentName(String name) {

        return this.studentRepository.findByStudentName(name);

    }


    @Override
    public Student addStudent(Student user) {
        return studentRepository.save(user);
    }

    @Override
    public Student updateStudent(Student student, String id) {

        Optional<Student> modifiedUser= Optional.ofNullable(studentRepository.findByStudentId(id));

        if(modifiedUser.isPresent()){
            modifiedUser.get().setStudentName(student.getStudentName());
            modifiedUser.get().setAge(student.getAge());
            modifiedUser.get().setEmail(student.getEmail());
            return studentRepository.save(modifiedUser.get());
        }
        return studentRepository.save(student);
    }

    @Override
    public String deleteStudent(String id) {
            studentRepository.deleteByStudentId(id);
            return "Student Deleted Successfully...";
        }



}
