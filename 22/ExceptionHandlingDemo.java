import java.io.*;

public class ExceptionHandlingDemo {

    // 1. Классический try-catch-finally (до Java 7)
    public static void readWithFinally(String path) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } finally {
            // Ручное закрытие с проверкой на null
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 2. Современный try-with-resources (Java 7+)
    public static void readWithResources(String path) {
        // Ресурс br будет закрыт автоматически
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }

    // 3. Демонстрация подавленных исключений
    static class FailingResource implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new Exception("Ошибка при закрытии ресурса!");
        }
    }

    public static void suppressedExceptionDemo() {
        try (FailingResource res = new FailingResource()) {
            throw new RuntimeException("Основная ошибка в try!");
        } catch (Exception e) {
            System.err.println("Поймано основное исключение: " + e.getMessage());
            // Получаем подавленное исключение из close()
            for (Throwable suppressed : e.getSuppressed()) {
                System.err.println("  -> Подавленное исключение: " + suppressed.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        String path = "test.txt";

        System.out.println("--- Классический try-catch-finally ---");
        readWithFinally(path);

        System.out.println("\n--- try-with-resources ---");
        readWithResources(path);

        System.out.println("\n--- Подавленные исключения ---");
        suppressedExceptionDemo();
    }
}
