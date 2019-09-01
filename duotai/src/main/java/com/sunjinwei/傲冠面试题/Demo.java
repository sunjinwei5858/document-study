package com.sunjinwei.傲冠面试题;

import javafx.beans.binding.ObjectExpression;

/**
 * @program: com.sunjinwei.傲冠面试题
 * @author: Sun jinwei
 * @create: 2019-08-29 12:28
 * @description:
 **/
public class Demo {
    public static void main(String[] args) {
        Object object=getObject();
        ((Father) object).get();
    }

    private static Object getObject() {
        return new A();
    }

}