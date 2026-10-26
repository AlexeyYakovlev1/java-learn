import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {
        // Одномерный массив
        int[] numbers = {5, 2, 8, 1, 9};
        System.out.println("Исходный: " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("Отсортированный: " + Arrays.toString(numbers));

        // Двумерный массив
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Матрица: " + Arrays.deepToString(matrix));
        System.out.println("Элемент [1][2]: " + matrix[1][2]); // 6

        // Рваный массив
        int[][] jagged = {
            {1, 2},
            {3, 4, 5},
            {6, 7, 8, 9}
        };
        System.out.println("Рваный массив:");
        for (int[] row : jagged) {
            System.out.println(Arrays.toString(row));
        }

        // Сравнение массивов
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        System.out.println("a == b: " + (a == b));              // false
        System.out.println("Arrays.equals(a, b): " + Arrays.equals(a, b)); // true
    }
}
