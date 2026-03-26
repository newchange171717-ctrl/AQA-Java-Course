package com.example.lesson7;

public class NumberComparator {
    public static String compare(int a, int b) {
        if (a > b) return "First is greater";
        if (b > a) return "Second is greater";
        return "Numbers are equal";
    }
}