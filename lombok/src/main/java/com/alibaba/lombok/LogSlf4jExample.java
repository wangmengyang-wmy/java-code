package com.alibaba.lombok;

import lombok.extern.slf4j.Slf4j;

/**
 * 使用Lombok生成日志对象时，根据使用日志实现的不同，有多种注解可以使用。比如@Log、@Log4j、@Log4j2、@Slf4j等。
 */
@Slf4j
public class LogSlf4jExample {
    public static void main(String[] args) {
        log.info("level:{}","info");
        log.warn("level:{}","warn");
        log.error("level:{}", "error");
    }
}
