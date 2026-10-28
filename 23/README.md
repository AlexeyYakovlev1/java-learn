# Зачем создавать свои исключения?
Стандартные исключения Java (`IOException`, `NullPointerException`) описывают общие проблемы. Но когда вы пишете, например, банковское приложение, ошибка «недостаточно средств» — это не просто `Exception`, это конкретная бизнес-ситуация. Собственные исключения позволяют:

- Сделать ошибки предметно-ориентированными: `InsufficientFundsException` говорит сама за себя, в отличие от общего `Exception`.
- Повысить читаемость и поддерживаемость кода: Другим разработчикам (и вам в будущем) сразу понятно, что пошло не так.
- Обеспечить точную обработку: Вы можете перехватывать разные типы исключений и реагировать на них по-разному.
- Добавить контекст: Свое исключение может нести дополнительные данные, например, сумму недостачи или идентификатор пользователя.

Согласно рекомендациям Oracle, стоит задуматься о создании собственного класса исключения, если вы отвечаете «да» хотя бы на один из вопросов: нужен ли вам тип исключения, которого нет в Java; поможет ли пользователям отличать ваши исключения от чужих; или бросает ли ваш код несколько связанных исключений?.

# Базовый синтаксис: наследование
Создание своего исключения — это просто создание нового класса, который наследуется от одного из существующих классов исключений. Главный выбор — от кого наследоваться: от `Exception` или от `RuntimeException`.
```java
// Проверяемое (checked) исключение
public class MyCheckedException extends Exception {
    public MyCheckedException(String message) {
        super(message);
    }
}

// Непроверяемое (unchecked) исключение
public class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String message) {
        super(message);
    }
}
```

Выбор родителя определяет, будет ли исключение проверяемым (компилятор заставит его обрабатывать) или непроверяемым (обработка не обязательна).

# Конструкторы: полный набор для профессионалов
Хороший класс исключения должен предоставлять несколько конструкторов, чтобы его было удобно использовать в разных ситуациях. Вот рекомендуемый набор:
```java
public class DomainException extends Exception {

    // 1. Конструктор по умолчанию (редко используется, но полезен для фреймворков)
    public DomainException() {
        super();
    }

    // 2. Конструктор с сообщением — самый частый вариант
    public DomainException(String message) {
        super(message);
    }

    // 3. Конструктор с причиной (cause) — для «цепочки исключений»
    public DomainException(Throwable cause) {
        super(cause);
    }

    // 4. Конструктор с сообщением и причиной — самый информативный
    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

Зачем нужен конструктор с `Throwable cause`? Он позволяет реализовать цепочку исключений (exception chaining). Представьте, что ваш метод ловит `SQLException` и хочет выбросить более понятное `DataAccessException`, но при этом сохранить информацию о первопричине. Конструктор с `cause` делает именно это: исходное исключение становится «причиной» нового и доступно через метод `getCause()`.

# Примеры
## Пример 1: Простое предметно-ориентированное исключение
```java
// Проверяемое исключение для ситуации «пользователь не найден»
public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

// Использование
public class UserService {
    public User findUser(String userId) throws UserNotFoundException {
        if (userId == null || userId.isBlank()) {
            throw new UserNotFoundException("ID пользователя не может быть пустым");
        }
        // ... поиск ...
        if (user == null) {
            throw new UserNotFoundException("Пользователь с ID " + userId + " не найден");
        }
        return user;
    }
}
```

## Пример 2: Исключение с дополнительными полями
Если ошибка несет в себе полезные данные, добавьте их в класс исключения.
```java
// Непроверяемое исключение для ошибки валидации возраста
public class InvalidUserAgeException extends RuntimeException {
    private final int age;

    public InvalidUserAgeException(String message, int age) {
        super(message);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

// Использование
public void registerUser(int age) {
    if (age < 0 || age > 150) {
        throw new InvalidUserAgeException("Некорректный возраст: " + age, age);
    }
}
```

## Пример 3: Цепочка исключений (Exception Chaining)
```java
public class DataAccessException extends Exception {
    public DataAccessException(String message, Throwable cause) {
        super(message, cause); // сохраняем первопричину
    }
}

// Использование
public User loadUser(long id) throws DataAccessException {
    try {
        return database.queryUser(id); // может выбросить SQLException
    } catch (SQLException e) {
        // Оборачиваем низкоуровневое исключение в предметно-ориентированное
        throw new DataAccessException("Не удалось загрузить пользователя с ID " + id, e);
    }
}
```

# Checked или Unchecked: как выбрать?
## Checked (`extends Exception`)
Когда вызывающий код может и должен отреагировать на ошибку и восстановиться после неё.
`FileNotFoundException` — можно попросить пользователя выбрать другой файл.

## Unchecked (`extends RuntimeException`)
Когда ошибка вызвана программной ошибкой (багом) или нарушением предусловий, и вызывающий код вряд ли сможет что-то сделать.
`IllegalArgumentException` — передан некорректный аргумент, это ошибка программиста.

Современная тенденция: Многие разработчики и фреймворки (например, Spring) предпочитают непроверяемые исключения для большинства бизнес-ошибок, чтобы не «загрязнять» сигнатуры методов и не заставлять писать бесконечные try-catch. Однако проверяемые исключения остаются отличным выбором для API, где важно, чтобы вызывающий код осознанно обработал возможность сбоя (например, при работе с внешними ресурсами).

# Лучшие практики
- Именование: Всегда добавляйте суффикс `Exception` к именам классов, наследующихся от `Exception` (например, `UserNotFoundException`, а не `UserNotFound`).
- Наследуйтесь от подходящего класса: Если создаете checked-исключение, наследуйтесь от `Exception`. Если unchecked — от `RuntimeException`. Не наследуйтесь напрямую от `Throwable` или `Error`.
- Предоставляйте полный набор конструкторов (особенно с `Throwable cause`) для гибкости и поддержки цепочек исключений.
- Документируйте: Используйте Javadoc-тег `@throws` чтобы указать, при каких условиях метод может выбросить ваше исключение.
- Не злоупотребляйте: Не создавайте отдельное исключение для каждой мелочи. Иногда достаточно стандартного `IllegalArgumentException`.
