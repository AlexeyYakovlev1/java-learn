import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    private final long id;          // неизменяемое поле
    private String name;            // изменяемое с валидацией
    private int grade;              // изменяемое с валидацией
    private List<String> courses;   // коллекция — защищаем от изменений извне

    public Student(long id, String name, int grade) {
        this.id = id;
        this.name = name;
        setGrade(grade);            // используем сеттер для валидации
        this.courses = new ArrayList<>();
    }

    // Геттеры
    public long getId() { return id; }

    public String getName() { return name; }

    public int getGrade() { return grade; }

    public List<String> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    // Сеттеры с валидацией
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public void setGrade(int grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Оценка должна быть от 0 до 100");
        }
        this.grade = grade;
    }

    // Бизнес-метод для изменения коллекции
    public void addCourse(String course) {
        if (course != null && !course.isBlank()) {
            courses.add(course);
        }
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', grade=" + grade +
               ", courses=" + courses + "}";
    }

    public static void main(String[] args) {
        Student student = new Student(1, "Анна", 85);
        System.out.println(student);

        student.setName("Анна Петрова");
        student.setGrade(92);
        student.addCourse("Java");
        student.addCourse("Алгоритмы");
        System.out.println(student);

        // Попытка изменить список напрямую вызовет исключение
        try {
            student.getCourses().add("Хакерство");
        } catch (UnsupportedOperationException e) {
            System.out.println("Нельзя изменить список напрямую!");
        }

        // Некорректная оценка
        try {
            student.setGrade(150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
