# Что такое инкапсуляция?
Инкапсуляция — это принцип объектно-ориентированного программирования, который заключается в сокрытии внутреннего состояния объекта и предоставлении контролируемого доступа к нему через публичные методы.
Проще говоря: данные (поля) объекта должны быть скрыты от прямого доступа извне, а взаимодействие с ними — происходить через специальные методы, которые контролируют, какие значения можно записать и прочитать.

# Как реализовать инкапсуляцию
- Объявить поля `private`. Это скрывает их от прямого доступа извне.
- Создать публичные геттеры и сеттеры для контролируемого доступа.
- Добавить валидацию в сеттеры и логику в геттеры (при необходимости).
```java
// ОЧЕНЬ ПЛОХО, НЕТ ИНКАПСУЛЯЦИИ
public class BankAccount {
    public double balance; // публичное поле — любой может изменить
}

// Использование
BankAccount account = new BankAccount();
account.balance = -1000000; // никакой проверки — счёт уходит в минус
```
```java
// ПРАВИЛЬНО, С ИНКАПСУЛЯЦИЕЙ
public class BankAccount {
    private double balance; // скрытое поле

    public double getBalance() { // геттер
        return balance;
    }

    public void deposit(double amount) { // контролируемое изменение
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Сумма пополнения должна быть положительной");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Недостаточно средств или некорректная сумма");
        }
    }
}
```
Теперь баланс нельзя изменить напрямую — только через методы, которые проверяют корректность операции.

# Геттеры и сеттеры: соглашения об именовании
- Геттер (getter, accessor) — метод для чтения значения поля.
- Сеттер (setter, mutator) — метод для изменения значения поля.
```java
public class Person {
    private String name;
    private int age;
    private boolean active;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.active = true;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return active;
    }

    // Сеттеры
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Некорректный возраст: " + age);
        }
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
```

## Защита от возврата изменяемых объектов
Если поле — это коллекция или массив, геттер не должен возвращать ссылку на оригинал, иначе инкапсуляция нарушается:
```java
public class Order {
    private List<String> items = new ArrayList<>();

    // ❌ Плохо: клиент может изменить список напрямую
    public List<String> getItems() {
        return items;
    }

    // ✅ Хорошо: возвращаем копию
    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    // ✅ Ещё лучше: возвращаем неизменяемое представление
    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }
}
```

## Когда геттеры и сеттеры не нужны
Не создавайте геттеры/сеттеры автоматически, если:
- Поле не должно читаться извне. Например, внутренний счётчик или кэш.
- Поле не должно изменяться извне. Например, идентификатор объекта (id), который задаётся только в конструкторе.
- Изменение поля должно происходить только через бизнес-метод. Например, баланс счёта меняется через `deposit()` и `withdraw()`, а не через `setBalance()`.
```java
public class User {
    private final long id; // задаётся только в конструкторе
    private String name;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() { return id; } // только геттер, без сеттера
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    // setter для id отсутствует — это правильно
}
```
