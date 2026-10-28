import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

    // Обобщённый метод с верхней границей
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    // Обобщённый метод с нижней границей (PECS)
    public static void addIntegers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        // 1. Обобщённый класс
        Box<String> stringBox = new Box<>();
        stringBox.set("Привет, дженерики!");
        String message = stringBox.get(); // Приведение не требуется
        System.out.println(message);

        // 2. Инвариантность
        // List<Object> objectList = new ArrayList<String>(); // Ошибка компиляции!

        // 3. Wildcards
        List<Integer> ints = List.of(1, 2, 3);
        List<Double> doubles = List.of(1.5, 2.5);

        // ? extends Number — Producer (читаем)
        System.out.println("Сумма Integer: " + sumOfList(ints));   // 6.0
        System.out.println("Сумма Double: " + sumOfList(doubles)); // 4.0

        // ? super Integer — Consumer (пишем)
        List<Number> numbers = new ArrayList<>();
        addIntegers(numbers);
        System.out.println("Список после добавления: " + numbers); // [1, 2, 3, 4, 5]

        // 4. Демонстрация стирания типов
        List<String> strList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        // Во время выполнения типы обеих коллекций — просто ArrayList
        System.out.println(strList.getClass() == intList.getClass()); // true
    }
}
