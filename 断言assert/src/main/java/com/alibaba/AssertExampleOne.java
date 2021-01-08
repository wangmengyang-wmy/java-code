package com.alibaba;

public class AssertExampleOne {
    public static void main(String[] args) {
        int x=10;
        System.out.println("Testing Assertion that x==100");
        assert x==100:"Out assertion failed!";
        System.out.println("Test passed!");
    }
}
