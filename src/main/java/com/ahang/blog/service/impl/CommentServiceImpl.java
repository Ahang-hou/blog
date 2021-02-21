package com.ahang.blog.service.impl;

import com.ahang.blog.dao.CommentRepository;
import com.ahang.blog.po.Comment;
import com.ahang.blog.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ahang
 * @date 2021/2/20 20:03
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        Sort sort = Sort.by("createTime");
        List<Comment> comments = commentRepository.findByBlogIdAndParentCommentNull(blogId, sort);
        return eachComment(comments);
    }

    @Transactional
    @Override
    public Comment saveComment(Comment comment) {
        Long parentCommentId = comment.getParentComment().getId();
        if (parentCommentId != -1) {
            comment.setParentComment(commentRepository.getOne(parentCommentId));
        } else {
            comment.setParentComment(null);
        }
        comment.setCreateTime(new Date());
        return commentRepository.save(comment);
    }

    /**
     * 循环每个顶级的评论节点
     */
    public List<Comment> eachComment(List<Comment> comments) {
        List<Comment> commentsVisew = new ArrayList<>();
        for (Comment comment : comments) {
            Comment c = new Comment();
            BeanUtils.copyProperties(comment, c);
            commentsVisew.add(c);
        }
        //合并评论的各层子代到第一级子代集合中
        combineChildren(commentsVisew);
        return commentsVisew;
    }

    /**
     * root根节点，blog不为空的对象集合
     */
    private void combineChildren(List<Comment> comments) {
        for (Comment comment : comments) {
            List<Comment> replys1 = comment.getReplyComment();
            for (Comment reply1 : replys1) {
                //循环迭代,找出子代,并存放在tempReplys中
                recursively(reply1);
            }
            comment.setReplyComment(tempReplys);
            tempReplys = new ArrayList<>();
        }
    }

    private List<Comment> tempReplys = new ArrayList<>();

    /**
     * 递归迭代，剥洋葱
     */
    private void recursively(Comment comment) {
        tempReplys.add(comment);
        if (comment.getReplyComment().size() > 0) {
            List<Comment> replys = comment.getReplyComment();
            for (Comment reply : replys) {
                tempReplys.add(reply);
                if (reply.getReplyComment().size() > 0) {
                    recursively(reply);
                }
            }
        }
    }
}
