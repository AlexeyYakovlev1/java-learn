import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        // 1. Полиморфизм: используем интерфейс List
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        // 2. Основные операции, общие для List
        arrayList.add("Java");          // добавление в конец
        arrayList.add("Python");
        arrayList.add(1, "C++");        // вставка по индексу

        linkedList.add("Java");
        linkedList.add("Python");
        linkedList.add(1, "C++");

        System.out.println("ArrayList:  " + arrayList);  // [Java, C++, Python]
        System.out.println("LinkedList: " + linkedList); // [Java, C++, Python]

        // 3. Доступ по индексу (ArrayList быстрее)
        String first = arrayList.get(0); // O(1) для ArrayList
        System.out.println("Первый элемент: " + first);

        // 4. Специфичные методы LinkedList (из Deque)
        if (linkedList instanceof LinkedList<String> ll) {
            ll.addFirst("Go");          // O(1) для LinkedList
            ll.addLast("Rust");         // O(1) для LinkedList
            System.out.println("После addFirst/addLast: " + ll);
        }

        // 5. Итерация
        System.out.print("Итерация ArrayList: ");
        for (String lang : arrayList) {
            System.out.print(lang + " ");
        }
        System.out.println();

        // 6. Удаление
        arrayList.remove("Python");     // удаление по значению
        linkedList.remove(0);           // удаление по индексу
        System.out.println("После удаления ArrayList:  " + arrayList);
        System.out.println("После удаления LinkedList: " + linkedList);
    }
}
