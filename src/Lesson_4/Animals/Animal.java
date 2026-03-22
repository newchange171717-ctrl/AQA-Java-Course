package Lesson_4.Animals;

public abstract class Animal {
    protected String name;
    protected static int totalAnimals = 0;

    public Animal(String name) {
        this.name = name;
        totalAnimals++;
    }

    public static int getTotalAnimals() {
        return totalAnimals;
    }

    protected abstract int getRunLimit();
    protected abstract int getSwimLimit();

    public void run(int distance) {
        if (distance <= getRunLimit()) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не смог пробежать " + distance + " м.");
        }
    }

    public void swim(int distance) {
        int limit = getSwimLimit();
        if (limit <= 0) {
            System.out.println(name + " не умеет плавать.");
            return;
        }
        if (distance <= limit) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не смог проплыть " + distance + " м.");
        }
    }
}