package com.sunjinwei.简单工厂模式01;

/**
 * @program: com.sunjinwei.简单工厂模式01
 * @author: Sun jinwei
 * @create: 2019-08-20 19:37
 * @description:
 **/
public class ProductB implements Product {
    @Override
    public int price() {
        return 200;
    }

    @Override
    public String getName() {
        return "product--B";
    }
}