package com.sunjinwei.懒汉式;

/**
 * @program: com.sunjinwei.懒汉式
 * @author: Sun jinwei
 * @create: 2019-08-21 18:10
 * @description: 饿汉式单例
 * 线程安全 调用效率不高 但是能延时加载
 **/
public class SingletonDemo01 {
    //类初始化 不初始化这个对象 延时加载 真正用的时候再创建
    private static SingletonDemo01 singletonDemo2;

    //构造器私有化
    private SingletonDemo01() {
    }

    //方法同步 调用效率低
    public static synchronized SingletonDemo01 getInstance() {
        if (singletonDemo2 == null) {
            singletonDemo2 = new SingletonDemo01();
        }
        return singletonDemo2;
    }
}