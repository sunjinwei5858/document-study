package com.sunjinwei.抽象工厂模式03;

/**
 * @program: com.sunjinwei.抽象工厂模式03
 * @author: Sun jinwei
 * @create: 2019-08-20 19:59
 * @description:
 * 假设现在需要针对每种产品生产对应的赠品，难道我们要新增一个Gift的生产工厂吗？
 * 其实没有必要，因为在这个场景下，每种产品必须附带了赠品，所以我们可以利用原有的工厂来生产赠品。
 **/
public interface Gift {
    String getGiftName();
}
