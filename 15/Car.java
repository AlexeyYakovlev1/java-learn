import Vehicle;

// Наследник
public class Car extends Vehicle {
    private int numDoors;

    public Car(String model, int numDoors) {
        super(model); // вызов конструктора Vehicle
        this.numDoors = numDoors;
    }

    @Override
    public void move() {
        super.move(); // вызов реализации родителя
        System.out.println("Автомобиль с " + numDoors + " дверями");
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota", 4);
        car.accelerate(60);
        car.move();
        // Вывод:
        // Toyota движется со скоростью 60
        // Автомобиль с 4 дверями
    }
}
