package com.example.webbasics_springboot;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @BelongsProject: webbasics_springboot
 * @BelongsPackage: com.example.webbasics_springboot
 * @Author: WeiZhenDeng
 * @CreateTime: 2025-09-05
 */
public class jdbc {


    @Test
    public void jdbcConnectData() throws Exception{
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库链接
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/javawebAI", "root", "DWZ20031022");
        //获取数据库操作对象
        Statement statement = connection.createStatement();
        //执行sql语句
        String sql = "update user set age = 25 where id = 1";
        int count = statement.executeUpdate(sql);
        System.out.println(count);
        //释放资源
        statement.close();
        connection.close();

    }
}
