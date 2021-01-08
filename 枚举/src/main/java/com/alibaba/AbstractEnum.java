package com.alibaba;

/**
 * 还可以在枚举类中给出抽象方法，然后在创建每个枚举项时使用“特殊”的语法来重复抽象方法。
 * 所谓“特殊”语法就是匿名内部类！也就是说每个枚举项都是一个匿名类的子类对象！
 *
 * 通常fun()方法应该定义为抽象的方法，因为每个枚举常量都会去重写它。
 * 你无法把Direction声明为抽象类，但需要声明fun()方法为抽象方法。
 */
public enum AbstractEnum {
    FRONT() {
        public void fun() {
            System.out.println("FROND：重写了fun()方法");
        }
    },
    BEHIND() {
        public void fun() {
            System.out.println("BEHIND：重写了fun()方法");
        }
    },
    LEFT() {
        public void fun() {
            System.out.println("LEFT：重写了fun()方法");
        }
    },
    RIGHT() {
        public void fun() {
            System.out.println("RIGHT：重写了fun()方法");
        }
    };

    // [只需要把fun()方法修改为抽象方法，但不可以把Direction类声明为抽象类。]
    public abstract void fun();


    public static void main(String[] args) {
        AbstractEnum.FRONT.fun();
    }
}
