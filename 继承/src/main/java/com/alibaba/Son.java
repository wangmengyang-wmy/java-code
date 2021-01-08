package com.alibaba;

public class Son extends Father{
    // 静态成员只加载一次
    private static int son_num = 4;
    // 静态代码块和静态变量按在类里面的书写顺序执行，一般将静态代码块放置于静态变量后面，用于初始化静态变量
    static {
        System.out.println("子类静态代码块执行");
        System.out.println("子类静态变量输出:"+son_num);
        son_num += 3;
        System.out.println("子类静态变量输出:"+son_num);
    }
    int son_a = 5;
    // 代码块后于静态变量执行
    {
        System.out.println("子类代码块执行");
        System.out.println("子类静态变量输出:"+son_num);
        son_num += 3;
        System.out.println("子类静态变量输出:"+son_num);
        System.out.println("子类成员变量输出:"+son_a);
    }
    public Son() {
        System.out.println("子类构造方法执行");
        System.out.println("子类构造方法成员变量son_a:"+son_a);
        System.out.println("子类构造方法成员变量son_num:"+son_num);
    }

    public static void main(String[] args) {
        new Son();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n\n");
        new Son();
    }
}
