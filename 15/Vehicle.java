// Родительский класс
public class Vehicle {
    protected String model;
    protected int speed;

    public Vehicle(String model) {
        this.model = model;
        this.speed = 0;
    }

    public void move() {
        System.out.println(model + " движется со скоростью " + speed);
    }

    public void accelerate(int amount) {
        speed += amount;
    }
}
