package com.alibaba;

/**
 * 枚举实现接口中的方法
 */
public enum ErrorCodeEn2 implements INumberEnum{

    OK(0, "成功"),
    ERROR_A(100, "错误A"),
    ERROR_B(200, "错误B");

    ErrorCodeEn2(int number, String description) {
        this.code = number;
        this.description = description;
    }

    private int code;
    private String description;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public static void main(String args[]) { // 静态方法
        for (ErrorCodeEn2 s : ErrorCodeEn2.values()) {
            System.out.println("name:"+s.name()+", code: " + s.getCode() + ", description: " + s.getDescription() + ", ordinal: " + s.ordinal());
        }
    }
}
