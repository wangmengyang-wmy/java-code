package com.alibaba.lombok;

import lombok.Value;

/**
 * 使用@Value注解可以把类声明为不可变的，声明后此类相当于final类，无法被继承，其属性也会变成final属性。
 * 其实@Value注解是@Data注解的升级版，他在@Data注解的基础上把类声明成public final、类成员声明为private final
 */
@Value
public class ValueExample {
    Long id;
    String name;
    Integer age;

    public static void main(String[] args) {
        //只能使用全参构造器
        ValueExample example = new ValueExample(1L,"test",20);
        // example.setName("andy") //没有生成setter方法，会报错
        // example.name="andy" //字段被设置为final类型，会报错
    }

}
