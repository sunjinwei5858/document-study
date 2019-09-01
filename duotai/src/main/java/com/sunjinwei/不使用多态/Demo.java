package com.sunjinwei.不使用多态;

/**
 * @program: com.sunjinwei.不使用多态
 * @author: Sun jinwei
 * @create: 2019-07-13 16:41
 * @description: 需求：有这样一个系统:有个学生工作从学校毕业了,作的还不错.买了辆捷达汽车.这个系统应该如何设计呢?
 **/
public class Demo {
    public static void main(String[] args) {
        /**
         * 如下这样的代码 会被项目经历砍死
         * 缺点：写的代码偶合性太强了!
         *
         */
        Person person = new Person();
        JieDa jieDa = new JieDa();
        person.drive(jieDa);
        /**
         * 需求发生变化，换成奔驰车了 那么我们只能修改系统
         * 所以需要使用多态 就不用去频繁的修改系统 需要将汽车抽象出来
         */
        BenChi benChi = new BenChi();
        person.drive(benChi);
    }
}