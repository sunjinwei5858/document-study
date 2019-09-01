package com.sunjinwei.demo02_被动引用;

/**
 * @program: com.sunjinwei.demo01_被动引用
 * @author: Sun jinwei
 * @create: 2019-07-14 14:28
 * @description:
 **/
public class SuperClass {

    /**
     * 设置父类的静态字段 验证子类调用父类的静态字段 子类不会触发初始化 只会初始化父类
     */
    public static int num = 10;

    static {
        System.out.println("SuperClass父类初始化");
    }

}