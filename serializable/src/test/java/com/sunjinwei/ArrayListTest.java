package com.sunjinwei;

import com.sunjinwei.pojo.Person;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.sunjinwei
 * @author: Sun jinwei
 * @create: 2019-06-17 09:34
 * @description: ArrayList的序列化
 * 在序列化操作过程中会对类型进行检查，要求被序列化的类必须属于Enum、Array和Serializable类型其中的任何一种。
 * 在变量声明前加上该关键字，可以阻止该变量被序列化到文件中。
 * 在类中增加writeObject 和 readObject 方法可以实现自定义序列化策略
 **/
public class ArrayListTest {
    /**
     * 查看ArrayList源码：
     * ArrayList底层是通过数组实现的。数组elementData这一成员变量是transient的，通过该属性的声明方式我们知道，他是无法通过序列化持久化下来的
     * 思考：那么list中的元素是如何通过序列化和反序列化把List中的元素保留下来了呢？
     * 继续查看源码 我们发现list重写了writeObject和readObject方法，
     * 在序列化过程中，如果被序列化的类中定义了writeObject 和 readObject 方法
     * 虚拟机会试图调用对象类里的 writeObject 和 readObject 方法，进行用户自定义的序列化和反序列化
     *
     * 如果没有这样的方法，则默认调用是 ObjectOutputStream 的 defaultWriteObject 方法以及 ObjectInputStream 的 defaultReadObject 方法。
     *
     * 用户自定义的 writeObject 和 readObject 方法可以允许用户控制序列化的过程，比如可以在序列化的过程中动态改变序列化的数值。
     */
    @Test
    public void test01(){
        List<String> list = new ArrayList<>();
        list.add("哈哈哈");
        list.add("嘻嘻嘻");
        list.add("嘿嘿嘿");

        System.out.println("序列化之前==="+list);

        //进行序列化
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("arrayListTemplate.txt"));
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //进行反序列化读取数据
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("arrayListTemplate.txt"));
            List o = (List) objectInputStream.readObject();
            System.out.println("序列化之后的==="+o);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}