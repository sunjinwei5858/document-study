package com.sunjinwei.工厂方法模式02;

import com.sunjinwei.简单工厂模式01.Product;
import com.sunjinwei.简单工厂模式01.ProductB;

/**
 * @program: com.sunjinwei.工厂方法模式02
 * @author: Sun jinwei
 * @create: 2019-08-20 19:53
 * @description: 生产ProductB的工厂FactoryB
 **/
public class FactoryB implements IFactory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}