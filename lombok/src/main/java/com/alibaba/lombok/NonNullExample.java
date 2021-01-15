package com.alibaba.lombok;

import lombok.NonNull;

/**
 * 在方法参数上使用@NonNull注解可以做非空判断，如果传入空值的话会直接抛出NullPointerException。
 * 如果这个注解放到方法的返回值上会如何？？貌似并没有抛出异常
 */
public class NonNullExample {
    private String name;
    public NonNullExample(@NonNull String name){
        this.name = name;
    }
    public void getName(){
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        new NonNullExample("test").getName();
        //会抛出NullPointerException
        new NonNullExample(null).getName();
    }
}
