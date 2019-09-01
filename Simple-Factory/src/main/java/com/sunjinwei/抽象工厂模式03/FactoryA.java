package com.sunjinwei.抽象工厂模式03;

import com.sunjinwei.简单工厂模式01.Product;
import com.sunjinwei.简单工厂模式01.ProductA;

/**
 * @program: com.sunjinwei.抽象工厂模式03
 * @author: Sun jinwei
 * @create: 2019-08-20 20:02
 * @description: 抽象工厂模式03
 *
 *
 **/
public class FactoryA implements IFactory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }

    @Override
    public Gift createGift() {
        return new GiftA();
    }
}