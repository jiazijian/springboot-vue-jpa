package com.peimeton.springboot.vue.controller;

import com.peimeton.springboot.vue.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author jiazj
 * @create 2019/7/17- 9:40
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String Login(@RequestParam Map<String,String > map){
        if(map==null){
            return "用户名不存在";
        }
        String username = map.get("username");
        String password = map.get("password");
        String user = loginService.findStudent(username,password);
        return user;
    }

}
