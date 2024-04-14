package com.aravind.springsecurity.controller;

import com.aravind.springsecurity.entity.UserInfo;
import com.aravind.springsecurity.repository.UserInfoRepository;
import com.aravind.springsecurity.service.UserInfoUserDetailsService;
import com.aravind.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public String addUser(@RequestBody UserInfo userInfo) {
        return userService.addUser(userInfo);
    }

}
