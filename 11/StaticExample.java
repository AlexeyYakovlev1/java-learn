public class StaticExample {
    // Статическое поле — счётчик созданных объектов
    static int objectCount = 0;

    // Статическая константа
    static final double PI = 3.14159;

    // Instance-поле
    String name;

    // Статический блок инициализации
    static {
        System.out.println("Статический блок выполнен при загрузке класса");
    }

    // Конструктор
    public StaticExample(String name) {
        this.name = name;
        objectCount++; // увеличиваем общий счётчик
    }

    // Статический метод
    public static int getObjectCount() {
        // return name; // Ошибка! Нельзя обратиться к instance-полю
        return objectCount;
    }

    // Instance-метод
    public void printInfo() {
        System.out.println("Объект: " + name + ", всего создано: " + objectCount);
    }

    // Статический вложенный класс
    static class Helper {
        static void assist() {
            System.out.println("Помощь от вложенного класса. Всего объектов: " + objectCount);
        }
    }

    public static void main(String[] args) {
        // Статический блок уже выполнен до этой строки
        System.out.println("Начало main");

        StaticExample a = new StaticExample("A");
        StaticExample b = new StaticExample("B");

        a.printInfo(); // Объект: A, всего создано: 2
        b.printInfo(); // Объект: B, всего создано: 2

        // Вызов статического метода через имя класса
        System.out.println("Всего объектов: " + StaticExample.getObjectCount());

        // Статический вложенный класс
        StaticExample.Helper.assist();
    }
}
