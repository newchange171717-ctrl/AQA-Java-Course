package Lesson6.PhoneDirectory;

public class PhoneDirectoryDemo {
    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory();
        directory.add("Ivanov", "123-4567");
        directory.add("Ivanov", "234-5678");
        directory.add("Petrov", "555-0101");

        System.out.println("Ivanov: " + directory.get("Ivanov"));
        System.out.println("Sidorov: " + directory.get("Sidorov"));
    }
}