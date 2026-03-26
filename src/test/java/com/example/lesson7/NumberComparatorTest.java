package com.example.lesson7;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberComparatorTest {

    @Test
    public void testCompare() {
        Assert.assertEquals(NumberComparator.compare(5, 3), "First is greater");
        Assert.assertEquals(NumberComparator.compare(2, 4), "Second is greater");
        Assert.assertEquals(NumberComparator.compare(3, 3), "Numbers are equal");
    }
}