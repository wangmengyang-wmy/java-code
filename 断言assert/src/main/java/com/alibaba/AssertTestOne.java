package com.alibaba;

public class AssertTestOne {
    public static void main(String[] args) {
        AssertTestOne at = new AssertTestOne();
        at.assertMe(true);
        at.assertMe(false);
    }
    private void assertMe(boolean boo)
    {
        assert boo;
        System.out.println("true condition");
    }
}
