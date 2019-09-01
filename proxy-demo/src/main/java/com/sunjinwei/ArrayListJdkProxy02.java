package com.sunjinwei;

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
public class ArrayListJdkProxy02 {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();

        //1类加载器对象 2要代理的接口字节码对象数组 3invocationalhandler接口的实现类
        ClassLoader loader = arrayList.getClass().getClassLoader(); //1类加载器对象

        Class<?>[] interfaces = arrayList.getClass().getInterfaces(); //2要代理的接口字节码对象数组

        /**
         * 创建代理对象
         */
        List<String> proxyInstance = (List<String>) Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                /**
                 * 如果是add操作 那么进行输出 开始新增了
                 */
                String name = method.getName();
                if ("add".equals(name)){
                    System.out.println("开始新增了");
                    return method.invoke(arrayList,args);
                }
                return null;
            }
        });

        proxyInstance.add("aaa");
        proxyInstance.add("bbb");
        proxyInstance.add("ccc");

        for (String s : arrayList) {
            System.out.println(s);
        }


    }
}