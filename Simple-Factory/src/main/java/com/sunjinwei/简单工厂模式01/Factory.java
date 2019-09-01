package com.sunjinwei.简单工厂模式01;

/**
 * @program: com.sunjinwei.简单工厂模式01
 * @author: Sun jinwei
 * @create: 2019-08-20 19:39
 * @description: 定义一个生产工厂类，根据输入类型生产对应的产品
 * 简单工厂模式的一个典型事例，当用户需要新增产品productD时，
 * 必须在工厂类的生产方法中增加对应的判断分之，所以简单工厂模式违背了开放封闭的原则
 * 简单工厂模式01，利用静态方法根据输入参数生成对应的产品，隐藏了产品实例化的细节
 * 总结：简单工厂模式最大的优点在于工厂类中包含了必要的逻辑判断，根据客户端的选择条件动态实例化相关的类
 * 对于客户端来说，去除了额与具体产品的依赖。但是当需求有变动的时候，需要对原有的类进行修改，违背了开放封闭的原则
 *
 **/
public class Factory {
    /**
     * 根据生产类型生产对应的产品
     * @param type
     * @return
     */
    public static Product createProduct(String type){
        Product product=null;
        switch (type){
            case "A":
                product=new ProductA();
                break;
            case "B":
                product=new ProductB();
                break;
            case "C":
                product=new ProductC();
                break;
        }
        return product;
    }


}