package Lesson_3;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private List<Attraction> attractions = new ArrayList<>();

    // Добавление аттракциона через Park-метод
    public void addAttraction(String name, String hours, double price) {
        attractions.add(new Attraction(name, hours, price));
    }

    // Вывод информации обо всех аттракционах
    public void printAllAttractions() {
        for (Attraction a : attractions) {
            a.printInfo();
        }
    }

    // Внутренний класс, представляющий аттракцион
    public class Attraction {
        private String name;
        private String hours;
        private double price;

        public Attraction(String name, String hours, double price) {
            this.name = name;
            this.hours = hours;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + name
                    + ", Время работы: " + hours
                    + ", Цена: " + price);
        }
    }
}