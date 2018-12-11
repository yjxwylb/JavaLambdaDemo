package java8;

/**
 * @author: xiayuejie
 * @date: 2018/12/11 13:29
 * @description:
 */
@FunctionalInterface
public interface MyCaculateFunction<Integer> {
    Integer caculate(Integer value);
}
