package com.sunjinwei.demo05_静态分派;

import org.junit.jupiter.api.Test;

/**
 * @program: com.sunjinwei.demo05_静态分派
 * @author: Sun jinwei
 * @create: 2019-07-16 15:46
 * @description: 方法重载--演示方法调用的静态分派 多态的实现机制
 *
 **/
public class Demo05 {

    class Man extends Human {

    }

    class Woman extends Human {

    }

    public void sayHello(Human human) {
        System.out.println("hello human");

    }

    public void sayHello(Man man) {
        System.out.println("hello man");

    }

    public void sayHello(Woman woman) {
        System.out.println("hello woman");

    }

    @Test
    public void test01() {
        /**
         * 静态分派
         * 分析：方法重载如何进行判断哪个方法 虚拟机根据传入的参数类型和返回值类型来进行判断
         * 这里human类型属于静态类型 man属于实际类型
         * 虚拟机【实际上应该是javac编译器】在重载时通过变量的静态类型而不是实际类型作为判断依据 并且静态类型在编译期可知。
         * 所有依赖静态类型来定位方法执行版本的分派动作 叫做 静态分派
         * 静态分派发生在编译阶段，因此静态分派的动作实际上不是由虚拟机来执行的。
         * 编译器虽然能确定出方法的重载版本，只能确定一个更加适合的版本
         *
         */
        Demo05 demo05 = new Demo05();
        Human man = new Man();
        demo05.sayHello(man); //hello human
        demo05.sayHello((Man) man); //hello man

        man=new Woman();
        demo05.sayHello(man); //hello human

    }


}