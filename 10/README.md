# Конструкторы: что это и зачем
Конструктор — это специальный метод, который автоматически вызывается при создании объекта через оператор `new`. 
Его основная задача — инициализировать поля объекта начальными значениями.

- Имя конструктора совпадает с именем класса.
- Конструктор не имеет возвращаемого типа (даже `void`).
- Вызывается автоматически при использовании `new`.
- Если конструктор не объявлен, Java создаёт конструктор по умолчанию (без параметров).

```java
public class Car {
    String brand;
    int speed;

    // Конструктор
    public Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }
}

// Использование
Car myCar = new Car("Toyota", 0);
```

# Ключевое слово `this`
`this` — это ссылка на текущий объект, то есть на объект, чей метод или конструктор в данный момент выполняется
У `this` есть два основных применения:
- Разрешение конфликта имён между полем класса и параметром метода/конструктора.
```java
public class Point {
    public int x = 0;
    public int y = 0;

    public Point(int x, int y) {
        this.x = x; // this.x — поле класса, x — параметр
        this.y = y;
    }
}
```
- Вызов одного конструктора из другого через `this(...)`.
```java
public class Rectangle {
    private int x, y;
    private int width, height;

    public Rectangle() {
        this(0, 0, 1, 1); // вызов конструктора с 4 параметрами
    }

    public Rectangle(int width, int height) {
        this(0, 0, width, height);
    }

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
```

# Другие применения `this`
Передача `this` как аргумента
```java
public class KeywordTest {
    public KeywordTest() {
        printInstance(this); // передаём ссылку на текущий объект
    }

    public void printInstance(KeywordTest obj) {
        System.out.println(obj);
    }
}
```

# Ограничения `this`
- `this` нельзя использовать в `static-методах`, так как статические методы принадлежат классу, а не объекту
- `this` нельзя использовать в `static-контексте` (например, в статических блоках инициализации).
