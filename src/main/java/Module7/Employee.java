package Module7;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    private String name;
    private int salary;

    public void work() {
        System.out.printf("%s работает с окладом %d рублей\n", getName(), getSalary());
    }
}