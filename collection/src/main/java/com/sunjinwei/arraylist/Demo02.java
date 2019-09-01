package com.sunjinwei.arraylist;

import java.util.Arrays;
import java.util.List;

/**
 * @program: com.sunjinwei.arraylist
 * @author: Sun jinwei
 * @create: 2019-08-22 16:36
 * @description: 如果数组通过Arrays.asList 那么后面的集合是不能进行增删改查的
 **/
public class Demo02 {
    public static void main(String[] args) {
        String[] arr=new String[]{"aaa","bbb","ccc"};
        /**
         * 使用asList返回的是Arrays的内部类ArrayList
         */
        List<String> strings = Arrays.asList(arr);

        strings.add("eee");
        System.out.println(strings);


    }
}