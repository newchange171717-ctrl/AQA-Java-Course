package Lesson_4.Animals;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[] {
                new Cat("Барсик"),
                new Cat("Мурзик"),
                new Cat("Котик") };


        Bowl bowl = new Bowl(12); // начальное количество еды

        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        for (Cat cat : cats) {
            System.out.println(cat.name + " сытость: " + cat.isSatiety());
        }

        System.out.println("Общее количество животных: " + Animal.getTotalAnimals());
        System.out.println("Количество котов: " + Cat.totalCats);
        System.out.println("Количество собак: " + Dog.totalDogs);

        System.out.println(bowl);
    }
}