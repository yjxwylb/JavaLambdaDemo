package java8;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author: xiayuejie
 * @date: 2018/12/11 16:35
 * @description: 方法的引用与构造器引用
 */
public class LambdaTest4 {

    /**
     * 方法的引用
     * 1.对象::方法名
     * 2.类::方法名
     * 3.对象::方法名
     */
    @Test
    public void test1() {
        Consumer<Integer> consumer=x-> System.out.println("小明今天消费");
    }

    }

