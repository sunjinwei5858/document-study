package com.sunjinwei.使用多态02_返回值类型多态;

import com.sunjinwei.使用多态01_参数多态.Car;
import com.sunjinwei.使用多态01_参数多态.Person02;

/**
 * @program: com.sunjinwei.使用多态02_返回值类型多态
 * @author: Sun jinwei
 * @create: 2019-07-13 17:05
 * @description: 第二个场景：将多态运用在方法的返回值上面
 * 这就是设计模式中的简单工厂模式
 **/
public class Demo03 {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();

        Car benchi = carFactory.createCar("benchi");

        Person02 person02 = new Person02();
        person02.setCar(benchi);

        person02.drive();
    }
}