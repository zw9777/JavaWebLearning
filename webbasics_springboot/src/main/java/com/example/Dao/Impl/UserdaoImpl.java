package com.example.Dao.Impl;

import cn.hutool.core.io.IoUtil;
import com.example.Dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: webbasics_springboot
 * @BelongsPackage: com.example.Dao.Impl
 * @Author: WeiZhenDeng
 * @CreateTime: 2025-09-03
 */
//方法一
//@Component // 将类交给spring管理IOC
//方法二
@Repository
public class UserdaoImpl implements UserDao {

    @Override
    public List<String> findAll() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
        return lines;
    }
}
