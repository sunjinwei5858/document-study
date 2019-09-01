package com.sunjinwei.threadlocal_dateformat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @program: com.sunjinwie.threadlocal_dateformat
 * @author: Sun jinwei
 * @create: 2019-06-21 09:04
 * @description: simpleDateFormat是线程不安全的类，一般不要定义为static变量
 * 如果定义为static，必须加锁，或者使用DateUtils工具类
 **/
public class MyDateUtils {

    private static ThreadLocal<DateFormat> dateFormatThreadLocal=new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

}