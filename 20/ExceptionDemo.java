import java.io.*;

public class ExceptionDemo {
    // Проверяемое исключение: компилятор требует обработки или проброса
    public static void readFile(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            System.out.println(reader.readLine());
        } // reader закроется автоматически (try-with-resources)
    }

    public static void main(String[] args) {
        // 1. Обработка проверяемого исключения
        try {
            readFile("nonexistent.txt");
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } finally {
            System.out.println("Блок finally выполнен.");
        }

        // 2. Непроверяемое исключение (программная ошибка)
        String text = null;
        try {
            System.out.println(text.length()); // NullPointerException
        } catch (NullPointerException e) {
            System.err.println("Попытка обратиться к null: " + e.getMessage());
        }

        // 3. Демонстрация Error (НЕ ПЕРЕХВАТЫВАЙТЕ в реальном коде!)
        // try {
        //     throw new OutOfMemoryError("Имитация нехватки памяти");
        // } catch (OutOfMemoryError e) { // ТАК ДЕЛАТЬ НЕЛЬЗЯ
        //     System.err.println("Поймана ошибка: " + e);
        // }
    }
}
