package com.example.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: webbasics_springboot
 * @BelongsPackage: com.example.Pojo
 * @Author: WeiZhenDeng
 * @CreateTime: 2025-09-05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJdbc {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
}
