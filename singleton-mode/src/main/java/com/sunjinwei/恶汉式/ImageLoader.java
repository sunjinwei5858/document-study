package com.sunjinwei.恶汉式;

/**
 * @program: com.sunjinwei.恶汉式
 * @author: Sun jinwei
 * @create: 2019-08-21 18:14
 * @description: 饿汉式
 *
 * 线程安全 调用效率高 但是不能延时加载
 *
 * 一上来就把单例对象创建出来 要用的时候直接返回即可，这种可以说是单例模式中最简单的一种实现方式
 **/
public class ImageLoader {

    private static ImageLoader imageLoader=new ImageLoader();

    private ImageLoader(){}

    public static ImageLoader getInstance(){
        return imageLoader;
    }
}