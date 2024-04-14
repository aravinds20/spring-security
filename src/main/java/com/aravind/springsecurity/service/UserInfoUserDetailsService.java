package com.aravind.springsecurity.service;

import com.aravind.springsecurity.dto.UserInfoDTO;
import com.aravind.springsecurity.entity.UserInfo;
import com.aravind.springsecurity.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepository.findByName(username);
        userInfo.map(UserInfoDTO::new).orElseThrow(()-> new UsernameNotFoundException("user not found "+username));
        return new UserInfoDTO(userInfo.get());
    }
}
