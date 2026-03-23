package Lesson_5;

public class Main {
    public static void main(String[] args) {
        String[][] good = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};

        try {
            int sum = sum4x4(good);
            System.out.println("Sum = " + sum);
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println("Error: " + ((Exception)e).getMessage());
        }

        String[][] badSize = new String[][]{
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"},
                {"10", "11", "12"}};

        try {
            int sum = sum4x4(badSize);
            System.out.println("Sum = " + sum);
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println("Size error: " + ((Exception)e).getMessage());
        }

        String[][] badData = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "x", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};

        try {
            int sum = sum4x4(badData);
            System.out.println("Sum = " + sum);
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println("Data error: " + ((Exception)e).getMessage());
        }

        triggerArrayIndexOutOfBounds();
    }

    public static int sum4x4(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array != null && array.length == 4) {
            for(int i = 0; i < 4; ++i) {
                if (array[i] == null || array[i].length != 4) {
                    throw new MyArraySizeException("Array size must be 4x4");
                }
            }

            int sum = 0;

            for(int i = 0; i < 4; ++i) {
                for(int j = 0; j < 4; ++j) {
                    String s = array[i][j];

                    try {
                        int val = Integer.parseInt(s);
                        sum += val;
                    } catch (NumberFormatException var6) {
                        throw new MyArrayDataException("Invalid data at cell [" + i + "][" + j + "]: '" + s + "'");
                    } catch (NullPointerException var7) {
                        throw new MyArrayDataException("Null value at cell [" + i + "][" + j + "]");
                    }
                }
            }

            return sum;
        } else {
            throw new MyArraySizeException("Array size must be 4x4");
        }
    }

    public static void triggerArrayIndexOutOfBounds() {
        int[][] arr = new int[4][4];

        try {
            int var1 = arr[4][0];
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + ex.getMessage());
        }

    }

    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }
}
