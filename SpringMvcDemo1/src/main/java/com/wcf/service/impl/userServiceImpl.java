package com.wcf.service.impl;

import com.wcf.pojo.User;
import com.wcf.service.userService;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {
    @Override
    public void save(User user) {
        System.out.println("user service..");
    }
}
