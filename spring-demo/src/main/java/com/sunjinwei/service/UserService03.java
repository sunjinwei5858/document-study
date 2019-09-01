package com.sunjinwei.service;

import com.sunjinwei.dao.UserDao;
import com.sunjinwei.dao.UserDao03;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

/**
 * @program: com.sunjinwei.service
 * @author: Sun jinwei
 * @create: 2019-07-03 11:25
 * @description: 第二种解决方法：使用@lookup注解
 * 我们只需要声明一个抽象方法，并在该方法上面添加@Lookup(“dao”)注解，“dao”表示要注入的类名，spring容器就会自动帮我们注入IndexDao实例。
 **/
@Service
public abstract class UserService03 {

    /**
     * 使用注解的方式 声明一个抽象方法 返回值为UserDao03
     * @return
     */
    @Lookup
    public abstract UserDao03 getUserDao();

    public void getHashCode() {
        System.out.println("service的hashcode值==" + this.hashCode());
        System.out.println("dao的hashcode值==" + getUserDao().hashCode());
    }

}
