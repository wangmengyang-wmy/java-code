package com.alibaba.lombok;

import lombok.AllArgsConstructor;
import lombok.With;

/**
 * 使用@With注解可以实现对原对象进行克隆，并改变其一个属性，使用时需要指定全参构造方法。
 */
@With
@AllArgsConstructor
public class WithExample {
    private Long id;
    private String name;
    private Integer age;

    public static void main(String[] args) {
        WithExample example1 = new WithExample(1L, "test", 20);
        WithExample example2 = example1.withAge(22);
        WithExample example3 = example2.withId(2L);
        WithExample example4 = example3.withName("wc");
        // 将原对象进行clone并设置age，返回false.可见克隆并不是对象引用
        System.out.println(example1.equals(example2));
    }
}
