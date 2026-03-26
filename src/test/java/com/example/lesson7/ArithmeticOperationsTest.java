package com.example.lesson7;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticOperationsTest {

    @Test
    public void testAdd() {
        Assert.assertEquals(ArithmeticOperations.add(3, 4), 7);
    }

    @Test
    public void testDivide() {
        Assert.assertEquals(ArithmeticOperations.divide(4, 2), 2.0);
        try {
            ArithmeticOperations.divide(4, 0);
            Assert.fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
            // OK
        }
    }
}