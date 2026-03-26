package com.example.lesson7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testFactorial() {
        assertEquals(120, Calculator.factorial(5));
        assertEquals(1, Calculator.factorial(0));
        assertThrows(IllegalArgumentException.class, () -> Calculator.factorial(-1));
    }
}