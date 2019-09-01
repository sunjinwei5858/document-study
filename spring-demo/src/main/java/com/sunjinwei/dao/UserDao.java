package com.sunjinwei.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @program: com.sunjinwei.dao
 * @author: Sun jinwei
 * @create: 2019-07-03 11:26
 * @description: 实现 单例bean中注入原型bean的问题
 **/
@Repository
@Scope(value = "prototype")
public class UserDao {

}
