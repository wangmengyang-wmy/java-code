package com.alibaba.lombok;

import lombok.SneakyThrows;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * 还在手动捕获并抛出异常？使用@SneakyThrows注解自动实现试试！
 */
public class SneakyThrowsExample {
    //自动抛出异常，无需处理
    @SneakyThrows(Exception.class)
//    @SneakyThrows(UnsupportedEncodingException.class)
    public static byte[] str2byte(String str){

//        java.nio.charset.StandardCharsets.UTF_8 不能正常捕捉UnsupportedEncodingException异常
        return str.getBytes(StandardCharsets.UTF_8);
//        return str.getBytes("UTF-8");
    }

    public static void main(String[] args) {
        String str = "Hello World!";
        System.out.println(str2byte(str).length);
    }
}
