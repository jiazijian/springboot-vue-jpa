package com.peimeton.springboot.vue.service;

import com.peimeton.springboot.vue.dao.LoginDao;
import com.peimeton.springboot.vue.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiazj
 * @create 2019/7/17- 13:34
 */
@Service
public class LoginService {
    @Autowired
    private LoginDao loginDao;

    public String findStudent(String username, String password) {
        Student student = loginDao.findByUserName(username);

        if(student!=null&& student.getUsername()!=null && username.equals(student.getUsername())){

             if(password.equals(student.getPassword())){
                 return student.getUsername();
             }

        }else {
            return "用户名不存在";
        }
        return "密码错误";
    }
}
