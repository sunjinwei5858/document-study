package com.sunjinwei.工厂方法模式02;

import com.sunjinwei.简单工厂模式01.Product;

/**
 * @program: com.sunjinwei.工厂方法模式02
 * @author: Sun jinwei
 * @create: 2019-08-20 19:54
 * @description:
 **/
public class Test {
    public static void main(String[] args) {

        FactoryA factoryA = new FactoryA();

        Product product = factoryA.createProduct();
        System.out.println(product.getName());

        FactoryB factoryB = new FactoryB();
        Product product1 = factoryB.createProduct();
        System.out.println(product1.getName());

    }
}