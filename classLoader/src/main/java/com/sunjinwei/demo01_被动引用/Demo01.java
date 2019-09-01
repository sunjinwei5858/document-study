package com.sunjinwei.demo01_被动引用;

/**
 * @program: com.sunjinwei.demo01_被动引用
 * @author: Sun jinwei
 * @create: 2019-07-14 14:30
 * @description: 验证子类调用父类的静态字段 只会初始化父类 不会触发子类的初始化
 * 通过引用父类的静态字段 子类不会进行初始化
 **/
public class Demo01 {
    public static void main(String[] args) {
        System.out.println(SubClass.num);
    }
}