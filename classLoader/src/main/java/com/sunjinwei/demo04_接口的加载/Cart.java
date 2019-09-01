package com.sunjinwei.demo04_接口的加载;

/**
 * @program: com.sunjinwei.demo04_接口的加载
 * @author: Sun jinwei
 * @create: 2019-07-16 10:45
 * @description: 接口的初始化并不要求父接口全部初始化 但是类必须要求父类全部进行了初始化
 * 接口的不能写静态代码块；但是编译器会提供<clinit>构造器 进行初始化接口定义的成员变量
 **/
public interface Cart extends User{
    public static String cart = "hahaha";
}
