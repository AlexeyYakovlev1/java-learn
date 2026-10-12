public class Car {
    // Поля
    private String brand;
    private String color;
    private int speed;

    // Конструкторы
    public Car() {
        this("Unknown", "Unknown");
    }

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
        this.speed = 0;
    }

    // Геттеры и сеттеры
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    // Методы поведения
    public void accelerate() {
        if (speed < 200) {
            speed += 10;
            System.out.println(brand + " ускоряется. Скорость: " + speed);
        } else {
            System.out.println(brand + " достиг максимальной скорости!");
        }
    }

    public void brake() {
        if (speed > 0) {
            speed -= 10;
            System.out.println(brand + " тормозит. Скорость: " + speed);
        } else {
            System.out.println(brand + " уже стоит на месте.");
        }
    }

    public void displayInfo() {
        System.out.println("Автомобиль: " + brand + ", цвет: " + color + ", скорость: " + speed);
    }

    // Точка входа для демонстрации
    public static void main(String[] args) {
        // Создание объектов разными конструкторами
        Car car1 = new Car("Toyota", "Red");
        Car car2 = new Car("BMW", "Black");

        // Работа с объектами
        car1.displayInfo();
        car2.displayInfo();

        car1.accelerate();
        car1.accelerate();
        car1.brake();

        // Изменение через сеттер
        car2.setColor("White");
        car2.displayInfo();

        // Проверка инкапсуляции
        // car1.brand = "Honda"; // Ошибка! Поле private
    }
}
