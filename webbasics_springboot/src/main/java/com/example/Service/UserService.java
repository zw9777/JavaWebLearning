package com.example.Service;

import com.example.Pojo.User;

import java.util.List;

/**
 * @BelongsProject: webbasics_springboot
 * @BelongsPackage: com.example.Service
 * @Author: WeiZhenDeng
 * @CreateTime: 2025-09-03
 * @WeChat: DWZ2328508177
 */
public interface UserService {


    public List<User> findAll();
}
