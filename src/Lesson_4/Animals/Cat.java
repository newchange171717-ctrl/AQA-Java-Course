package Lesson_4.Animals;

public class Cat extends Animal {
    public static int totalCats = 0;
    private boolean satiety;
    private int appetite;

    public Cat(String name, int appetite) {
        super(name);
        totalCats++;
        this.satiety = false;
        this.appetite = appetite;
    }

    @Override
    protected int getRunLimit() {
        return 200;
    }

    @Override
    protected int getSwimLimit() {
        return 0;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void eat(Bowl bowl) {
        int foodAvailable = bowl.getFood();
        int foodToEat = Math.min(appetite, foodAvailable);
        if (foodToEat > 0) {
            bowl.takeFood(foodToEat);
            satiety = (foodToEat == appetite);
        }
    }
}