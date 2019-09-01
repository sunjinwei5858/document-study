package com.sunjinwei.service;

import com.sunjinwei.dao.UserDao02;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @program: com.sunjinwei.service
 * @author: Sun jinwei
 * @create: 2019-07-03 11:36
 * @description:  解决单例中可以有多例的bean属性
 * 1第一种方法：实现ApplicationContextAware接口 可以拿到ApplicationContext对象，从而用这个对象获取容器中的Bean.
 * 2第二种方法：
 **/
@Service("userService02")
public class UserService02  implements ApplicationContextAware{

    //可以拿到ApplicationContext对象，从而用这个对象获取容器中的Bean.
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }


    @Autowired
    private UserDao02 userDao02;

    /**
     * 从applicationContext容器中获取dao的bean
     */
    public void getHashCode(){
        System.out.println("service的hashcode值=="+this.hashCode());
        //从applicationContext对象中获取dao对象
        System.out.println("dao的hashcode值=="+applicationContext.getBean("userDao02").hashCode());
    }
}