package com.sunjinwei.demo01_内存泄漏原因;

/**
 * @program: com.sunjinwei.demo01_内存泄漏原因
 * @author: Sun jinwei
 * @create: 2019-07-16 20:11
 * @description:
 **/
public class Person {
    private String name;
    private String password;
    private int age;

    public Person() {
    }

    public Person(String name, String password, int age) {

        this.name = name;
        this.password = password;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}