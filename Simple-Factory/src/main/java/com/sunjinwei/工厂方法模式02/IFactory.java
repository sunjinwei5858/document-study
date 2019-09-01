package com.sunjinwei.工厂方法模式02;

import com.sunjinwei.简单工厂模式01.Product;

/**
 * @program: com.sunjinwei.工厂方法模式02
 * @author: Sun jinwei
 * @create: 2019-08-20 19:51
 * @description: 工厂方法模式02
 * 通过工厂方法模式，可以解决简单工厂模式的问题
 * 首先声明一个工厂接口，所有工厂必须实现这个接口
 **/
public interface IFactory {

    Product createProduct();

}
