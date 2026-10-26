public class Loops {
    public static void main(String[] args) {
        // for
        System.out.println("--- for ---");
        for (int i = 1; i <= 3; i++) {
            System.out.println("i = " + i);
        }

        // while
        System.out.println("--- while ---");
        int j = 1;
        while (j <= 3) {
            System.out.println("j = " + j);
            j++;
        }

        // do-while
        System.out.println("--- do-while ---");
        int k = 1;
        do {
            System.out.println("k = " + k);
            k++;
        } while (k <= 3);

        // for-each
        System.out.println("--- for-each ---");
        int[] arr = {10, 20, 30};
        for (int num : arr) {
            System.out.println("num = " + num);
        }

        // break и continue
        System.out.println("--- break/continue ---");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) break;       // Прервёт цикл на 5
            if (i % 2 != 0) continue; // Пропустит нечётные
            System.out.println(i);    // Выведет 2, 4
        }
    }
}
