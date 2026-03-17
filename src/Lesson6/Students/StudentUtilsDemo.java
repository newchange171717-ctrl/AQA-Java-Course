package Lesson6.Students;

import java.util.*;

public class StudentUtilsDemo {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Alex", "G1", 1, Arrays.asList(4, 5, 3)));
        students.add(new Student("Mila", "G1", 1, Arrays.asList(2, 3, 2)));
        students.add(new Student("Ivan", "G2", 2, Arrays.asList(5, 5, 4)));
        students.add(new Student("Oleg", "G2", 2, Arrays.asList(2, 2, 1)));

        System.out.println("До удаления (курс 1):");
        printStudents(students, 1);

        removeStudentsWithLowAverage(students);
        System.out.println("После удаления студентов с средним баллом < 3:");
        printAll(students);

        promoteStudents(students);
        System.out.println("После перевода на следующий курс (если средний >= 3):");
        printAll(students);
    }

    public static void removeStudentsWithLowAverage(Set<Student> students) {
        students.removeIf(s -> s.getAverage() < 3.0);
    }

    public static void promoteStudents(Set<Student> students) {
        // копируем, чтобы безопасно изменять курс во время итерации
        List<Student> list = new ArrayList<>(students);
        for (Student s : list) {
            if (s.getAverage() >= 3.0) {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        for (Student s : students) {
            if (s.getCourse() == course) {
                System.out.println(s.getName());
            }
        }
    }

    public static void printAll(Set<Student> students) {
        for (Student s : students) {
            System.out.println(s.getName() + " - " + s.getCourse() + " курс, avg=" + s.getAverage());
        }
    }
}