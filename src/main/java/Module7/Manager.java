package Module7;

public class Manager extends Employee {

    public Manager(String name, int salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.printf("%s управляет отделом за %d рублей\n", getName(), getSalary());
    }
}