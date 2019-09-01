package com.sunjinwei.reference;

import java.lang.ref.SoftReference;

/**
 * @program: com.sunjinwei.reference
 * @author: Sun jinwei
 * @create: 2019-07-28 11:49
 * @description: 软引用  只有在内存不足的时候JVM才会回收该对象。
 * 软引用可以和一个引用队列（ReferenceQueue）联合使用，如果软引用所引用的对象被JVM回收，这个软引用就会被加入到与之关联的引用队列中
 **/
public class Soft {
    /**
     * 软引用是用来描述一些有用但并不是必需的对象，在Java中用java.lang.ref.SoftReference类来表示。
     * 对于软引用关联着的对象，只有在内存不足的时候JVM才会回收该对象。
     * 因此，这一点可以很好地用来解决OOM的问题，并且这个特性很适合用来实现缓存：比如网页缓存、图片缓存等。
     * @param args
     */
    public static void main(String[] args) {

        SoftReference<String> softReference=new SoftReference<String>(new String("abc"));
        //1获取软引用对象
        System.out.println("获取到的软引用：     "+softReference.get());
        String aaa = new String("aaa");
        //2告知jvm去回收 通知JVM的gc进行垃圾回收
        System.gc();
        //3打印告知jvm回收之后 看看有没有被回收
        System.out.println("告知jvm去回收的软引用：   "+softReference.get()); //没有被回收 因为此时内存充足
        System.out.println("告知jvm去回收的软引用：    "+aaa); //没有被回收
    }
}