package java8;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author: xiayuejie
 * @date: 2018/12/11 16:35
 * @description: 方法的引用与构造器引用
 */
public class LambdaTest4 {

    /**
     * 方法的引用
     * 1.对象::实例方法名
     * 2.类::静态方法名
     * 3.类::实例方法名
     */

    //一、
    @Test
    public void test1() {
        Consumer<Integer> consumer = x -> System.out.println(x);
        consumer.accept(1000);
        System.out.println("========================");
        Consumer<Integer> consumer1 = System.out::println;//对象名::方法名
        consumer1.accept(2000);

        Employee employee = new Employee("张三", 19, 5000);
        Supplier<String> supplier1 = () -> employee.getName();
        System.out.println(supplier1.get());
        Supplier<String> supplier2 = employee::getName;//对象名::方法名
        System.out.println(supplier2.get());
    }

}


