package com.example.webbasics_springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: webbasics_springboot
 * @BelongsPackage: com.example.webbasics_springboot
 * @Author: WeiZhenDeng
 * @CreateTime: 2025-09-02
 */


@RestController
public class helloworldController {

    @RequestMapping("/hello")
    public String hello(String name){
        System.out.println("name"+name);
        return name + "hello!";
    }
}
