package com.sunjinwei;

import static org.junit.Assert.assertTrue;

import com.sunjinwei.pojo.Person;
import org.junit.Test;

import java.beans.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 内省机制学习
 * 1什么是内省
 * 通过反射的方式操作JavaBean的属性，jdk提供了PropertyDescription类来操作访问JavaBean的属性，Beantils工具基于此来实现
 *
 * 2如何使用内省  执行写操作 就是使用setter方法；执行读操作 就是使用get方法
 *  操作一个属性
 *  操作多个属性
 *  但是还要加上 Object类里面的一个getClass
 */
public class IntrospectorTest {
    /**
     * 内省机制demo----第一种方式 使用Introspector类
     * 通过类Introspector的getBeanInfo()方法获取某个对象的BeanInfo信息
     */
    @Test
    public void introspectorTest() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Person person = new Person(18,"小明");
        //通过Introspector类来获取BeanInfo对象
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
        System.out.println("beanInfo对象==="+beanInfo);//java.beans.GenericBeanInfo@2530c12
        //获取bean类的描述器 java.beans.BeanDescriptor[name=Person; beanClass=class com.sunjinwei.pojo.Person]
        BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
        System.out.println("beanDescriptor描述器==="+beanDescriptor);
        System.out.println("获取bean字节码对象==="+beanDescriptor.getBeanClass());
        //获取bean类属性的描述器
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            //获取bean属性名字
            System.out.println(propertyDescriptor.getName());//age int class
            //进行判断bean属性名字是否是name
            if (propertyDescriptor.getName().equals("name")){
                //如果是name属性 那么执行写方法--就是setter方法
                //执行读方法 那么就是get
                Method method = propertyDescriptor.getWriteMethod();
                //进行赋值
                method.invoke(person,"孙晋伟");
            }
        }
        System.out.println(person.toString());
    }
    /**
     * 内省机制demo02 使用JDK内省类库：PropertyDescriptor类:
     * 操作一个属性
     * */
    @Test
    public void propertyDescriptorTest() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Person person = new Person(18,"小明");
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", Person.class);
        Method readMethod = propertyDescriptor.getReadMethod();
        Object invoke = readMethod.invoke(person);
        System.out.println(invoke);
    }
    /**
     * 通过内省获得bean的所有属性---包含了object类的属性
     */
    @Test
    public void test01() throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            System.out.println("属性==="+propertyDescriptor);
            System.out.println("属性名字==="+propertyDescriptor.getName());
        }
    }
    /**
     * 删掉父类的属性
     */
    @Test
    public void test02() throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            System.out.println(propertyDescriptor.getName());
        }
    }

}
