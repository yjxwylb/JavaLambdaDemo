package java8;

import lombok.Data;

/**
 * @author: xiayuejie
 * @date: 2018/12/10 18:41
 * @description:
 */
@Data
public class Employee {

    private String name;
    private int age;
    private double salary;

    public Employee() {
    }

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
