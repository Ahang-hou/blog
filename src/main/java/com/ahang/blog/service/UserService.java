package com.ahang.blog.service;

import com.ahang.blog.po.User;

/**
 * @author ahang
 * @date 2021/2/18 15:33
 */
public interface UserService {

    /**
     * 检测用户是否存在
     * @param username
     * @param password
     * @return
     */
    User checkUser(String username, String password);
}
