package com.sunjinwei.去重;

import java.util.*;

/**
 * @program: com.sunjinwei.去重
 * @author: Sun jinwei
 * @create: 2019-08-02 13:20
 * @description: 去重和排序
 **/
public class Demo01 {
    public static void main(String[] args) {
        int[] arr =new int[]{1,2,7,5,5,2,6,6,6,2,3,3};

        /**
         * 第一种方法  通过集合set去重并且排序
         */
        Set<Integer> set=new HashSet<>();

        for (int i : arr) {
            if (!set.contains(i)){
                set.add(i);
            }
        }
        System.out.println(set);

    }
}