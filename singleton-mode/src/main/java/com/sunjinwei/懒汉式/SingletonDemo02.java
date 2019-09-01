package com.sunjinwei.懒汉式;

/**
 * @program: com.sunjinwei.懒汉式
 * @author: Sun jinwei
 * @create: 2019-08-21 18:21
 * @description: 双重锁 实现单例
 **/
public class SingletonDemo02 {

    private volatile static SingletonDemo02 singletonDemo02;

    private SingletonDemo02() {
    }

    public static SingletonDemo02 getInstance() {
        if (singletonDemo02 == null) {
            synchronized (SingletonDemo02.class) {
                if (singletonDemo02 == null) {
                    singletonDemo02=new SingletonDemo02();
                }
            }
        }
        return singletonDemo02;
    }

}