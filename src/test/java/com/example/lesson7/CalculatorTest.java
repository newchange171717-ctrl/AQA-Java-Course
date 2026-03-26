package com.example.lesson7;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    @Test
    public void testFactorial() {
        Assert.assertEquals(Calculator.factorial(5), 120);
        Assert.assertEquals(Calculator.factorial(0), 1);
        try {
            Calculator.factorial(-1);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }
}