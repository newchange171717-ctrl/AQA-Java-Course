package com.example.lesson7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {

    @Test
    void testCompare() {
        assertEquals("First is greater", NumberComparator.compare(5, 3));
        assertEquals("Second is greater", NumberComparator.compare(2, 4));
        assertEquals("Numbers are equal", NumberComparator.compare(3, 3));
    }
}
