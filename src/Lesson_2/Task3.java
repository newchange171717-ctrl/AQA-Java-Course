package Lesson_2;

public class Task3 {
    public static void main(String [] args){
        int value = 176;
        if (value <= 0 ){
            System.out.println("Красный");
        }
        else if (value > 0 && value <=100) {
            System.out.println("Желтый");
        }
        else if (value >100) {
            System.out.println("Зеленый");
        }
    }
}