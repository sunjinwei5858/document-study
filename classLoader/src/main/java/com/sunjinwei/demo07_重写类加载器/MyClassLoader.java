package com.sunjinwei.demo07_重写类加载器;

import java.io.InputStream;

/**
 * @program: com.sunjinwei
 * @author: Sun jinwei
 * @create: 2019-07-13 19:14
 * @description:  不同的加载器对instanceof关键字运算结果的影响
 * 一个是自定义类加载器去加载
 * 一个是系统的类加载器去加载 得出来的两个类 其实不是同一个对象
 * Java团队通过一个类的全限定名来获取描述此类的二进制字节流
 *
 * 假如我们自己写了一个java.lang.String的类，我们是否可以替换调JDK本身的类？
 * 不会加载成功，具体就是因为针对java.*开头的类，jvm的实现中已经保证了必须由bootstrp来加载
 *
 * 不遵循“双亲委托机制”的场景？
 * ---存在父类加载器加载的类需要用到子加载器加载的类的情况
 * Java中有一个SPI(Service Provider Interface)标准,使用了SPI的库，比如JDBC，JNDI等，我们都知道JDBC需要第三方提供的驱动才可以
 * 这里面JAVA引入了线程上下文类加载的概念，线程类加载器默认会从父线程继承，
 * 如果没有指定的话，默认就是系统类加载器（AppClassLoader）,这样的话当加载第三方驱动的时候，就可 以通过线程的上下文类加载器来加载。
 *
 *
 **/
public class MyClassLoader  {
    public static void main(String[] args) throws Exception {
        /**
         * 自定义类加载器
         */
        ClassLoader myLoader=new ClassLoader() {
            /**
             * 这是用户自定义的类加载器方法--这是jdk推荐的
             * 将类加载的逻辑写到这个方法中；因为loadClass()方法，如果顶层启动类加载器加载失败 那么才会调用findClass()方法
             * 这样可以保证写出来的代码符合双亲委派模型规则
             * @param name
             * @return
             * @throws ClassNotFoundException
             */
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                return super.findClass(name);
            }

            /**
             * 这个用户重写加载方法--这个是jdk不推荐的，这样会打破双亲委托机制
             * @param name
             * @return
             * @throws ClassNotFoundException
             */
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName=name.substring(name.lastIndexOf(".")+1)+ ".class";
                    //获取二进制流
                    InputStream inputStream =getClass().getResourceAsStream(fileName);
                    if (inputStream==null){
                        return super.loadClass(name);
                    }
                    byte[] b=new byte[inputStream.available()];
                    //
                    inputStream.read(b);
                    /**
                     * 获取class二进制了以后就可以交给defineClass来实现进一步的加载
                     * 此方法被定义为了final，这也就意味着此方法不能被Override，其实这也是jvm留给我们的唯一的入口，
                     * 通过这个唯 一的入口，jvm保证了类文件必须符合Java虚拟机规范规定的类的定义。
                     * 此方法最后会调用native的方法来实现真正的类的加载工作。
                     */
                    return defineClass(name,b,0,b.length);
                }catch (Exception e){
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj = myLoader.loadClass("com.sunjinwei.demo07_重写类加载器.MyClassLoader").newInstance();
        System.out.println(obj.getClass());
        /**
         * 重写loadClass()方法就是打破双亲委托机制
         */
        System.out.println(obj instanceof MyClassLoader);//false

    }
}