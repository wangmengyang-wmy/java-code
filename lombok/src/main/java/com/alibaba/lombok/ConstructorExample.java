package com.alibaba.lombok;

import lombok.*;

/**
 * @XxConstructor
 * 使用@XxConstructor注解可以自动生成构造方法，有@NoArgsConstructor、@RequiredArgsConstructor和@AllArgsConstructor三个注解可以使用。
 *
 * @NoArgsConstructor： 生成无参构造函数。
 * @RequiredArgsConstructor： 生成包含必须参数的构造函数，使用@NonNull注解的类属性为必须参数。
 * 如果想要对外提供使用(调用方法对必须参数赋值并创建对象)可以使用staticName选项生成一个static方法。方法名是staticName=of
 * @AllArgsConstructor： 生成包含所有参数的构造函数。
 */
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor
@ToString
public class ConstructorExample {

    @NonNull
    private Long id;
    @NonNull
    private String name;
    private Integer age;

    public static void main(String[] args) {
        //无参构造器
        ConstructorExample example1 = new ConstructorExample();
        System.out.println(example1);
        //@NonNull注解的必须参数构造器
        ConstructorExample example2 = new ConstructorExample(1L,"张三");
        ConstructorExample example2_of = ConstructorExample.of(2L,"李四");
        System.out.println(example2);
        System.out.println(example2_of);
        //全部参数构造器
        ConstructorExample example3 = new ConstructorExample(1L,"test",20);
        System.out.println(example3);
    }
}
