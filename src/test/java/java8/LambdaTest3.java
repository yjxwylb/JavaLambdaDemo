package java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author: xiayuejie
 * @date: 2018/12/11 15:03
 * @description: java8四大内置核心函数式接口
 */
public class LambdaTest3 {


    //四、断言型函数式接口 Boolean Predicate<T>
    //需求：过滤满足条件的字符串并放入集合中
    @Test
    public void test04() {
        List<String> stringList = Arrays.asList("Hello", "Ts", "世界第一等", "hahaha", "en", "sys");
        filterStr(stringList, str -> str.length() >= 3).forEach(str -> System.out.println(str));
    }

    public List<String> filterStr(List<String> stringList, Predicate<String> predicate) {
        ArrayList<String> strings = new ArrayList<>();
        stringList.forEach(str -> {
            if (predicate.test(str)) {
                strings.add(str);
            }
        });
        return strings;
    }

    //三、 R  Function<T,R> 函数型函数式接口
    //需求：处理字符串，并把处理结果返回
    @Test
    public void test3() {
        String s = strHandler("\t\t\t我是一枝梅  ", (x -> x.trim()));//去除首尾空格
        System.out.println(s);
        System.out.println("===========================");
        String s1 = strHandler("我是一枝花，风吹雨打都不怕", str -> str.substring(6, 10));//包头不包尾
        System.out.println(s1);
    }

    public String strHandler(String str, Function<String, String> function) {
        return function.apply(str);
    }

    //二、T Supplier<T>供给型函数接口 无参数，有返回值
    //需求：获取一定数目的随机数集合
    @Test
    public void test2() {
        getRandomNum(10, () -> (int) (Math.random() * 100)).forEach(System.out::println);
    }

    public List<Integer> getRandomNum(int num, Supplier<Integer> supplier) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            integers.add(supplier.get());
        }
        return integers;
    }

    //一、Comsumer<T> 消费型函数接口   有参数无返回值
    @Test
    public void test1() {
        consumer(1000, x -> System.out.println("今天消费了" + x + "元"));
    }

    public void consumer(Integer money, Consumer<Integer> consumer) {
        consumer.accept(money);
    }
}
