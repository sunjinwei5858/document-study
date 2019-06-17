package com.sunjinwei;

import com.sunjinwei.pojo.User;
import org.junit.Test;

import java.io.*;

/**
 * @program: com.sunjinwei
 * @author: Sun jinwei
 * @create: 2019-06-17 09:00
 * @description: 对java对象进行序列化和反序列化
 **/
public class SerializableTest {
    @Test
    public void test01() throws IOException, ClassNotFoundException {
        User user = new User();
        user.setAge(19);
        user.setName("小明");
        System.out.println("序列化前==="+user);

        //进行序列化
        ObjectOutputStream objectOutputStream=null;
        try {
             objectOutputStream = new ObjectOutputStream(new FileOutputStream("userTemplate.txt"));
             objectOutputStream.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //进行反序列化
        ObjectInputStream objectInputStream=null;
        try {
            objectInputStream=new ObjectInputStream(new FileInputStream("userTemplate.txt"));
            User o = (User) objectInputStream.readObject();


            System.out.println("序列化后===="+o);
        }catch (IOException e){
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