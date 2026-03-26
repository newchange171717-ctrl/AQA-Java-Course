package com.example.lesson7;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleAreaTest {

    @Test
    public void testArea() {
        Assert.assertEquals(TriangleArea.area(3, 4, 5), 6.0, 0.0001);
    }
}