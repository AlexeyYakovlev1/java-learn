public class Branching {
    public static void main(String[] args) {
        int month = 4;
        String season;

        // if-else if
        if (month == 12 || month == 1 || month == 2) {
            season = "Зима";
        } else if (month >= 3 && month <= 5) {
            season = "Весна";
        } else if (month >= 6 && month <= 8) {
            season = "Лето";
        } else {
            season = "Осень";
        }
        System.out.println("if-else: " + season);

        // switch (statement)
        switch (month) {
            case 12: case 1: case 2:
                season = "Зима";
                break;
            case 3: case 4: case 5:
                season = "Весна";
                break;
            default:
                season = "Другое время года";
        }
        System.out.println("switch: " + season);

        // switch (expression, Java 14+)
        season = switch (month) {
            case 12, 1, 2 -> "Зима";
            case 3, 4, 5 -> "Весна";
            case 6, 7, 8 -> "Лето";
            case 9, 10, 11 -> "Осень";
            default -> "Некорректный месяц";
        };
        System.out.println("switch expression: " + season);

        // Тернарный оператор
        String type = (month >= 3 && month <= 5) ? "Весенний месяц" : "Не весенний месяц";
        System.out.println("Тернарный: " + type);
    }
}
