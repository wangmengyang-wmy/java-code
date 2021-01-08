package com.alibaba;

/**
 * 捕获断言的错误信息
 */
public class AssertTestTwo {
    public static void main(String[] args) {
        AssertTestTwo at = new AssertTestTwo();
        try{
            at.assertMe(true);
            at.assertMe(false);
        }catch (AssertionError ae){
            System.out.println("Asseriont Error catched");
        }
        System.out.println("go on");
    }
    private void assertMe(boolean boo)
    {
        assert boo;
        System.out.println("true condition");
    }
}
