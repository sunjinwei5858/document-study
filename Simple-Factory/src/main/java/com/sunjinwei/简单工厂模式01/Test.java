package com.sunjinwei.简单工厂模式01;

/**
 * @program: com.sunjinwei.简单工厂模式01
 * @author: Sun jinwei
 * @create: 2019-08-20 19:42
 * @description: 根据输入的生产类型生产对应的产品
 **/
public class Test {
    public static void main(String[] args) {

        Product product = Factory.createProduct("A");

        System.out.println(product.getName());
    }
}