package com.alibaba.lombok;

import lombok.extern.java.Log;

/**
 * 使用@Log注解，可以直接生成日志对象log，通过log对象可以直接打印日志。
 */
@Log
public class LogExample {
    public static void main(String[] args) {
        log.info("level info");
        log.warning("level warning");
        log.severe("level severe");
    }
}
