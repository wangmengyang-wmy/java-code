package com.alibaba.lombok;


import lombok.Builder;
import lombok.ToString;

/**
 * 使用@Builder注解可以通过建造者模式来创建对象，建造者模式加链式调用，创建对象太方便了！
 */
@Builder
@ToString
public class BuilderExample {
    private Long id;
    private String name;
    private Integer age;

    public static void main(String[] args) {
        BuilderExample example = BuilderExample.builder()
                .id(1L)
                .name("test")
                .age(20)
                .build();
        System.out.println(example);
    }
}
