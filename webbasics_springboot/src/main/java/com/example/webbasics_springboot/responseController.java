package com.example.webbasics_springboot;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @BelongsProject: webbasics_springboot
 * @BelongsPackage: com.example.webbasics_springboot
 * @Author: WeiZhenDeng
 * @CreateTime: 2025-09-02
 */
@RestController
public class responseController {

    /*方法一*/
    @RequestMapping("/response")
    public void responseController(HttpServletResponse response) throws IOException {
        //设置状态码，这个状态码随便写的
        response.setStatus(405454545);

        //设置响应头
        response.setHeader("name","wei");

        //设置响应体
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("<h1>hello response</h1>");

    }

    /*方法二*/
    @RequestMapping("/response2")
    public ResponseEntity<String> response2(HttpServletResponse response) throws IOException {
        return ResponseEntity
                .status(401)
                .header("name","itcast")
                .body("<h1>hello response</h1>");
    }


    
}
