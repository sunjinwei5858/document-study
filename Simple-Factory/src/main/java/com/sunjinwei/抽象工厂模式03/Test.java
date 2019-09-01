package com.sunjinwei.抽象工厂模式03;

import com.sunjinwei.简单工厂模式01.Product;

/**
 * @program: com.sunjinwei.抽象工厂模式03
 * @author: Sun jinwei
 * @create: 2019-08-20 20:03
 * @description: 抽象工厂
 **/
public class Test {
    public static void main(String[] args) {

        FactoryA factoryA = new FactoryA();

        Product product = factoryA.createProduct();
        Gift gift = factoryA.createGift();

        System.out.println(product.getName());
        System.out.println(gift.getGiftName());
    }
}