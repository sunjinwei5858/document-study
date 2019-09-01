package com.sunjinwei.gc;

/**
 * @program: com.sunjinwei
 * @author: Sun jinwei
 * @create: 2019-06-24 10:49
 * @description:
 * finalize是在Object类中定义的，因此，所有的类都继承了它。子类可以覆盖finalize()方法，来整理系统资源或者执行其他清理工作。
 **/
public class FinalizeEscapeGC {
    private static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        //因为finalizer方法优先级很低，暂停0.5秒 以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no i am  dead");
        }

        //对象第二次拯救自己失败
        SAVE_HOOK = null;
        System.gc();
        //因为finalizer方法优先级很低，暂停0.5秒 以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no i am dead");
        }
    }
}