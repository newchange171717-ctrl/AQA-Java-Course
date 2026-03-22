package Lesson_4.Animals;

public class Cat extends Animal {
    public static int totalCats = 0;
    private boolean satiety;
    private final int appetite = 5;

    public Cat(String name) {
        super(name);
        totalCats++;
        this.satiety = false;
    }

    @Override
    protected int getRunLimit() {
        return 200;
    }

    @Override
    protected int getSwimLimit() {
        return 0; // кот не умеет плавать
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void eat(Bowl bowl) {
        if (bowl.getFood() >= appetite) {
            bowl.takeFood(appetite);
            satiety = true;
        }
    }
}