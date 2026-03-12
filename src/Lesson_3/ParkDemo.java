package Lesson_3;

public class ParkDemo {
    public static void main(String[] args) {
        Park park = new Park();
        park.addAttraction("Карусель", "09:00-21:00", 0.0);
        park.addAttraction("Американские горки", "10:00-22:00", 5.5);

        // Вывод всех аттракционов
        park.printAllAttractions();

        // Прямое создание экземпляра внутреннего класса
        Park.Attraction atr = park.new Attraction("Батут", "11:00-19:00", 3.0);
        atr.printInfo();
    }
}