package com.sunjinwei;

import static org.junit.Assert.assertTrue;

import com.sunjinwei.service.UserService;
import com.sunjinwei.service.UserService02;
import com.sunjinwei.service.UserService03;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 单元测试 验证单例service中实现原型bean的问题
 */
public class AppTest {

    /**
     *
     * 单例service 多例dao 但是dao不是多例的
     * 为什么会这样，因为service是单例的 spring创建service的时候 已经注入了dao 并且将其存储到了缓存中
     * 所以不管使用多少次service dao都是单例的 并不是多例的
     */
    @Test
    public void test01(){
       ApplicationContext context =new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.getHashCode();
        System.out.println("===========");
        userService.getHashCode();
        System.out.println("===========");
        userService.getHashCode();
    }
    /**
     * Spring官方文档中提供了两种方法解决
     * 第一种：service实现ApplicationContextAware接口 重写setApplicationContext方法 可以拿到ApplicationContext对象，从而用这个对象获取容器中的Bean.
     */
    @Test
    public void test02(){
        ApplicationContext context =new ClassPathXmlApplicationContext("spring.xml");
        UserService02 userService02 = context.getBean("userService02", UserService02.class);
        userService02.getHashCode();
        System.out.println("===========");
        userService02.getHashCode();
        System.out.println("===========");
        userService02.getHashCode();
    }
    /**
     * spring第二种解决方法
     */
    @Test
    public void test03(){
        ApplicationContext context =new ClassPathXmlApplicationContext("spring.xml");
        UserService03 userService02 = context.getBean("userService03", UserService03.class);
        userService02.getHashCode();
        System.out.println("===========");
        userService02.getHashCode();
        System.out.println("===========");
        userService02.getHashCode();
    }



}
