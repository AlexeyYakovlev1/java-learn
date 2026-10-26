# `if-else`: базовый выбор из двух и более путей
Это самая фундаментальная конструкция ветвления. Она позволяет выполниить блок кода только при истинности условия.
```java
if (condition) {
	// выполняется, если условие истинно (true)
} else {
	// выполняется, если условие ложно (false)
}
```

Цепочка `if-else` позволяет выполнить несколько блоков кода в зависимости от условий.
```java
int score = 85;
if (score >= 90) {
    System.out.println("Отлично");
} else if (score >= 75) {
    System.out.println("Хорошо");
} else if (score >= 60) {
    System.out.println("Удовлетворительно");
} else {
    System.out.println("Неудовлетворительно");
}
```

# `switch`: выбор по значению
Это удобный инструмент когда нужно сравнить одно значение с несколькими константами (фиксированными вариантами)
```java
switch (выражение) {
    case значение1:
        // код
        break;
    case значение2:
        // код
        break;
    default:
        // код по умолчанию
        break;
}
```

## Ключевые моменты
- `break` оператор завершает выполнение `switch`.
```java
case SUNDAY:
case SATURDAY:
    System.out.println("Выходной");
    break;
```

- `default` выполняется, если ни один `case` не совпал
- Какие типы можно использовать: `byte`, `short`, `char`, `int`, `enum`, а также `String`. Важно: `boolean`, `long`, `float`, `double` использовать нельзя.
- Осторожно с `null`: если выражение `switch` равно `null`, будет выброшено исключение `NullPointerException`.

## Современный `switch` (exppression, Java 14+)
Можно использовать `switch` как выражение (expression), который возвращает значение.
```java
Day day = Day.WEDNESDAY;
int numLetters = switch (day) {
    case MONDAY, FRIDAY, SUNDAY -> 6;
    case TUESDAY -> 7;
    case THURSDAY, SATURDAY -> 8;
    case WEDNESDAY -> 9;
};
```
