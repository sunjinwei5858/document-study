package com.sunjinwei.pojo;

import java.io.Externalizable;
import java.io.Serializable;

/**
 * @program: com.sunjinwei.pojo
 * @author: Sun jinwei
 * @create: 2019-06-17 09:00
 * @description:
 *
 * 数组和枚举的序列化---底层重写了ObjectOutputStream的writeObject()方法和ObjectInputStream的readObject()方法
 * javabean的序列化
 *
 * 第一种方式：实现Serializable接口
 * 第二种方式：实现Externalizable 并重写writeExternal()和readExternal()方法
 *
 * 关键字的使用：
 * 1。transient 阻止序列化
 * 2。序列化ID
 *
 **/
public class User implements Serializable {
    private int age;
    private transient String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}