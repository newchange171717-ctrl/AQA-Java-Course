package Lesson6.PhoneDirectory;

import java.util.*;

public class PhoneDirectory {
    private Map<String, List<String>> data = new HashMap<>();

    public void add(String surname, String number) {
        data.computeIfAbsent(surname, k -> new ArrayList<>()).add(number);
    }

    public List<String> get(String surname) {
        return data.getOrDefault(surname, Collections.emptyList());
    }
}