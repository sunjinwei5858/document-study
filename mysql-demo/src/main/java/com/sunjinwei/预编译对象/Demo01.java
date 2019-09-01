package com.sunjinwei.预编译对象;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: com.sunjinwei.预编译对象
 * @author: Sun jinwei
 * @create: 2019-08-24 16:26
 * @description: 预编译对象处理 使用缓存提高效率
 * PreparedStatement是预编译的,对于批量处理可以大大提高效率. 也叫JDBC存储过程
 * 使用 Statement 对象。在对数据库只执行一次性存取的时侯，用 Statement 对象进行处理。PreparedStatement 对象的开销比Statement大，对于一次性操作并不会带来额外的好处。
 *
 **/
public class Demo01 {
    private Connection connection;
    /**
     * 第一种方案：
     * 存取方案（Access Plan）的生成会占用相当多的CPU。理想的情况是，当我们多次发送一个statement到数据库，数据库应该对statement的存取方案进行重用。
     */
    @Test
    public void test01(){
        for (int i = 0; i < 100; i++) {
            try {
                /**
                 * 这样达不到缓存的效果 每次sql都是新的 需要将sql放在for循环的外面
                 */
                PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = " + i);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test02(){
        try {
            /**
             * 这样写的话 那么就可以达到缓存的效果
             */
            PreparedStatement preparedStatement = connection.prepareStatement("select * from stu where id = ?");
            for (int i = 0; i < 100; i++) {
                preparedStatement.setObject(1,i);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}