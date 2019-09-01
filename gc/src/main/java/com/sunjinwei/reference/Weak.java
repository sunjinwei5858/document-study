package com.sunjinwei.reference;

import java.lang.ref.WeakReference;

/**
 * @program: com.sunjinwei.reference
 * @author: Sun jinwei
 * @create: 2019-07-28 11:49
 * @description: 弱引用 无论内存是否充足 都会进行回收
 **/
public class Weak {
    public static void main(String[] args) {
        WeakReference<String> weakReference=new WeakReference<String>(new String("hello"));

        //获取一下
        System.out.println(weakReference.get());

        //通知jvm去回收
        System.gc();

        System.out.println(weakReference.get());



    }
}