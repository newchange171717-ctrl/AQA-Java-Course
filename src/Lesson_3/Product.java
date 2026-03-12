package Lesson_3;

public class Product {
    private String название;
    private String датаПроизводства;
    private String производитель;
    private String странаПроисхождения;
    private double цена;
    private boolean забронированПокупателем;

    public Product(String название, String датаПроизводства, String производитель,
                   String странаПроисхождения, double цена, boolean забронированПокупателем) {
        this.название = название;
        this.датаПроизводства = датаПроизводства;
        this.производитель = производитель;
        this.странаПроисхождения = странаПроисхождения;
        this.цена = цена;
        this.забронированПокупателем = забронированПокупателем;
    }

    // Метод вывода информации об объекте в консоль
    public void printInfo() {
        System.out.println("Название: " + название);
        System.out.println("Дата производства: " + датаПроизводства);
        System.out.println("Производитель: " + производитель);
        System.out.println("Страна происхождения: " + странаПроисхождения);
        System.out.println("Цена: " + цена);
        System.out.println("Забронирован покупателем: " + забронированПокупателем);
    }
}