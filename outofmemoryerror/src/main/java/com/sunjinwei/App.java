package com.sunjinwei;

/**
 * 如果要向运行时常量池中添加内容，最简单的作法就是使用string.intern()这个Native方法
 * 该方法作用：
 * 1 如果池中已经包含一个等于此string对象的字符串，则返回池中这个字符串的string对象
 *  否则，将此string对象包含的字符串添加到常量池中，并且返回此string对象的引用
 */
public class App {
    public static void main(String[] args) {
        String username="小明";
        String intern = username.intern();
        String intern1 = intern.intern();
        System.out.println(intern1);
    }
}
