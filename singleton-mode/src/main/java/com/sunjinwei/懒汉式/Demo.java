package com.sunjinwei.懒汉式;

/**
 * @program: com.sunjinwei.懒汉式
 * @author: Sun jinwei
 * @create: 2019-08-22 12:20
 * @description:
 **/
public class Demo {
    //不进行初始化 并且使用volatile设置可见
    private static volatile Demo demo;

    //私有构造
    private Demo() {
    }

    //创建方法进行生成对象
    public static Demo createBean() {
        //第一重判断
        if (demo == null) {
            //使用锁
            synchronized (Demo.class) {
                //第二重判断
                if (demo == null) {
                    demo = new Demo();
                }
            }
        }
        return demo;
    }
}