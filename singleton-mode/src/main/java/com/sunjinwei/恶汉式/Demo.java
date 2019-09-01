package com.sunjinwei.恶汉式;

/**
 * @program: com.sunjinwei.恶汉式
 * @author: Sun jinwei
 * @create: 2019-08-22 13:32
 * @description: 饿汉式单例自己写一遍
 * 饿汉就是类一旦加载，就把单例初始化完成，保证getInstance的时候，单例是已经存在的了
 **/
public class Demo {
    //1进行初始化对象
    private static Demo demo=new Demo();
    //2私有构造方法
    private Demo(){}
    //3创建方法获取对象
    public static Demo getBean(){
        return demo;
    }

}