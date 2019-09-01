package com.sunjinwei.不使用多态;

/**
 * @program: com.sunjinwei.不使用多态
 * @author: Sun jinwei
 * @create: 2019-07-13 16:39
 * @description: 抽象出一个类,来代表人.其中有个drive()方法,需要一个汽车类型作为参数,我们先传入一个JD类型的参数
 * 这样写的弊端：耦合性太强了
 * 如果需求变了，这个人想开奔驰车 怎么办 那只能修改系统
 **/
public class Person {
    public void drive(JieDa jieDa){
        jieDa.run();
    }
    /**
     * 只能修改系统 传入奔驰的参数
     */
    public void drive(BenChi benChi){
        benChi.run();

    }

}