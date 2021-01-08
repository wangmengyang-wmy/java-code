package com.alibaba;

public class PlantTest implements Plant{
    public static void main(String[] args) {
        Fruit apple = Fruit.APPLE;
        System.out.println(apple.getCode());
        System.out.println(apple.getDescription());
        Vegetable potato = Vegetable.POTATO;
        System.out.println(potato.getCode());
        System.out.println(potato.getDescription());
    }
}
