public class Car {
    private String brand;
    private String color;
    private int speed;

    // Конструктор по умолчанию делегирует параметризованному
    public Car() {
        this("Unknown", "Unknown", 0);
    }

    // Конструктор с двумя параметрами делегирует трёхпараметрическому
    public Car(String brand, String color) {
        this(brand, color, 0);
    }

    // Основной конструктор со всей логикой инициализации
    public Car(String brand, String color, int speed) {
        this.brand = brand;
        this.color = color;
        this.speed = speed;
    }

    // Сеттер с this для разрешения конфликта имён
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Метод, возвращающий this для цепочки вызовов
    public Car accelerate() {
        this.speed += 10;
        return this;
    }

    public void displayInfo() {
        System.out.println(brand + " " + color + ", скорость: " + speed);
    }

    public static void main(String[] args) {
        Car car1 = new Car();                          // Unknown Unknown, 0
        Car car2 = new Car("Toyota", "Red");           // Toyota Red, 0
        Car car3 = new Car("BMW", "Black", 50);        // BMW Black, 50

        car1.displayInfo();
        car2.displayInfo();

        // Цепочка вызовов благодаря return this
        car3.accelerate().accelerate().accelerate();
        car3.displayInfo(); // BMW Black, скорость: 80

        // Сеттер с this
        car1.setBrand("Honda");
        car1.displayInfo(); // Honda Unknown, 0
    }
}
