package com.sunjinwei.arraylist;

import org.junit.Test;

import java.util.*;

/**
 * @program: com.sunjinwei.arraylist
 * @author: Sun jinwei
 * @create: 2019-07-18 11:52
 * @description: ArrayList源码的第三个构造器
 * 传入是一个collection集合
 **/
public class Demo01 {
    /**
     * 源码的是将传入的collection集合转化为Object[]类型的数组
     */
    public static void main(String[] args) {
        Set<String> set=new HashSet<String>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");

        /**
         * 第一个，Object[] toArray()方法。该方法有可能会抛出java.lang.ClassCastException异常，
         * 如果直接用向下转型的方法，将整个ArrayList集合转变为指定类型的Array数组，便会抛出该异常，
         * 而如果转化为Array数组时不向下转型，而是将每个元素向下转型，则不会抛出该异常，
         * 显然对数组中的元素一个个进行向下转型，效率不高，且不太方便。
         */
        //String[] objects = (String[]) set.toArray();
        /**
         * T[] toArray(T[] a)方法。该方法可以直接将ArrayList转换得到的Array进行整体向下转型（转型其实是在该方法的源码中实现的），
         * 且从该方法的源码中可以看出，参数a的大小不足时，内部会调用Arrays.copyOf方法，该方法内部创建一个新的数组返回
         */
        String[] strings = set.toArray(new String[0]);

        //System.out.println(objects.getClass());
        //System.out.println(Object[].class);
        //Object[] objects1 = Arrays.copyOf(objects, set.size(), Object[].class);

        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        //Integer[] objects = (Integer[]) arrayList.toArray();

        Integer[] integers = arrayList.toArray(new Integer[0]);




    }
}