package com.sunjinwei;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.sunjinwei
 * @author: Sun jinwei
 * @create: 2019-08-10 11:30
 * @description: 写一个ArrayList的动态代理类
 * 1。动态代理是实现 JDK 里的 InvocationHandler 接口的 invoke 方法，但注意的是代理的是接口，也就是你的
 * 业务类必须要实现接口，通过 Proxy 里的 newProxyInstance 得到代理对象。
 * 2。动态代理 CGLIB，代理的是类，不需要业务类继承接口，通过派生的子类来实现代理
 **/
public class ArrayListJdkProxy01 implements InvocationHandler {

    private List<String> list;

    public ArrayListJdkProxy01(List<String> list) {
        this.list = list;
    }

    /**
     * 创建产生代理的方法
     * 1。类加载器
     * 2.接口数组
     * 3.生成代理对象，使用this代表实现类
     */
    public List<String> createProxy(){
        //1类加载器
        ClassLoader classLoader = list.getClass().getClassLoader();
        //2接口数组
        Class<?>[] interfaces = list.getClass().getInterfaces();
        //3生成代理对象
        List<String> proxyInstance = (List<String>) Proxy.newProxyInstance(classLoader, interfaces, this);

        return proxyInstance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        if ("add".equals(name)){
            System.out.println("进行jdk代理   权限校验了");
        }
        return method.invoke(list,args);
    }

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        List<String> proxy =  new ArrayListJdkProxy01(list).createProxy();

        proxy.add("aaaa");

        System.out.println(list);
    }
}