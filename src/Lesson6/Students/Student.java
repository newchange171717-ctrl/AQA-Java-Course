package Lesson6.Students;

import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() { return name; }
    public String getGroup() { return group; }
    public int getCourse() { return course; }
    public List<Integer> getGrades() { return grades; }

    public void setCourse(int course) { this.course = course; }

    public double getAverage() {
        if (grades == null || grades.isEmpty()) return 0.0;
        double sum = 0;
        for (Integer g : grades) sum += g;
        return sum / grades.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student other = (Student) o;
        return Objects.equals(name, other.name) && Objects.equals(group, other.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group);
    }
}