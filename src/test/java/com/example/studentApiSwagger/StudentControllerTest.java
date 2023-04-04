package com.example.studentApiSwagger;


import com.example.studentApiSwagger.controller.StudentController;
import com.example.studentApiSwagger.entities.Student;
import com.example.studentApiSwagger.repository.StudentRepository;
import com.example.studentApiSwagger.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper=new ObjectMapper();
    ObjectWriter objectWriter=objectMapper.writer();


    @Mock
    private StudentService studentService;
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentController studentController;

    Student student=new Student("34","akash","akash@123",25);

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(studentController).build();//this says that we use mockmvc and mokito for book controller class
    }
}
