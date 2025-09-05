package com.example.Controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.example.Pojo.User;
import com.example.Service.Impl.UserServiceImpl;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongsProject: webbasics_springboot
 * @BelongsPackage: com.example.Controller
 * @Author: WeiZhenDeng
 * @CreateTime: 2025-09-03
 */
/*
* @RestController里面已经又component这个注解了，所以我们这里不需要专门在进行component了*/
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/list")
    /*加载读取文件*/
    public List<User> list() throws Exception{
        /*调用Service获取数据*/
        List<User> userList = userService.findAll();

        return userList;
    }


}
