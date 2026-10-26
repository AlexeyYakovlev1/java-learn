// Enum с полями, конструктором и методами
public enum HttpStatus {
    OK(200, "OK"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int code;
    private final String message;

    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() { return code; }
    public String getMessage() { return message; }

    // Метод для поиска статуса по коду
    public static HttpStatus fromCode(int code) {
        for (HttpStatus status : values()) {
            if (status.code == code) return status;
        }
        throw new IllegalArgumentException("Неизвестный код: " + code);
    }

    public static void main(String[] args) {
        // Встроенные методы
        System.out.println("Все статусы: " + java.util.Arrays.toString(values()));
        System.out.println("Статус 404: " + valueOf("NOT_FOUND"));
        System.out.println("Порядковый номер OK: " + OK.ordinal()); // 0

        // Использование в switch
        HttpStatus status = HttpStatus.NOT_FOUND;
        switch (status) {
            case OK:
                System.out.println("Успех!");
                break;
            case NOT_FOUND:
                System.out.println("Ресурс не найден");
                break;
            default:
                System.out.println("Ошибка сервера");
        }

        // Собственные методы
        System.out.println("Сообщение для 500: " + INTERNAL_SERVER_ERROR.getMessage());
        System.out.println("Поиск по коду 200: " + fromCode(200));
    }
}
