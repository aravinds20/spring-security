package com.aravind.springsecurity.service;

import com.aravind.springsecurity.entity.UserInfo;
import com.aravind.springsecurity.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder encoder;

    public String addUser(UserInfo userInfo){
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "User added.";
    }

}
