package com.sunjinwei.service;

import com.sunjinwei.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: com.sunjinwei.service
 * @author: Sun jinwei
 * @create: 2019-07-03 11:25
 * @description:
 **/
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void getHashCode(){
        System.out.println("service的hashcode值=="+this.hashCode());
        System.out.println("dao的hashcode值=="+userDao.hashCode());
    }

}
