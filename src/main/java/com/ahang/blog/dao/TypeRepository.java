package com.ahang.blog.dao;

import com.ahang.blog.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ahang
 * @date 2021/2/19 13:53
 */
public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByName(String name);

    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
