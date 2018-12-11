package java8;

/**
 * @author: xiayuejie
 * @date: 2018/12/11 14:45
 * @description: 自定义function，按需操作相应需求
 */
@FunctionalInterface
public interface MyFunction<T> {

    T operate(T t1,T t2);
}
