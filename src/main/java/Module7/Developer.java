package Module7;

public class Developer extends Employee {

    public Developer(String name, int salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.printf("%s пишет автотесты на Java за %d рублей\n", getName(), getSalary());
    }
}