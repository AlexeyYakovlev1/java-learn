// Иерархия классов
class Shape {
    public void draw() {
        System.out.println("Рисую фигуру");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Рисую круг");
    }

    public void calculateRadius() {
        System.out.println("Вычисляю радиус круга");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Рисую квадрат");
    }

    public void calculateSide() {
        System.out.println("Вычисляю сторону квадрата");
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        // Upcasting: ссылки типа Shape на объекты подклассов
        Shape[] shapes = { new Circle(), new Square(), new Circle() };

        // Полиморфизм: у каждого объекта своя реализация draw()
        for (Shape shape : shapes) {
            shape.draw(); // динамическое связывание
        }

        // Downcasting с проверкой instanceof
        for (Shape shape : shapes) {
            if (shape instanceof Circle circle) { // pattern matching
                circle.calculateRadius();
            } else if (shape instanceof Square square) {
                square.calculateSide();
            }
        }

        // Демонстрация ClassCastException (раскомментируйте, чтобы увидеть)
        // Shape s = new Circle();
        // Square sq = (Square) s; // ClassCastException!
    }
}
