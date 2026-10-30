import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        // Исходный массив с дубликатами
        String[] languages = {"Java", "Python", "C++", "Java", "Go", "Python"};

        // 1. HashSet — без гарантий порядка, самый быстрый
        Set<String> hashSet = new HashSet<>();
        for (String lang : languages) hashSet.add(lang);
        System.out.println("HashSet (порядок не гарантирован): " + hashSet);

        // 2. LinkedHashSet — сохраняет порядок вставки
        Set<String> linkedHashSet = new LinkedHashSet<>();
        for (String lang : languages) linkedHashSet.add(lang);
        System.out.println("LinkedHashSet (порядок вставки):    " + linkedHashSet);

        // 3. TreeSet — сортирует элементы
        Set<String> treeSet = new TreeSet<>();
        for (String lang : languages) treeSet.add(lang);
        System.out.println("TreeSet (отсортировано):          " + treeSet);

        // Демонстрация уникальности
        boolean added = hashSet.add("Java"); // уже есть
        System.out.println("\nПовторное добавление 'Java' в HashSet: " + added); // false

        // Демонстрация TreeSet с null
        try {
            treeSet.add(null);
        } catch (NullPointerException e) {
            System.out.println("TreeSet не принимает null: " + e.getClass().getSimpleName());
        }
    }
}
