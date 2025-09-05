package com.example.Service.Impl;

import com.example.Dao.Impl.UserdaoImpl;
import com.example.Dao.UserDao;
import com.example.Pojo.User;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongsProject: webbasics_springboot
 * @BelongsPackage: com.example.Service.Impl
 * @Author: WeiZhenDeng
 * @CreateTime: 2025-09-03
 */


//@Component
@Service
public class UserServiceImpl implements UserService {

    @Autowired  //自动注入查找Bean对象并赋值
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        List<String> lines = userDao.findAll();
        List<User> userList = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).collect(Collectors.toList());
        return userList;
    }

}
