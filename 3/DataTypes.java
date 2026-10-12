public class DataTypes {
    public static void main(String[] args) {
        // Целые числла
        byte smallNumber = 100;
        short mediumNumber = 1000;
        int regularNumber = 1000000;
        long bigNumber = 100_000_000L;

        // Дробные числа
        float smallDecimal = 3.14f;
        double regularDecimal = 3.14159265358979323846;

        // Символ и логическое значение
        char grade = 'A';
        boolean isPassed = true;

        // Вывод
        System.out.println("byte: " + smallNumber);
        System.out.println("short: " + mediumNumber);
        System.out.println("int: " + regularNumber);
        System.out.println("long: " + bigNumber);
        System.out.println("float: " + smallDecimal);
        System.out.println("double: " + regularDecimal);
        System.out.println("char: " + grade);
        System.out.println("boolean: " + isPassed);
    }
}
