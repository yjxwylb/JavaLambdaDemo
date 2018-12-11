package java8;

/**
 * @author: xiayuejie
 * @date: 2018/12/10 18:43
 * @description: 策略模式，一个接口，多个实现，相对于匿名内部类，每增加一个判断，需要多一个接口实现
 */
public class MyPredicateByAge implements MyPredicate<Employee> {


    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 28 ? true : false;
    }
}
