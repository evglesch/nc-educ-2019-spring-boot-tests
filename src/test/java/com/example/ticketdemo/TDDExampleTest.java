package com.example.ticketdemo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TDDExampleTest {

    @Test
    public void tddTest() {
        MyCalculator calc = new MyCalculator();
        Assert.assertNotNull(calc);
    }

    @Test
    public void testPlus() {
        MyCalculator calc = new MyCalculator();
        String result = calc.plus("1","2");
        Assert.assertEquals("3", result);
    }
}
