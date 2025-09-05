package com.example.webbasics_springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @BelongsProject: webbasics_springboot
 * @BelongsPackage: com.example.webbasics_springboot
 * @Author: WeiZhenDeng
 * @CreateTime: 2025-09-02
 */

@RestController
public class requestController {

    @RequestMapping("/request")
    public String request(HttpServletRequest request){
        //获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式："+ method);
        //获取请求url路径
        String url = request.getRequestURI().toString();
        System.out.println("请求路径："+ url);
        //获取请求参数
        String string = request.getRequestURI();
        System.out.println("请求参数："+ string);
        //获取请求协议
        String protocol = request.getProtocol();
        System.out.println("请求协议："+ protocol);
        //获取请求参数
        String requestParameter = request.getParameter("name");
        System.out.println("请求参数："+ requestParameter);
        //获取请求头
        String header = request.getHeader("Accept");
        System.out.println("请求头："+ header);


        return "OK";
    }
}
