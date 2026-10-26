// Интерфейс — определяет контракт
interface Flyable {
    void fly();
    void land();

    default void checkWeather() {
        System.out.println("Проверяю погоду перед полётом...");
    }
}

// Абстрактный класс — частичная реализация
abstract class Vehicle {
    protected String model;
    protected int speed;

    public Vehicle(String model) {
        this.model = model;
    }

    public void accelerate(int amount) {
        speed += amount;
        System.out.println(model + " ускоряется до " + speed);
    }

    // Абстрактный метод — наследники обязаны реализовать
    public abstract void move();
}

// Класс-наследник абстрактного класса + реализация интерфейса
class Airplane extends Vehicle implements Flyable {
    public Airplane(String model) {
        super(model);
    }

    @Override
    public void move() {
        System.out.println(model + " движется по взлётной полосе");
    }

    @Override
    public void fly() {
        System.out.println(model + " летит!");
    }

    @Override
    public void land() {
        System.out.println(model + " приземляется");
    }

    // Может переопределить default-метод
    @Override
    public void checkWeather() {
        System.out.println("Проверяю погоду для " + model + "...");
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {
        Airplane plane = new Airplane("Boeing 747");

        plane.move();          // Boeing 747 движется по взлётной полосе
        plane.accelerate(200); // Boeing 747 ускоряется до 200
        plane.checkWeather();  // Проверяю погоду для Boeing 747...
        plane.fly();           // Boeing 747 летит!
        plane.land();          // Boeing 747 приземляется

        // Полиморфизм: ссылка типа интерфейса
        Flyable flyable = new Airplane("Cessna");
        flyable.fly();         // Cessna летит!
    }
}
