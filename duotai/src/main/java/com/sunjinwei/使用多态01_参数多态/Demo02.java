package com.sunjinwei.使用多态01_参数多态;

/**
 * @program: com.sunjinwei.使用多态01_参数多态
 * @author: Sun jinwei
 * @create: 2019-07-13 16:51
 * @description:
 **/
public class Demo02 {
    public static void main(String[] args) {
        Person02 person02 = new Person02();
        Benchi02 benchi02 = new Benchi02();
        person02.setCar(benchi02);
        person02.drive();

        /**
         * 如果需求变成将车换成捷达
         *
         * 多态可以用在什么地方呢?
         *
         */
        JieDa02 jieDa02 = new JieDa02();
        person02.setCar(jieDa02);
        person02.drive();
    }
}