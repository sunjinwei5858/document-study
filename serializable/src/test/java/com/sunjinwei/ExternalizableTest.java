package com.sunjinwei;

import com.sunjinwei.pojo.Person;
import org.junit.Test;

import java.io.*;

/**
 * @program: com.sunjinwei
 * @author: Sun jinwei
 * @create: 2019-06-17 09:16
 * @description:
 **/
public class ExternalizableTest {
    @Test
    public void test01() {
        Person person = new Person();
        person.setAge(10);
        person.setName("哈哈哈");
        System.out.println("序列化前====" + person);

        //进行序列化
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("personTemplate.txt"));
            objectOutputStream.writeObject(person);
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
            objectInputStream = new ObjectInputStream(new FileInputStream("personTemplate.txt"));
            Person o = (Person) objectInputStream.readObject();
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