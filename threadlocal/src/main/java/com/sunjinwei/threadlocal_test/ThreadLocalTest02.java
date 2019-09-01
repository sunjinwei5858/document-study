package com.sunjinwei.threadlocal_test;

import org.junit.Test;

/**
 * @program: com.sunjinwei.threadlocal_test
 * @author: Sun jinwei
 * @create: 2019-06-21 10:02
 * @description:
 **/
public class ThreadLocalTest02 {
    /**
     * ThreadLocal：它是一个数据结构，有点像HashMap，可以保存"key : value"键值对，
     * 但是一个ThreadLocal只能保存一个，并且各个线程的数据互不干扰。
     */
    @Test
    public void test01(){
        //在线程1中初始化了一个ThreadLocal对象localName
        ThreadLocal<String> localName = new ThreadLocal<>();
        //并通过set方法，保存了一个值
        localName.set("小明");
        //同时在线程1中通过localName.get()可以拿到之前设置的值
        //但是如果在线程2中，拿到的将是一个null。
        System.out.println(localName.get());
    }

}