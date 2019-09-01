package com.sunjinwei.gc;

/**
 * @program: com.sunjinwei
 * @author: Sun jinwei
 * @create: 2019-06-21 11:37
 * @description: 如何判断对象已死
 * 证明java虚拟机不是使用引用技术算法
 *  很教科书判断一个对象是否存活的方法是--使用引用技术算法
 *  给对象添加一个引用计数器，每当有一个地方引用对象，那么计数器就进行+1；
 *  当引用失效时，那么计数器的值就减1；
 *  如果计数器等于0，那么就失效 对象就已经死亡 gc就可以进行回收
 *  但是：引用技术算法不能解决对象引用的问题
 *
 **/
public class TestGC {

    private Object instance=null;

    public static void testGc(){

        TestGC testGC01 = new TestGC();
        TestGC testGC02 = new TestGC();

        testGC01.instance=testGC02;
        testGC02.instance=testGC01;

        testGC01=null;
        testGC02=null;

        //假设在这里发生gc,那么这两个对象能否被回收
        System.gc();
    }

    public static void main(String[] args) {

        /**
         * 通过上面配置两个对象都没有任何引用 实际上这两个对象都不可能再被访问
         * 但是他们都互相被引用 那么计数器就不等于0 这样gc就无法进行回收
         */
        testGc();
    }


}