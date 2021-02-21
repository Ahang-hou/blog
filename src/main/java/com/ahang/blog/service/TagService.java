package com.ahang.blog.service;

import com.ahang.blog.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * @author ahang
 * @date 2021/2/19 17:35
 */
public interface TagService {
    /**
     * 新增标签
     *
     * @param tag
     * @return
     */
    Tag saveTag(Tag tag);

    /**
     * 查询标签
     *
     * @param id
     * @return
     */
    Tag getTag(Long id);

    /**
     * 分页
     *
     * @param pageable
     * @return
     */
    Page<Tag> listTag(Pageable pageable);

    /**
     * 更新标签
     *
     * @param id
     * @param tag
     * @return
     */
    Tag updateTag(Long id, Tag tag);

    /**
     * 删除标签
     *
     * @param id
     */
    void deleteTag(Long id);

    /**
     * 根据名称查询标签
     *
     * @param name
     * @return
     */
    Tag getTagByName(String name);

    /**
     * 查询所有标签
     *
     * @return
     */
    List<Tag> listTag();

    /**
     * 查询所有ID
     * @param ids
     * @return
     */
    List<Tag> listTag(String ids);

    List<Tag> listTagTop(Integer size);
}
