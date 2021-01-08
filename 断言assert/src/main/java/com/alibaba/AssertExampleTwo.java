package com.alibaba;

public class AssertExampleTwo {
    public static void main(String[] args) {
        boolean isEnable=false;
        assert isEnable=true;
        if(isEnable){
            throw new RuntimeException("Assertion should be enabled!");
        }else {
            throw new RuntimeException("Assertion should be disabled!");
        }
    }
}
