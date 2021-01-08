package com.alibaba;

public class AssertTestThree {
    public static void main(String[] args) {
        AssertTestThree at = new AssertTestThree();
        at.assertMe(true);
        at.assertMe(false);
    }
    private void assertMe(boolean boo) {
        String s = null;
        assert boo :s = "hello world";
        System.out.println("true condition");
    }
}
