package Lesson_4.Shapes;

public class Triangle implements Shape {
    private final double a, b, c;
    private final String fillColor;
    private final String borderColor;

    public Triangle(double a, double b, double c, String fillColor, String borderColor) {
        // можно добавить валидацию на условие существования треугольника
        this.a = a;
        this.b = b;
        this.c = c;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double computePerimeter() {
        return a + b + c;
    }

    @Override
    public double computeArea() {
        // Используем полупериметр (формула Герона)
        double s = computePerimeter() / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}