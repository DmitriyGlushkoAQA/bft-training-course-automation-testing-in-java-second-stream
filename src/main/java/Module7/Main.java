package Module7;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Петров", 50000),
                new Developer("Иванов", 100000),
                new Manager("Сидоров", 130000)
        };

        for (Employee empl : employees) {
            empl.work();
        }

        Shape[] shapes = {
                new Circle(),
                new Rectangle()
        };

        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}