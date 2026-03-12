package Lesson_3;

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 15 Pro", "2024-09-15",
                "Apple Inc.", "USA", 1099, false);
        productsArray[2] = new Product("Dell XPS 15", "2024-03-12",
                "Dell Technologies", "USA", 1999, false);
        productsArray[3] = new Product("Sony WH-1000XM5", "2023-06-01",
                "Sony", "Japan", 399.99, true);
        productsArray[4] = new Product("LG OLED C1", "2021-11-20",
                "LG Electronics", "Korea", 1299, false);

        // Вывод информации по каждому товару
        for (Product p : productsArray) {
            if (p != null) {
                p.printInfo();
                System.out.println("----");
            }
        }
    }
}