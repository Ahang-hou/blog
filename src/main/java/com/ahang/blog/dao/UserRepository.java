package com.ahang.blog.dao;

import com.ahang.blog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ahang
 * @date 2021/2/18 15:40
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}
