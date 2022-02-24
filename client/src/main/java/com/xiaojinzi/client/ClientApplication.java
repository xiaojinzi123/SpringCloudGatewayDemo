package com.xiaojinzi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@Controller
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        String res = restTemplate.getForObject("http://127.0.0.1:8088/server/helloServer", String.class);
        return "hello, 我是 server client, 我调用 server 返回的信息是: " + res;
    }

}