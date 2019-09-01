package com.sunjinwei.demo07_重写类加载器;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @program: com.sunjinwei.demo07_重写类加载器
 * @author: Sun jinwei
 * @create: 2019-07-16 18:23
 * @description:
 * 启动类加载器返回值为null？
 * Bootstrap ClassLoader是由C/C++编写的，它本身是虚拟机的一部分，所以它并不是一个JAVA类，也就是无法在java代码中获取它的引用，
 * JVM启动时通过Bootstrap类加载器加载rt.jar等核心jar包中的class文件，之前的int.class,String.class都是由它加载。
 * 然后呢，我们前面已经分析了，JVM初始化sun.misc.Launcher并创建Extension ClassLoader和AppClassLoader实例。
 * 并将ExtClassLoader设置为AppClassLoader的父加载器。Bootstrap没有父加载器，但是它却可以作用一个ClassLoader的父加载器。
 * 比如ExtClassLoader。这也可以解释之前通过ExtClassLoader的getParent方法获取为Null的现象
 **/
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(ClassLoader.getSystemClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(ClassLoader.getSystemClassLoader().getParent());//sun.misc.Launcher$ExtClassLoader@5e481248
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());//null

        System.out.println(Demo.class.getClassLoader());
        System.out.println(Class.forName("com.sunjinwei.demo07_重写类加载器.Demo").getClassLoader());


    }
}