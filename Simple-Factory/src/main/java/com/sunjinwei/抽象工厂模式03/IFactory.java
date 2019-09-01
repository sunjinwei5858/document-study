package com.sunjinwei.抽象工厂模式03;

import com.sunjinwei.简单工厂模式01.Product;

/**
 * @program: com.sunjinwei.工厂方法模式02
 * @author: Sun jinwei
 * @create: 2019-08-20 19:51
 * @description: 抽象工厂模式03
 * 假设现在需要针对每种产品生产对应的赠品，难道我们要新增一个Gift的生产工厂吗？
 * 其实没有必要，因为在这个场景下，每种产品必须附带了赠品，所以我们可以利用原有的工厂来生产赠品。
 **/
public interface IFactory {
    /**
     * 抽象工厂模式03：提供一个创建一系列相关或者相互依赖对象的接口，而无需制定他们具体的类。
     * 抽象工厂接口，应该包含所有产品创建的抽象方法 我们可以定义实现不止一个接口，一个工厂也可以不生产一个产品类
     * 和工厂方法模式一样，抽象工厂模式同样实现了开放封闭原则
     * @return
     */
    Product createProduct();
    Gift createGift();

}
