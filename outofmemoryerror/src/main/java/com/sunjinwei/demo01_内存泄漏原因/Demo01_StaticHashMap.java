package com.sunjinwei.demo01_内存泄漏原因;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: com.sunjinwei.demo01_内存泄漏原因
 * @author: Sun jinwei
 * @create: 2019-07-16 20:04
 * @description: Java内存泄露根本原因是什么呢？
 * 长生命周期的对象持有短生命周期对象的引用就很可能发生内存泄露，尽管短生命周期对象已经不再需要，
 * 但是因为长生命周期对象持有它的引用而导致不能被回收，这就是java中内存泄露的发生场景
 **/
public class Demo01_StaticHashMap {
    /**
     * 1静态集合类引起内存泄露：
     * 像HashMap、Vector等的使用最容易出现内存泄露，这些静态变量的生命周期和应用程序一致，
     * 他们所引用的所有的对象Object也不能被释放，因为他们也将一直被Vector等引用着。
     *
     * 在这个例子中，循环申请Object 对象，并将所申请的对象放入一个Vector 中，
     * 如果仅仅释放引用本身（o=null），那么Vector 仍然引用该对象，所以这个对象对GC 来说是不可回收的。
     * 因此，如果对象加入到Vector 后，还必须从Vector 中删除，最简单的方法就是将Vector对象设置为null。
     */
    @Test
    public void test01(){
        Map map=new HashMap(10);
        for (int i = 0; i < 100; i++) {
            Object o = new Object();
            o=null;
            map.put(i,o);
        }
        //map=null;
        System.out.println(map);
    }

    /**
     * 2当集合里面的对象属性被修改后，再调用remove（）方法时不起作用。
     */
    @Test
    public void test02(){
        Set<Person> set = new HashSet<Person>();
        Person p1 = new Person("唐僧","pwd1",25);
        Person p2 = new Person("孙悟空","pwd2",26);
        Person p3 = new Person("猪八戒","pwd3",27);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println("总共有"+set.size()+"条结果");
        p3.setAge(30);
        set.remove(p3);
        System.out.println("总共有"+set.size()+"条结果");
        set.add(p3);
        System.out.println("总共有"+set.size()+"条结果");


    }


}