package com.sunjinwei.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @program: com.sunjinwei.reference
 * @author: Sun jinwei
 * @create: 2019-07-28 11:50
 * @description: 虚引用 如果一个对象与虚引用关联，则跟没有引用与之关联一样，在任何时候都可能被垃圾回收器回收。
 **/
public class Phantom {
    public static void main(String[] args) {

        ReferenceQueue<String> queue = new ReferenceQueue<String>();

        PhantomReference<String> pr = new PhantomReference<String>(new String("hello"), queue);

        System.out.println(pr.get()); //null

    }
}