package com.zyc.shardingjdbc.controller;

import com.zyc.shardingjdbc.entity.User;
import com.zyc.shardingjdbc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @ClassName: UserController
 * @Package: com.zyc.shardingjdbc
 * @Description:
 * @Datetime: 2021/4/18 10:29
 * @Author: zyc
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/save")
    public String insert(){
        User user =new User();
        user.setNickname("张三"+ new Random().nextInt());
        user.setPassword("123456");
        user.setSex(1);
        user.setBirthday(new Date());
        userMapper.addUser(user);
        return "success";
    }

    @GetMapping("/listuser")
    public List<User> listuser(){
        return userMapper.findUser();
    }
}
