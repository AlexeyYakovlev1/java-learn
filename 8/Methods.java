public class Methods {
    // Метод без параметров и без возврата
    public static void printGreeting() {
        System.out.println("Добро пожаловать!");
    }

    // Метод с параметрами и возвратом
    public static int add(int a, int b) {
        return a + b;
    }

    // Перегруженный метод: работа со строками
    public static String add(String a, String b) {
        return a + b;
    }

    // Перегруженный метод: три числа
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    // Метод с varargs
    public static int sumAll(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    // Метод с void, демонстрация передачи по значению
    public static void tryToChange(int value) {
        value = 100;
        System.out.println("Внутри метода: " + value);
    }

    public static void main(String[] args) {
        // Вызов метода без параметров
        printGreeting();

        // Вызов метода с параметрами
        int sum = add(5, 3);
        System.out.println("add(5, 3) = " + sum); // 8

        // Перегрузка
        System.out.println("add(\"Java\", \"!\") = " + add("Java", "!")); // Java!
        System.out.println("add(1, 2, 3) = " + add(1, 2, 3)); // 6

        // Varargs
        System.out.println("sumAll(1, 2, 3) = " + sumAll(1, 2, 3)); // 6
        System.out.println("sumAll(10, 20) = " + sumAll(10, 20));   // 30

        // Передача по значению
        int number = 5;
        tryToChange(number);
        System.out.println("В main: " + number); // 5 (не изменилось)
    }
}
