# Выбор и установка JDK
Для разработки понадобится JDK (Java Development Kit).

## Какой JDK выбрать?
- Eclipse Temurin (Adoptium): Широко используемый открытый дистрибутив. Отличный выбор для большинства разработчиков.
- Microsoft Build of OpenJDK: Бесплатный, с открытым исходным кодом, поддерживается Microsoft. Хороший вариант для Windows юзеров.
- Oracle JDK: Официальный дистрибутив от Oracle. Требует коммерческой лицензии для использования в бизнесе.

### Linux
```bash
sudo apt install openjdk-21-jdk
```

## Настройка переменных среды (JAVA_HOME, PATH)
Переменные нужны, чтобы система и другие инструменты (например, Maven, Gradle) могли находить исполняемые файлы Java.
JAVA_HOME: Указывает на корневую директорию установки JDK. 
PATH: Содержит список директорий, в которых ОС ищет исполняемые файлы.

### Linux
```bash
sudo nano ~/.bashrc
```
```bash
# Добавить в конец файла 
export JAVA_HOME=/path/to/jdk
export PATH=$JAVA_HOME/bin:$PATH
```

# Первая программа - "Hello, World!"
- Код - HelloWorld.java
- Компиляция - ```bash javac HelloWorld.java```
- Запуск - ```bash java HelloWorld```
