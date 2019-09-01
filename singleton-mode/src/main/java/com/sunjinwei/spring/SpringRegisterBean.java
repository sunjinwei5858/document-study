package com.sunjinwei.spring;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: com.sunjinwei
 * @author: Sun jinwei
 * @create: 2019-07-04 18:04
 * @description: spring如何创建单例----单例注册表
 * <p>
 * 注意和懒汉式和饿汉式做对比
 * 懒汉式和饿汉式不能继承
 **/
public class SpringRegisterBean {
    //定义一个缓存map用来存储name和别名
    private static Map cashMap = new HashMap<>();

    //将对象放在静态代码块中进行
    static {
        SpringRegisterBean springRegisterBean = new SpringRegisterBean();
        //将实例对象的名字作为key 对象作为value存储在map中
        cashMap.put(springRegisterBean.getClass().getName(), springRegisterBean);
    }

    //protected受保护的构造方法 这样就可以实现继承
    protected SpringRegisterBean() {
    }

    //工厂方法获取单例必须传入参数
    public SpringRegisterBean getBean(String name) {
        if (name == null) {
            name = "SpringRegisterBean";
        }
        if (cashMap.get(name) == null) {
            //如果从map中得不到实例对象 那么进行创建

            try {
                cashMap.put(name, Class.forName(name).newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return (SpringRegisterBean) cashMap.get(name);

    }
}