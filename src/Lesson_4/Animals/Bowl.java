package Lesson_4.Animals;

public class Bowl {
    private int food;
    public Bowl(int food) {
        if (food < 0) food = 0;
        this.food = food;
    }

    public int takeFood(int amount) {
        if (amount <= 0) return 0;
        int taken = Math.min(food, amount);
        food -= taken;
        return taken;
    }

    public void addFood(int amount) {
        if (amount > 0) food += amount;
    }

    public int getFood() {
        return food;
    }

    @Override
    public String toString() {
        return "В миске осталось еды: " + food;
    }
}