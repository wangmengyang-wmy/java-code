package com.alibaba;

public class Father {
    // 静态成员只加载一次
    private static int father_num = 4;
    // 静态代码块和静态变量按在类里面的书写顺序执行，一般将静态代码块放置于静态变量后面，用于初始化静态变量
    static {
        System.out.println("父类静态代码块执行");
        System.out.println("父类静态变量输出:"+father_num);
        father_num += 3;
        System.out.println("父类静态变量输出:"+father_num);
    }
    int father_a = 5;
    // 代码块后于静态变量执行
    {
        System.out.println("父类代码块执行");
        System.out.println("父类静态变量输出:"+father_num);
        father_num += 3;
        System.out.println("父类静态变量输出:"+father_num);
        System.out.println("父类成员变量输出:"+father_a);
    }
    public Father() {
        System.out.println("父类构造方法执行");
        System.out.println("父类构造方法成员变量father_a:"+father_a);
        System.out.println("父类构造方法成员变量father_num:"+father_num);
    }
}
