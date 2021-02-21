package com.ahang.blog.service.impl;

import com.ahang.blog.dao.UserRepository;
import com.ahang.blog.po.User;
import com.ahang.blog.service.UserService;
import com.ahang.blog.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ahang
 * @date 2021/2/18 15:36
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user=userRepository.findByUsernameAndPassword(username, MD5Util.code(password));
        return user;
    }
}
