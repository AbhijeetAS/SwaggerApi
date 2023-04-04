package com.example.studentApiSwagger;

import com.example.studentApiSwagger.practice.Calculater;
import com.example.studentApiSwagger.practice.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculaterTestClass {
    Calculater calculater;
    @BeforeEach
    void setUp()
    {
        calculater=new Calculater();
    }

    @Test
     void testAddition()
    {
        Assertions.assertEquals(20,calculater.sum(10,10));
//        Assertions.assertEquals(25,calculater.sum(10,2));
    }

    @Test
    void testMultiply()
    {
        int expectedValue=15;
        int actualValue=calculater.multiply(5,4);
        Assertions.assertEquals(expectedValue,actualValue);
    }


}
