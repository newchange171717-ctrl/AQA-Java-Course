package Lesson_4.Animals;

public class Dog extends Animal {
    public static int totalDogs = 0;
    public Dog(String name) {
        super(name);
        totalDogs++;
    }

    @Override
    protected int getRunLimit() {
        return 500;
    }

    @Override
    protected int getSwimLimit() {
        return 10;
    }
}