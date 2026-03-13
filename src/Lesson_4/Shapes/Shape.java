package Lesson_4.Shapes;

public interface Shape {
    String getFillColor();
    String getBorderColor();
    double computePerimeter();
    double computeArea();
    default double perimeter() {
        return computePerimeter();
    }

    default double area() {
        return computeArea();
    }

    default void printInfo() {
        System.out.printf("%s: perimeter=%.2f, area=%.2f, fillColor=%s, borderColor=%s%n",
                this.getClass().getSimpleName(),
                perimeter(), area(),
                getFillColor(), getBorderColor());
    }
}