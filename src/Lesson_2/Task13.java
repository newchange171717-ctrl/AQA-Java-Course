package Lesson_2;

public class Task13 {
    public static void main(String[] args) {
        int n = 6;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i][i] = 1;
        }
        printMatrix(arr);
    }
    private static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int v : row) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}