package com.ssafy.cafe.model.service;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.cafe.model.dao.CommentDao;
import com.ssafy.cafe.model.dao.CommentDaoImpl;
import com.ssafy.cafe.model.dto.Comment;

public class CommentServiceImpl implements CommentService {
    CommentDao CommentDaoInstance = CommentDaoImpl.getInstance();

    private static CommentServiceImpl instance;

    public static CommentService getInstance() {
        if (instance == null) {
            instance = new CommentServiceImpl();
        }
        return instance;
    }

    private CommentServiceImpl() {

    }

    public void addComment(Comment comment) {
        CommentDaoInstance.insert(comment);
    }

    public Comment selectComment(Integer id) {
        Comment comment = CommentDaoInstance.select(id);
        return comment;
    }

    public void removeComment(Integer id) {
        CommentDaoInstance.delete(id);
    }

    public void updateComment(Comment comment) {
        CommentDaoInstance.update(comment);
    }

    public List<Comment> selectByProduct(Integer productId) {
        List<Comment> commentList = CommentDaoInstance.selectByProduct(productId);
        return commentList;
    }

}
