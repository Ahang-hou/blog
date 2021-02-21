package com.ahang.blog.service;

import com.ahang.blog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author ahang
 * @date 2021/2/19 13:48
 */
public interface TypeService {

    /**
     * 新增分类
     *
     * @param type
     * @return
     */
    Type saveType(Type type);

    /**
     * 根据ID查询分类
     *
     * @param id
     * @return
     */
    Type getType(Long id);

    /**
     * 分页
     *
     * @param pageable
     * @return
     */
    Page<Type> listType(Pageable pageable);

    /**
     * 更新分类
     *
     * @param id
     * @param type
     * @return
     */
    Type updateType(Long id, Type type);

    /**
     * 根据ID删除分类
     *
     * @param id
     */
    void deleteType(Long id);

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    Type getTypeByName(String name);

    /**
     * 查询分类
     * @return
     */
    List<Type> listType();

    List<Type> listTypeTop(Integer size);
}
