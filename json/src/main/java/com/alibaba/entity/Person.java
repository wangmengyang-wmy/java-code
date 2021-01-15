package com.alibaba.entity;

import java.util.Date;

public class Person {
    private String name;
    private Integer age;
    private Date birthday;
    private String other;
    public Person() { }

    public Person(String name, Integer age, Date birthday, String other) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.other = other;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", other='" + other + '\'' +
                '}';
    }
}
