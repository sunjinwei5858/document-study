package com.sunjinwei.懒汉式;

/**
 * @program: com.sunjinwei.懒汉式
 * @author: Sun jinwei
 * @create: 2019-08-22 13:28
 * @description: 重写懒汉式子单例
 **/
public class Demo02 {
    //不进行初始化 并且使用voliate关键字 标示可见性
    private volatile static Demo02 demo02;

    //私有构造方法
    private Demo02(){}

    //使用双重锁
    public static Demo02 getBean(){
        //第一重判断
        if (demo02==null){
            //如果为null 那么进行加锁
            synchronized (Demo02.class){
                //线程获取到锁之后 进入到第二重判断是否为null
                if (demo02==null){
                    //如果为null 那么进行初始化
                    demo02=new Demo02();
                }
            }
        }
        return demo02;

    }
}