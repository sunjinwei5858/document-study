package com.sunjinwei.threadlocal_test;

/**
 * @program: com.sunjinwei.threadlocal_test
 * @author: Sun jinwei
 * @create: 2019-06-21 09:11
 * @description: ThreadLocal一些细节！
 * 为了验证本地线程是不共享的，线程独立的
 *
 * 从运行的结果我们可以看到threadLocal进行set值对threadLocal2并没有任何影响！
 **/
public class ThreadLocalTest {
    //定义threadlocal静态变量
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        //线程1
        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    //为本地线程设置id
                    threadLocal.set(i);
                    //打印以下线程的名字，还有使用本地线程获取一下设置的id
                    System.out.println("线程的名字："+Thread.currentThread().getName()+", 本地线程获取到的ID=="+threadLocal.get());
                    //设置线程睡眠时间
                    Thread.sleep(200);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                //这里把ThreadLocal定义为static还有一个好处就是，由于ThreadLocal有强引用在，那么在ThreadLocalMap里对应的Entry的键会永远存在，那么执行remove的时候就可以正确进行定位到并且删除！！！
                /**
                 * 不显示调用remove方法会导致内存溢出问题
                 */
                threadLocal.remove();
            }
        },"thread001").start();

        //线程2
        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    //打印以下线程的名字，还有使用本地线程获取一下设置的id
                    System.out.println("线程的名字："+Thread.currentThread().getName()+", 本地线程获取到的ID=="+threadLocal.get());
                    //设置线程睡眠时间
                    Thread.sleep(200);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                //这里把ThreadLocal定义为static还有一个好处就是，由于ThreadLocal有强引用在，那么在ThreadLocalMap里对应的Entry的键会永远存在，那么执行remove的时候就可以正确进行定位到并且删除！！！
                threadLocal.remove();
            }
        },"thread002").start();
    }

}