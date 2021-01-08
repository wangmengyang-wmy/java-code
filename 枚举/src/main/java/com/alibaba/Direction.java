package com.alibaba;

public enum Direction {
    FRONT, BEHIND, LEFT, RIGHT;
    Direction(){
        // [枚举类的构造器不可以添加访问修饰符，枚举类的构造器默认是private的。但你自己不能添加private来修饰构造器。]
        System.out.println("--------hello");
    }
}
