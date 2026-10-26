public class StringExample {
    public static void main(String[] args) {
        // --- Неизменяемость String ---
        String original = "Hello";
        original.concat(" World"); // результат игнорируется
        System.out.println("После concat: " + original); // Hello

        String changed = original.concat(" World");
        System.out.println("После сохранения: " + changed); // Hello World

        // --- Пул строк ---
        String a = "Java";
        String b = "Java";
        String c = new String("Java");
        String d = c.intern();

        System.out.println("a == b: " + (a == b)); // true  (пул)
        System.out.println("a == c: " + (a == c)); // false (куча vs пул)
        System.out.println("a == d: " + (a == d)); // true  (intern вернул пул)
        System.out.println("a.equals(c): " + a.equals(c)); // true (содержимое)

        // --- StringBuilder ---
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World").append("!").insert(5, ",");
        System.out.println("StringBuilder: " + sb.toString()); // Hello, World!

        // --- StringBuffer ---
        StringBuffer sbf = new StringBuffer("Hello");
        sbf.append(" World");
        System.out.println("StringBuffer: " + sbf.toString()); // Hello World

        // --- Производительность в цикле ---
        long start = System.currentTimeMillis();
        String bad = "";
        for (int i = 0; i < 10_000; i++) {
            bad += i;
        }
        long timeBad = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        StringBuilder good = new StringBuilder();
        for (int i = 0; i < 10_000; i++) {
            good.append(i);
        }
        long timeGood = System.currentTimeMillis() - start;

        System.out.println("String в цикле: " + timeBad + " мс");
        System.out.println("StringBuilder в цикле: " + timeGood + " мс");
    }
}
