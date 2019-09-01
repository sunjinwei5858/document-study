package com.sunjinwei.工厂方法模式02;

import com.sunjinwei.简单工厂模式01.Product;
import com.sunjinwei.简单工厂模式01.ProductA;

/**
 * @program: com.sunjinwei.工厂方法模式02
 * @author: Sun jinwei
 * @create: 2019-08-20 19:53
 * @description: 生产ProductA的工厂FactoryA
 *
 * 由于使用了多态，工厂方法克服了简单工厂违背的开放封闭原则，又保持了封装对象创建过程的优点
 **/
public class FactoryA implements IFactory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}