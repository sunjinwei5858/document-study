package com.sunjinwei.gc;

/**
 * @program: com.sunjinwei
 * @author: Sun jinwei
 * @create: 2019-06-21 12:14
 * @description:
 **/
public class Person {

    private int age;

    private String username;

    public Person() {
    }

    public Person(int age, String username) {
        this.age = age;
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}