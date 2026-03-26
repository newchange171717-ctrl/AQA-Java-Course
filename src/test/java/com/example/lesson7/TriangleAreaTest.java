package com.example.lesson7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaTest {

    @Test
    void testArea() {
        assertEquals(6.0, TriangleArea.area(3, 4, 5), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.area(-3, 4, 5));
    }
}
