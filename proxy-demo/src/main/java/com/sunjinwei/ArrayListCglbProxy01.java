package com.sunjinwei;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @program: com.sunjinwei
 * @author: Sun jinwei
 * @create: 2019-08-10 11:48
 * @description: 使用cgjb实现list的动态代理
 * cglb针对的是实现类 所以可以返回ArrayList ；如果是jdk代理 那么就需要传入list接口 这里要注意
 **/
public class ArrayListCglbProxy01 implements MethodInterceptor {

    /**
     * 将要增强的对象传入代理中
     */
    private ArrayList<String> arrayList;

    public ArrayListCglbProxy01(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    /**
     * 产生代理对象的方法:
     * 1.创建enhance对象
     * 2.设置父类--字节码对象
     * 3.设置接口对调--实现类对象
     * 4.创建代理对象
     */
    public ArrayList<String> creatListCglbProxy(){

        Enhancer enhancer = new Enhancer();
        //1设置字节码对象
        enhancer.setSuperclass(arrayList.getClass());
        //2设置实习类对象 这里使用this 代表当前实现类
        enhancer.setCallback(this);
        //3创建代理对象
        ArrayList<String> o = (ArrayList<String>) enhancer.create();

        return o;
    }

    /**
     * 使用动态代理进行增强某个方法，使用的MethodProxy
     * 对add方法进行增强
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        String name = method.getName();

        //如果是add方法 那么就进行权限校验
        if ("add".equals(name)){
            System.out.println("进行cglb代理 实现类权限校验了");
            return methodProxy.invoke(arrayList,objects);
        }

        //如果不是add方法 那么就正常执行
        return methodProxy.invoke(arrayList,objects);
    }

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        /**
         * 使用cglb创建动态代理对象
         */
        ArrayList<String> proxyList = new ArrayListCglbProxy01(list).creatListCglbProxy();

        proxyList.add("aaa");

        System.out.println(list);

    }
}