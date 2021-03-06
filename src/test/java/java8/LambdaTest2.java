package java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author: xiayuejie
 * @date: 2018/12/11 11:09
 * @description: lambda表达式的几种写法
 */
//lambda表达式 -> 左侧代表的是接口函数的参数，右侧代表对接口函数的具体实现
public class LambdaTest2 {

    //一、无参无返回值
    @Test
    public void test01() {
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类实现,无参无返回值");
            }
        };
        run1.run();
        System.out.println("==============================");

        Runnable run2 = () -> System.out.println("Lambda表达式实现");
        run2.run();
    }

    //二、有一个参数，无返回值
    @Test
    public void test02() {
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("匿名内部类实现,有一个参数,无返回值");
        System.out.println("=========================");
        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("Lambda实现,有一个参数,无返回值");
    }

    //三、有多个参数，有返回值
    @Test
    public void test03() {
        //匿名内部类实现
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare = com1.compare(10, 20);
        System.out.println(compare);
        System.out.println("================================");

        //Lambda表达式中只有一条语句，return 和{}都可以省略不写
        Comparator<Integer> com2 = (x, y) -> Integer.compare(x, y);
        System.out.println(com2.compare(10, 20));
        System.out.println("===================================");

        Comparator<Integer> com3 = (x, y) -> {
            System.out.println("Lambda体中包含多个语句，需要书写完整");
            return Integer.compare(x, y);
        };
        System.out.println(com3.compare(10,20));
    }
    //自定义计算功能的函数式接口MyCaculateFunction
    @Test
    public void test04() {
        MyCaculateFunction<Integer> caculate1 = new MyCaculateFunction<Integer>() {
            @Override
            public Integer caculate(Integer value) {
                return value * value;
            }
        };
        System.out.println(caculate1.caculate(10));
        System.out.println("=============================");
        //直接使用函数式接口
        MyCaculateFunction<Integer> caculate2 = x -> x * x;
        System.out.println(caculate2.caculate(200)
        );
        //调用自定义方法
        Integer number = caculate(30, x -> x * x);
        System.out.println(number);

    }

    //自定义公共方法
    public Integer caculate(Integer value, MyCaculateFunction<Integer> myCaculateFunction) {
        return myCaculateFunction.caculate(value);
    }

    @Test
    public void test05(){
        Long value = getValue(100L, 200L, (x, y) -> x * y);
        System.out.println(value);
    }

  public Long  getValue(Long x,Long y,MyFunction<Long> myFunction){
        return myFunction.operate(x,y);
  }

}
