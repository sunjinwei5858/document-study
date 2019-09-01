package com.sunjinwei.恶汉式;

/**
 * @program: com.sunjinwei.恶汉式
 * @author: Sun jinwei
 * @create: 2019-08-22 12:14
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
        ImageLoader imageLoader = ImageLoader.getInstance();
        ImageLoader imageLoader01 = ImageLoader.getInstance();

        System.out.println(imageLoader==imageLoader01);

    }
}