package Lesson_4.Shapes;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0, "red", "black");
        Shape rectangle = new Rectangle(4.0, 6.0, "blue", "green");
        Shape triangle = new Triangle(3.0, 4.0, 5.0, "yellow", "gray");

        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
    }
}