package com.example.lesson7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    @Test
    void testAdd() {
        assertEquals(7, ArithmeticOperations.add(3, 4));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, ArithmeticOperations.divide(4, 2));
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(4, 0));
    }
}