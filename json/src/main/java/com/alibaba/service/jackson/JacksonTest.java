package com.alibaba.service.jackson;

import com.alibaba.entity.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

public class JacksonTest {

    public static void writeValueAsString1() throws JsonProcessingException {
        Person person=new Person("张三",18,new Date(),null);
        ObjectMapper objectMapper = new ObjectMapper();
        /**
         * String writeValueAsString(Object value)
         * 1、用于将任何 Java 对象（如 POJO、List、Set、Map等）序列化为 json 字符串，如果对象中某个属性的值为 null，则默认也会序列化为 null；
         * 2、如果 value 为 null，返回序列化的结果也返回 null
         */
        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
        /**
         * T readValue(String content, Class<T> valueType)
         * 1、从给定的 JSON 字符串反序列化为 Java 对象；
         * 2、content 为空或者为 null，都会报错
         * 3、valueType 表示反序列化的结果对象，可以是任何 java 对象，比如 POJO、List、Set、Map 等等，并且这些对象必须有默认的无参构造函数
         */
        Person person1=objectMapper.readValue(json,Person.class);
        System.out.println(person1);
    }

    public static void main(String[] args) throws Exception{
        JacksonTest.writeValueAsString1();
    }
}
