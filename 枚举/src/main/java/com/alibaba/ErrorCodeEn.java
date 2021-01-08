package com.alibaba;

/**
 * 枚举的显式定义枚举值，重写抽象方法
 */
public enum ErrorCodeEn {
    OK(0, "成功"){
        @Override
        public void fun() {
            System.out.println("OK：重写了fun()方法");
            System.out.println(this.getCode());
            System.out.println(this.getDescription());
        }
    },
    ERROR_A(100, "错误A") {
        @Override
        public void fun() {
            System.out.println("ERROR_A：重写了fun()方法");
            System.out.println(this.getCode());
            System.out.println(this.getDescription());
        }
    },
    ERROR_B(200, "错误B") {
        @Override
        public void fun() {
            System.out.println("ERROR_B：重写了fun()方法");
            System.out.println(this.getCode());
            System.out.println(this.getDescription());
        }
    };

    // 构造方法：enum的构造方法只能被声明为private权限或不声明权限（默认private）
    ErrorCodeEn(int number, String description) {
        this.code = number;
        this.description = description;
    }
    private int code;
    private String description;
    // 普通方法
    public int getCode() {
        return code;
    }
    public String getDescription() {
        return description;
    }
    public abstract void fun();
    public static void main(String args[]) { // 静态方法
        for (ErrorCodeEn s : ErrorCodeEn.values()) {
            System.out.println("code: " + s.getCode() + ", description: " + s.getDescription());
            System.out.println("---------------------------");
            s.fun();
            System.out.println("+++++++++++++++++++++++++++");
        }
    }
}
