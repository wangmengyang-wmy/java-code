package com.alibaba;

public enum Direction2 {
    FRONT("front"),BEHIND("behind"), LEFT("left"), RIGHT("right");

    private String name;

    Direction2(String name) {
        System.out.println("构造枚举对象");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
