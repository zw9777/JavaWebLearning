package com.example.webbasics_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*
* 这个com.example主要是因为这个代码的文件生成我写在上一层文件了，为了保留上一次的代码，没有进行删除*/
@ComponentScan(basePackages = {"com.example"})
public class WebbasicsSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebbasicsSpringbootApplication.class, args);
    }




}
