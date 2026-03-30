package Main;

public class Task14 {
    public static int[] createArray(int len, int initialValue) {
        if (len < 0) throw new IllegalArgumentException("len must be non-negative");
        int[] arr = new int[len]; for (int i = 0; i < len; i++) {
            arr[i] = initialValue; } return arr;
    }
    public static void main(String[] args) {
        int[] a = createArray(5, 7); // [7, 7, 7, 7, 7]
        System.out.println(java.util.Arrays.toString(a));
    }
}