package com.example.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @BelongsProject: webbasics_springboot
 * @BelongsPackage: com.example.Pojo
 * @Author: WeiZhenDeng
 * @CreateTime: 2025-09-03
 */

/*
* 封装用户数据
* */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime updateTime;

}
