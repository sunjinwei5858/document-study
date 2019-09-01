package com.sunjinwei.demo03_被动引用;

/**
 * @program: com.sunjinwei.demo03_被动引用
 * @author: Sun jinwei
 * @create: 2019-07-16 10:26
 * @description: 常量池中的静态字段 编译时候已经将字段放入了常量池中 也不会触发其初始化
 * 常量在编译阶段会存入调用类的常量池中 本质上没有直接引用到定义常量的类 因此不会触发定义常量的类的初始化
 **/
public class ConstClass {
    static {
        System.out.println("ConstClass常量初始化");
    }
    public static final String name="hello world";
}