package com.sunjinwei.简单工厂模式01;

/**
 * @program: com.sunjinwei.简单工厂模式01
 * @author: Sun jinwei
 * @create: 2019-08-20 19:37
 * @description: 分别有三个产品ProductA、ProductB、ProductC ，均实现Product接口
 **/
public class ProductA implements Product {
    @Override
    public int price() {
        return 100;
    }

    @Override
    public String getName() {
        return "product--A";
    }
}