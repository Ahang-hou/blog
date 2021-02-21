package com.ahang.blog.service;

import com.ahang.blog.po.Comment;

import java.util.List;

/**
 * @author ahang
 * @date 2021/2/20 20:02
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
