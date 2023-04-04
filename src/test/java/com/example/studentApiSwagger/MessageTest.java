package com.example.studentApiSwagger;

import com.example.studentApiSwagger.practice.Calculater;
import com.example.studentApiSwagger.practice.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MessageTest {

    Message message;
    @BeforeEach
    void setUp()
    {
        message=new Message();
    }
    @Test
    void testMessage()
    {
        Assertions.assertEquals("hello from the message class",message.hello());
    }


}
