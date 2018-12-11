package java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xiayuejie
 * @date: 2018/12/10 18:47
 * @description:
 */
public class LambdaFilterTest {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 28, 5000.00),
            new Employee("李四", 32, 1888.00),
            new Employee("王五", 19, 3333.00));

    @Test
    public void test01() {
        //策略模式 获取年龄大于等于28的员工信息
        List<Employee> filterEmployees = filterEmployee(this.employees, new MyPredicateByAge());
        filterEmployees.forEach(e -> {
            System.out.println(e);
        });
    }

    @Test
    public void test02() {
        //匿名内部类，获取薪水大于2000的员工信息
        List<Employee> filterEmployees = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() >= 2000 ? true : false;
            }
        });
        filterEmployees.forEach(e -> {
            System.out.println(e);
        });
    }

    @Test
    public void test03() {
        //lambda表达式 获取薪水大于4000 的员工信息
        List<Employee> filterEmployees = filterEmployee(employees, e -> e.getSalary() > 4000);
        filterEmployees.forEach(e -> {
            System.out.println(e);
        });
    }

    @Test
    public void test04() {
        //lambda表达式流操作
        employees.stream().filter(e -> e.getSalary() > 4000).forEach(System.out::println);
    }

    @Test
    public void test05() {
        //获取所有员工的名称
        employees.stream().map(e -> e.getName()).forEach(System.out::println);
        System.out.println("=================================");
        employees.stream().map(Employee::getName).forEach(System.out::println);
    }

    public List<Employee> filterEmployee(List<Employee> employees, MyPredicate<Employee> myPredicate) {
        List<Employee> filterEmployees = new ArrayList<>();
        employees.forEach(e -> {
            if (myPredicate.test(e)) {
                filterEmployees.add(e);
            }
        });
        return filterEmployees;
    }
}
